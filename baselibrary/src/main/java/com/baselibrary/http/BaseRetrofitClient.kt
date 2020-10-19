package com.baselibrary.http

import com.baselibrary.BuildConfig
import com.baselibrary.utils.TimeUtils
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.net.SocketTimeoutException
import java.util.concurrent.TimeUnit

/**
 * author : Naruto
 * date   : 2019-07-30
 * desc   :
 * version:
 */
abstract class BaseRetrofitClient {

    protected open fun <Service> getService(serviceClass: Class<Service>): Service {
        return Retrofit.Builder()
            .baseUrl("https://www.wanandroid.com/")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(initClient())
            .build()
            .create(serviceClass)
    }


    private fun initClient(): OkHttpClient {
        val client =
            OkHttpClient().newBuilder().connectTimeout(getTimeOutSeconds(), TimeUnit.SECONDS)
                .readTimeout(getTimeOutSeconds(), TimeUnit.SECONDS)
                .writeTimeout(getTimeOutSeconds(), TimeUnit.SECONDS)
        if (BuildConfig.DEBUG) {
            client
                .addInterceptor(initLogInterceptor())
                .createInterceptor()
        }
        initHeadInterceptor()?.let {
            client.addInterceptor(it)
        }
        initErrorInterceptor()?.let {
            client.addInterceptor(it)
        }
        client.addInterceptor(getResponseDateInterceptor())
        return client.build()
    }


    private fun initLogInterceptor(): Interceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }


    private fun OkHttpClient.Builder.createInterceptor(): OkHttpClient.Builder {
        getInterceptors()?.forEach { interceptor ->
            this.addInterceptor(interceptor)
        }
        return this
    }

    private fun getResponseDateInterceptor(): Interceptor {
        return Interceptor {
            try {
                val response = it.proceed(it.request())
                TimeUtils.calOffsetServerTimeAndSave(response.header("date"))
                response
            } catch (e: SocketTimeoutException) {
                it.proceed(it.request())
            }
        }
    }

    abstract fun getBaseUrl(): String

    open fun initHeadInterceptor(): Interceptor? = null

    open fun getInterceptors(): List<Interceptor>? = null

    open fun initErrorInterceptor(): Interceptor? = null

    open fun getTimeOutSeconds(): Long {
        return 30
    }


}


