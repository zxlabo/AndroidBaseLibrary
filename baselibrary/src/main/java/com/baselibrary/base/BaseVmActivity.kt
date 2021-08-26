package com.baselibrary.base

abstract class BaseVmActivity<VM : BaseViewModel> : BaseToolBarActivity() {

    protected abstract val mVm: VM

}