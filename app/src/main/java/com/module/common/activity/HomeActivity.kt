package com.module.common.activity

import android.view.KeyEvent
import androidx.activity.viewModels
import com.base.databinding.ActivityHomeBinding
import com.baselibrary.base.BaseVmActivity
import com.module.common.helper.TabBottomHelper
import com.module.common.vm.HomeVm
import com.utils.ext.inflate
import com.utils.ext.showToast

class HomeActivity : BaseVmActivity<HomeVm>() {

    override val mVm: HomeVm by viewModels()
    private val mBinding: ActivityHomeBinding by inflate()
    private var mExitTime: Long = 0

    override fun initView() {
        setContentView(mBinding.root)
        hideToolBar()
        initTabBottom()
    }

    private fun initTabBottom() {
        val tabBottomHelper = TabBottomHelper(supportFragmentManager)
        tabBottomHelper.initTabBottom(mBinding.hitablayout)
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (System.currentTimeMillis() - mExitTime >= 2000) {
                showToast("再按一次退出应用")
                mExitTime = System.currentTimeMillis()
            } else {
                finish()
            }
            return false
        }
        return super.onKeyDown(keyCode, event)
    }

}