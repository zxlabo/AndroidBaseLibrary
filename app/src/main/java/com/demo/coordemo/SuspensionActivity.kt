package com.demo.coordemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.vlayout.DelegateAdapter
import com.alibaba.android.vlayout.VirtualLayoutManager
import com.base.R
import kotlinx.android.synthetic.main.activity_suspension.*


class SuspensionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_suspension)
        init1()


        val layoutManager = VirtualLayoutManager(this)
        recycler_view_top.layoutManager = layoutManager
        val delegateAdapter = DelegateAdapter(layoutManager, false)
        recycler_view_top.adapter = delegateAdapter
        delegateAdapter.clear()
//        delegateAdapter.addAdapter()
    }

    private fun init1() {
        val adapter = AppBarAdapter(this)
        recycler_view.adapter = adapter
        recycler_view.isNestedScrollingEnabled = false
        val list = mutableListOf<String>()
        for (i in 0..60) {
            list.add(i.toString())
        }
        adapter.setData(list)
    }
}