package com.recy

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.LinearLayout

/**
 * author : Naruto
 * date   : 3/25/21
 * desc   :
 * version:
 */
class MySmoothView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    var x1 = 0f
    var x2 = 0f
    var y1 = 0f
    var y2 = 0f

    override fun onInterceptTouchEvent(event: MotionEvent?): Boolean {
        when (event?.action) {

            MotionEvent.ACTION_DOWN -> {
                x1 = event.x
                y1 = event.y
            }

            MotionEvent.ACTION_UP -> {
                x2 = event.x
                y2 = event.y
                if (y1 - y2 > 50) {
                    Log.e("====",(y1 - y2).toString())
                    Log.e("====", "向上滑")
                } else if (y2 - y1 > 50) {
                    Log.e("====", "向下滑")
                } else if (x1 - x2 > 50) {
                    Log.e("====", "向左滑")
                } else if (x2 - x1 > 50) {
                    Log.e("====", "向右滑")
                }
            }
        }
        return super.onInterceptTouchEvent(event)
    }


//    override fun onTouchEvent(event: MotionEvent?): Boolean {
//        when (event?.action) {
//
//            MotionEvent.ACTION_DOWN -> {
//                x1 = event.x
//                y1 = event.y
////                return true
//            }
//
//            MotionEvent.ACTION_UP -> {
//                x2 = event.x
//                y2 = event.y
//                if (y1 - y2 > 50) {
//                    Log.e("====", "向上滑")
//                } else if (y2 - y1 > 50) {
//                    Log.e("====", "向下滑")
//                } else if (x1 - x2 > 50) {
//                    Log.e("====", "向左滑")
//                } else if (x2 - x1 > 50) {
//                    Log.e("====", "向右滑")
//                }
//            }
//        }
//        return super.onTouchEvent(event)
//    }


}