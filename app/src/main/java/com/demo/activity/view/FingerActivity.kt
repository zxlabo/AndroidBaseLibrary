package com.demo.activity.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.base.R
import kotlinx.android.synthetic.main.activity_finger.*

class FingerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finger)
        btn_reset.setOnClickListener {
            my_finger_track_view.reset()
        }
    }
}
