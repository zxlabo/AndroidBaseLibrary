package com.demo.coordemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.base.R
import com.demo.activity.DemoActivity
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
        btn_move.setOnClickListener {

//            startActivity(Intent(this, FollowMoveActivity::class.java))
            val intent =
                Intent(this, DemoActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
            finish()
        }
        btn_appbar.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    AppBarDemoActivity::class.java
                )
            )
        }
        btn_coll.setOnClickListener { startActivity(Intent(this, CollapseActivity::class.java)) }
        btn_head.setOnClickListener { startActivity(Intent(this, HeadActivity::class.java)) }
        btn_suspension.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    SuspensionActivity::class.java
                )
            )
        }
        btn_fit.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    FitSystemWindowActivity::class.java
                )
            )
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("===onDestroy","CoordinatorLayoutDemoActivity")
    }
}
