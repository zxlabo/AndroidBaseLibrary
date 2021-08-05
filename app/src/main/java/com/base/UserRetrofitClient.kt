package com.base

import com.baselibrary.http.BaseRetrofitClient
import com.baselibrary.utils.TimeUtils
import okhttp3.Interceptor
import okhttp3.Response
import okhttp3.ResponseBody
import okio.Buffer
import okio.BufferedSource
import org.json.JSONObject
import org.json.JSONTokener
import retrofit2.Call
import java.lang.Exception
import java.net.SocketTimeoutException

object UserRetrofitClient : BaseRetrofitClient() {

    val apiService: UserApiService by lazy {
        getService(UserApiService::class.java)
    }

    override fun getBaseUrl() : String  {
        return "https://www.wanandroid.com/"
    }

//    @Throws(Exception::class)
//    override fun initErrorInterceptor(): Interceptor {
//        return Interceptor { chain: Interceptor.Chain? ->
//            val response: Response? = chain?.proceed(chain.request())
//            throw Exception("主动抛出异常")
//            response
//        }
//    }



     fun login(name: String, pwd: String): Call<BaseResp<LoginResp>> {
        val params = HashMap<String, String>()
        params["username"] = name
        params["password"] = pwd
        return apiService.login(params)
    }

    /**
     * 使用本地的 json 模拟网络请求返回结果
     */
//    private fun getInterceptors(): List<Interceptor> {
//        val interceptors = mutableListOf<Interceptor>()
//        interceptors.add(
//            DebugInterceptor(
//                "/api/v1/special_questions",
//                R.raw.health
//            )
//        )
//        return interceptors
//    }
}