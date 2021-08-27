package com.demo.fragment

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.base.R
import com.demo.activity.DemoActivity
import com.demo.activity.ViewGroup.ViewGroupDemoActivity
import com.demo.activity.anim.AnimationDemoActivity
import com.demo.activity.view.ViewDemoActivity
import com.demo.main.MainActivity
import kotlinx.android.synthetic.main.fragment_one.*

/**
 * author : Naruto
 * date   : 2020/11/17
 * desc   :
 * version:
 */
class OneFragment : Fragment() {

    private val mModel: OneViewModel by viewModels()

    val tagName by lazy {
        this::class.java.name
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_one, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_main.setOnClickListener {
            startActivity(Intent(activity, MainActivity::class.java))
        }

        btn_demo.setOnClickListener {
            startActivity(Intent(activity, DemoActivity::class.java))
        }
        btn_animation.setOnClickListener {
            startActivity(Intent(activity, AnimationDemoActivity::class.java))
        }
        btn_view.setOnClickListener {
            startActivity(Intent(activity, ViewDemoActivity::class.java))
        }
        btn_view_group.setOnClickListener {
            startActivity(Intent(activity, ViewGroupDemoActivity::class.java))
        }
        btn_shape.setOnClickListener {
            setShape(img_ring, Color.parseColor("#FFEA7D"))
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

}