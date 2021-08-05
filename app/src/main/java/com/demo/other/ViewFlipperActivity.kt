package com.demo.other

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.base.R
import kotlinx.android.synthetic.main.activity_view_flipper.*


class ViewFlipperActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_flipper)

        btn_go.setOnClickListener {
            setViewFlipper()
            i++;
        }

    }

    var i = 0;

    private fun setViewFlipper() {
        view_flipper.removeAllViews()
        view_flipper.clearFocus()
        val list = mutableListOf<String>()
        list.add("---" + i)
        list.add("---" + ++i)
        list.forEach { msg ->
            val view = LayoutInflater.from(this).inflate(R.layout.view_flipper_item, null)
            val tv = view.findViewById<TextView>(R.id.tv_text)
            tv.text = msg
            view_flipper.addView(view)
        }
        view_flipper.setInAnimation(this, R.anim.mine_vf_come_in)
        view_flipper.setOutAnimation(this, R.anim.mine_vf_go_out)
        view_flipper.flipInterval = 3000
        view_flipper.startFlipping()
        view_flipper.isAutoStart
    }

    fun stopFlip() {
        if (view_flipper.isFlipping) {
            view_flipper.stopFlipping()
        }
    }
}