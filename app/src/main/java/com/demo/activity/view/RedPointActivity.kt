package com.demo.activity.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.base.R
import kotlinx.android.synthetic.main.activity_red_point.*

class RedPointActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_red_point)
        dot_view.showNum(22)
//        val drgView = DragView2(this)
//        drgView.initRedView(this, red_view)
//        btn_reset.setOnClickListener {
//            red_view.resetView()
//        }
    }
}
