package com.recy;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 *
 */

public class GridDividerItemDecoration extends RecyclerView.ItemDecoration {
    private Context mContext;
    private List<DetailBean> mList;

    public GridDividerItemDecoration(Context context, List<DetailBean> list) {
        super();
        mContext = context;
        mList = list;

    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        if (parent.getLayoutManager() instanceof GridLayoutManager) {
            int position = parent.getChildAdapterPosition(view);
            DetailBean bean = mList.get(position);
            outRect.bottom=5;
            if (bean != null && bean.isTitle()) {
            }else {
                switch (bean.getPosition()%3) {
                    case 0:
                    case 1:
                        outRect.right=5;
                        break;
                    default:
                        break;
                }
            }
        } else if (parent.getLayoutManager() instanceof LinearLayoutManager) {
            outRect.set(0, 0, 0, 5);
        } else {
            super.getItemOffsets(outRect, view, parent, state);
        }
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c, parent, state);
    }
}