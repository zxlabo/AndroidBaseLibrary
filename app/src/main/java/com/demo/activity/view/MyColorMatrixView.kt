package com.demo.activity.view

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View


/**
 * author : Naruto
 * date   : 2020-10-04
 * desc   :
 * version:
 */
class MyColorMatrixView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    private var mPaint = Paint()
    private var mBitMap: Bitmap? = null
    init {

    }
    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        mPaint.isAntiAlias = true
        mPaint.setARGB(255, 200, 100, 100)
        canvas?.drawRect(0f, 0f, 200f, 200f, mPaint)

        canvas?.translate(250f, 0f)
        val colorMatrix = ColorMatrix(
            floatArrayOf(
                0f, 0f, 0f, 0f, 0f, 0f, 0f,
                0f,
                0f,
                0f,
                0f,
                0f,
                1f,
                0f,
                0f,
                0f,
                0f,
                0f,
                1f,
                0f
            )
        )
        mPaint.setColorFilter(ColorMatrixColorFilter(colorMatrix))
        canvas?.drawRect(0f, 0f, 200f, 200f, mPaint)
    }
}