package com.baselibrary.utils.file;

import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;

public class FileDownLoadOkHttpUtils {
    // 网络请求超时时间值(s)
    private static final int DEFAULT_TIMEOUT = 30;
    private static FileDownLoadOkHttpUtils okhUtils;
    private OkHttpClient client;

    private FileDownLoadOkHttpUtils() {
        Interceptor logInterceptor = new HttpLoggingInterceptor(new FileDownLoadOkHttpLog()).setLevel(HttpLoggingInterceptor.Level.BODY);
        client = new OkHttpClient.Builder()
                .readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .addInterceptor(logInterceptor)
                .build();
    }

    public static FileDownLoadOkHttpUtils getInstance() {
        if (okhUtils == null) {
            synchronized (FileDownLoadOkHttpUtils.class) {
                if (okhUtils == null)
                    okhUtils = new FileDownLoadOkHttpUtils();
            }
        }
        return okhUtils;
    }

    public void download(String url, Callback callback) {
        Request request = new Request.Builder().url(url).get().build();
        Call call = client.newCall(request);
        call.enqueue(callback);
    }

}