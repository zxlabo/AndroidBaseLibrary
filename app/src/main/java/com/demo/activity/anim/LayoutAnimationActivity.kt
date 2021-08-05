package com.demo.activity.anim

import android.os.Bundle
import android.view.animation.AccelerateInterpolator
import android.view.animation.LayoutAnimationController
import android.view.animation.LinearInterpolator
import android.view.animation.ScaleAnimation
import androidx.appcompat.app.AppCompatActivity
import com.base.R
import kotlinx.android.synthetic.main.activity_layout_animation.*


class LayoutAnimationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_layout_animation)
        val adapter = LayoutAnimationAdapter()
        rl_container.adapter = adapter
        val list = mutableListOf<String>()
        for (i in 0..10) {
            list.add("${i}${i}${i}${i}${i}${i}")
        }
        adapter.setData(list)
        val scaleAnimation = ScaleAnimation(0f, 1.0f, 0f, 1.0f) //缩放动画
        scaleAnimation.duration = 500
        scaleAnimation.interpolator = AccelerateInterpolator()//item的插值器
        val controller = LayoutAnimationController(scaleAnimation)
        controller.delay = 2f //两倍duration间隔
        controller.interpolator = LinearInterpolator() //ViewGroup初始化的插值器
        controller.order=LayoutAnimationController.ORDER_NORMAL//设置顺序
        rl_container.layoutAnimation = controller //设置动画

    }
}