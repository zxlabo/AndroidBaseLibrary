package com.demo.http

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.base.R
import okhttp3.*
import java.io.IOException
import java.util.concurrent.TimeUnit

class OkHttpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ok_http)
    }
    fun requestData(){
        val okHttpClient = OkHttpClient.Builder().readTimeout(1000,TimeUnit.MILLISECONDS).build()
        val request = Request.Builder().url("").build()
        val realCall = okHttpClient.newCall(request)
        realCall.execute()
        realCall.enqueue(object : Callback{
            override fun onFailure(call: Call, e: IOException) {

            }

            override fun onResponse(call: Call, response: Response) {
            }

        })
    }
}