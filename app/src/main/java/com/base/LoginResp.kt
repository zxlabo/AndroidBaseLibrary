package com.base

/**
 * author : Naruto
 * date   : 2019-08-03
 * desc   :
 * version:
 */
data class LoginResp(
    val admin: Boolean,
    val chapterTops: List<Any>,
    val collectIds: List<Any>,
    val email: String,
    val icon: String,
    val id: Int,
    val nickname: String,
    val password: String,
    val token: String,
    val type: Int,
    val username: String

) {
    override fun toString(): String {
        return "LoginResp(admin=$admin, chapterTops=$chapterTops, collectIds=$collectIds, email='$email', icon='$icon', id=$id, nickname='$nickname', password='$password', token='$token', type=$type, username='$username')"
    }
}

