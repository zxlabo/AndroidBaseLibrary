package com.demo.activity.anim

import android.animation.LayoutTransition
import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.base.R
import kotlinx.android.synthetic.main.activity_view_group_layout_transition.*


class ViewGroupLayoutTransitionActivity : AppCompatActivity() {
    var i = 0
    private lateinit var layoutTransition: LayoutTransition
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_group_layout_transition)
        btn_add.setOnClickListener {
            val button = Button(this)
            button.setPadding(20, 20, 20, 20)
            i++
            button.setText("tempBtn$i")
            ll_container.addView(button, 2)
        }
        btn_del.setOnClickListener {
            val childCount = ll_container.childCount
            if (childCount > 2) {
                i--
                ll_container.removeViewAt(2)
            }
        }
        layoutTransition = LayoutTransition()
        addCustomTransition()
        ll_container.layoutTransition = layoutTransition
    }

    private fun addCustomTransition() {
        /**
         * APPEARING：添加view时被添加的view的动画
         * desc:每次添加view时X轴从0.5缩放到1.0
         */
        val addAnimator =
            ObjectAnimator.ofFloat(null, "scaleX", 0.5f, 1f).setDuration(1500)
        layoutTransition.setAnimator(LayoutTransition.APPEARING, addAnimator)

        /**
         * DISAPPEARING：移除View时被移除view的动画
         * desc:view向右移动50px后回到原点，然后消失。
         */
        val removeAnimatior =
            ObjectAnimator.ofFloat(null, "scaleX", 1f,0f).setDuration(1500)
        layoutTransition.setAnimator(LayoutTransition.DISAPPEARING, removeAnimatior)

        //为了防止动画没有效果，把left，right，top，bottom的设置都加上
        val changeLeft = PropertyValuesHolder.ofInt("left", 0, 0)
        val changeTop = PropertyValuesHolder.ofInt("top", 0, 0)
        val changeRight = PropertyValuesHolder.ofInt("right", 0, 0)
        val changeBottom = PropertyValuesHolder.ofInt("bottom", 0, 0)


        /**
         * CHANGE_APPEARING：添加view时，其他受影响view动画效果
         */
        val aniChanApp = PropertyValuesHolder.ofFloat("rotation", 0f, 50f, 0f)
        val changeApp =
            ObjectAnimator.ofPropertyValuesHolder(this, changeLeft, changeTop, aniChanApp)
        layoutTransition.setAnimator(LayoutTransition.CHANGE_APPEARING, changeApp)


        /**
         * 删除view时其他受影响view动画效果
         */
        val aniChangeDis =
            PropertyValuesHolder.ofFloat("rotation", 0f, 50f, 0f)
        val changeDis =
            ObjectAnimator.ofPropertyValuesHolder(this, changeLeft, changeTop, aniChangeDis)
        layoutTransition.setAnimator(LayoutTransition.CHANGE_DISAPPEARING, changeDis)

    }
}