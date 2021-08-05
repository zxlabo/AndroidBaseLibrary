package com.demo.jetpack.room

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * author : Naruto
 * date   : 2020/11/9
 * desc   :
 * version:
 */
class UserViewModel(application: Application) : AndroidViewModel(application) {
    private var repository: UserRepository
    var allUsers: LiveData<List<User>>

    init {
        val userDao = UserDatabase.getDatabase(application, viewModelScope).userDao()
        repository = UserRepository(userDao)
        allUsers = repository.allUsers
    }

    fun insert(user: User) = viewModelScope.launch(Dispatchers.IO) { repository.insert(user) }

    fun queryAll() = viewModelScope.launch(Dispatchers.IO) { allUsers = repository.queryAll() }
}