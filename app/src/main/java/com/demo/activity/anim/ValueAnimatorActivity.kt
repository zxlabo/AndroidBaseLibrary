package com.demo.activity.anim

import android.animation.ValueAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.base.R
import kotlinx.android.synthetic.main.activity_value_animator.*

class ValueAnimatorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_value_animator)
        btn_begin.setOnClickListener {
            animationBegin()
        }
    }

    private fun animationBegin() {
        ValueAnimator.ofInt(0, 600).apply {
            duration = 1000
            start()
            addUpdateListener { anim ->
                val value = anim.animatedValue as Int
                Log.e("===", value.toString())
                //layout（）函数中上下左右点的坐标是以屏幕坐标来标准的。
                tv_name.layout(value, value, value + tv_name.width, value + tv_name.height)
            }
        }

    }
}

