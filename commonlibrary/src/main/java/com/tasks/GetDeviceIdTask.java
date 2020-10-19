package com.tasks;

import android.provider.Settings;

import com.CommonApplication;
import com.baselibrary.utils.LogUtils;
import com.baselibrary.utils.launchstarter.Task;


public class GetDeviceIdTask extends Task {

    private String mDeviceId;

    @Override
    public boolean needWait() {
        return true;
    }

    @Override
    public void run() {
        // 模拟一些操作
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        CommonApplication app = (CommonApplication) mContext;
        mDeviceId = Settings.System.getString(mContext.getContentResolver(), Settings.System.ANDROID_ID);
        app.setDeviceId(mDeviceId);
        LogUtils.e("GetDeviceIdTask,"+ mDeviceId+ Thread.currentThread().getName());

    }

}
