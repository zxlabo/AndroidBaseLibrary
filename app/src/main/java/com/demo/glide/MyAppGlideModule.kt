package com.demo.glide

import android.annotation.SuppressLint
import android.content.Context
import com.base.R
import com.bumptech.glide.Glide
import com.bumptech.glide.GlideBuilder
import com.bumptech.glide.Registry
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.module.AppGlideModule
import com.bumptech.glide.request.RequestOptions

/**
 * author : Naruto
 * date   : 2020/11/30
 * desc   :
 * version:
 */
@GlideModule
public class MyAppGlideModule : AppGlideModule() {

    @SuppressLint("CheckResult")
    override fun applyOptions(context: Context, builder: GlideBuilder) {
        super.applyOptions(context, builder)
        val options = RequestOptions()
        options.placeholder(R.drawable.tip_anim).error(R.drawable.tip_anim)
        builder.setDefaultRequestOptions(options)
    }

    override fun isManifestParsingEnabled(): Boolean {
        return false
    }

    override fun registerComponents(context: Context, glide: Glide, registry: Registry) {
        super.registerComponents(context, glide, registry)
    }
}