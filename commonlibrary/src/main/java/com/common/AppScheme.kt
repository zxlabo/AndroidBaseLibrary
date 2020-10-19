package com.common

import android.content.Context
import android.net.Uri
import android.util.Log

/**
 * author : Naruto
 * date   : 2019-08-24
 * desc   :
 * version:
 */
class AppScheme {
    companion object {
        fun handleUrl(context: Context, url: String) {
            //1.根据协议参数，判断是否是协议约定的url
            //一般根据scheme（协议格式） & authority（协议名）判断（前两个参数）
            //假定传入进来的 url = "js://webview?arg1=111&arg2=222"（同时也是约定好的需要拦截的）
            val uri = Uri.parse(url)
            //如果url的协议==预先约定的js协议，就往下解析url协议参数
            if (uri.scheme.equals("js")) {
                //如果authority==预先约定协议里的webview，即代表符合约定的协议
                if (uri.authority.equals("webview")) {
                    val map = mutableMapOf<String, String>()
                    //获取传递的数据
                    val names = uri.queryParameterNames
                    for (name in names) {
                        Log.e("===", name + ":" + uri.getQueryParameter(name))
                    }
                }
            }
        }
    }
}