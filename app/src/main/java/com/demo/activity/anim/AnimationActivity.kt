package com.demo.activity.anim

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.base.R
import kotlinx.android.synthetic.main.activity_animation.*

class AnimationActivity : AppCompatActivity() {
    private var isOpen = false
    private var radius = 600
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation)
        btn_main.setOnClickListener {
            doAnimation()
        }
    }

    private fun doAnimation() {
        if (isOpen) {
            doAnimationCLose()
        } else {
            doAnimationOpen()
        }
        isOpen = !isOpen
    }

    private fun doAnimationCLose() {
        doAnimationCLose(btn_1, 1, 4, radius)
        doAnimationCLose(btn_2, 2, 4, radius)
        doAnimationCLose(btn_3, 3, 4, radius)
        doAnimationCLose(btn_4, 4, 4, radius)
    }

    private fun doAnimationCLose(view: View?, index: Int, total: Int, radius: Int) {
        val translationX = -Math.sin((Math.PI * index / 2 / total)) * radius
        val translationY = -Math.cos((Math.PI * index / 2 / total)) * radius
        val animatorSet = AnimatorSet()
        animatorSet.playTogether(
            ObjectAnimator.ofFloat(view, "translationX", translationX.toFloat(), 0f),
            ObjectAnimator.ofFloat(view, "translationY", translationY.toFloat(), 0f),
            ObjectAnimator.ofFloat(view, "scaleX", 1f, 0f),
            ObjectAnimator.ofFloat(view, "scaleY", 1f, 0f),
            ObjectAnimator.ofFloat(view, "scaleY", 1f, 0f),
            ObjectAnimator.ofFloat(view, "alpha", 1f, 0f)
        )
        animatorSet.setDuration(500).start()

    }

    private fun doAnimationOpen() {
        doAnimationOpen(btn_1, 1, 4, radius)
        doAnimationOpen(btn_2, 2, 4, radius)
        doAnimationOpen(btn_3, 3, 4, radius)
        doAnimationOpen(btn_4, 4, 4, radius)
    }

    private fun doAnimationOpen(view: View?, index: Int, total: Int, radius: Int) {
        val translationX = -Math.sin((Math.PI * index / 2 / total)) * radius
        val translationY = -Math.cos((Math.PI * index / 2 / total)) * radius
        val animatorSet = AnimatorSet()
        animatorSet.playTogether(
            ObjectAnimator.ofFloat(view, "translationX", 0f, translationX.toFloat()),
            ObjectAnimator.ofFloat(view, "translationY", 0f, translationY.toFloat()),
            ObjectAnimator.ofFloat(view, "scaleX", 0f, 1f),
            ObjectAnimator.ofFloat(view, "scaleY", 0f, 1f),
            ObjectAnimator.ofFloat(view, "scaleY", 0f, 1f),
            ObjectAnimator.ofFloat(view, "alpha", 0f, 1f)
        )
        animatorSet.setDuration(500).start()
    }

}
