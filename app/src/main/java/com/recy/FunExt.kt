package com.recy

/**
 * author : Naruto
 * date   : 2020/11/4
 * desc   :
 * version:
 */

class Text {
    var text: String? = null
    infix fun diff(other: Any?): Any? {
        return when {
            other !is Text -> null
            this.text != (other as? Text)?.text -> ""
            else -> null
        }

    }
}
fun test(){
    val text = Text()
    val text2 = Text()
    text.diff(text2)
    text diff text2
}