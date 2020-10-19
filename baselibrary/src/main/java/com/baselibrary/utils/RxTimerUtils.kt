package com.baselibrary.utils

import androidx.annotation.NonNull
import java.util.concurrent.TimeUnit

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable

/**
 * 描述：RxJava 定时任务工具类
 */
object RxTimerUtils {
    private var mDisposable: Disposable? = null

    /**
     * 定时任务 毫秒
     * milliseconds毫秒后执行指定动作
     */
    @JvmStatic
    fun timer(milliSeconds: Long, rxAction: RxAction?) {
        Observable.timer(milliSeconds, TimeUnit.MILLISECONDS)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<Long> {
                override fun onNext(t: Long) {
                    rxAction?.action(t)
                }

                override fun onSubscribe(@NonNull disposable: Disposable) {
                    mDisposable = disposable
                }


                override fun onError(@NonNull e: Throwable) {
                    //取消订阅
                    cancel()
                }

                override fun onComplete() {
                    //取消订阅
                    cancel()
                }
            })
    }

    /**
     * 轮训任务 毫秒
     * 延迟delay毫秒之后，每隔milliSeconds执行任务
     */
    @JvmStatic
    fun interval(delay: Long, milliSeconds: Long, rxAction: RxAction?) {
        Observable.interval(delay, milliSeconds, TimeUnit.MILLISECONDS)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<Long> {
                override fun onNext(t: Long) {
                    rxAction?.action(t)
                }

                override fun onSubscribe(@NonNull disposable: Disposable) {
                    mDisposable = disposable
                }

                override fun onError(@NonNull e: Throwable) {
                    //取消订阅
                    cancel()
                }

                override fun onComplete() {
                    //取消订阅
                    cancel()
                }
            })
    }

    /**
     * 取消订阅
     * 循环任务是需要在activity 的 onDestroy()方法中调用该方法
     */
    @JvmStatic
    fun cancel() {
        mDisposable?.let {
            if (!it.isDisposed) {
                it.dispose()
            }
        }
    }

    interface RxAction {
        /**
         * 让调用者指定指定动作
         */
        fun action(number: Long)
    }

}
