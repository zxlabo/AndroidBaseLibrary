package com.demo.jetpack.lifecycle

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.base.R

class LifecycleActivityV2 : Activity(), LifecycleOwner {

private val mLiveData=MutableLiveData<String>().apply {
    "aa"
}
private val mLiveData2=MutableLiveData("")


    private val mLifecycleRegistry = LifecycleRegistry(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lifecycle_v2)
        getLifecycle().addObserver(MyLifecycleObserver())
        mLiveData.observe(this, Observer {

        })
    }

    override fun getLifecycle(): Lifecycle =mLifecycleRegistry

    override fun onResume() {
        super.onResume()
        mLifecycleRegistry.currentState=Lifecycle.State.RESUMED
    }

}