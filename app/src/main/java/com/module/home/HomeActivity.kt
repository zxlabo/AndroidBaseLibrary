package com.module.home

import android.os.Bundle
import androidx.activity.viewModels
import com.base.databinding.ActivityHomeBinding
import com.baselibrary.base.BaseVmActivity
import com.baselibrary.utils.ext.inflate
import com.baselibrary.utils.ext.inflateView

class HomeActivity : BaseVmActivity<HomeVm>() {

    override val mVm: HomeVm by viewModels()
    private val mBinding :ActivityHomeBinding by inflate()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mBinding.root)
    }



}