package com.demo.other

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.base.R
import com.utils.ext.setOnAvoidClickListener
import com.utils.ext.showToast
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        btn_hide.setOnAvoidClickListener {
            showFirstMenuItem = false
            invalidateOptionsMenu()
        }
        btn_show.setOnAvoidClickListener {
            showFirstMenuItem = true
            invalidateOptionsMenu()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_demo, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_one -> {
                showToast("点击了第一个item")
                true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }

    }

    var showFirstMenuItem = false

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        menu?.findItem(R.id.menu_one)?.setVisible(showFirstMenuItem)
        return super.onPrepareOptionsMenu(menu)
    }
}