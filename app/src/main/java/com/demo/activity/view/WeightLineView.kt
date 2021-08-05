package com.demo.activity.view

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.base.R
import kotlinx.android.synthetic.main.frame_weight_view.view.*

/**
 * author : Naruto
 * date   : 3/2/21
 * desc   :
 * version:
 */
class WeightLineView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {
    init {
        LayoutInflater.from(context).inflate(R.layout.frame_weight_view,this)
        Log.e("===",rv_week.width.toString())
        rv_week.adapter=WeightLineTvAdapter(this.context)
    }
}