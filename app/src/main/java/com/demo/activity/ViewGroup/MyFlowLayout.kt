package com.demo.activity.ViewGroup

import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup

/**
 * author : Naruto
 * date   : 2020-10-02
 * desc   :
 * version:
 */
class MyFlowLayout @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ViewGroup(context, attrs, defStyleAttr) {

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        var width = 0 //FlowLayout的宽度
        var height = 0//FlowLayout的高度
        var lineWidth = 0 //每一行的宽度
        var lineHeight = 0 //每一行的高度
        /**
         * 步骤一：获取ViewGroup的测量模式和测量大小
         */
        val widthMode = MeasureSpec.getMode(widthMeasureSpec)
        val measureWidth = MeasureSpec.getSize(widthMeasureSpec)
        val heightMode = MeasureSpec.getMode(heightMeasureSpec)
        val measureHeight = MeasureSpec.getSize(heightMeasureSpec)
        /**
         * 步骤二：计算所有子view的宽高
         */
        //遍历所有子view
        for (i in 0 until childCount) {
            //1、获取子view
            val childView = getChildAt(i)
            //2、让子视图进行自我测量
            measureChild(childView, widthMeasureSpec, heightMeasureSpec)
            //3、获取子view的宽高
            var childWidth = childView.measuredWidth
            var childHeight = childView.measuredHeight
            //4、获取子view的margin,计算当前子view的宽高
            val childParams = childView.layoutParams
            //这里我们要重写generateLayoutParams方法。
            if (childParams is MarginLayoutParams) {
                childWidth += childParams.leftMargin + childParams.rightMargin
                childHeight += childParams.topMargin + childParams.bottomMargin
            }
            /**
             * 5、我们做的是FlowLayout流式布局，要计算换行。
             * a:(如果当前行的宽度+下一个子view的宽度)小于ViewGroup的宽度，
             *      我们将当前子控件的宽度累加到lineWidth上。
             * b：(如果当前行的宽度+下一个子view的宽度)大于ViewGroup的宽度，
             *      1、我们就需要进行换行，把当前lineWidth和lineHeight累加到ViewGroup上。
             *      2、重新初始化lineWidth和lineHeight，
             *      由于换行，那当前控件就是下一行控件的第一个控件，
             *      那么当前行的行高就是这个控件的高，当前行的行宽就是这个控件的宽度值了。
             */

            if ((lineWidth + childWidth) > measureWidth) {
                //这里需要换行，所以把当前行的宽高，叠加到ViewGroup的宽高上。
                width = Math.max(lineWidth, childWidth)
                height += lineHeight
                //注意：这里给下一行设置宽、高
                lineHeight = childHeight
                lineWidth = childWidth
            } else {//不需要换行
                //比较行高和当前子view的高，把最大高度赋值给当前行高
                lineHeight = Math.max(lineHeight, childHeight)
                lineWidth += childWidth
            }
            /**
             * 6、因为我们是在比较的时候，把每一行的宽高叠加到ViewGroup的宽高上的。
             * 所以当最后一个子view的时候，也就是最后一行。我们要把最后一行的宽高叠加到ViewGroup的宽高上。
             */
            if (i == childCount - 1) {
                width = Math.max(width, lineWidth)
                height += lineHeight
            }
        }

        /**
         * 7、最后通过setMeasuredDimension把ViewGroup的宽高设置到系统中
         * 当测量模式是MeasureSpec.EXACTILY的时候，我们就不需要计算viewgroup的大小了。
         */
        val currentWidth = if (widthMode == MeasureSpec.EXACTLY) {
            measureWidth
        } else {
            width
        }
        val currentHeight = if (heightMode == MeasureSpec.EXACTLY) {
            measureHeight
        } else {
            height
        }
        setMeasuredDimension(currentWidth, currentHeight)
    }

    /**
     * 布局所有子控件
     */
    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        val viewGroupWidth = measuredWidth
        var top = 0//当前坐标的top坐标
        var left = 0
        var lineWidth = 0
        var lineHeight = 0
        //1、遍历所以子view，给每个子view布局
        for (i in 0 until childCount) {
            //2、获取当前子view
            val childView = getChildAt(i)
            //3、获取当前子view的宽高
            val childParams = childView.layoutParams
            var childWidth = childView.measuredWidth
            var childHeight = childView.measuredHeight
            //4、把当前子view的margin累加到子view的宽高上
            if (childParams is MarginLayoutParams) {
                childWidth += childParams.leftMargin + childParams.rightMargin
                childHeight += childParams.topMargin + childParams.bottomMargin
            }
            //5、判断是否换行
            if ((lineWidth + childWidth) > viewGroupWidth) {//换行
                top = lineHeight
                left = 0
                lineHeight += childHeight
                lineWidth = childWidth
            } else {//不换行
                lineHeight = Math.max(lineHeight, childHeight)
                lineWidth += childWidth
            }
            //6、计算当前子view的left、right、top、bottom
            var lc = left
            var tc = top
            if (childParams is MarginLayoutParams) {
                lc += childParams.leftMargin
                tc += childParams.topMargin
            }
            var rc = lc + childView.measuredWidth
            var bc = tc + childView.measuredHeight
            //7、给子view进行layout布局
            childView.layout(lc, tc, rc, bc)
            //8、给下一个子view设置left值
            //注意：这里不能把子view的rc设置给left，因为还需要加上子view的marginRight。
            left += childWidth
        }
    }

    /**
     * 获取到childView，通过 child.getLayoutParams()获取child对应的LayoutParams实例。
     * 将其强转成MarginLayoutParams；然后获取对应的margin值，计算childWidth时添加上左边间距和右边间距。
     */
    override fun generateLayoutParams(attrs: AttributeSet?): LayoutParams {
        return MarginLayoutParams(context, attrs)
    }

    override fun generateLayoutParams(p: LayoutParams?): LayoutParams {
        return MarginLayoutParams(p)
    }

    override fun generateDefaultLayoutParams(): LayoutParams {
        return MarginLayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
    }
}