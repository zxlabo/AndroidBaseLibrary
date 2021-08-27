package com.module.common.activity

import android.content.Intent
import android.graphics.Color
import androidx.activity.viewModels
import com.base.databinding.ActivitySplashBinding
import com.baselibrary.base.BaseVmActivity
import com.module.common.vm.SplashVm
import com.utils.ext.inflate
import com.utils.ext.setOnAvoidClickListener
import kotlinx.android.synthetic.main.activity_splash.*

/**
 * 开屏页
 * 1、请求获取权限
 * 2、倒计时3s，进入首页
 */

class SplashActivity : BaseVmActivity<SplashVm>() {

    override val mVm: SplashVm by viewModels()
    private val mBinding : ActivitySplashBinding by inflate()

    override fun initView() {
        setContentView(mBinding.root)
        hideToolBar()
        setStatusBarLightMode(true)
        btn_go_home.setOnAvoidClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        }
        btn_go_welcome.setOnAvoidClickListener {
//            startActivity(Intent(this, WelcomeActivity::class.java))
//            finish()
        }
    }

    override fun getAppBarColor(): Int =Color.WHITE

}
