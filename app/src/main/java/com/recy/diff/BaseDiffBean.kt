package com.recy.diff

interface BaseDiffBean {
    // 判断当前对象和给定对象是否是同一对象
    fun isSameObject(other: Any): Boolean
    // 判断当前对象和给定对象是否拥有相同内容
    fun hasSameContent(other: Any): Boolean
    // 返回当前对象和给定对象的差异
    fun diff(other: Any?): Any?
}
