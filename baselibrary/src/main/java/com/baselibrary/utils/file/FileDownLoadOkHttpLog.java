package com.baselibrary.utils.file;

import okhttp3.logging.HttpLoggingInterceptor;


public class FileDownLoadOkHttpLog implements HttpLoggingInterceptor.Logger {
    @Override
    public void log(String message) {
//       Helper.showLog(message);
    }
}