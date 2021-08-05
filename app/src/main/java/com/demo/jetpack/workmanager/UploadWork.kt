package com.demo.jetpack.workmanager

import android.content.Context
import android.os.Handler
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import java.lang.StringBuilder

/**
 * author : Naruto
 * date   : 2020/11/9
 * desc   :
 * version:
 */
class UploadWork(context: Context, params: WorkerParameters) : Worker(context, params) {
    var sb= StringBuilder()
    override fun doWork(): Result {
        uploadImage()
        return Result.success()
    }

    private fun uploadImage() {
        Log.e("==work:", Thread.currentThread().name)
        Thread.sleep(10000)
        Log.e("==work:", "uploadImage")
    }
}