package com

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.base.R

/**
 * 开屏页
 * 1、请求获取权限
 * 2、倒计时3s，进入首页
 */

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
    }

}
