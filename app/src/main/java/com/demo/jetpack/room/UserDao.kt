package com.demo.jetpack.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

/**
 * author : Naruto
 * date   : 2020/11/9
 * desc   :
 * version:
 */
@Dao
interface UserDao {
    @Insert
    fun insertUser(user: User)

    @Delete
    fun deleteUser(user: User)

    @Query("DELETE FROM userDataBase")
    suspend fun deleteAll()


    @Query("SELECT * FROM userDataBase ")
    fun getUsers(): LiveData<List<User>>
}