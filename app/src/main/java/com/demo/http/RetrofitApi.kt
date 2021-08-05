package com.demo.http

import com.base.Person
import com.demo.jetpack.room.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * author : Naruto
 * date   : 2020/11/22
 * desc   :
 * version:
 */
interface RetrofitApi {
    @GET("users/repos")
    fun getData(): Call<Person>
}