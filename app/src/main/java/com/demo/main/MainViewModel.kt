package com.demo.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.base.BaseResp
import com.base.LoginResp
import com.base.UserRetrofitClient
import com.baselibrary.base.BaseViewModel
import com.baselibrary.base.SingleLiveEvent
import io.reactivex.Single
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * author : Naruto
 * date   : 2020-05-15
 * desc   :
 * version:
 */
class MainViewModel : BaseViewModel() {

    val mName = MutableLiveData<String>()
//    by lazy {
//        SingleLiveEvent<String>()

    //    }
//    init {
//        mName.value = "oncreate"
//    }

    val api by lazy {
        UserRetrofitClient.apiService
    }

    fun getData() {
        UserRetrofitClient.login("", "").enqueue(object : Callback<BaseResp<LoginResp>> {
            override fun onFailure(call: Call<BaseResp<LoginResp>>, t: Throwable) {

            }

            override fun onResponse(  call: Call<BaseResp<LoginResp>>, response: Response<BaseResp<LoginResp>>) {


            }

        })

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
                Log.e("====", e.toString())
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
