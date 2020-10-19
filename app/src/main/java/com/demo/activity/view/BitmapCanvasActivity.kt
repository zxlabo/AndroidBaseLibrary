package com.demo.activity.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.base.R

/**
 *一、Bitmap创建方式:
常用的两种:
//方法一：新建一个空白bitmap
Bitmap bmp = Bitmap.createBitmap(width ,height Bitmap.Config.ARGB_8888);
//方法二：从图片中加载
Bitmap bmp = BitmapFactory.decodeResource(getResources(),R.drawable.wave_bg,null);
 */
class BitmapCanvasActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bitmap_canvas)
    }
}
