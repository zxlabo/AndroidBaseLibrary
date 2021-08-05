package com.demo.design.proxy

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.base.R
import com.youth.banner.loader.ImageLoader
import kotlinx.android.synthetic.main.activity_proxy.*
import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method
import java.lang.reflect.Proxy

class ProxyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_proxy)
        btn_load.setOnClickListener {
            var imageLoader: IImageLoad = createImgloadService(IImageLoad::class.java)
            imageLoader.loadImg("aaa")
        }
    }


    private fun <T> createImgloadService(service: Class<T>): T {
        return Proxy.newProxyInstance(
            service.classLoader,
            arrayOf<Class<*>>(service),
            object : InvocationHandler {
                override fun invoke(proxy: Any?, method: Method?, args: Array<out Any>?): Any? {
                    Log.e("===proxy method name", method?.name ?: "")
                    return method?.invoke(proxy, args)
                }

            }) as T

    }


}