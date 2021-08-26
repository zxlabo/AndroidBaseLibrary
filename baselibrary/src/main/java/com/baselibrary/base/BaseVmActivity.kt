package com.baselibrary.base

import android.graphics.Color
import com.ui.activity.BaseToolBarActivity

abstract class BaseVmActivity<VM : BaseViewModel> : BaseToolBarActivity() {

    protected abstract val mVm: VM

    override fun getAppBarColor(): Int {
        return Color.parseColor("#23C5A3")
    }

    override fun getToolBarColor(): Int {
        return Color.parseColor("#23C5A3")
    }

}