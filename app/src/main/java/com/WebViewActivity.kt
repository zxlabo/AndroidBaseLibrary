package com

import android.webkit.JavascriptInterface
import com.common.CommonWebViewActivity

/**
 *  WebView页面
 */
class WebViewActivity : CommonWebViewActivity() {

    override fun initUrl(): String {
        return  "http://docs.google.com/gview?embedded=true&url=http://www.adobe.com/devnet/acrobat/pdfs/pdf_open_parameters.pdf"
    }

    /**
     *
     * Js调用Android的方法
     */
    @JavascriptInterface
    fun hello(msg: String) {

    }

}