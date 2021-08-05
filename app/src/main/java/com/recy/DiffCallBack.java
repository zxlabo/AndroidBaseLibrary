package com.recy;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DiffUtil;

import java.util.List;

/**
 * 介绍：核心类 用来判断 新旧Item是否相等
 * 判定列表中数据是否相同分为递进三个层次：
 *
 * 1、是否是同一个数据：对应areItemsTheSame()
 * 2、若是同一个数据，其中具体内容是否相同：对应areContentsTheSame()（当areItemsTheSame()返回true时才会被调用）
 * 3、若同一数据的具体内容不同，则找出不同点：对应getChangePayload()（当areContentsTheSame()返回false时才会被调用）
 */

public class DiffCallBack extends DiffUtil.Callback {
    private List<TestBean> mOldDatas, mNewDatas;//看名字

    public DiffCallBack(List<TestBean> mOldDatas, List<TestBean> mNewDatas) {
        this.mOldDatas = mOldDatas;
        this.mNewDatas = mNewDatas;
    }

    //老数据集size
    @Override
    public int getOldListSize() {
        return mOldDatas != null ? mOldDatas.size() : 0;
    }

    //新数据集size
    @Override
    public int getNewListSize() {
        return mNewDatas != null ? mNewDatas.size() : 0;
    }

    /**
     * 定义什么情况下新老元素是同一个对象
     * 例如，如果你的Item有唯一的id字段，这个方法就 判断id是否相等。
     * 本例判断name字段是否一致
     */
    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return mOldDatas.get(oldItemPosition).getName().equals(mNewDatas.get(newItemPosition).getName());
    }

    /**
     * 定义什么情况下同一对象内容是否相同
     */
    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        TestBean beanOld = mOldDatas.get(oldItemPosition);
        TestBean beanNew = mNewDatas.get(newItemPosition);
        if (!beanOld.getDesc().equals(beanNew.getDesc())) {
            return false;//如果有内容不同，就返回false
        }
        return true; //默认两个data内容是相同的
    }

    @Nullable
    @Override
    public Object getChangePayload(int oldItemPosition, int newItemPosition) {
        return super.getChangePayload(oldItemPosition, newItemPosition);
    }
}