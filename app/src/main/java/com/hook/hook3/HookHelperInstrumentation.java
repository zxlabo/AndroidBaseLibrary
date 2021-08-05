package com.hook.hook3;

import android.app.Instrumentation;

import com.hook.EvilInstrumentationExecStartActivity;
import com.hook.RefInvoke;

public class HookHelperInstrumentation {

    public static void attachContext() throws Exception{
        // 先获取到当前的ActivityThread对象
        Object currentActivityThread = RefInvoke.invokeStaticMethod("android.app.ActivityThread", "currentActivityThread");

        // 拿到原始的 mInstrumentation字段
        Instrumentation mInstrumentation = (Instrumentation) RefInvoke.getFieldObject(currentActivityThread, "mInstrumentation");

        // 创建代理对象
        Instrumentation evilInstrumentation = new EvilInstrumentation(mInstrumentation);

        // 偷梁换柱
        RefInvoke.setFieldObject(currentActivityThread, "mInstrumentation", evilInstrumentation);
    }
}