package com.demo.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.base.R
import com.recy.MyAdapter2
import kotlinx.android.synthetic.main.activity_constraint.*

class ConstraintActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_constraint)
//        val adapter = MyAdapter2()
//        val manager = LinearLayoutManager(this)
//        manager.orientation = RecyclerView.VERTICAL
//        rv_demo.layoutManager = manager
//        rv_demo.adapter = adapter
//        val list = mutableListOf<String>()
//        for (i in 1..24){
//            list.add("$i")
//        }
//        adapter.setData(list)
    }
}