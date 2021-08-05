package com.hook;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.demo.main.MainActivity;

public class HookActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Instrumentation mInstrumentation = (Instrumentation) RefInvoke.getFieldObject(Activity.class, this, "mInstrumentation");
        Instrumentation evilInstrumentation = new EvilInstrumentationExecStartActivity(mInstrumentation);
        RefInvoke.setFieldObject(Activity.class, this, "mInstrumentation", evilInstrumentation);

        Button tv = new Button(this);
        tv.setText("测试界面");
        setContentView(tv);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HookActivity2.this, MainActivity.class);
                startActivity(intent);
            }
        });
        testA(tv.getClass());
        testB(PersonA.class);
    }

    private void testB(Class<PersonA> personAClass) {

    }

    private void testA(Class<? extends Button> clz) {

    }
}