package com.recy

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.base.R

/**
 * author : Naruto
 * date   : 2020/12/18
 * desc   :
 * version:
 */
class MyAdapter2 : RecyclerView.Adapter<MyHolder2>() {
    private val mList = mutableListOf<String>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder2 {
        val view = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_grid_green, parent, false)
        return MyHolder2(view)
    }

    override fun getItemCount(): Int = mList.size

    override fun onBindViewHolder(holder: MyHolder2, position: Int) {
        holder?.mTv?.text = mList[position]
    }

    fun setData(list: MutableList<String>) {
        mList.clear()
        mList.addAll(list)
        notifyDataSetChanged()
    }


}

class MyHolder2(view: View) : RecyclerView.ViewHolder(view) {
    var mTv: TextView? = null

    init {
        mTv = view.findViewById<TextView>(R.id.tv_name)
    }
}