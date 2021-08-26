package com.demo.coordemo

import android.content.Context
import android.view.ViewGroup
import android.widget.TextView
import com.base.R
import com.baselibrary.utils.recyclerview.BaseRecyclerViewAdapter
import com.ui.adapter.CommonViewHolder

/**
 * author : Naruto
 * date   : 2020-09-04
 * desc   :
 * version:
 */
class AppBarAdapter(mcontext: Context) : BaseRecyclerViewAdapter<String, CommonViewHolder>(mcontext) {

    override fun onBindViewHolder(holder: CommonViewHolder, position: Int, item: String?) {
        holder?.getView<TextView>(R.id.tv_name)?.text = item + "text"
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommonViewHolder =
        CommonViewHolder(parent, R.layout.item_bar)


}