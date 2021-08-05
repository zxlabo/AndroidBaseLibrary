package com.demo.activity.anim

import android.animation.Keyframe
import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat
import com.base.R
import kotlinx.android.synthetic.main.activity_share_a.*


class ShareAActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share_a)
        btn_skip.setOnClickListener {
            val bundle=
                ActivityOptionsCompat.makeSceneTransitionAnimation(this,img_share,"shareElement").toBundle()
            startActivity(Intent(this,ShareBActivity::class.java),bundle)
        }
    }


}