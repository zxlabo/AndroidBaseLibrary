package com

import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.webkit.JavascriptInterface
import com.baselibrary.utils.RxTimerUtils
import com.common.CommonWebViewActivity
import kotlin.random.Random

/**
 *  WebView页面
 */
class WebViewActivity : CommonWebViewActivity() {
private val list= listOf<String>("https://blog.csdn.net/weixin_37292229/article/details/72953602","https://blog.csdn.net/weixin_37292229/article/details/76573755","https://blog.csdn.net/weixin_37292229/article/details/76422592")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setNavigatorColor(Color.parseColor("#3A3B49"))
//        Handler().postDelayed({ finish() }, 1000 * 30)
    }

    override fun initUrl(): String {
//        return  list[getIndex()]
        return  "http://docs.google.com/gview?embedded=true&url=http://www.adobe.com/devnet/acrobat/pdfs/pdf_open_parameters.pdf"
    }

    fun getIndex() = java.util.Random().nextInt(list.size)
    /**
     *
     * Js调用Android的方法
     */
    @JavascriptInterface
    fun hello(msg: String) {
//        toast(msg)
    }
}