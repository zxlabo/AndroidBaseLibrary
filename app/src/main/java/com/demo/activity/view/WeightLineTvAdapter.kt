package com.demo.activity.view

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.base.R
import com.baselibrary.utils.ViewUtil

/**
 * author : Naruto
 * date   : 3/2/21
 * desc   :
 * version:
 */
class WeightLineTvAdapter(val mContext: Context) : RecyclerView.Adapter<SimpleRcvViewHolder>() {
    private val list = mutableListOf<String>()
    private var itemWidth =
        ((mContext.resources.displayMetrics.widthPixels) - ViewUtil.dip2px(66f)) / 20

    init {
        for (i in 0..40 step 2) {
            list.add(i.toString())
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimpleRcvViewHolder =
        SimpleRcvViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_weight_tv_view, parent, false)
        )

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: SimpleRcvViewHolder, position: Int) {
        holder.getView<TextView>(R.id.tv_week).text = list[position]
//        holder.getView<TextView>(R.id.tv_week).width = itemWidth
    }
}