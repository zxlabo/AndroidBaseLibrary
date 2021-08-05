package com.recy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.base.R
import kotlinx.android.synthetic.main.activity_recycler_view_click.*

class RecyclerViewClickActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view_click)
        val adapter=MyAdapter2()
        rv_demo.isNestedScrollingEnabled=false
        rv_demo.adapter=adapter
        rv_demo.suppressLayout(true)
        val list= mutableListOf<String>()
        for (i in 0..6){
            list.add("$i-----")
        }

        adapter.setData(list)
        cl_container.setOnClickListener {
            Log.e("===","aaaaa")
        }
//        rv_demo.setOnClickListener {
//            cl_container.performClick()
//        }
    }
}