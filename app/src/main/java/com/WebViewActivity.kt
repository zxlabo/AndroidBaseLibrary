package com

import android.graphics.Color
import android.webkit.JavascriptInterface
import com.common.CommonWebViewActivity

/**
 *  WebView页面
 */
class WebViewActivity : CommonWebViewActivity() {

    override fun initUrl(): String {
        return  "http://docs.google.com/gview?embedded=true&url=http://www.adobe.com/devnet/acrobat/pdfs/pdf_open_parameters.pdf"
    }

    override fun getAppBarColor(): Int {
        return Color.parseColor("#23C5A3")
    }

    override fun getToolBarColor(): Int {
        return Color.parseColor("#23C5A3")
    }
    /**
     *
     * Js调用Android的方法
     */
    @JavascriptInterface
    fun hello(msg: String) {

    }

}