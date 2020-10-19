package com.demo.activity.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

/**
 * author : Naruto
 * desc   :
 * 1、要实现手指轨迹其实是非常简单的，我们只需要在自定义中拦截OnTouchEvent，然后根据手指的移动轨迹来绘制Path即可。
 * 2、使用Path.lineTo()就能实现把各个点连接起来
 * 3、line是直线，不够平滑。所以我们可以使用贝塞尔曲线来实现平滑过渡。
 * version:
 */
class FingerTrackView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    private var mPath = Path()
    private var mPreX = 0f
    private var mPreY = 0f

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when (event?.action) {
            /**
             * return true表示当前控件已经消费了down动作，之后的ACTION_MOVE、ACTION_UP动作也会继续传递到当前控件中；
             * 如果return false，那么后序的ACTION_MOVE、ACTION_UP动作就不会再传到这个控件来了。
             */
            MotionEvent.ACTION_DOWN -> {
                mPreX = event.x
                mPreY = event.y
                mPath.moveTo(mPreX, mPreY)
                return true
            }
            MotionEvent.ACTION_MOVE -> {
                val mEndx = (mPreX + event.x) / 2
                val mEndY = (mPreY + event.y) / 2
                mPath.quadTo(mPreX, mPreY, mEndx, mEndY)
                mPreX = mEndx
                mPreY = mEndY
                invalidate()
            }
            
        }
        return super.onTouchEvent(event)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val paint = Paint()
        paint.setColor(Color.GREEN)
        paint.isAntiAlias = true
        paint.strokeWidth = 2f
        paint.style = Paint.Style.STROKE
        canvas?.drawPath(mPath, paint)
    }

    fun reset() {
        mPath.reset()
        /**
         * Invalidate()一定要在UI线程执行，如果不是在UI线程就会报错。
         * postInvalidate(),可以在任何线程中执行.利用handler来通知主线程刷新。
         */
        invalidate()
    }
}