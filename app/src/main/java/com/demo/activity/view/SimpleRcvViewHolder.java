package com.demo.activity.view;

import android.util.SparseArray;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by hhy on 2017/6/22.
 * email:65351871@qq.com
 */

public class SimpleRcvViewHolder extends RecyclerView.ViewHolder {
    private SparseArray<View> views = new SparseArray<>();

    public SimpleRcvViewHolder(View itemView) {
        super(itemView);
    }

    @SuppressWarnings("unchecked")
    public <V extends View> V getView(int resId) {
        View v = views.get(resId);
        if (null == v) {
            v = itemView.findViewById(resId);
            views.put(resId, v);
        }
        return (V) v;
    }
}