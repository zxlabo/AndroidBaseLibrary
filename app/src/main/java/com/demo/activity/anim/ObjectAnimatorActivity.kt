package com.demo.activity.anim

import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.base.R
import kotlinx.android.synthetic.main.activity_object_animator.*

class ObjectAnimatorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_object_animator)
        btn_begin.setOnClickListener {
            animationBegin()
        }
        btn_begin_custom.setOnClickListener {
            animationCustomBegin()
        }
    }


    private fun animationBegin() {
        val animator = ObjectAnimator.ofFloat(tv_name, "alpha", 1f, 0f, 1f)
        animator.duration = 2000
        animator.start()
    }

    private fun animationCustomBegin() {
        val animator = ObjectAnimator.ofFloat(point_view, "pointRadius", 0f, 300f, 100f)
        animator.duration = 2000
        animator.start()
    }

}
