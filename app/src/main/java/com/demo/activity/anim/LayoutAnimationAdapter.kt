package com.demo.activity.anim

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.base.R

/**
 * author : Naruto
 * date   : 2/24/21
 * desc   :
 * version:
 */
class LayoutAnimationAdapter : RecyclerView.Adapter<LayoutAnimationVh>() {
    private var list = mutableListOf<String>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LayoutAnimationVh {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout_animation, parent, false)
        return LayoutAnimationVh(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: LayoutAnimationVh, position: Int) {
        holder.mTv?.text = list[position]
    }

    fun setData(data: MutableList<String>) {
        list.clear()
        list.addAll(data)
        notifyDataSetChanged()
    }
}

class LayoutAnimationVh(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var mTv: TextView? = null

    init {
        mTv = itemView.findViewById(R.id.tv_content)
    }
}