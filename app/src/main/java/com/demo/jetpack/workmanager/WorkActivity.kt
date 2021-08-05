package com.demo.jetpack.workmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.work.*
import com.base.R
import com.baselibrary.extension.setOnAvoidClickListener
import com.baselibrary.jetpack.livedata.LiveDataBus2
import kotlinx.android.synthetic.main.activity_work.*
import java.lang.StringBuilder
import java.util.concurrent.TimeUnit

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

    override fun onStart() {
        super.onStart()
        Log.e("====WorkActivity","onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.e("====WorkActivity","onResume")
        LiveDataBus2.get().getChannel(tag,String::class.java).observe(this, Observer {
            Log.e("====WorkActivity",it)
        })
    }

}