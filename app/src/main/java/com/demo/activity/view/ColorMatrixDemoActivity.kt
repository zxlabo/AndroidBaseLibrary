package com.demo.activity.view

import android.graphics.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import com.base.R
import kotlinx.android.synthetic.main.activity_color_matrix_demo.*

class ColorMatrixDemoActivity : AppCompatActivity() {
    private lateinit var mOriginBmp: Bitmap
    private lateinit var mTempBmp: Bitmap
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_color_matrix_demo)
        mOriginBmp = BitmapFactory.decodeResource(resources, R.mipmap.naruto)
        mTempBmp =
            Bitmap.createBitmap(mOriginBmp.width, mOriginBmp.height, Bitmap.Config.ARGB_8888)
        seek_bar.max = 20
        seek_bar.progress = 1
        seek_bar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                tv_saturation.text = progress.toString()
                val canvas = Canvas(mTempBmp)
                val paint = Paint()
                paint.isAntiAlias = true
                val mSaturation = ColorMatrix()
                mSaturation.setSaturation(progress.toFloat())
                paint.colorFilter = ColorMatrixColorFilter(mSaturation)
                canvas.drawBitmap(mOriginBmp, 0f, 0f, paint)
                img_naruto.setImageBitmap(mTempBmp)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }

        })
    }
}
