package com.baselibrary.extension

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


inline fun <reified T : ViewModel> AppCompatActivity.CreateViewModel(): T =
    ViewModelProvider(this)[T::class.java]


inline fun <reified T : ViewModel> Fragment.CreateViewModel(): T =
    ViewModelProvider(this)[T::class.java]


