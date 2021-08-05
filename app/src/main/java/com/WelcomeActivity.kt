package com

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.base.R
import com.demo.activity.DemoActivity
import com.demo.activity.ViewGroup.ViewGroupDemoActivity
import com.demo.activity.anim.AnimationDemoActivity
import com.demo.activity.view.ViewDemoActivity
import com.demo.main.MainActivity
import kotlinx.android.synthetic.main.activity_welcome.*


class WelcomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        btn_main.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
        btn_demo.setOnClickListener {
            startActivity(Intent(this, DemoActivity::class.java))
        }
        btn_memory.setOnClickListener {
            setShape(img_ring, Color.parseColor("#FFEA7D"))
        }
        btn_step.setOnClickListener {

        }
        btn_animation.setOnClickListener {
            startActivity(Intent(this, AnimationDemoActivity::class.java))
        }
        btn_view.setOnClickListener {
            startActivity(Intent(this, ViewDemoActivity::class.java))
        }
        btn_view_group.setOnClickListener {
            startActivity(Intent(this, ViewGroupDemoActivity::class.java))
        }
        btn_flutter.setOnClickListener {
        }
    }


    private fun setShape(view: ImageView, color: Int) {
        val drawable = GradientDrawable()
        drawable.shape = GradientDrawable.OVAL
        drawable.useLevel = false
        drawable.setStroke(4, color)
        drawable.setSize(64, 64)
        view.setImageDrawable(drawable)
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}

