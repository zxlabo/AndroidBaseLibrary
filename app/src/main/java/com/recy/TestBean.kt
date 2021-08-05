package com.recy

import com.recy.diff.BaseDiffBean

internal class TestBean(var name: String, var desc: String) : Cloneable,
    BaseDiffBean {

    //仅写DEMO 用 实现克隆方法
    @Throws(CloneNotSupportedException::class)
    public override fun clone(): TestBean {
        var bean: TestBean? = null
        try {
            bean = super.clone() as TestBean
        } catch (e: CloneNotSupportedException) {
            e.printStackTrace()
        }
        return bean!!
    }

     //判断是否同一个对象
    override fun isSameObject(other: Any): Boolean {
        return false
    }

    //判断是否同一个对象
    override fun hasSameContent(other: Any): Boolean {
        return false
    }

    override fun diff(other: Any?): Any? {
        return null
    }

}