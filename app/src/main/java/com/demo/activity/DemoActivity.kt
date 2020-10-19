package com.demo.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.base.R
import com.demo.coordemo.CoordinatorLayoutDemoActivity
import kotlinx.android.synthetic.main.activity_demo.*

class DemoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo)
        btn_shake.setOnClickListener { startActivity(Intent(this, ShakeActivity::class.java)) }
        btn_coor.setOnClickListener { startActivity(Intent(this, CoordinatorLayoutDemoActivity::class.java)) }
    }
}
