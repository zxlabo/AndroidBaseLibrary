package com.base

import android.os.Bundle
import com.baselibrary.base.BaseVMActivity
import com.baselibrary.extension.CreateViewModel
import com.baselibrary.extension.setOnAvoidClickListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseVMActivity<MainViewModel>() {


    override fun setLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initView(savedInstanceState: Bundle?) {
    }

    override fun initListener() {
        btn_test1.setOnAvoidClickListener {
            mViewModel.showTip()
        }
    }

    override fun createViewModel(): MainViewModel = CreateViewModel()
}
