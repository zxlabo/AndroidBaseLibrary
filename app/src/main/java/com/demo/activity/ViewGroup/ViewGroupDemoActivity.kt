package com.demo.activity.ViewGroup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.base.R
import kotlinx.android.synthetic.main.activity_view_group_demo.*

class ViewGroupDemoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_group_demo)
        btn_flow.setOnClickListener { startActivity(Intent(this,FlowLayoutActivity::class.java)) }
    }
}
