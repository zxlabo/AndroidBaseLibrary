package com.base

import retrofit2.Call
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import kotlin.collections.HashMap

/**
 * author : Naruto
 * date   : 2019-08-03
 * desc   :
 * version:
 */
interface UserApiService {

    @FormUrlEncoded
    @POST("user/login")
     fun login(@FieldMap params: HashMap<String, String>): Call<BaseResp<LoginResp>>
//    suspend fun login(@FieldMap params: HashMap<String, String>): BaseResp<LoginResp>

}