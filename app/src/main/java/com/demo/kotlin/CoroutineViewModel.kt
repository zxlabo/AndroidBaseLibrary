package com.demo.kotlin

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.recy.test
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * author : Naruto
 * date   : 2/4/21
 * desc   :
 * version:
 */
class CoroutineViewModel : ViewModel() {


    private fun funLaunch() {
      val job = viewModelScope.launch {
            Log.e("====", "1111")
            delay(100)
            Log.e("====", "2222")
            testaa()
            Log.e("====", "4444")
        }
        job.cancel()
    }

    private suspend fun testaa() {
        Log.e("====", "3333")
    }


}


