package com.baselibrary.model

import io.reactivex.functions.Consumer

/**
 *
 */
open class HttpErrorConsumer(private val errorAction: (e: Throwable) -> Unit = {}) :
    Consumer<Throwable> {

    override fun accept(e: Throwable) {
        handleError(e)
        e.printStackTrace()
        errorAction(e)
    }

}