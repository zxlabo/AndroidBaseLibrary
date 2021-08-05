package com.tasks;

import com.baselibrary.utils.LogUtils;
import com.baselibrary.utils.launchstarter.MainTask;


/**
 * 主线程执行的task
 */
public class InitMainBTask extends MainTask {


    @Override
    public void run() {
        // 模拟一些操作
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LogUtils.i("InitMainBTask 主线程执行的task" + Thread.currentThread().getName());
    }
}
