package com.demo.activity.anim

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.TimeInterpolator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.*
import com.base.R
import kotlinx.android.synthetic.main.activity_interpolator.*

class InterpolatorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_interpolator)
        btn_begin.setOnClickListener {
            doAnimation(tv_name,LinearInterpolator())
            doAnimation(tv_name2, BounceInterpolator())
            doAnimation(tv_name3, AnticipateInterpolator())
        }
    }

    private fun doAnimation(view:View,interpolator: TimeInterpolator) {
        val translationX = ObjectAnimator.ofFloat(view, "translationX", 0f, 800f,100f)
        val translationY = ObjectAnimator.ofFloat(view, "translationY", 0f, 800f,100f)
        val animatorSet = AnimatorSet()
        animatorSet.play(translationX).with(translationY)
        animatorSet.interpolator =interpolator
        animatorSet.duration = 2000
        animatorSet.start()
    }

}
