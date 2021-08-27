package com.module.common.helper

import android.graphics.BitmapFactory
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.base.R
import com.baselibrary.ui.tab.bottom.TabBottomBean
import com.baselibrary.ui.tab.bottom.TabBottomLayout
import com.demo.fragment.OneFragment
import com.demo.fragment.TwoFragment
import com.utils.AppGlobals
import com.utils.SizeUtils

/**
 * author : Naruto
 * date   : 2021/8/27
 * desc   :
 */
class TabBottomHelper(val supportFragmentManager: FragmentManager) {

    private val mFragmentList = mutableListOf<Fragment>()
    private var lastFragment: Fragment? = null

    fun initTabBottom(tabBottomLayout: TabBottomLayout) {
        initFragment()
        removeAllFragment()
        tabBottomLayout.setTabAlpha(0.85f)
        val bottomInfoList: MutableList<TabBottomBean<*>> = getTabBottomList()
        tabBottomLayout.inflateInfo(bottomInfoList)
        tabBottomLayout.addTabSelectedChangeListener { index, _, _ ->
            chooseTab(index)
        }
        tabBottomLayout.defaultSelected(bottomInfoList[0])
        //        改变某个tab的高度
        val tabBottom = tabBottomLayout.findTab(bottomInfoList[2])
        tabBottom?.apply { resetHeight(SizeUtils.dp2px(66f)) }
    }

    private fun getTabBottomList(): MutableList<TabBottomBean<*>> {
       val context= AppGlobals.getContext()!!
        val bottomInfoList: MutableList<TabBottomBean<*>> = ArrayList()
        val homeInfo = TabBottomBean(
            "首页", "fonts/iconfont.ttf", context.getString(R.string.if_home), null, "#ff656667", "#ffd44949")
        val infoRecommend = TabBottomBean("收藏", "fonts/iconfont.ttf", context.getString(R.string.if_favorite), null, "#ff656667", "#ffd44949")
        val bitmap = BitmapFactory.decodeResource(context.resources, R.drawable.fire, null)
        val infoCategory = TabBottomBean<String>("分类", bitmap, bitmap)
        val infoChat = TabBottomBean("推荐", "fonts/iconfont.ttf", context.getString(R.string.if_recommend), null, "#ff656667", "#ffd44949")
        val infoProfile = TabBottomBean("我的", "fonts/iconfont.ttf", context.getString(R.string.if_profile), null, "#ff656667", "#ffd44949")
        bottomInfoList.add(homeInfo)
        bottomInfoList.add(infoRecommend)
        bottomInfoList.add(infoCategory)
        bottomInfoList.add(infoChat)
        bottomInfoList.add(infoProfile)
        return bottomInfoList
    }

    private fun initFragment() {
        mFragmentList.add(OneFragment())
        mFragmentList.add(TwoFragment())
    }

    private fun removeAllFragment() {
        val transaction = supportFragmentManager.beginTransaction()
        mFragmentList.forEach {
            supportFragmentManager.findFragmentByTag(it::class.java.name)?.apply {
                transaction.remove(this)
            }
        }
        transaction.commitAllowingStateLoss()
    }

    private fun chooseTab(index: Int) {
        if (index >= mFragmentList.size) return
        val currentFragment = mFragmentList[index]
        if (currentFragment == lastFragment) return
        switchSelectedFragment(currentFragment)
    }

    private fun switchSelectedFragment(currentFragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        if (currentFragment.isAdded) {
            lastFragment?.let { transaction.hide(it) }
            transaction.show(currentFragment)
        } else {
            lastFragment?.let { transaction.hide(it) }
            transaction.add(R.id.container, currentFragment, currentFragment::class.java.name)
        }
        transaction.commitAllowingStateLoss()
        lastFragment = currentFragment
    }

}