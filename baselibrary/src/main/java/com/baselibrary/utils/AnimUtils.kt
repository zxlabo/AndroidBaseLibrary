package com.baselibrary.utils

import android.view.View
import android.view.animation.AnimationUtils

/**
 * author : Naruto
 * date   : 2020-09-25
 * desc   : 动画工具类
 * version:
 */

/**
 * 补间动画
 */
fun View.startTweenAnimation(animSource: Int) {
    //从xml文件中获取动画
    try {
        val animation = AnimationUtils.loadAnimation(this.context, animSource)
        this.startAnimation(animation)
    } catch (e: Exception) {
    }
}