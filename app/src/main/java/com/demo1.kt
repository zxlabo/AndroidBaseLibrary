package com

import android.app.Activity
import android.content.Intent
import android.view.View
import android.widget.TextView

/**
 * author : Naruto
 * date   : 2021/5/13
 * desc   :
 * version:
 */

fun main() {
     val list= mutableListOf<String>()
    list.add("0")
    list.add("1")
    list.add("2")
    list.add("3")
    for (i in 0 until list.size){
        val productItem = list[i]
        if ("2" == productItem){
            list.removeAt(i)
            break
        }
    }
    println(list)

}

inline fun <reified T:Activity> Activity.startAct(){
    startActivity(Intent(this,T::class.java))
}

