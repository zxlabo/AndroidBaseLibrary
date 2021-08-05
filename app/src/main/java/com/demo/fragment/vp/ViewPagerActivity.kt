package com.demo.fragment.vp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import com.base.R
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_view_pager.*

class ViewPagerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager)
        val tag = "3"
        val list = mutableListOf<String>()
        list.add("hello$tag")
        list.add("world$tag")
        list.add("发年终奖吗$tag")
        list.add("呵呵呵$tag")
        list.add("哈哈哈哈$tag")
        val adapter = ScreenSlidePagerAdapter(supportFragmentManager, list)
        view_pager.adapter = adapter
        tab_layout.setupWithViewPager(view_pager, true)
        for (i in 0 until adapter.count) {
            val tab = tab_layout.getTabAt(i)
            tab?.setCustomView(R.layout.item_custom_tab)
            tab?.customView?.findViewById<TextView>(R.id.tv_1)?.text = list[i]
            tab?.customView?.findViewById<TextView>(R.id.tv_2)?.text = list[i]
        }
        tab_layout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                tab?.customView?.findViewById<TextView>(R.id.tv_1)?.isSelected = false
                tab?.customView?.findViewById<TextView>(R.id.tv_2)?.isSelected = false
            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.customView?.findViewById<TextView>(R.id.tv_1)?.isSelected = true
                tab?.customView?.findViewById<TextView>(R.id.tv_2)?.isSelected = true
            }

        })


    }

    private inner class ScreenSlidePagerAdapter :
        FragmentStatePagerAdapter {
        private lateinit var list: MutableList<String>

        constructor(
            supportFragmentManager: FragmentManager,
            list: MutableList<String>
        ) : super(supportFragmentManager) {
            this.list = list
        }

        override fun getCount(): Int = list.size

        override fun getItem(position: Int): Fragment =
            ScreenSlidePageFragment.newInstance(list[position])

        override fun getPageTitle(position: Int): CharSequence? {
            return list[position]
        }
    }

    private inner class ScreenSlidePagerAdapter2 : FragmentPagerAdapter {
        private lateinit var list: MutableList<String>

        constructor(
            supportFragmentManager: FragmentManager,
            list: MutableList<String>
        ) : super(supportFragmentManager) {
            this.list = list
        }

        override fun getCount(): Int = list.size

        override fun getItem(position: Int): Fragment =
            ScreenSlidePageFragment.newInstance(list[position])

    }

}