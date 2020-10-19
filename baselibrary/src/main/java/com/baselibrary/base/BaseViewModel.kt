package com.baselibrary.base

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.baselibrary.model.LifecycleEvent

open class BaseViewModel : ViewModel() {

     val activityBlock = MutableLiveData<LifecycleEvent>()


    fun startForContext(block: AppCompatActivity.() -> Unit) {
        activityBlock.postValue(LifecycleEvent(block))
    }

}