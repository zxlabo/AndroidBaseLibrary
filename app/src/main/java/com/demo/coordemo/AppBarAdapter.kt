package com.demo.coordemo

import android.content.Context
import android.view.ViewGroup
import android.widget.TextView
import com.base.R
import com.baselibrary.utils.recyclerview.BaseRecyclerViewAdapter
import com.baselibrary.utils.recyclerview.BaseViewHolder

/**
 * author : Naruto
 * date   : 2020-09-04
 * desc   :
 * version:
 */
class AppBarAdapter(mcontext: Context) : BaseRecyclerViewAdapter<String, BaseViewHolder>(mcontext) {

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int, item: String?) {
        holder?.getView<TextView>(R.id.tv_name)?.text = item + "text"
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder =
        BaseViewHolder(parent, R.layout.item_bar)


}