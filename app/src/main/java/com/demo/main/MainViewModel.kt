package com.demo.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.base.BaseResp
import com.base.LoginResp
import com.base.UserRetrofitClient
import com.baselibrary.base.BaseViewModel
import kotlinx.coroutines.*

/**
 * author : Naruto
 * date   : 2020-05-15
 * desc   :
 * version:
 */
class MainViewModel : BaseViewModel() {
    val api by lazy {
        UserRetrofitClient.apiService
    }
    fun loadData() {
        try {
            safeLaunch({
                UserRetrofitClient.login(
                    "123456labozx",
                    "123456zx"
                )
            }, { data.value = it })
        } catch (e: Exception) {
            Log.e("====",e.toString())
        }
    }


    fun <T> safeLaunch(
        request: suspend () -> BaseResp<T>,
        onSuccess: (T?) -> Unit = {},
        onFail: (Throwable) -> Unit = {}
    ) {
        viewModelScope.launch {
            try {
                withContext(Dispatchers.IO) { request().dataConvert() }.apply(onSuccess)
                    ?: throw Exception("暂无数据,请稍后重试")
            } catch (e: Exception) {
               Log.e("====",e.toString())
            } finally {

            }
        }
    }

    val data: MutableLiveData<LoginResp> = MutableLiveData()


    fun <T> BaseResp<T>.dataConvert(): T {
        if (this.errorCode != 0) {
            throw Exception(this.errorMsg)
        }
        return this.data
    }

}
