package com.baselibrary.utils;

import android.content.Context;

import androidx.annotation.StringRes;

import com.baselibrary.base.BaseApplication;

public class ViewUtil {

    public static int dip2px(float dpValue) {
        return dip2px(BaseApplication.mContext, dpValue);
    }

    public static int px2dip(float dpValue) {
        return px2dip(BaseApplication.mContext, dpValue);
    }

    /**
     * dp to px
     */
    public static int dip2px(Context context, float dpValue) {
        if (context != null) {
            final float scale = context.getResources().getDisplayMetrics().density;
            return (int) (dpValue * scale + 0.5f);
        } else {
            return (int) dpValue;
        }
    }

    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    public static String getString(@StringRes int strId) {
        return BaseApplication.mContext.getResources().getString(strId);
    }
    public static float sp2px(Context context, float spValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (spValue * fontScale);
    }

    /*
     * 得到屏幕的宽度
     */
    public static int getScreenWidth(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

}
