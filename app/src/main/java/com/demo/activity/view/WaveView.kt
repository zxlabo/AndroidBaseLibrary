package com.demo.activity.view

import android.animation.AnimatorSet
import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View
import android.view.animation.LinearInterpolator

/**
 * author : Naruto
 * desc   : 水波纹
 * version:
 */
class WaveView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    private var mPaint = Paint()
    private var mPath = Path()
    private var mItemWaveLength = 1000
    private var mWaveHeight = 100f
    private var dx = 0f
    private var dy = 0f

    init {
        mPaint.color = Color.GREEN
        mPaint.style = Paint.Style.FILL_AND_STROKE
        mPaint.strokeWidth = 4f
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        mPath.reset()
        val halfItemWaveLength = mItemWaveLength / 2
        mPath.moveTo(-mItemWaveLength.toFloat() + dx, 300f + dy)
        for (i in -mItemWaveLength..(width + mItemWaveLength) step mItemWaveLength) {
            mPath.rQuadTo(halfItemWaveLength / 2.toFloat(), -mWaveHeight, halfItemWaveLength.toFloat(), 0f)
            mPath.rQuadTo(halfItemWaveLength / 2.toFloat(), mWaveHeight, halfItemWaveLength.toFloat(), 0f)
        }
        mPath.lineTo(width.toFloat(), height.toFloat())
        mPath.lineTo(0f, height.toFloat())
        mPath.close()
        canvas?.drawPath(mPath, mPaint)
    }

    fun startAnim() {
        val animatorX = ValueAnimator.ofFloat(0f, mItemWaveLength.toFloat())
        //无限循环
        animatorX.repeatCount = ValueAnimator.INFINITE
        animatorX.duration = 2000
        //设置LinerInterpolator保持匀速动画，不会有暂停的效果
        animatorX.interpolator = LinearInterpolator()
        animatorX.addUpdateListener {
            dx = it.animatedValue as Float
            postInvalidate()
        }
        animatorX.start()
    }

}