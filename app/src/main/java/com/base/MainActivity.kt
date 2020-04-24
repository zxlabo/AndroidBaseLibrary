package com.base

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.baselibrary.utils.AppUtils

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AppUtils.getAppVersionName(this)

    }
}
