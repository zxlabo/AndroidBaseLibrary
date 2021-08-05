package com.demo.jetpack.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * author : Naruto
 * date   : 2020/11/9
 * desc   :
 * version:
 */
@Entity(tableName = "userDataBase")//Room默认使用类名作为数据库表名，要修改表名使用 @Entity 的 tableName属性
class User {
    //@PrimaryKey ：至少定义一个字段作为主键,如果自增长ID 使用设置@PrimaryKey的 autoGenerate 属性
    //使用组合主键 使用@Entity 的@primaryKeys属性 @Entity(primaryKeys = ["id", "name"])  // 主键
    @PrimaryKey(autoGenerate = true)
    public var id = 0

    //Room 默认使用字段名成作为列名，要修改使用 @ColumnInfo(name = "***")
    @ColumnInfo(name = "nameUser")
    public var name: String? = null

    public var age: Int = 0

    constructor(name: String?) {
        this.name = name
    }

    override fun toString(): String {
        return "User(id=$id, name=$name)"
    }

}