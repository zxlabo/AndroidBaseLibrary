package com.baselibrary.base

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlin.properties.Delegates

abstract class BaseActivity : AppCompatActivity() {

    protected var instance: Context by Delegates.notNull()

    protected abstract fun setLayoutId(): Int

    protected abstract fun initView(savedInstanceState: Bundle?)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        instance = this
        setContentView(setLayoutId())
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        initView(savedInstanceState)
        initData()
        initListener()
    }

    protected open fun initData() {}

    protected open fun initListener() {}
}