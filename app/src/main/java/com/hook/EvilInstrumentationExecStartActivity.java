package com.hook;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

import com.hook.hook1.hook.AMSHookHelper;

/**
 * @author weishu
 * @date 16/1/28
 */
public class EvilInstrumentationExecStartActivity extends Instrumentation {

    private static final String TAG = "EvilInstrumentationExecStartActivity";

    // ActivityThread中原始的对象, 保存起来
    Instrumentation mBase;

    public EvilInstrumentationExecStartActivity(Instrumentation base) {
        mBase = base;
    }

    public ActivityResult execStartActivity(
            Context who, IBinder contextThread, IBinder token, Activity target,
            Intent intent, int requestCode, Bundle options) {


        Intent newIntent = new Intent();

        // 替身Activity的包名, 也就是我们自己的包名
        String stubPackage = intent.getComponent().getPackageName();

        // 这里我们把启动的Activity临时替换为 StubActivity
        ComponentName componentName = new ComponentName(stubPackage, StubActivity.class.getName());
        newIntent.setComponent(componentName);

        // 把我们原始要启动的TargetActivity先存起来
        newIntent.putExtra(AMSHookHelper.EXTRA_TARGET_INTENT, intent);





        // 开始调用原始的方法, 调不调用随你,但是不调用的话, 所有的startActivity都失效了.
        // 由于这个方法是隐藏的,因此需要使用反射调用;首先找到这个方法
        Class[] p1 = {Context.class, IBinder.class,
                IBinder.class, Activity.class,
                Intent.class, int.class, Bundle.class};
        Object[] v1 = {who, contextThread, token, target,
                newIntent, requestCode, options};
        return (ActivityResult) RefInvoke.invokeInstanceMethod(
                mBase, "execStartActivity", p1, v1);
    }
}
