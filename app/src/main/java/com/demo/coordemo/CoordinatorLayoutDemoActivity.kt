package com.demo.coordemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.base.R
import kotlinx.android.synthetic.main.activity_coordinator_layout_demo.*


/**
 * 1、
 * 2、
 * 3、
 * layout_collaspeMode
 */
class CoordinatorLayoutDemoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coordinator_layout_demo)
        btn_move.setOnClickListener { startActivity(Intent(this, FollowMoveActivity::class.java)) }
        btn_appbar.setOnClickListener { startActivity(Intent(this, AppBarDemoActivity::class.java)) }
        btn_coll.setOnClickListener { startActivity(Intent(this, CollapseActivity::class.java)) }
        btn_head.setOnClickListener { startActivity(Intent(this, HeadActivity::class.java)) }
    }
}
