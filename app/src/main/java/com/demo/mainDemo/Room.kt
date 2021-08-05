package com.demo.mainDemo

import android.view.View

/**
 * author : Naruto
 * date   : 4/26/21
 * desc   :
 * version:
 */
fun View.invisible() {
    visibility = View.INVISIBLE
}

class Room(age:String,var name:String) {
   init {
       age
       name
   }
    fun test(){
        name
    }

}