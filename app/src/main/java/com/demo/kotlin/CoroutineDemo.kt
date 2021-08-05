package com.demo.kotlin

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.ArrayList

/**
 * author : Naruto
 * date   : 3/29/21
 * desc   :
 * version:
 */
fun main() {
    val list = ArrayList<String>()
    list.add("1")
    list.add("2")
    list.add("3")
    list.add("4")

    val iterator = list.iterator()
    while (iterator.hasNext()){
        val next = iterator.next()
        if (next=="2"){
            iterator.remove()
//            list.add("555")
        }
    }
    println(list)

}
suspend fun getNum():Int{
    delay(200)
    return 1
}