package com.baselibrary.base

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.baselibrary.utils.LogUtils
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * author : Naruto
 * date   : 2019-09-26
 * desc   : 管理Activity 和 Fragment 生命周期
 *  LifecycleObserver 接口是一个空接口，主要是给注解处理器使用
 *  我们通过在方法上使用@OnLifecycleEvent 注解使得该方法具有了生命周期感知能力。
 *  括号里面的参数，表明需要监听的是什么生命周期事件
 * version:
 */
class BaseActivityLifecycle : LifecycleObserver {
    private var TAG = "BaseActivityLifecycle"
    private var lifecycleActivity: BaseLifecycleActivity? = null

    /**
     * 管理Observer和Subscribers订阅
     */
    private val compositeDisposable = CompositeDisposable()

    constructor(lifecycleActivity: BaseLifecycleActivity?) {
        this.lifecycleActivity = lifecycleActivity
        lifecycleActivity?.let { TAG = it::class.java.simpleName }
    }


    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public fun onCreate() {
        showLog(TAG, "onCreate")

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public fun onStart() {
        showLog(TAG, "onStart")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public fun onResume() {
        showLog(TAG, "onResume")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public fun onPause() {
        showLog(TAG, "onPause")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public fun onStop() {
        showLog(TAG, "onStop")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public fun onDestroy() {
        showLog(TAG, "onDestroy")
        compositeDisposable.clear()
    }

    /**
     * 将Disposable添加到CompositeDisposable中，统一管理
     */
    fun add(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }

    fun getCompositeDisposable(): CompositeDisposable {
        return compositeDisposable
    }

    private fun showLog(tag: String, msg: String) {
        LogUtils.v(tag + msg)
    }
}