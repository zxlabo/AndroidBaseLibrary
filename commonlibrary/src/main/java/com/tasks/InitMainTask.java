package com.tasks;

import com.baselibrary.utils.LogUtils;
import com.baselibrary.utils.launchstarter.MainTask;


/**
 * 主线程执行的task
 */
public class InitMainTask extends MainTask {

    @Override
    public boolean needWait() {
        return true;
    }

    @Override
    public void run() {
        // 模拟一些操作
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LogUtils.e("InitMainTask 主线程执行的task" + Thread.currentThread().getName());
    }
}
