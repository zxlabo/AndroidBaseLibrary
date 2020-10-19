package com.demo.activity.anim

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

/**
 * author : Naruto
 * date   : 2020-09-25
 * desc   :
 * version:
 */
class MyPointView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    private var mPoint = Point(100f)
    override fun onDraw(canvas: Canvas?) {
        if (mPoint != null) {
            val paint = Paint()
            paint.isAntiAlias = true
            paint.setColor(Color.RED)
            paint.style = Paint.Style.FILL
            canvas?.drawCircle(300f, 300f, mPoint.mRadius, paint)
        }
        super.onDraw(canvas)
    }

    fun setPointRadius(radius: Float) {
        mPoint.mRadius = radius
        invalidate()//ui线程调用
    }
    fun getPointRadius():Float{
        return 50f
    }
}