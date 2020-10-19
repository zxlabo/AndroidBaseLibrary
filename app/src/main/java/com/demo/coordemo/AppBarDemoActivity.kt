package com.demo.coordemo

import android.os.Bundle
import com.base.R
import com.baselibrary.base.BaseLifecycleActivity
import kotlinx.android.synthetic.main.activity_app_bar_demo.*

class AppBarDemoActivity : BaseLifecycleActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app_bar_demo)
       val adapter= AppBarAdapter(this)
        recycler_view.adapter =adapter
        val list = mutableListOf<String>()
        for (i in 0..60){
            list.add(i.toString())
        }
        adapter.setData(list)


    }
}
