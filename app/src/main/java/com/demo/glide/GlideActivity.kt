package com.demo.glide

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.base.R
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.activity_glide.*
import java.util.*

class GlideActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_glide)
        btn_glide.setOnClickListener {
            val url = "https://i.niupic.com/images/2020/11/27/929x.png"
//            Glide.with(this).load(url)
//                .placeholder(R.drawable.bg_splash)
//                .error(R.drawable.bg_splash)
//                .override(300, 300)//指定图片尺寸
//                .fitCenter()//指定图片错误类型
//                .skipMemoryCache(true)//跳过内存缓存
//                //硬盘缓存策略 .diskCacheStrategy() 跳过磁盘缓存、缓存不同类型的策略
//                .priority(Priority.HIGH)//指定优先级，加载最重要的图片
//                .into(img_1)//指定显示图片的ImageView。
            loadSimpleImageView()
            val array = intArrayOf(1, 5, 4, 8, 7)
        }
    }

    fun loadSimpleImageView() {
        val url = "https://i.niupic.com/images/2020/11/27/929x.png"
        Glide.with(this).load(url).into(img_1)
        Glide.with(this).load(url)
            .apply(RequestOptions.circleCropTransform())
            .into(img_2)
        Glide.with(this).load(url)
            .apply(RequestOptions.bitmapTransform(RoundedCorners(22)))
            .into(img_3)
    }
}