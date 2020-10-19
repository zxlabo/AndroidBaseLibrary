package com.demo.activity.view

import android.content.Context
import android.graphics.*
import android.graphics.drawable.AnimationDrawable
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.base.R


/**
 * author : Naruto
 * date   : 2020-10-05
 * desc   :
 * 1、根据手指所在位置画一个圆
 * 2、用贝塞尔曲线，链接两个圆。
 * 3、添加TextView，显示消息数量。
 * 4、当用户点击的时候，设置textview的位置为点击时候的坐标。用户未点击的时候，显示在原来的位置。
 * 5、判断是否画圆（当用户点击的时候，根据当前用户的手指位置，是否在原来的位置内）
 */
class RedPointView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {
    private var mStartPoint: PointF //起始的圆心位置
    private var mCurPoint: PointF//手指当前位置
    private var mPaint: Paint = Paint()
    private var mPath: Path
    private val DEFAULT_RADIUS = 40f
    private var mRadius = DEFAULT_RADIUS
    private var mTouch = false
    private var isAnimStart = false//表示动画效果 当true的时候，贝塞尔曲线和之前的圆应该消失。也就不绘画了

    private var mTv: TextView
    private var mImg: ImageView

    init {
        mPaint.color = Color.RED
        mPaint.style = Paint.Style.FILL
        mPath = Path()
        mStartPoint = PointF(100f, 100f)
        mCurPoint = PointF()
        val params = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        mTv = TextView(getContext())
        mTv.layoutParams = params
        mTv.setPadding(10, 10, 10, 10)
        mTv.setTextColor(Color.WHITE)
        mTv.setTextSize(10f)
        mTv.setBackgroundResource(R.drawable.tip_anim)
        mTv.setText("99+")
        addView(mTv)
        mImg = ImageView(getContext())
        mImg.layoutParams = params
        mImg.setImageResource(R.drawable.loading_main)
        mImg.visibility = View.GONE
        addView(mImg)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        event ?: return false
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                //判断当前点击区域是否在textview内部
                val rect = Rect()
                val location = IntArray(2)
                mTv.getLocationOnScreen(location)
                rect.left = location[0]
                rect.top = location[1]
                rect.right = mTv.width + location[0]
                rect.bottom = mTv.height + location[1]
                if (rect.contains(event.rawX.toInt(), event.rawY.toInt())) {
                    mTouch = true
                }

            }
            MotionEvent.ACTION_UP -> {
                mTouch = false

                if (mRadius < 9) {
                    isAnimStart = true
                    mImg.setX(mCurPoint.x - mTv.getWidth() / 2)
                    mImg.setY(mCurPoint.y - mTv.getHeight() / 2)
                    mImg.setVisibility(View.VISIBLE)
                    val animationDrawable = mImg.getDrawable() as AnimationDrawable
                    animationDrawable.start()
                    postDelayed({
                        animationDrawable.stop()
                        mImg.visibility = View.GONE
                    }, 1000)
                    mTv.visibility = View.GONE
                } else {
                    mRadius = DEFAULT_RADIUS
                }
            }
        }
        mCurPoint.set(event.x, event.y)
        postInvalidate()
        return true
    }

    /**
     * 一、onDraw和dispatchDraw的区别
     * onDraw()的意思是绘制视图自身
     * dispatchDraw()是绘制子视图
     * 无论是View还是ViewGroup对它们俩的调用顺序都是onDraw()->dispatchDraw() 
     * 但在ViewGroup中，当它有背景的时候就会调用onDraw()方法，否则就会跳过onDraw()直接调用dispatchDraw()；
     * 所以如果要在ViewGroup中绘图时，往往是重写dispatchDraw()方法
     * 在View中，onDraw()和dispatchDraw()都会被调用的，所以我们无论把绘图代码放在onDraw()或者dispatchDraw()中都是可以得到效果的，
     * 但是由于dispatchDraw()的含义是绘制子控件，所以原则来上讲，在绘制View控件时，我们是重新onDraw()函数
     * 总结：在绘制View控件时，需要重写onDraw()函数，在绘制ViewGroup时，需要重写dispatchDraw()函数。
     * 二、save()、saveLayer、restore
     * restore：每当调用Restore（）函数，就会把栈中最顶层的画布状态取出来，并按照这个状态恢复当前的画布，并在这个画布上做画。
     * saveLayer(图层)会创建一个全新透明的bitmap，大小与指定保存的区域一致，其后的绘图操作都放在这个bitmap上进行。在绘制结束后，会直接盖在上一层的Bitmap上显示。
     */
    override fun dispatchDraw(canvas: Canvas?) {
        canvas ?: return
        if (!mTouch || isAnimStart) {
            mTv.x = mStartPoint.x - mTv.width / 2
            mTv.y = mStartPoint.y - mTv.height / 2
        } else {
            canvas.drawCircle(mStartPoint.x, mStartPoint.y, mRadius, mPaint)
            calculatePath()
            canvas.drawCircle(mCurPoint.x, mCurPoint.y, DEFAULT_RADIUS, mPaint)
            canvas.drawPath(mPath, mPaint)
            mTv.x = mCurPoint.x - mTv.width / 2
            mTv.y = mCurPoint.y - mTv.height / 2
        }
        super.dispatchDraw(canvas)
    }


    private fun calculatePath() {
        val x = mCurPoint.x
        val y = mCurPoint.y
        val startX = mStartPoint.x
        val startY = mStartPoint.y
        // 根据角度算出四边形的四个点
        val dx = x - startX
        val dy = y - startY
        val a = Math.atan(dy / dx.toDouble())
        val offsetX = mRadius * Math.sin(a)
        val offsetY = mRadius * Math.cos(a)
        val distance = Math.sqrt(
            Math.pow(
                y - startY.toDouble(),
                2.0
            ) + Math.pow(
                x - startX.toDouble(),
                2.0
            )
        ).toFloat()
        mRadius = DEFAULT_RADIUS - distance / 15
        if (mRadius < 9) {
            mRadius = 8F
        }
        // 根据角度算出四边形的四个点
        val x1 = startX + offsetX
        val y1 = startY - offsetY
        val x2 = x + offsetX
        val y2 = y - offsetY
        val x3 = x - offsetX
        val y3 = y + offsetY
        val x4 = startX - offsetX
        val y4 = startY + offsetY
        val anchorX = (startX + x) / 2
        val anchorY = (startY + y) / 2
        mPath.reset()
        mPath.moveTo(x1.toFloat(), y1.toFloat())
        mPath.quadTo(anchorX, anchorY, x2.toFloat(), y2.toFloat())
        mPath.lineTo(x3.toFloat(), y3.toFloat())
        mPath.quadTo(anchorX, anchorY, x4.toFloat(), y4.toFloat())
        mPath.lineTo(x1.toFloat(), y1.toFloat())
    }

    fun resetView() {
        mTv.visibility = View.VISIBLE
        mTouch = false
        isAnimStart = false
        mRadius = DEFAULT_RADIUS
    }

}