package com.demo.kotlin

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.base.R
import com.utils.ext.setOnAvoidClickListener
import com.demo.main.MainViewModel
import kotlinx.android.synthetic.main.activity_coroutine.*
import kotlinx.coroutines.*

class CoroutineActivity : AppCompatActivity() {
    val model: MainViewModel by viewModels()

    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.Main)

    private val mExceptionHandler = CoroutineExceptionHandler { _, exception ->
        log("CoroutineExceptionHandler got $exception")
    }

    private val mScope = CoroutineScope(mExceptionHandler + SupervisorJob() + Dispatchers.Main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutine)
        btn_coroutine.setOnAvoidClickListener {
            lifecycleScope.launch(Dispatchers.IO) {
                Log.e("====", "1111")
                test1()
                Log.e("====", "2222")
            }
            Log.e("====", "3333")
        }

    }

    private suspend fun test1() {
//        delay(100)
        Log.e("====", "4444")
    }


    fun log(msg: Any) {
        Log.e("===$msg", "thread：" + Thread.currentThread().name)
    }

}