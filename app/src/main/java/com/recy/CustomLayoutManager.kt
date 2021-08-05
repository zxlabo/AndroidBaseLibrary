package com.recy

import android.graphics.Rect
import android.util.SparseArray
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler


/**
 * author : Naruto
 * date   : 2020/10/29
 * desc   :
 * version:
 */
class CustomLayoutManager : RecyclerView.LayoutManager() {
    private var mSumDy = 0
    private var mTotalHeight = 0

    /**
     *  这个方法就是RecyclerView Item的布局参数，
     *  RecyclerView子item的LayoutParameters，若是想修改子Item的布局参数（比如：宽/高/margin/padding等等），那么可以在该方法内进行设置
     */
    override fun generateDefaultLayoutParams(): RecyclerView.LayoutParams {
        return RecyclerView.LayoutParams(
            RecyclerView.LayoutParams.WRAP_CONTENT,
            RecyclerView.LayoutParams.WRAP_CONTENT
        )
    }

    /**
     * Item的布局都是在onLayoutChildren()函数中处理的
     * 此函数中我们要做两件事
     * 1、把所有的item所对应的view加进来
     * 2、把所有的Item摆放在它应在的位置
     * 3、使用 detachAndScrapAttachedViews(recycler)将所有的可见HolderView剥离
     */
    private var mItemWidth: Int = 0
    private  var mItemHeight:Int = 0
    private val mItemRects: SparseArray<Rect> = SparseArray<Rect>()
    override fun onLayoutChildren(recycler: Recycler, state: RecyclerView.State?) {
       if (itemCount==0){
           //在Adapter中没有数据的时候，直接将当前所有的Item从屏幕上剥离，将当前屏幕清空：
           detachAndScrapAttachedViews(recycler)
           return
       }
        detachAndScrapAttachedViews(recycler)
        //将item的位置存储起来
        val childView = recycler.getViewForPosition(0)
        measureChildWithMargins(childView, 0, 0)
        mItemWidth = getDecoratedMeasuredWidth(childView)
        mItemHeight = getDecoratedMeasuredHeight(childView)

        val visibleCount: Int = getVerticalSpace() / mItemHeight

        //定义竖直方向的偏移量
        var offsetY = 0
        for (i in 0 until getItemCount()) {
            val rect = Rect(0, offsetY, mItemWidth, offsetY + mItemHeight)
            mItemRects.put(i, rect)
            offsetY += mItemHeight
        }

        for (i in 0 until visibleCount) {
            val rect = mItemRects[i]
            val view = recycler.getViewForPosition(i)
            addView(view)
            //addView后一定要measure，只有测量过以后，系统才知道它的测量的宽高，先measure再layout
            measureChildWithMargins(view, 0, 0)
            layoutDecorated(view, rect.left, rect.top, rect.right, rect.bottom)
        }
        //如果所有子View的高度和没有填满RecyclerView的高度，
        // 则将高度设置为RecyclerView的高度
        mTotalHeight = Math.max(offsetY, getVerticalSpace())
    }

    private fun getVerticalSpace(): Int {
        return getHeight() - getPaddingBottom() - getPaddingTop()
    }

    /**
     * 使LayoutManager具有垂直滚动的功能。然后在scrollVerticallyBy中接收每次滚动的距离dy。
     * 如果你想使LayoutManager具有横向滚动的功能，可以通过在canScrollHorizontally()中return true;
     */
    override fun canScrollVertically(): Boolean {
        return true
    }

    /**
     *在scrollVerticallyBy中,dy表示手指在屏幕上每次滑动的位移.
     */
    override fun scrollVerticallyBy(dy: Int, recycler: Recycler, state: RecyclerView.State?): Int {
        if (childCount <= 0) {
            return dy
        }
        var travel = dy
        //如果滑动到最顶部
        if (mSumDy + dy < 0) {
            travel = -mSumDy
        } else if (mSumDy + dy > mTotalHeight - getVerticalSpace()) {
            //如果滑动到最底部
            travel = mTotalHeight - getVerticalSpace() - mSumDy
        }

        //回收越界子View
        //遍历所有当前在显示的item，所以getChildCount() - 1就表示当前在显示的item的最后一个索引。
        for (i in childCount - 1 downTo 0) {
            val child: View= getChildAt(i)!!
            //当travel>0时，说明是从下向上滚动，自然是会将顶部的item移除
            if (travel > 0) { //需要回收当前屏幕，上越界的View
                //getDecoratedBottom(child) - travel表示将这个item上移以后，它的下边界的位置，当下边界的位置小于当前的可显示区域的上边界（此时为0）时，就需要将它移除
                if (getDecoratedBottom(child) - travel < 0) {
                    //所有移除的View都是使用removeAndRecycleView(child, recycler),
                    removeAndRecycleView(child, recycler)
                    //detachAndScrapAttachedViews(recycler) 在滚动时，已经超出边界的HolderView是需要被回收的，而不是被detach。detach的意思是暂时存放，立马使用。
                    continue
                }
            }
        }
        val visibleRect: Rect = getVisibleArea(travel)
        //布局子View阶段
        if (travel >= 0) {
            val lastView: View = getChildAt(childCount - 1)!!
            val minPos = getPosition(lastView) + 1 //从最后一个View+1开始吧

            //顺序addChildView
            for (i in minPos..itemCount - 1) {
                val rect = mItemRects[i]
                if (Rect.intersects(visibleRect, rect)) {
                    val child: View = recycler.getViewForPosition(i)
                    addView(child)
                    measureChildWithMargins(child, 0, 0)
                    layoutDecorated(
                        child,
                        rect.left,
                        rect.top - mSumDy,
                        rect.right,
                        rect.bottom - mSumDy
                    )
                } else {
                    break
                }
            }
        }
        mSumDy += travel
        // 平移容器内的item
        offsetChildrenVertical(-travel)
        return travel
    }
    private fun getVisibleArea(travel: Int): Rect{
        //其中mSumDy表示上次的移动距离，travel表示这次的移动距离，所以mSumDy + travel表示这次移动后的屏幕位置。
        return Rect(
            paddingLeft,
            paddingTop + mSumDy + travel,
            width + paddingRight,
            getVerticalSpace() + mSumDy + travel
        )
    }

}
