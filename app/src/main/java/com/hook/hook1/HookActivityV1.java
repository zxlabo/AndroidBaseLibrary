package com.hook.hook1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.hook.EvilInstrumentationExecStartActivity;
import com.hook.RefInvoke;
import com.hook.TargetActivity;
import com.hook.hook1.hook.AMSHookHelper;

/**
 *  这已经是29版本了，对之前的已经不适用了。所以会崩溃。
 */
public class HookActivityV1 extends AppCompatActivity {


    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(newBase);

        try {
//            AMSHookHelper.hookAMN();
            AMSHookHelper.hookActivityThread();
        } catch (Throwable throwable) {
            throw new RuntimeException("hook failed", throwable);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Instrumentation mInstrumentation = (Instrumentation) RefInvoke.getFieldObject(Activity.class, this, "mInstrumentation");
        Instrumentation evilInstrumentation = new EvilInstrumentationExecStartActivity(mInstrumentation);
        RefInvoke.setFieldObject(Activity.class, this, "mInstrumentation", evilInstrumentation);

        Button button = new Button(this);
        button.setText("启动TargetActivity");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // 启动目标Activity; 注意这个Activity是没有在AndroidManifest.xml中显式声明的
                // 但是调用者并不需要知道, 就像一个普通的Activity一样
                startActivity(new Intent(HookActivityV1.this, TargetActivity.class));
            }
        });
        setContentView(button);

    }
}