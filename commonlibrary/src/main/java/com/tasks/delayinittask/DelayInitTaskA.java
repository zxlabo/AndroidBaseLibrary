package com.tasks.delayinittask;


import com.baselibrary.utils.LogUtils;
import com.baselibrary.utils.launchstarter.MainTask;

public class DelayInitTaskA extends MainTask {

    @Override
    public void run() {
        // 模拟一些操作
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LogUtils.e("lazy--DelayInitTaskA finished"+ Thread.currentThread().getName());
    }
}
