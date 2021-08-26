package com.demo.fragment.vp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.base.R
import com.baselibrary.utils.ext.setOnAvoidClickListener
import com.demo.RichTextActivity
import kotlinx.android.synthetic.main.fragment_screen_slide_page.*

class ScreenSlidePageFragment() : Fragment() {
    private val rootView: View? = null
    private var s: String? = null
    override fun onAttach(context: Context) {
        super.onAttach(context)
        s=arguments?.getString(key_1)
        Log.e("===", "onAttach$s")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_screen_slide_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tv_fragment.text = s
        btn_go.setOnAvoidClickListener {
            startActivity(Intent(activity, RichTextActivity::class.java))
        }
        Log.e("===", "onViewCreated$s")
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        Log.e("===", "setUserVisibleHint${s}$isVisibleToUser")
    }

    override fun onResume() {
        super.onResume()
        Log.e("===", "onResume$s")
    }

    fun onFragmentFirstVisible() {

    }

    fun onFragmentVisible() {

    }

    companion object {
        const val key_1 = "key_1"
        fun newInstance(s: String): ScreenSlidePageFragment {
            val dialog = ScreenSlidePageFragment()
            dialog.arguments = Bundle().apply {
                putString(key_1, s)
            }
            return dialog
        }
    }
}
    