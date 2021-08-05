package com.recy

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import com.base.R
import kotlinx.android.synthetic.main.activity_snap_helper.*


class SnapHelperActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_snap_helper)
        val adapter = MyAdapter(this)
        rv_demo.adapter = adapter
        val list = initData()
        val manager = LinearLayoutManager(this)
        manager.orientation = LinearLayoutManager.VERTICAL
        rv_demo.layoutManager = manager
        // 将SnapHelper attach 到RecyclrView
        val snapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(rv_demo)
        adapter.dataList = list
        adapter.notifyDataSetChanged()
    }

    private fun initData(): MutableList<DetailBean> {
        val list = mutableListOf<DetailBean>()
        for (i in 0..15) {
            list.add(DetailBean(true, "分类$i", "$i"))
            for (j in 0..9) {
                list.add(DetailBean(false, "$j", "$i", j))
            }
        }
        return list
    }
}