package com.baselibrary.model

import retrofit2.HttpException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import java.util.concurrent.CancellationException


fun handleError(e: Throwable) {
    if (e is CancellationException) {
        return
    }
    if (e is ConnectException || e is UnknownHostException) {
//        BHToastUtil.show("连接错误，请检查您的网络稍后重试")
    } else if (e is SocketTimeoutException) {
        //BHToastUtil.show("连接超时，请稍后重试")
    } else if (e is HttpException) { //http状态码错误
        val code = e.code()
        when (code) {
            401 -> {

            }
            in 500..599 -> {
//                BHToastUtil.show("服务器错误$code")
            }
            404 -> {
//                BHToastUtil.show("服务器找到不给定的接口资源$code")
            }
            in 400..499 -> {
//                BHToastUtil.show("网络错误$code")
            }
            else -> {
//                BHToastUtil.show("网络未知错误$code")
            }
        }
    } else {
//        BHToastUtil.BHToastUtilshow("未知错误" + e.message)
    }
}
