package com.demo.main

import android.graphics.Bitmap
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.base.R
import kotlinx.android.synthetic.main.activity_memory_demo.*


class MemoryDemoActivity : AppCompatActivity() {
    val MSG_MEMORY_JITTER = 0x001

    private val mHandler: Handler = object : Handler() {
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            when (msg.what) {
                MSG_MEMORY_JITTER -> {
                    while (true) {
                        Bitmap.createBitmap(1920, 1080, Bitmap.Config.ARGB_8888)
                    }
                    this.sendEmptyMessageDelayed(MSG_MEMORY_JITTER, 20)
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_memory_demo)
        btn_go.setOnClickListener {
            mHandler.sendEmptyMessage(MSG_MEMORY_JITTER)
        }
    }
}
