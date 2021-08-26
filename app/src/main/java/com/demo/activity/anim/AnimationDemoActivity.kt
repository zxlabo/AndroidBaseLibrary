package com.demo.activity.anim

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import com.base.R
import com.baselibrary.utils.ext.setOnAvoidClickListener
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
        btn_view_group.setOnAvoidClickListener {
            startActivity(Intent(this, ViewGroupLayoutTransitionActivity::class.java))
        }
        btn_state.setOnAvoidClickListener {
            startActivity(Intent(this, StateListAnimatorActivity::class.java))
        }
        btn_show_hide.setOnAvoidClickListener {
            startActivity(Intent(this, ShowHideActivity::class.java))
        }
        btn_share.setOnAvoidClickListener {
            startActivity(Intent(this, ShareAActivity::class.java))
        }
        btn_view_property_animator.setOnAvoidClickListener {
            startActivity(Intent(this, ViewPropertyAnimatorActivity::class.java))
        }
        btn_layout_animation.setOnAvoidClickListener {
            startActivity(Intent(this, LayoutAnimationActivity::class.java))
        }
        img_scale.setOnAvoidClickListener {
            val animation = ScaleAnimation(1.0f, 2.0f, 1.0f, 2.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f)
            animation.duration = (5 * 1000).toLong()
            animation.fillAfter = true
            img_scale.startAnimation(animation)
        }


    }
}
