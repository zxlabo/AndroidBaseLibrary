package com.demo.fragment.vp2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.base.R
import com.demo.fragment.vp.ScreenSlidePageFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_view_pager2.*

private const val NUM_PAGES = 5

class ViewPager2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager2)
        val tag = "2"
        val list = mutableListOf<String>()
        list.add("hello$tag")
        list.add("world$tag")
        list.add("发年终奖吗$tag")
        list.add("呵呵呵$tag")
        list.add("哈哈哈哈$tag")
        val adapter = ScreenSlidePagerAdapter(this, list)
        view_pager2.adapter = adapter
        view_pager2.setPageTransformer(ZoomOutPageTransformer())
        TabLayoutMediator(tab_layout2, view_pager2,
            TabLayoutMediator.TabConfigurationStrategy { tab, position ->
                tab.text = list[position]
            }).attach()
        view_pager2.offscreenPageLimit
    }

    private inner class ScreenSlidePagerAdapter : FragmentStateAdapter {
        private lateinit var list: MutableList<String>

        constructor(activity: FragmentActivity, list: MutableList<String>) : super(activity) {
            this.list = list
        }

        override fun getItemCount(): Int = list.size

        override fun createFragment(position: Int): Fragment =
            ScreenSlidePageFragment.newInstance(list[position])    }


}