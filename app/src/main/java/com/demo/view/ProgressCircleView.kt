package com.demo.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import com.base.R

/**
 * author : Naruto
 * date   : 2020/12/17
 * desc   :
 * version:
 */
class ProgressCircleView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private var progressBgPaint = Paint()
    private var progressBgColor = Color.parseColor("#F5F6FA")

    private var progressPaint = Paint()
    private var progressColor = Color.parseColor("#F5F6FA")
    private var progressHeight = 12
    private var rectF: RectF = RectF()
    private var mProgress = -1f
    private val totalProgress = 360f
    private var startAngle = 270f

    private var progressSize = 40f

    init {
        val array = context.obtainStyledAttributes(attrs, R.styleable.ProgressCircleView)
        progressHeight = array.getLayoutDimension(
            R.styleable.ProgressCircleView_circle_progress_height,
            progressHeight
        )
        progressBgColor =
            array.getColor(R.styleable.ProgressCircleView_circle_progress_bg_color, progressBgColor)
        progressColor =
            array.getColor(R.styleable.ProgressCircleView_circle_progress_color, progressColor)

        progressBgPaint.color = progressBgColor
        progressBgPaint.strokeWidth = progressHeight.toFloat()
        progressBgPaint.strokeCap = Paint.Cap.ROUND
        progressBgPaint.style = Paint.Style.STROKE
        progressBgPaint.isAntiAlias = true

        progressPaint.color = progressColor
        progressPaint.strokeWidth = progressHeight.toFloat()
        progressPaint.strokeCap = Paint.Cap.ROUND
        progressPaint.style = Paint.Style.STROKE
        progressPaint.isAntiAlias = true
    }

    fun setProgress(progress: Float) {
        val gap = progressHeight / 2f
        mProgress = progress
        progressSize = width.toFloat()
        val left = gap
        val top = gap
        val right = progressSize - gap
        val bottom = progressSize - gap
        rectF.set(left, top, right, bottom)
        invalidate()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        if (mProgress >= 0) {
            val sweepAngle = totalProgress * mProgress
            canvas?.drawArc(rectF, startAngle, totalProgress, false, progressBgPaint)
            canvas?.drawArc(rectF, startAngle, sweepAngle, false, progressPaint)
        }
    }
}