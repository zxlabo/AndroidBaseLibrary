package com.demo.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.base.R
import kotlinx.android.synthetic.main.activity_region_select.*
@Route(path = "/account/order")
class RegionSelectActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_region_select)
        btn_address.setOnClickListener {

        }
    }
}