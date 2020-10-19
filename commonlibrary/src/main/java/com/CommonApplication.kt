package com

import android.os.StrictMode
import com.baselibrary.base.BaseApplication
import com.baselibrary.utils.LogUtils
import com.baselibrary.utils.launchstarter.DelayInitDispatcher
import com.baselibrary.utils.launchstarter.TaskDispatcher
import com.common.BuildConfig
import com.tasks.*
import com.tasks.delayinittask.DelayInitTaskA
import com.tasks.delayinittask.DelayInitTaskB

/**
 * author : Naruto
 * date   : 2020-06-12
 * desc   :
 * version:
 */
open class CommonApplication : BaseApplication() {

    var deviceId: String? = null

    override fun onCreate() {
        super.onCreate()

        TaskDispatcher.init(this)
        val dispatcher: TaskDispatcher = TaskDispatcher.createInstance()
        dispatcher
            .addTask(InitCommonTask())
            .addTask(InitDependsTask())
            .addTask(InitMainBTask())
//            .addTask(InitMainTask())
            .addTask(GetDeviceIdTask())
            .addTask(BlockCanaryTask())
            .start()
        dispatcher.await()
        LogUtils.e("CommonApplication await")
        DelayInitDispatcher().addTask(DelayInitTaskA()).addTask(DelayInitTaskB()).start()
        LogUtils.e("CommonApplication onCreate end")
    }

    /**
     * StrictMode类是Android 2.3 （API 9）引入的一个工具类，可以用来帮助开发者发现代码中的一些不规范的问题，以达到提升应用响应能力的目的。
     * 举个例子来说，如果开发者在UI线程中进行了网络操作或者文件系统的操作，而这些缓慢的操作会严重影响应用的响应能力，甚至出现ANR对话框。
     * 为了在开发中发现这些容易忽略的问题，我们使用StrictMode，系统检测出主线程违例的情况并做出相应的反应，最终帮助开发者优化和改善代码逻辑。
     */
    private fun initStrictMode() {
        if (BuildConfig.DEBUG) {
            StrictMode.setThreadPolicy(
                StrictMode.ThreadPolicy.Builder()
                    .detectCustomSlowCalls() //API等级11，使用StrictMode.noteSlowCode
                    .detectDiskReads()
                    .detectDiskWrites()
                    .detectNetwork() // or .detectAll() for all detectable problems
                    .penaltyLog() //在Logcat 中打印违规异常信息
                    .build()
            )
//            StrictMode.setVmPolicy(
//                VmPolicy.Builder()
//                    .detectLeakedSqlLiteObjects()
//                    .setClassInstanceLimit(NewsItem::class.java, 1)
//                    .detectLeakedClosableObjects() //API等级11
//                    .penaltyLog()
//                    .build()
//            )
        }
    }
}