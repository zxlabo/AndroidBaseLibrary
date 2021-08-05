package com.demo.jetpack.room

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * author : Naruto
 * date   : 2020/11/9
 * desc   :
 * version:
 */
@Entity
data class Baby(@PrimaryKey(autoGenerate = true)var id:Int, var name:String, var age:Int)