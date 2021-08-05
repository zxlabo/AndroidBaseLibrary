package com.recy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.base.R
import kotlinx.android.synthetic.main.activity_recy2.*

class RecyActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recy2)
        val adapter = MyAdapter(this)
        rv_demo.adapter = adapter
        val list = initData()
        val manager=  CustomLayoutManager()
//      val manager=  LinearLayoutManager(this)
//        manager.orientation=LinearLayoutManager.VERTICAL

        rv_demo.layoutManager=manager
        adapter.dataList = list
        adapter.notifyDataSetChanged()
//        rv_demo.setHasFixedSize(true)
//        rv_demo.setItemViewCacheSize(4)
    }
    private fun initData(): MutableList<DetailBean> {
        val list = mutableListOf<DetailBean>()
        for (i in 0..15) {
            list.add(DetailBean(true, "分类$i", "$i"))
            for (j in 0..9) {
                list.add(DetailBean(false, "$j", "$i",j))
            }
        }
        return list
    }
}