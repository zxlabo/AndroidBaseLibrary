package com.demo.activity.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import com.baselibrary.utils.ViewUtil
import com.demo.activity.WeightPointBean

/**
 * author : Naruto
 * date   : 3/2/21
 * desc   :
 * version:
 */
class WeightLineDetailView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    private var itemWidth =
        ((this.context.resources.displayMetrics.widthPixels) - ViewUtil.dip2px(66f)) / 20
    private var mPaint: Paint = Paint()
    private var mPaint2: Paint = Paint()
    private var mCirclePaint: Paint = Paint()
    private var mTextPaint: Paint = Paint()
    private val xList = mutableListOf<Float>()
    private var mRadius = ViewUtil.dip2px(3f).toFloat()

    private val mWeightList = mutableListOf<Float>()

    init {
        mPaint.color = Color.parseColor("#3300c4b3")
        mPaint.style = Paint.Style.FILL
        mPaint.isAntiAlias = true
        mPaint2.color = Color.parseColor("#00C4B3")
        mPaint2.strokeWidth = ViewUtil.dip2px(2f).toFloat()
        mPaint2.style = Paint.Style.FILL
        mPaint2.isAntiAlias = true
        mCirclePaint.color = Color.parseColor("#00C4B3")
        mCirclePaint.strokeWidth = ViewUtil.dip2px(2f).toFloat()
        mCirclePaint.style = Paint.Style.STROKE
        mCirclePaint.isAntiAlias = true
        mTextPaint.color = Color.parseColor("#00C4B3")
        mTextPaint.isAntiAlias = true
        mTextPaint.textSize = ViewUtil.dip2px(11f).toFloat()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        for (i in 0..40) {
            mWeightList.add(45.6f)
        }
        val listTop = mutableListOf<WeightPointBean>()
        val listBottom = mutableListOf<WeightPointBean>()
        var x = 0f
        var y = height.toFloat()
        xList.clear()
        for (i in 0..40) {
            xList.add(x)
            listTop.add(WeightPointBean(x, y))
            listBottom.add(WeightPointBean(x, y - 40f))
            x += itemWidth
            y -= 5f
        }
        val path = Path()
        path.moveTo(listTop[0].pointX, listTop[0].pointY)
        for (weightPointBean in listTop) {
            path.lineTo(weightPointBean.pointX, weightPointBean.pointY)
        }
        for (i in (listBottom.size - 1) downTo 0) {
            path.lineTo(listBottom[i].pointX, listBottom[i].pointY)
        }
        path.close()
        canvas?.drawPath(path, mPaint)
        if (drawTouch) {
            touchPosition?.let { pos ->
                val bean = listTop[touchPosition]
                val bean2 = listBottom[touchPosition]
                val touchX = bean.pointX
                canvas?.drawLine(touchX, height.toFloat(), touchX, 0f, mPaint2)
                canvas?.drawCircle(touchX, bean.pointY, mRadius, mCirclePaint)
                canvas?.drawCircle(touchX, bean2.pointY, mRadius, mCirclePaint)
                canvas?.drawText(
                    mWeightList[touchPosition].toString(),
                    touchX + ViewUtil.dip2px(10f).toFloat(),
                    bean.pointY,
                    mTextPaint
                )
                canvas?.drawText(
                    mWeightList[touchPosition].toString(),
                    touchX + ViewUtil.dip2px(10f).toFloat(),
                    bean2.pointY,
                    mTextPaint
                )
            }
//            drawTouch = false
        }
    }

    private var drawTouch = false
    private var touchPosition = 0

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when (event?.action) {
            MotionEvent.ACTION_DOWN -> {
                return true
            }
            MotionEvent.ACTION_MOVE -> {
                getTouchX(event.x)
                drawTouch = true
                postInvalidate()
            }
        }
        return super.onTouchEvent(event)
    }

    private fun getTouchX(touchX: Float) {
        touchPosition = 0
        for (i in 0 until xList.size) {
            if (xList[i] >= touchX) {
                touchPosition = i
                break
            }
        }
    }

}