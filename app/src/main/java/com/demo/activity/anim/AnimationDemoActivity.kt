package com.demo.activity.anim

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.base.R
import com.baselibrary.extension.setOnAvoidClickListener
import kotlinx.android.synthetic.main.activity_animation_demo.*

class AnimationDemoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation_demo)
        btn_value.setOnAvoidClickListener {
            startActivity(Intent(this, ValueAnimatorActivity::class.java))
        }
        btn_object.setOnAvoidClickListener {
            startActivity(Intent(this, ObjectAnimatorActivity::class.java))
        }
        btn_interpolator.setOnAvoidClickListener {
            startActivity(Intent(this, InterpolatorActivity::class.java))
        }
    }
}
