package com.demo.activity.anim

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.base.R
import kotlinx.android.synthetic.main.activity_view_property_animator.*

class ViewPropertyAnimatorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_property_animator)
        btn_skip.setOnClickListener {
            img_share.animate().apply {
                duration = 2000
                translationY(200f)
                translationYBy(200f)
                translationX(200f)
                rotation(200f)
            }
        }
    }
}