package com.demo.main;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.base.R;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        findViewById(R.id.btn_test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("===", urlAppendParams("test?aa=dd", "key", "value"));
            }
        });
    }


    public static String urlAppendParams(String originUrl, String key, String value) {
        if (TextUtils.isEmpty(originUrl) || TextUtils.isEmpty(key) || TextUtils.isEmpty(value)) {
            return "";
        }
        StringBuilder sb = new StringBuilder(originUrl);
        if (originUrl.contains("?")) {
            sb.append("&").append(key).append("=").append(value);
        } else {
            sb.append("?&").append(key).append("=").append(value);
        }
        return sb.toString();
    }
}