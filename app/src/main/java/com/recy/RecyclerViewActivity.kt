package com.recy

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.base.R
import com.baselibrary.utils.LiveDataBusUtil
import kotlinx.android.synthetic.main.activity_recycler_view.*

class RecyclerViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)
        val adapter = MyAdapter(this)
        rv_demo.adapter = adapter
        val list = initData()
        val manager = GridLayoutManager(this, 3)
        manager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return if (list[position].isTitle) {
                    3
                } else {
                    1
                }
            }

        }
        rv_demo.layoutManager = manager
        rv_demo.addItemDecoration(GridDividerItemDecoration(this, list))
        rv_demo.addItemDecoration(ItemHeaderDecoration(this, list))
        adapter.dataList = list
        adapter.notifyDataSetChanged()
        LiveDataBusUtil.get().with("key_test", String::class.java).observe(this, Observer {
        })
//        smooth_view.setOnClickListener {}
    }

    private fun initData(): MutableList<DetailBean> {
        val list = mutableListOf<DetailBean>()
//        for (i in 0..15) {
//            list.add(DetailBean(true, "分类$i", "$i"))
//            for (j in 0..9) {
//                list.add(DetailBean(false, "$j", "$i", j))
//            }
//        }
        for (j in 0..90) {
            list.add(DetailBean(false, "$j", "$j", j))
        }
        return list
    }

    //手指按下的点为(x1, y1)手指离开屏幕的点为(x2, y2)
    var x1 = 0f
    var x2 = 0f
    var y1 = 0f
    var y2 = 0f

//    override fun onTouchEvent(event: MotionEvent?): Boolean {
//        when (event?.action) {
//
//            MotionEvent.ACTION_DOWN -> {
//                x1 = event.x
//                y1 = event.y
//            }
//
//            MotionEvent.ACTION_UP -> {
//                x2 = event.x
//                y2 = event.y
//                if (y1 - y2 > 50) {
//                    Log.e("====", "向上滑")
//                } else if (y2 - y1 > 50) {
//                    Log.e("====", "向下滑")
//                } else if (x1 - x2 > 50) {
//                    Log.e("====", "向左滑")
//                } else if (x2 - x1 > 50) {
//                    Log.e("====", "向右滑")
//                }
//            }
//        }
//        return super.onTouchEvent(event)
//    }

}