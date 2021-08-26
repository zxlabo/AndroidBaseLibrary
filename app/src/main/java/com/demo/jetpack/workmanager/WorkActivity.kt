package com.demo.jetpack.workmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.work.*
import com.base.R
import com.utils.ext.setOnAvoidClickListener
import kotlinx.android.synthetic.main.activity_work.*

class WorkActivity : AppCompatActivity() {
    private val tag="live_data_tag"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_work)
//        val workRequest = OneTimeWorkRequest.Builder(UploadWork::class.java).build()
//        WorkManager.getInstance().enqueue(workRequest)


        btn_work.setOnAvoidClickListener {
            val build = OneTimeWorkRequest.Builder(UploadWork::class.java).build()
            WorkManager.getInstance(this).enqueue(build)
//            var uploadWorkRequest = OneTimeWorkRequest.from(UploadWork::class.java)
//            var uploadWorkRequest  =PeriodicWorkRequest.Builder(UploadWork::class.java,20,TimeUnit.MINUTES).build()
//            WorkManager.getInstance(this).enqueue(uploadWorkRequest)
//            WorkManager.getInstance().enqueue(uploadWorkRequest)
        }
    }


}