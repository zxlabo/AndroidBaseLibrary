package com.demo.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.base.R
import com.baselibrary.utils.ViewUtil
import java.math.BigDecimal

/**
 * author : Naruto
 * date   : 2020/12/10
 * desc   :
 * version:
 */
class PregnancyProgressView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    private var paintBackGround = Paint()
    private var paintOne: Paint = Paint()
    private var paintTwo: Paint = Paint()
    private var paintThree: Paint = Paint()
    private var paintFour: Paint = Paint()
    private var textPaint: Paint = Paint()
    private var bitmapPaint: Paint = Paint()

    private var defaultColor = Color.parseColor("#F5F6FA")
    private var progressBackgroundColor = Color.parseColor("#F5F6FA")
    private var oneColor = Color.parseColor("#8ECBFF")
    private var twoColor = Color.parseColor("#FFD274")
    private var threeColor = Color.parseColor("#75A5FF")
    private var fourColor = Color.parseColor("#B9BDFD")
    val msgTotal = "总计"

    private var progressHeight = ViewUtil.dip2px(14f).toFloat()
    var bitmapBubble = BitmapFactory.decodeResource(resources, R.drawable.ic_bubble);
    var bitmapBubbleRed = BitmapFactory.decodeResource(resources, R.drawable.ic_bubble_red);

    init {
        val array = context.obtainStyledAttributes(attrs, R.styleable.PregnancyProgressView)
        progressHeight = array.getLayoutDimension(
            R.styleable.PregnancyProgressView_pregnancy_progress_height,
            14
        ).toFloat()
        paintInit(paintBackGround, progressBackgroundColor)
        paintInit(paintOne, oneColor)
        paintInit(paintTwo, twoColor)
        paintInit(paintThree, threeColor)
        paintInit(paintFour, fourColor)

        bitmapPaint.isAntiAlias = true
        textPaint.isAntiAlias = true
        textPaint.textAlign = Paint.Align.RIGHT
        textPaint.textSize = ViewUtil.dip2px(12f).toFloat()
        textPaint.color = Color.parseColor("#697387")
    }

    private fun paintInit(paint: Paint, color: Int) {
        paint.isAntiAlias = true
        paint.style = Paint.Style.STROKE
        paint.strokeCap = Paint.Cap.ROUND
        paint.color = color
        paint.strokeWidth = progressHeight
    }

    private var allX = 0f
    private var oneX = 0f
    private var twoX = 0f
    private var threeX = 0f
    private var fourX = 0f
    private var msg = ""
    fun setData(one: Int, two: Int, three: Int, four: Int, all: Int) {
        if (all == 0) return
        allX = width.toFloat()
        oneX = width * getNum(one, all).toFloat()
        twoX = width * getNum(two, all).toFloat()
        threeX = width * getNum(three, all).toFloat()
        fourX = width * getNum(four, all).toFloat()
        msg = "已完成${getNum(four, all) * 100}%"
        postInvalidate()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        val startX = progressHeight / 2

        val allEnd = allX - progressHeight / 2
        val fourEnd = fourX - progressHeight / 2
        val threeEnd = threeX - progressHeight / 2
        val twoEnd = twoX - progressHeight / 2
        val oneEnd = oneX - progressHeight / 2
        val flag = 0
        //画bubble
        val bubbleY = 0f
        val bubbleTextY = ViewUtil.dip2px(19f).toFloat()
        canvas?.drawBitmap(bitmapBubble, fourEnd, bubbleY, bitmapPaint)
        canvas?.drawBitmap(bitmapBubbleRed, allEnd, bubbleY, bitmapPaint)
        canvas?.drawText("23",fourEnd,bubbleTextY,textPaint)
        canvas?.drawText("33",allEnd,bubbleTextY,textPaint)
        //画进度条
        val progressStartY = progressHeight / 2 + ViewUtil.dip2px(25f)
        if (allEnd > flag) canvas?.drawLine(
            startX,
            progressStartY,
            allEnd,
            progressStartY,
            paintBackGround
        )
        if (fourEnd > flag) canvas?.drawLine(
            startX,
            progressStartY,
            fourEnd,
            progressStartY,
            paintFour
        )
        if (threeEnd > flag) canvas?.drawLine(
            startX,
            progressStartY,
            threeEnd,
            progressStartY,
            paintThree
        )
        if (twoEnd > flag) canvas?.drawLine(
            startX,
            progressStartY,
            twoEnd,
            progressStartY,
            paintTwo
        )
        if (oneEnd > flag) canvas?.drawLine(
            startX,
            progressStartY,
            oneEnd,
            progressStartY,
            paintOne
        )

        //画总结文字
        var textEnd = textPaint.measureText(msg)
        if (textEnd < fourX) {
            textEnd = fourX
        }
        val textY = progressStartY + progressHeight / 2 + ViewUtil.dip2px(22f).toFloat()
        canvas?.drawText(msg, textEnd, textY, textPaint)
        canvas?.drawText(msgTotal, allX, textY, textPaint)


    }

    private fun getNum(a: Int, b: Int): Double {
        return BigDecimal(a.toDouble() / b).setScale(2, BigDecimal.ROUND_HALF_UP).toDouble()
    }
}