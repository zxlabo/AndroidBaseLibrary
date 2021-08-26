package com.recy

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.LayoutRes
import com.base.R
import com.baselibrary.utils.recyclerview.BaseRecyclerViewAdapter
import com.ui.adapter.CommonViewHolder

/**
 * author : Naruto
 * date   : 2020/10/29
 * desc   :
 * version:
 */
class MyAdapter(context: Context) : BaseRecyclerViewAdapter<DetailBean, MyHolder>(context) {
    val ITEM_VIEW_TYPE_NORMAL = 1
    val ITEM_VIEW_TYPE_GREEN = 2
    private val mOnClickListener = View.OnClickListener {

    }

    override fun onBindViewHolder(holder: MyHolder, position: Int, item: DetailBean?) {
//        holder.getView<TextView>(R.id.tv_name).text = item?.name
        holder.mTvName?.text = item?.name

//        holder.itemView.
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val layoutId = if (viewType == ITEM_VIEW_TYPE_NORMAL) {
            R.layout.item_grid_white
        } else {
            R.layout.item_grid_green
        }

        return MyHolder(parent, layoutId, mOnClickListener)
    }


    override fun getItemViewType(position: Int): Int {
        return if (dataList[position].isTitle) {
            ITEM_VIEW_TYPE_GREEN
        } else {
            ITEM_VIEW_TYPE_NORMAL
        }
    }

    override fun getItemId(position: Int): Long {
        return super.getItemId(position)
    }
}

class MyHolder(parent: ViewGroup, @LayoutRes res: Int, mOnClickListener: View.OnClickListener) :
    CommonViewHolder(parent, res) {
    var mTvName: TextView? = null

    init {
        mTvName = itemView.findViewById(R.id.tv_name)
        mTvName?.setOnClickListener(mOnClickListener)
    }
}