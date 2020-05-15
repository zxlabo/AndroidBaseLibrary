package com.base

import androidx.appcompat.app.AlertDialog
import com.baselibrary.base.BaseViewModel

/**
 * author : Naruto
 * date   : 2020-05-15
 * desc   :
 * version:
 */
class MainViewModel : BaseViewModel() {

    fun showTip() {
        startForContext {
            AlertDialog.Builder(this).setTitle("title").create().show()
        }
    }

}