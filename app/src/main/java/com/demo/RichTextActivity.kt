package com.demo

import android.graphics.Color
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.*
import androidx.appcompat.app.AppCompatActivity
import com.base.R
import kotlinx.android.synthetic.main.activity_rich_text.*


class RichTextActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rich_text)
        val msg1 = "预测：排卵日"
        val msg2 = "排卵日"
        val index = msg1.indexOf(msg2)
        if (index > 0) {
            val textSpanned1 = SpannableString(msg1)
            textSpanned1.setSpan(
                ForegroundColorSpan(Color.parseColor("#373D52")),
                index, index + msg2.length, Spanned.SPAN_INCLUSIVE_INCLUSIVE
            )
            textSpanned1.setSpan(
                RelativeSizeSpan(1.2f),
                index, index + msg2.length , Spanned.SPAN_INCLUSIVE_INCLUSIVE
            )
            tv_ovulation_day.text = textSpanned1
        } else {
            tv_ovulation_day.text = msg1
        }


    }
}