package com.demo.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.MutiTest
import com.base.R
import com.baselibrary.extension.setOnAvoidClickListener
import com.demo.main.MainViewModel
import kotlinx.android.synthetic.main.activity_my_fragment.*

class MyFragmentActivity : AppCompatActivity() {

    private val mFragmentList = mutableListOf<Fragment>()
    private var lastFragment: Fragment? = null

    private var mModel: MainViewModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_fragment)
        mModel = ViewModelProvider(this).get(MainViewModel::class.java)
        Log.e("===MyFragme oncreate:", mModel?.mName?.value ?: "")
        mModel?.mName?.observe(this, Observer {
            Log.e("===MyFragmentActivity:", it)
        })


        initFragment()
        removeAllFragment()
        btn_one.setOnAvoidClickListener {
            chooseTab(0)
        }
        btn_two.setOnAvoidClickListener {
            chooseTab(1)
        }
        btn_change.setOnAvoidClickListener {
            mModel?.mName?.value = "bbbb"
        }

    }

    override fun onResume() {
        super.onResume()
        MutiTest.show()
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