package com.recy;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * author : Naruto
 * date   : 2020/10/29
 * desc   :
 * version:
 */
class LinearDecoration extends RecyclerView.ItemDecoration {
    private Paint mGreenPaint;
    private Paint mYellowPaint;

    public LinearDecoration() {
        mGreenPaint = new Paint();
        mYellowPaint = new Paint();
        mGreenPaint.setColor(Color.GREEN);
        mYellowPaint.setColor(Color.YELLOW);
    }

    /**
     * 调用顺序
     * ItemDecoration 的 onDraw->item的 onDraw->ItemDecoration 的 onDrawOver
     */
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
        int childCount = parent.getChildCount();
        RecyclerView.LayoutManager manager = parent.getLayoutManager();
        for (int i = 0; i < childCount; i++) {
            View child = parent.getChildAt(i);
            //动态获取outRect的left值
            int left = manager.getLeftDecorationWidth(child);
            int cx = left / 2;
            int cy = child.getTop() + child.getHeight() / 2;
            c.drawCircle(cx, cy, 20, mGreenPaint);
        }
    }


    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c, parent, state);
        RecyclerView.LayoutManager manager = parent.getLayoutManager();
        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = parent.getChildAt(i);
            int index = parent.getChildAdapterPosition(child);
            int left = manager.getLeftDecorationWidth(child);
            if (index % 5 == 0) {
               c.drawRect(0,child.getTop(),left,child.getBottom(), mYellowPaint);
            }
        }
    }

    /**
     * 主要作用就是给item的四周加上边距，实现的效果类似于margin，将item的四周撑开一些距离，在撑开这些距离后，我们就可以利用上面的onDraw函数，在这个距离上进行绘图了。
     * Rect outRect：这个是最难理解的部分，outRect就是表示在item的上下左右所撑开的距离；
     * outRect 中的 top、left、right、bottom四个点，并不是普通意义的坐标点，而是指的在Item上、左、右、下各撑开的距离。
     * View view：是指当前Item的View对象；
     * RecyclerView parent：是指RecyclerView 本身；
     * RecyclerView.State state：通过State可以获取当前RecyclerView的状态，也可以通过State在RecyclerView各组件间传递参数；
     */
    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.left = 200;
        outRect.bottom = 1;

    }
}
