package com.baselibrary.base

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.LinearLayout
import androidx.appcompat.widget.Toolbar
import com.baselibrary.R
import com.baselibrary.utils.BarUtils
import com.google.android.material.appbar.AppBarLayout

/**
 * author : Naruto
 * date   : 2019-10-22
 * desc   :
 * version:
 */
open class BaseToolBarActivity : BaseLifecycleActivity() {

    private var statusBarHeight = 0
    private var toolbar: Toolbar? = null
    private var appbar: AppBarLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        super.setContentView(R.layout.activity_base)
        statusBarHeight = BarUtils.getStatusBarHeight(applicationContext)
        setTranslucentStatus()
    }

    /**
     * 设置状态栏透明
     */
    @SuppressLint("ObsoleteSdkInt")
    private fun setTranslucentStatus() {
        // 5.0以上系统状态栏透明
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window = window
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.decorView.systemUiVisibility =
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = Color.TRANSPARENT
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        }
    }

    /**
     * 设置状态栏颜色
     */
    @SuppressLint("ObsoleteSdkInt")
     fun setStatusBarColor(color: Int) {
        // 5.0以上系统状态栏透明
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window = window
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.decorView.systemUiVisibility =
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = color
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        }
    }

    override fun setContentView(layoutId: Int) {
        val rootLayout = findViewById<LinearLayout>(R.id.root_layout)
        toolbar = findViewById(R.id.toolbar)
        appbar = findViewById(R.id.appbar)
        val params = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        rootLayout.addView(View.inflate(this, layoutId, null), params)
        if (toolbar != null) {
            setSupportActionBar(toolbar)
            supportActionBar?.setDisplayHomeAsUpEnabled(true) // 设置返回按钮可见
            supportActionBar?.setDisplayShowHomeEnabled(true) // 设置是否显示logo图标
            supportActionBar?.setHomeButtonEnabled(true) // 设置左上角的图标可点击
        }
        val barHeight =
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) statusBarHeight else 0

        appbar?.let {
            it.setPadding(0, barHeight, 0, 0)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                it.elevation = 3f
            }
        }

    }

    fun hideToolBar() {
        toolbar?.visibility = View.GONE
    }

    /**
     * 设置导航颜色
     *
     * @param color
     */
    fun setNavigatorColor(color: Int) {
        toolbar?.setBackgroundColor(color)
        appbar?.setBackgroundColor(color)
    }

    /**
     * 设置状态栏是否为浅色模式
     */
    fun setStatusBarLightMode(lightMode: Boolean) {
        BarUtils.setStatusBarLightMode(this, lightMode)
    }

}