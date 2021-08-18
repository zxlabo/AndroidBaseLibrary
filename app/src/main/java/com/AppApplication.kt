package com

import android.content.Context
import com.CommonApplication
import com.utils.time_monitor.TimeMonitorConfig
import com.utils.time_monitor.TimeMonitorManager


/**
 * author : Naruto
 * date   : 2020-06-10
 * desc   :
 * version:
 */

class AppApplication : CommonApplication() {

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        TimeMonitorManager.getInstance()
            .resetTimeMonitor(TimeMonitorConfig.TIME_MONITOR_ID_APPLICATION_START)
    }


    override fun onCreate() {
        super.onCreate()
        TimeMonitorManager.getInstance()
            .getTimeMonitor(TimeMonitorConfig.TIME_MONITOR_ID_APPLICATION_START)
            .recordingTimeTag("Application-onCreate")
    }

}