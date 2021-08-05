package com.demo.jetpack.room

import androidx.lifecycle.LiveData

/**
 * author : Naruto
 * date   : 2020/11/9
 * desc   :
 * version:
 */
class UserRepository(private var userDao: UserDao) {
    val allUsers=userDao.getUsers()
    suspend fun insert(user: User){
        userDao.insertUser(user)
    }
    suspend fun queryAll(): LiveData<List<User>> {
       return userDao.getUsers()
    }
}