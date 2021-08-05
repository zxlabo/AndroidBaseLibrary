package com.tasks;


import com.baselibrary.utils.LogUtils;
import com.baselibrary.utils.launchstarter.Task;


/**
 * 异步线程执行的普通task
 */
public class InitCommonTask extends Task {


    @Override
    public void run() {
        // 模拟一些操作
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LogUtils.i("InitCommonTask 异步线程执行的普通task"+ Thread.currentThread().getName());
    }
}
