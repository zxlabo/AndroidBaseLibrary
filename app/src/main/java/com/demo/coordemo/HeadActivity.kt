package com.demo.coordemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.base.R
import com.scwang.smartrefresh.layout.api.RefreshHeader
import com.scwang.smartrefresh.layout.listener.OnMultiPurposeListener
import com.scwang.smartrefresh.layout.listener.SimpleMultiPurposeListener
import kotlinx.android.synthetic.main.activity_app_bar_demo.*
import kotlinx.android.synthetic.main.activity_head.*
import kotlinx.android.synthetic.main.activity_head.recycler_view

class HeadActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_head)
        val adapter= AppBarAdapter(this)

        recycler_view.adapter =adapter
        val list = mutableListOf<String>()
        for (i in 0..60){
            list.add(i.toString())
        }
        adapter.setData(list)
        smr_layout.setOnMultiPurposeListener(object: SimpleMultiPurposeListener() {
            override fun onHeaderMoving(header: RefreshHeader, isDragging: Boolean, percent: Float, offset: Int, headerHeight: Int, maxDragHeight: Int) {
          Log.e("===onHeaderMoving",offset.toString())
            }

            override fun onHeaderReleased(
                header: RefreshHeader,
                headerHeight: Int,
                maxDragHeight: Int
            ) {
                Log.e("===onHeaderReleased",headerHeight.toString())
            }
        })
    }
}
