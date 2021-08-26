package com.common

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.net.Uri
import android.net.http.SslError
import android.os.Build
import android.os.Bundle
import android.text.TextUtils
import android.view.KeyEvent
import android.view.View
import android.view.ViewGroup
import android.webkit.*
import android.widget.LinearLayout
import androidx.appcompat.app.AlertDialog
import com.baselibrary.base.BaseApplication
import com.baselibrary.base.BaseToolBarActivity
import com.baselibrary.utils.ext.showToast
import kotlinx.android.synthetic.main.common_web_view.*
import org.json.JSONException
import org.json.JSONObject


/**
 * author : Naruto
 * date   : 2019-10-22
 * desc   :
 * version:
 */
abstract class CommonWebViewActivity : BaseToolBarActivity() {
    private var mWebView: WebView? = null
    private lateinit var url: String
    private val APP_CACHE_DIRNAME = "app_cache_dirname"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //解决webview截长屏不全的问题
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            try {
                WebView.enableSlowWholeDocumentDraw()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        setContentView(R.layout.common_web_view)
        addWebView()
        url = initUrl()
        initWebView()
    }


    /**
     * 代码动态添加WebView
     */
    private fun addWebView() {
        val params = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        mWebView = WebView(applicationContext)
        mWebView?.layoutParams = params
        //设置webview取消右边滚动条和水波纹效果
        mWebView?.overScrollMode = View.OVER_SCROLL_NEVER
        mWebView?.isVerticalScrollBarEnabled = false
        fl_web_view.addView(mWebView)
    }

    abstract fun initUrl(): String

    /**
     * 初始化WebView
     */
    @SuppressLint("SetJavaScriptEnabled", "ObsoleteSdkInt", "JavascriptInterface")
    private fun initWebView() {
        if (TextUtils.isEmpty(url)) return
        mWebView?.let {
            it.loadUrl(url)
            //对webview进行配置和管理
            val webSettings = it.settings
            //设置与JS交互的权限
            webSettings.javaScriptEnabled = true
            //js调用Android对象
            it.addJavascriptInterface(JSInterface(), "AndroidObject")
            //设置允许JS弹窗
            webSettings.javaScriptCanOpenWindowsAutomatically = true
            //将图片调整到适合WebView的大小
            webSettings.useWideViewPort = true
            //缩放至屏幕大小
            webSettings.loadWithOverviewMode = true
            //设置编码格式
            webSettings.defaultTextEncodingName = "UTF-8"
            //启用地理定位
            webSettings.setGeolocationEnabled(true)
            //允许WebView使用File协议
            webSettings.allowFileAccess = true;
            //不保存密码
            webSettings.savePassword = false;
            //解决js跨域问题
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                webSettings.allowUniversalAccessFromFileURLs = true
            }
            //5.1以上默认禁止了https和http的混用，下面的设置是开启
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                webSettings.mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
            }
            //开启DOM storage API功能
            webSettings.domStorageEnabled = true
            //开启database storage API功能
            webSettings.databaseEnabled = true
            //开启Application Caches功能
            webSettings.setAppCacheEnabled(true)
            //设置Application Caches缓存目录，把内部私有缓存目录'/data/data/包名/cache/'作为WebView的AppCache的存储路径
            val cachePath = BaseApplication.mContext.cacheDir.path
            webSettings.setAppCachePath(cachePath)
            webSettings.setAppCacheMaxSize((10 * 1024 * 1024).toLong())
            //设置缓存的模式
            webSettings.cacheMode = getCacheMode()
            it.webViewClient = MyWebViewClient()
            it.webChromeClient = MyWebChromeClient()
        }

    }


    /**
     * 页面刷新
     */
    fun refreshView() {
        if (mWebView != null && !TextUtils.isEmpty(url)) {
            mWebView?.loadUrl(url)
        }
    }

    /**
     * 获取webview缓存的模式
    LOAD_CACHE_ONLY: 不使用网络，只读取本地缓存数据
    LOAD_DEFAULT: （默认）根据cache-control决定是否从网络上取据。
    LOAD_NO_CACHE: 不使用缓存，只从网络获取数据.
    LOAD_CACHE_ELSE_NETWORK，只要本地有，无论是否过期，或no-cache，都使用缓存中的数据。
     */
    private fun getCacheMode(): Int {
        return WebSettings.LOAD_DEFAULT
    }

    /**
     * 销毁Webview
     * 在关闭了Activity时，如果Webview的音乐或视频，还在播放。就必须销毁Webview.
     * 注意：webview调用destory时,webview仍绑定在Activity上
     * 这是由于自定义webview构建时传入了该Activity的context对象,因此需要先从父容器中移除webview,然后再销毁webview:
     */
    override fun onDestroy() {
        super.onDestroy()
        mWebView?.let {
            it.loadDataWithBaseURL(null, null, "text/html", "utf-8", null)
            //清除当前WebView访问的历史记录
            it.clearHistory()
            val parent = it.parent as ViewGroup
            //从父容器中移除WebView
            parent.removeView(it)
            it.destroy()
        }
    }

    /**
     * 对返回键的监听，实现网页后退
     */
    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        mWebView?.let {
            if (keyCode == KeyEvent.KEYCODE_BACK && it.canGoBack()) {
                it.goBack()
                return true
            }
        }
        return super.onKeyDown(keyCode, event)
    }

    /**
     * WebViewClient
     * 作用：处理各种通知，请求事件，主要有:网页开始加载，加载结束，加载错误(如404)，处理https请求
     */
    inner class MyWebViewClient : WebViewClient() {
        override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
            super.onPageStarted(view, url, favicon)
            //页面开始的时候，设置不加载图片
            view?.settings?.blockNetworkImage = true
        }

        //页面加载结束
        override fun onPageFinished(view: WebView?, url: String?) {
            super.onPageFinished(view, url)
            //页面加载结束，开始加载图片
            view?.settings?.blockNetworkImage = false
            val automatically = view?.settings?.loadsImagesAutomatically
            automatically?.let {
                if (!it) {
                    //设置wenView加载图片资源
                    view.settings.blockNetworkImage = false
                    view.settings.loadsImagesAutomatically = true
                }
            }
        }

        //只要加载html、js、css资源，会回调这个方法
        override fun onLoadResource(view: WebView?, url: String?) {
            super.onLoadResource(view, url)
        }

        //加载页面的服务器出现错误时（如404）调用。
        override fun onReceivedError(
            view: WebView,
            request: WebResourceRequest,
            error: WebResourceError
        ) {
            showToast("加载错误")
//            when (error.errorCode) {
//                // 404 -> view.loadUrl("file:///android_assets/error_handle.html")
//            }
        }

        //webView默认是不处理https请求的，页面显示空白，需要进行如下设置
        override fun onReceivedSslError(view: WebView, handler: SslErrorHandler, error: SslError) {
            handler.proceed()  // 接受所有网站的证书
            //handler.cancel(); // Android默认的处理方式
            //handleMessage(Message msg); // 进行其他处理
        }

        override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
            if (TextUtils.isEmpty(url)) return true
            //JS调用Android，对协议进行处理
            AppScheme.handleUrl(this@CommonWebViewActivity, url)
            return true
        }


        // 拦截资源 通常用于h5的首页页面，将常用的一些资源，放到本地
        override fun shouldInterceptRequest(
            view: WebView?,
            request: WebResourceRequest?
        ): WebResourceResponse? {
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                    request?.url.toString().contains("logo.gif")
//                }
            return super.shouldInterceptRequest(view, request)
        }
    }

    private fun handleRequest(request: WebResourceRequest) {
//        val uri = Uri.parse(request?.url.toString())
//        // 一般根据scheme（协议格式） & authority（协议名）判断（前两个参数）
//        //假定传入进来的 url = "js://webview?arg1=111&arg2=222"（同时也是约定好的需要拦截的）
//        if (TextUtils.equals(uri.scheme, "js")) {
//            if (TextUtils.equals(uri.authority, "webview")) {
//                showToast(request?.url.toString())
//                //获取参数
//                val params = uri.queryParameterNames
//                for (param in params) {
//                    showToast("key" + param + "value" + uri.getQueryParameter(param))
//                }
//            }
//        }
    }

    /**
     * WebChromeClient
     * 可以得到网页加载的进度，网页的标题，网页的icon,js的一些弹框，
     */
    inner class MyWebChromeClient : WebChromeClient() {
        //网页加载的进度
        override fun onProgressChanged(view: WebView, progress: Int) {
            progress_bar.visibility = View.VISIBLE
            progress_bar.progress = progress
            if (progress >= 90) {
                progress_bar.visibility = View.GONE
            }
        }

        //网页的标题
        override fun onReceivedTitle(view: WebView, title: String) {
            super.onReceivedTitle(view, title)
            setTitle(title)
        }

        //js alert
        override fun onJsAlert(
            view: WebView?,
            url: String?,
            message: String?,
            result: JsResult?
        ): Boolean {
            AlertDialog.Builder(this@CommonWebViewActivity)
                .setTitle("JsAlert")
                .setMessage(message)
                .setPositiveButton("OK") { _, _ -> result?.confirm() }
                .setCancelable(false)
                .show()
            return true
        }


        override fun onJsPrompt(
            view: WebView?,
            url: String?,
            message: String?,
            defaultValue: String?,
            result: JsPromptResult?
        ): Boolean {
            //先判断页面是否关闭
            showToast(message.toString())
            val uri = Uri.parse(message)
            if (uri.scheme == "js") {
                // 将需要返回的值通过该方式返回
                result?.confirm("js调用了Android的方法成功啦啦啦啦啦")
                return true
            }
            return super.onJsPrompt(view, url, message, defaultValue, result)
        }

    }

    inner class JSInterface {
        /**
         *
         * Js调用Android的方法
         */
        @JavascriptInterface
        fun hello(msg: String) {
            showToast(msg)
        }

        @JavascriptInterface
        fun set(json: String) {
            try {
                // 显示分享按钮
                val obj = JSONObject(json)
                var url = obj.optString("url")
                val title = obj.optString("title")
            } catch (e: JSONException) {
            }
        }
    }

}


