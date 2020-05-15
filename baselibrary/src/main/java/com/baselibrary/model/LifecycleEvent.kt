package com.baselibrary.model

import androidx.appcompat.app.AppCompatActivity

/**
 *
 */
data class LifecycleEvent(
    val block: AppCompatActivity.() -> Unit
)