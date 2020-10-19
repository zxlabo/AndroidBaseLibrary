package com.demo.activity.view

import android.content.Context
import android.graphics.*
import android.os.Build
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import androidx.annotation.RequiresApi
import com.base.R


/**
 * author : Naruto
 * date   : 2020-10-04
 * desc   : 橡皮擦
 * version:
 */
class EraserView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    private var mBitPaint: Paint = Paint()
    private lateinit var mBmpDST: Bitmap
    private lateinit var mBmpSRC: Bitmap
    private val mPath: Path = Path()
    private var mPreX = 0f
    private var mPreY = 0f

    init {
        setLayerType(View.LAYER_TYPE_HARDWARE, null)//禁用硬件加速
        mBitPaint.color = Color.RED
        mBitPaint.style = Paint.Style.STROKE
        mBitPaint.strokeWidth = 45f
        mBmpSRC = BitmapFactory.decodeResource(resources, R.mipmap.naruto)
        mBmpDST = Bitmap.createBitmap(mBmpSRC.width, mBmpSRC.height, Bitmap.Config.ARGB_8888)
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val layerId =
            canvas?.saveLayer(
                0f, 0f,
                width.toFloat(),
                height.toFloat(), null
            )
        //先把手指轨迹画到目标bitmap上
        val c = Canvas(mBmpDST)
        c.drawPath(mPath, mBitPaint)
        //把目标图像画到画布上
        canvas?.drawBitmap(mBmpDST, 0f, 0f, mBitPaint)

        //计算源图像区域
        mBitPaint.setXfermode(PorterDuffXfermode(PorterDuff.Mode.SRC_OUT))
        canvas?.drawBitmap(mBmpSRC, 0f, 0f, mBitPaint)

        mBitPaint.xfermode = null
        canvas?.restoreToCount(layerId!!)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when (event?.action) {
            MotionEvent.ACTION_DOWN -> {
                mPath.moveTo(event.x, event.y)
                mPreX = event.x
                mPreY = event.y
                return true
            }
            MotionEvent.ACTION_MOVE -> {
                val endX = (mPreX + event.x) / 2
                val endY = (mPreY + event.y) / 2
                mPath.quadTo(mPreX, mPreY, endX, endY)
                mPreX = event.x
                mPreY = event.y
            }
        }
        postInvalidate()
        return super.onTouchEvent(event)
    }

}