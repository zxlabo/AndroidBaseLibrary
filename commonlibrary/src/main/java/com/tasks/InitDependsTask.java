package com.tasks;


import com.CommonApplication;
import com.baselibrary.utils.LogUtils;
import com.baselibrary.utils.launchstarter.Task;

import java.util.ArrayList;
import java.util.List;

/**
 * 需要在getDeviceId之后执行
 */
public class InitDependsTask extends Task {

    @Override
    public List<Class<? extends Task>> dependsOn() {
        List<Class<? extends Task>> task = new ArrayList<>();
        task.add(GetDeviceIdTask.class);
        return task;
    }

    @Override
    public void run() {
        CommonApplication app = (CommonApplication) mContext;
        LogUtils.e("InitDependsTask，需要在getDeviceId之后执行，deviceId："+app.getDeviceId()+ Thread.currentThread().getName());
    }

}
