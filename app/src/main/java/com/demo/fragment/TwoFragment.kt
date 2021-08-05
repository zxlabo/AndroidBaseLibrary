package com.demo.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.base.R
import kotlinx.android.synthetic.main.fragment_two.*

/**
 * author : Naruto
 * date   : 2020/11/17
 * desc   :
 * version:
 */
class TwoFragment: Fragment() {


    private var mModel:OneViewModel?=null
    val tagName by lazy {
        this::class.java.name
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.let {
            mModel=   ViewModelProvider(it).get(OneViewModel::class.java)
        }
        mModel?.mName?.observe(viewLifecycleOwner, Observer {
            tv_two.text=it
            Log.e(tagName,it)
        })
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater?.inflate(R.layout.fragment_two,container,false)
    }

}