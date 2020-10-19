package com.demo.coordemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import com.base.R
import kotlinx.android.synthetic.main.activity_follow_move.*

class FollowMoveActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_follow_move)
        btn_move.setOnTouchListener { view, motionEvent ->
            if (motionEvent!!.action == MotionEvent.ACTION_MOVE) {
                view!!.x = motionEvent.rawX -view.width /2
                view!!.y = motionEvent.rawY -view.height /2
            }
            true
        }
    }
}
