package com.demo.coordemo

import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.base.R
import kotlinx.android.synthetic.main.activity_follow_move.*


class FollowMoveActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_follow_move)
        btn_move.setOnTouchListener(object : View.OnTouchListener {
            private var downX = 0f
            private var downY = 0f
            override fun onTouch(v: View, event: MotionEvent): Boolean {
                when (event.action) {
                    MotionEvent.ACTION_DOWN -> {
                        //按下位置
                        downX = event.rawX
                        downY = event.rawY
                    }
                    MotionEvent.ACTION_MOVE -> {
                        val moveX = event.rawX
                        val moveY = event.rawY
                        val dx = moveX - downX
                        val dy = moveY - downY
                        val tX: Float = v.getTranslationX() + dx
                        val tY: Float = v.getTranslationY() + dy
                        v.translationX = tX
                        v.translationY = tY
                        // 下一次按下位置
                        downX = event.rawX
                        downY = event.rawY
                    }
                    MotionEvent.ACTION_UP -> {
                    }
                }
                return true
            }
        })

    }
}
