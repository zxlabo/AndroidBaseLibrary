package com.main

import android.content.Context
import android.util.Log
import com.CommonApplication
import com.MutiTest
import com.baselibrary.utils.AppUtils
import com.squareup.leakcanary.LeakCanary
import com.squareup.leakcanary.RefWatcher
import com.tencent.smtt.sdk.QbSdk
import com.tencent.smtt.sdk.QbSdk.PreInitCallback
import com.utils.time_monitor.TimeMonitorConfig
import com.utils.time_monitor.TimeMonitorManager


/**
 * author : Naruto
 * date   : 2020-06-10
 * desc   :
 * version:
 */
class AppApplication : CommonApplication() {
    private var refWatcher: RefWatcher? = null


    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        TimeMonitorManager.getInstance()
            .resetTimeMonitor(TimeMonitorConfig.TIME_MONITOR_ID_APPLICATION_START)
    }

    override fun onCreate() {
        super.onCreate()
        MutiTest.init(AppUtils.getProcessName(this))
        TimeMonitorManager.getInstance()
            .getTimeMonitor(TimeMonitorConfig.TIME_MONITOR_ID_APPLICATION_START)
            .recordingTimeTag("Application-onCreate")
        //打印结果 TimeMonitorApplication-onCreate: 417
        // Instantiate a FlutterEngine.
//        initFlutterEngine()
//        initX5()
//        if (LeakCanary.isInAnalyzerProcess(this)) {
//            // 1
//            Log.e("====","LeakCanary.isInAnalyzerProcess(this)")
//            return;
//        }
        // 2
        Log.e("====","LeakCanary.install(this)")
        refWatcher = LeakCanary.install(this);
    }

    private fun initX5() {
        //下载x5内核，可以不需要，因为会共用其他软件的x5内核，比如微信、QQ等
        QbSdk.setDownloadWithoutWifi(true)

        QbSdk.initX5Environment(this, object : PreInitCallback {
            override fun onCoreInitFinished() {
                Log.e("snow", "========onCoreInitFinished===")
            }

            override fun onViewInitFinished(b: Boolean) {
                //加载x5内核成功返回值为true，否则返回false，加载失败会调用系统的webview
                Log.e("snow", "x5初始化结果====$b")
            }
        })
    }


}