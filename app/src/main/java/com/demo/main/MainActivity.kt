package com.demo.main

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import com.WebViewActivity
import com.base.R
import com.baselibrary.base.BaseVMActivity
import com.baselibrary.extension.CreateViewModel
import com.baselibrary.extension.setOnAvoidClickListener
import com.utils.time_monitor.TimeMonitorConfig
import com.utils.time_monitor.TimeMonitorManager
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseVMActivity<MainViewModel>() {


    override fun onCreate(savedInstanceState: Bundle?) {
        TimeMonitorManager.getInstance()
            .getTimeMonitor(TimeMonitorConfig.TIME_MONITOR_ID_APPLICATION_START)
            .recordingTimeTag("SplashActivity-onCreate")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initListener()
        TimeMonitorManager.getInstance()
            .getTimeMonitor(TimeMonitorConfig.TIME_MONITOR_ID_APPLICATION_START)
            .recordingTimeTag("SplashActivity-onCreate-Over")

    }

    override fun onResume() {
        super.onResume()
        Handler().postDelayed({ startActivity(Intent(this, WebViewActivity::class.java)) }, 1000)

    }
    override fun onStart() {
        super.onStart()
        TimeMonitorManager.getInstance()
            .getTimeMonitor(TimeMonitorConfig.TIME_MONITOR_ID_APPLICATION_START)
            .end("SplashActivity-onStart", false);
    }

    override fun createViewModel(): MainViewModel = CreateViewModel()

    private fun initListener() {
        btn_test1.setOnAvoidClickListener {
            Handler().postDelayed(Runnable {
                Log.e("===", Thread.currentThread().name)
            }, 500)
        }
        btn_web.setOnAvoidClickListener {
            startActivity(Intent(this, WebViewActivity::class.java))
        }
    }

}
