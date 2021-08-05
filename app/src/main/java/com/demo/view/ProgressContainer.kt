package com.demo.view

import android.content.Context
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.FrameLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.Constraints
import com.base.R
import com.baselibrary.utils.ViewUtil
import kotlinx.android.synthetic.main.layout_progress_container.view.*
import java.math.BigDecimal
import kotlin.math.roundToInt

/**
 * author : Naruto
 * date   : 2020/12/11
 * desc   :
 * version:
 */
class ProgressContainer @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {
    //屏幕宽度
    private var screenWidth = (context.resources.displayMetrics.widthPixels) - ViewUtil.dip2px(40f)

    //进度条高度
    private var progressHeight = 0f
    private var defaultHeight = 20

    //已完成数量的textSize和textColor
    private var numTextSize = 11f
    private var numTextColor = 0
    private var numTextHeight = 20f
    private var numPaddingLeft=6f

    //已完成进度
    private var progressTextSize = 12f
    private var progressTextColor = 0
    private var progressLeftMargin = 6f
    private var progressTopMargin = 4f
    private var progressTextHeight = 20f

    val paint = Paint()

    init {
        LayoutInflater.from(context).inflate(R.layout.layout_progress_container, this)
        val array = context.obtainStyledAttributes(attrs, R.styleable.ProgressContainer)
        progressHeight =
            array.getLayoutDimension(R.styleable.ProgressContainer_container_line_height, defaultHeight)
                .toFloat()
    }

    fun setData(one: Int, two: Int, three: Int, four: Int, all: Int) {
        //设置总计数量
        tv_all_num.text = all.toString()
        //设置进度
        val oneX = getProgressWidth(one, all)
        val twoX = oneX + getFinalWidth(two, all)
        val threeX = twoX + getFinalWidth(three, all)
        val fourX = threeX + getFinalWidth(four, all)
        progress_one.setData(oneX)
        progress_two.setData(twoX)
        progress_three.setData(threeX)
        progress_four.setData(fourX)
        progress_all.setData(getProgressWidth(all, all))
        //计算完成数量
        val completeNum = one + two + three + four
        val msgNum = (completeNum).toString()
        //设置完成数量
        setCompleteTv(msgNum, fourX, all)
        //设置完成进度
        setCompleteProgress(completeNum, all, fourX)
    }

    private fun getFinalWidth(num: Int, all: Int): Float {
        var a = getProgressWidth(num, all)
        if (a > 0) {
            a += progressHeight / 2
        } else {
            a
        }
        return a
    }

    private fun setCompleteProgress(completeNum: Int, all: Int, fourX: Float) {
        val progressMsg = "已完成${(getNum(completeNum, all) * 100).roundToInt()}%"
        val textViewProgress = TextView(context)
        textViewProgress.gravity = Gravity.CENTER
        textViewProgress.setTextColor(Color.parseColor("#697387"))
        textViewProgress.text = progressMsg
        textViewProgress.textSize = progressTextSize
        val params = Constraints.LayoutParams(
            ConstraintLayout.LayoutParams.WRAP_CONTENT,
            ViewUtil.dip2px(progressTextHeight)
        )
        params.topToBottom = R.id.progress_all
        paint.textSize = ViewUtil.dip2px(progressTextSize).toFloat()
        val progressMsgWidth = paint.measureText(progressMsg)
        val allNumWidth = paint.measureText("总计")
        params.leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID
        var numLeft = (fourX - progressMsgWidth).toInt()
        val maxLeft =
            screenWidth - progressMsgWidth - allNumWidth - ViewUtil.dip2px(progressLeftMargin)
        if (numLeft <= 0) {
            numLeft = 0
        } else if (numLeft > maxLeft) {
            numLeft = maxLeft.toInt()
        }
        params.marginStart = numLeft
        params.topMargin = ViewUtil.dip2px(progressTopMargin)
        cl_container.addView(textViewProgress, params)
    }

    private fun setCompleteTv(msgNum: String, fourX: Float, allNum: Int) {
        val textViewCompletedNum = TextView(context)
        textViewCompletedNum.gravity = Gravity.CENTER
        textViewCompletedNum.setTextColor(Color.parseColor("#FF6C65"))
        textViewCompletedNum.text = msgNum
        textViewCompletedNum.textSize = numTextSize
        textViewCompletedNum.setBackgroundResource(R.drawable.ic_bubble)
        val left = ViewUtil.dip2px(numPaddingLeft)
        val bottom = ViewUtil.dip2px(4f)
        textViewCompletedNum.setPadding(left, 0, left, bottom)
        val completedNumParams = Constraints.LayoutParams(
            ConstraintLayout.LayoutParams.WRAP_CONTENT,
            ViewUtil.dip2px(numTextHeight)
        )
        completedNumParams.topToTop = R.id.tv_all_num
        paint.textSize = ViewUtil.dip2px(numTextSize).toFloat()
        val msgNumWidth = paint.measureText(msgNum) + ViewUtil.dip2px(2*numPaddingLeft)
        val allNumWidth = paint.measureText(allNum.toString()) + ViewUtil.dip2px(2*numPaddingLeft)
        completedNumParams.leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID
        val maxLeft = screenWidth - msgNumWidth - allNumWidth - ViewUtil.dip2px(6f)
        var numLeft = (fourX - msgNumWidth / 2).toInt()
        if (numLeft <= 0) {
            numLeft = 0
        } else if (numLeft > maxLeft) {
            numLeft = maxLeft.toInt()
        }
        completedNumParams.marginStart = numLeft
        cl_container.addView(textViewCompletedNum, completedNumParams)
    }

    private fun getProgressWidth(num: Int, allNum: Int): Float {
        var progressWidth = 0f
        if (num > 0) {
            progressWidth = (getNum(num, allNum) * screenWidth).toFloat() - progressHeight / 2
            if (progressWidth < (progressHeight / 2)) {
                progressWidth = (progressHeight * 0.6).toFloat()
            }
        }
        return progressWidth
    }

    private fun getNum(a: Int, b: Int): Double {
        return BigDecimal(a.toDouble() / b).setScale(2, BigDecimal.ROUND_HALF_UP).toDouble()
    }
}