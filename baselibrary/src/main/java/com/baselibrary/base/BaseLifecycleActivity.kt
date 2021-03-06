package com.baselibrary.base

import android.os.Bundle
import com.baselibrary.utils.AppManager

/**
 * author : Naruto
 * date   : 2019-07-25
 * desc   :
 * version:
 */

open class BaseLifecycleActivity : BaseActivity() {
    private var activityLifecycle: BaseActivityLifecycle? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppManager.instance.addActivity(this)
        activityLifecycle = BaseActivityLifecycle(this)
        activityLifecycle?.let {
            lifecycle.addObserver(it)
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        AppManager.instance.finishActivity(this)
    }

}