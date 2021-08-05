package com.demo.jetpack.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.base.R
import com.baselibrary.extension.setOnAvoidClickListener
import kotlinx.android.synthetic.main.activity_room.*

class RoomActivity : AppCompatActivity() {
    private lateinit var mViewModel: UserViewModel
    var i = 1
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)
        mViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        mViewModel.allUsers.observe(this, Observer { tv_user.text = it.toString() })
        btn_db.setOnAvoidClickListener {
            val user = User("小明$i")
            i++
            mViewModel.insert(user)
        }
//        val db = Room.databaseBuilder(
//            applicationContext,
//            UserDatabase::class.java, "database-name"
//        ).build()
//        val user = User("小明")
//        db.userDao().insertUser(user)
    }
}