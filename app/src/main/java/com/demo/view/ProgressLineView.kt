package com.demo.view

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.base.R
import com.baselibrary.utils.ViewUtil

/**
 * author : Naruto
 * date   : 2020/12/11
 * desc   :
 * version:
 */
class ProgressLineView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    private var mPaint = Paint()
    private var progressHeight = ViewUtil.dip2px(14f).toFloat()
    private var defaultColor = Color.parseColor("#F5F6FA")
    private var mPaintColor = defaultColor

    init {
        val array = context.obtainStyledAttributes(attrs, R.styleable.ProgressLineView)
        progressHeight =
            array.getLayoutDimension(R.styleable.ProgressLineView_line_height, 20).toFloat()
        mPaintColor = array.getColor(R.styleable.ProgressLineView_line_color, defaultColor)
        mPaint.color = mPaintColor
        mPaint.isAntiAlias = true
        mPaint.strokeCap = Paint.Cap.ROUND
        mPaint.style = Paint.Style.STROKE
        mPaint.strokeWidth = progressHeight
    }

    private var endX = 0f

    fun setData(rightX: Float) {
        if (rightX > 0) {
            endX = rightX
            invalidate()
        }
    }

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        if (endX > 0) {
            val left = progressHeight / 2
            val y = progressHeight / 2
            canvas?.drawLine(left, y, endX, y, mPaint)
        }
    }


}