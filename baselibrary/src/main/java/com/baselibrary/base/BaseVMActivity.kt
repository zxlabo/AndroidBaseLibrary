package com.baselibrary.base

import android.os.Bundle
import androidx.lifecycle.Observer
import kotlin.properties.Delegates

abstract class BaseVMActivity<T : BaseViewModel> : BaseActivity() {

    protected var mViewModel: T by Delegates.notNull()

    protected abstract fun createViewModel(): T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel = createViewModel()
        // 接受到启动Activity事件，返回Activity实例
        mViewModel.activityBlock.observe(this, Observer {
            it?.block?.invoke(this)
        })

    }


}