package com.demo.activity.other

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.*
import androidx.fragment.app.DialogFragment
import com.base.R
import com.baselibrary.utils.ViewUtil

class GoodsTipBottomDialog :DialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.dialog_shop_goods_tip, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val window = dialog?.window ?: return
        window.setGravity(Gravity.BOTTOM)
        val lp = window.attributes
        lp.width = ViewUtil.getScreenWidth(activity)
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT
        window.attributes = lp
        window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }


    companion object {
        fun newInstance(): GoodsTipBottomDialog {
            return GoodsTipBottomDialog()
        }
    }

}