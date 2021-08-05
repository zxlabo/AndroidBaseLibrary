package com.demo.fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.demo.jetpack.room.User

/**
 * author : Naruto
 * date   : 2020/11/17
 * desc   :
 * version:
 */
class OneViewModel: ViewModel() {
     val mName: MutableLiveData<String> by lazy {
       MutableLiveData<String>()
    }
}