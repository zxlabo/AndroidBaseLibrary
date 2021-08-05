package com.demo.activity.other

import android.app.Dialog
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.TextView
import com.base.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class MyBottomSheetDialogFragment : BottomSheetDialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.e("====","onCreateView")
        // 自定义布局
        val view = inflater.inflate(R.layout.dialog_bottom, container, false)
        val gotit = view.findViewById<View>(R.id.gotIt) as TextView
        gotit.setOnClickListener { dismiss() }
        return view
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        // 解决dialog黑屏问题
        val dialog = super.onCreateDialog(savedInstanceState)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            dialog.window?.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        }
        return dialog
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.e("====","onViewCreated")
    }
}