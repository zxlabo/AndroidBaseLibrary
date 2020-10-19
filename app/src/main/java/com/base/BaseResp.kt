package com.base

/**
 * author : Naruto
 * date   : 2019-08-03
 * desc   : 返回类型BaseResp
 * version:
 */
open class BaseResp<out T>(val errorCode: Int, val errorMsg: String, val data: T) {
    override fun toString(): String {
        return "BaseResp(errorCode=$errorCode, errorMsg='$errorMsg', data=$data)"
    }
}