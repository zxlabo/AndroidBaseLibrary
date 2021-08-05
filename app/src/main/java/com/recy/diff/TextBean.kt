package com.recy.diff

/**
 * author : Naruto
 * date   : 2020/11/5
 * desc   :
 * version:
 */
data class TextBean(var text: String, var id: Int, var type: String) : BaseDiffBean {

    override fun isSameObject(other: Any): Boolean {
        return this.id == (other as? TextBean)?.id
    }

    override fun hasSameContent(other: Any): Boolean {
        return this.text == (other as? TextBean)?.text
    }

    override fun diff(other: Any?): Any? {
        return when {
            other !is TextBean -> null
            this.text != other.text -> {"text change"}
            else -> null
        }
    }
}