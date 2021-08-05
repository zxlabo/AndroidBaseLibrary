package com.demo.jetpack

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import com.base.R
import com.baselibrary.jetpack.livedata.LiveDataBus2
import com.demo.jetpack.workmanager.WorkActivity
import kotlinx.android.synthetic.main.activity_live_data.*

class LiveDataActivity : AppCompatActivity() {
    private val tag="live_data_tag"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live_data)
        LiveDataBus2.get().getChannel(tag,String::class.java).observe(this, Observer {
            Log.e("====LiveDataActivity",it)
        })
        btn_work.setOnClickListener {
            LiveDataBus2.get().getChannel(tag).value="hello"
        }
        btn_livedata.setOnClickListener {
            startActivity(Intent(this, WorkActivity::class.java))
        }
    }


}