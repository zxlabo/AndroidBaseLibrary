package com.demo.jetpack

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.base.R
import com.demo.jetpack.workmanager.WorkActivity
import kotlinx.android.synthetic.main.activity_live_data.*

class LiveDataActivity : AppCompatActivity() {
    private val tag="live_data_tag"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live_data)

        btn_work.setOnClickListener {
        }
        btn_livedata.setOnClickListener {
            startActivity(Intent(this, WorkActivity::class.java))
        }
    }


}