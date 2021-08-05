package com.demo.activity

import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.base.R
import com.demo.coordemo.CoordinatorLayoutDemoActivity
import kotlinx.android.synthetic.main.activity_demo.*

class DemoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo)
//        btn_demo.typeface = Typeface.DEFAULT_BOLD
        btn_demo.paint.setFakeBoldText(true);
        btn_demo.setOnClickListener {
            val intent =
                Intent(this,DemoActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
            finish()
        }
        btn_shake.setOnClickListener { startActivity(Intent(this, ShakeActivity::class.java)) }
        btn_coor.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    CoordinatorLayoutDemoActivity::class.java
                )
            )
        }
    }

}
