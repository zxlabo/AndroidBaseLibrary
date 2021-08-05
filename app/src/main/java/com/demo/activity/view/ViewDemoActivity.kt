package com.demo.activity.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.base.R
import kotlinx.android.synthetic.main.activity_view_demo.*

class ViewDemoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_demo)
        btn_finger.setOnClickListener { startActivity(Intent(this, FingerActivity::class.java)) }
        btn_wave.setOnClickListener { startActivity(Intent(this, WaveActivity::class.java)) }
        btn_color_matrix.setOnClickListener { startActivity(Intent(this, ColorMatrixDemoActivity::class.java)) }
        btn_eraser.setOnClickListener { startActivity(Intent(this, EraserActivity::class.java)) }
        btn_bitmap.setOnClickListener { startActivity(Intent(this, BitmapCanvasActivity::class.java)) }
        btn_red.setOnClickListener { startActivity(Intent(this, RedPointActivity::class.java)) }
        btn_weight_view.setOnClickListener { startActivity(Intent(this, WeightViewActivity::class.java)) }
    }
}
