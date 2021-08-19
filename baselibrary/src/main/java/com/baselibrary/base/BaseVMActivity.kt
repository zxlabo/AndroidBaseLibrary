package com.baselibrary.base

abstract class BaseVMActivity<VM : BaseViewModel> : BaseToolBarActivity() {

    protected abstract val mVm: VM

}