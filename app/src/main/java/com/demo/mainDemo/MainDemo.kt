package com.demo.mainDemo

import android.graphics.Color
import android.graphics.Typeface
import android.text.Spannable
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.method.LinkMovementMethod
import android.text.style.StyleSpan
import android.util.Log
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.produce
import java.util.regex.Pattern


/**
 * author : Naruto
 * date   : 2020-08-28
 * desc   :
 * version:
 */
class MainDemo {
    companion object {
        private var name: String? = "hello"

        @JvmStatic
        fun main(args: Array<String>) {
            foo.invoke(1,2)
            foo(1,2)
            foo2(1).invoke(2)
            foo2(1)(2)

            var sum=0
            listOf(1,2,3).forEach {
                sum+=it
            }

        }

        val foo = { x: Int, y: Int -> x + y }

        fun foo2(x: Int) = { y: Int -> x + y }

    }


}
