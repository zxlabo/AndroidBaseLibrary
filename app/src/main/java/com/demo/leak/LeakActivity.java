package com.demo.leak;

import androidx.annotation.NonNull;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.base.R;
import com.baselibrary.base.BaseToolBarActivity;
import com.baselibrary.utils.StatusBarUtil;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.schedulers.Schedulers;


public class LeakActivity extends BaseToolBarActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leak);
        StatusBarUtil.StatusBarLightMode(this);


        findViewById(R.id.btn_leak).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //1、创建事件生产者
                ObservableOnSubscribe observableOnSubscribe = new ObservableOnSubscribe<String>() {
                    @Override
                    public void subscribe(@io.reactivex.annotations.NonNull ObservableEmitter<String> emitter) throws Exception {
                        emitter.onNext("hello");
                        emitter.onError(new Throwable("主动错误"));
                        emitter.onComplete();
                    }
                };

                //2、将observableOnSubscribe事件生产者作为参数create方法中，创建被观察者
                Observable observable = Observable.create(observableOnSubscribe);

                //3、创建观察者
                Observer<String> observer = new Observer<String>() {
                    @Override
                    public void onSubscribe(@io.reactivex.annotations.NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@io.reactivex.annotations.NonNull String s) {

                    }


                    @Override
                    public void onError(@io.reactivex.annotations.NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                };
                observable.subscribe(observer);
                //3、通过订阅subscribe链接观察者和被观察者
                observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer);


//                LeakSingle.getInstance(LeakActivity.this);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("====", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("====", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("====", "onStop");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.e("====", "onSaveInstanceState");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("====", "onDestroy");




    }

//    class TestLeak {
//
//    }
}