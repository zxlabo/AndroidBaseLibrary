package com.tasks.delayinittask;


import com.baselibrary.utils.LogUtils;
import com.baselibrary.utils.launchstarter.MainTask;

public class DelayInitTaskB extends MainTask {

    @Override
    public void run() {
        // 模拟一些操作
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LogUtils.v("lazy--DelayInitTaskB finished"+ Thread.currentThread().getName());
    }
}
