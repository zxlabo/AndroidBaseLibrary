package com.recy

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DiffUtil
import com.base.R
import kotlinx.android.synthetic.main.activity_diff_util.*


class DiffUtilActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diff_util)
        initData()
        mAdapter = DiffAdapter(this, mDatas)
        rv_diff_demo.adapter = mAdapter
        mAdapter?.notifyDataSetChanged()
        btn_refresh?.setOnClickListener {
            onRefresh()
        }
    }

    var mAdapter: DiffAdapter? = null
    private var mDatas = mutableListOf<TestBean>()
    private fun initData() {
        mDatas.add(TestBean("张旭童1", "Android"))
        mDatas.add(TestBean("张旭童2", "Java"))
        mDatas.add(TestBean("张旭童3", "背锅"))
        mDatas.add(TestBean("张旭童4", "手撕产品"))
        mDatas.add(TestBean("张旭童5", "手撕测试"))
    }

    fun onRefresh() {
        try {
            val newDatas: MutableList<TestBean> = ArrayList()
            for (bean in mDatas) {
                newDatas.add(bean.clone()) //clone一遍旧数据 ，模拟刷新操作
            }
            newDatas.add(TestBean("赵子龙", "帅")) //模拟新增数据
            newDatas[0].desc = "Android+"
            val testBean = newDatas[1] //模拟数据位移
            newDatas.remove(testBean)
            newDatas.add(testBean)
            /**
             *DiffUtil.calculateDiff()方法定义如下：
             * 第一个参数是DiffUtil.Callback对象，
             * 第二个参数代表是否检测Item的移动，改为false算法效率更高，按需设置，我们这里是true。
             */
            val diffCallBack = DiffCallBack(mDatas, newDatas)
            val difResult = DiffUtil.calculateDiff(diffCallBack, true)
            difResult.dispatchUpdatesTo(mAdapter!!)

            //别忘了将新数据给Adapter
            mDatas = newDatas
            mAdapter?.setDatas(mDatas)
//            mAdapter?.notifyDataSetChanged() //以前我们大多数情况下只能这样


        } catch (e: CloneNotSupportedException) {
            e.printStackTrace()
        }
    }

}