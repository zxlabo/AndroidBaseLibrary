package com.demo.http

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.base.Person
import com.base.R
import com.baselibrary.utils.ext.setOnAvoidClickListener
import kotlinx.android.synthetic.main.activity_retrofit.*
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit)
        btn_retrofit.setOnAvoidClickListener {
            loadData()
        }


    }

    private fun loadData() {
        val okhttpClient = OkHttpClient.Builder().build()
        var retrofit = Retrofit.Builder()
            .baseUrl("https://columbus.iboohee.com/")
            //设置数据转换器
            .addConverterFactory(GsonConverterFactory.create())
            //支持rxjava平台
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okhttpClient)
            .build()
        val api = retrofit.create(RetrofitApi::class.java)
        val call = api.getData()
        call.enqueue(object : Callback<Person> {
            override fun onFailure(call: Call<Person>, t: Throwable) {

            }

            override fun onResponse(call: Call<Person>, response: Response<Person>) {
            }

        })
    }
}