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
        val animator = ValueAnimator.ofInt(0, 600)
        animator.addUpdateListener { anim ->
            val value = anim.animatedValue as Int
            Log.e("===", value.toString())
            /**
             *  layout（）函数中上下左右点的坐标是以屏幕坐标来标准的。
             *  layout函数在改变控件位置时是永久性的，即通过更改控件left,top,right,bottom这四个点的坐标来改更改坐标位置的，
             *  所以通过layout函数更改位置后，控件在新位置是可以响应点击事件的。 
             */
            tv_name.layout(value, value, value + tv_name.width, value + tv_name.height)
        }
        animator.duration = 1000
        animator.start()
    }
}

