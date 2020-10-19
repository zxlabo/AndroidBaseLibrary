package com.demo.coordemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.base.R
import kotlinx.android.synthetic.main.activity_app_bar_demo.*

/**
 * 标题栏可折叠
 */
class CollapseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_collapse)
        val adapter= AppBarAdapter(this)
        recycler_view.adapter =adapter
        val list = mutableListOf<String>()
        for (i in 0..60){
            list.add(i.toString())
        }
        adapter.setData(list)
    }
}
