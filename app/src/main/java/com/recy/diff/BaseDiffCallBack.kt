package com.recy.diff

import androidx.recyclerview.widget.DiffUtil

/**
 * author : Naruto
 * date   : 2020/11/5
 * desc   :
 * version:
 */
class BaseDiffCallBack : DiffUtil.Callback {

    private var newList: List<Any>? = null
    private var oldList: List<Any>? = null

    constructor()

    constructor(newList: List<Any>?, oldList: List<Any>?) {
        this.newList = newList
        this.oldList = oldList
    }

    override fun getOldListSize(): Int {
        return oldList?.size ?: 0
    }

    override fun getNewListSize(): Int {
        return newList?.size ?: 0
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        try {// 将数据强转为Diff
            val oldItem = oldList!![oldItemPosition] as? BaseDiffBean
            val newItem = newList!![newItemPosition] as? BaseDiffBean
            if (oldItem == null || newItem == null) return false
            return oldItem.isSameObject(newItem)
        } catch (e: Exception) {
            return false
        }
    }


    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        try {// 将数据强转为Diff
            val oldItem = oldList!![oldItemPosition] as? BaseDiffBean
            val newItem = newList!![newItemPosition] as? BaseDiffBean
            if (oldItem == null || newItem == null) return false
            return oldItem.hasSameContent(newItem)
        } catch (e: Exception) {
            return false
        }
    }

    override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {
        try {
            val oldItem = oldList!![oldItemPosition] as? BaseDiffBean
            val newItem = newList!![newItemPosition] as? BaseDiffBean
            if (oldItem == null || newItem == null) return null
            return oldItem.diff(newItem)
        } catch (e: Exception) {
            return null
        }
    }

}