package com.baselibrary.utils;

import android.annotation.SuppressLint;


import com.orhanobut.logger.Logger;

import org.jetbrains.annotations.NotNull;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日志工具类
 */

public class LogUtils {

    public synchronized static void v(String msg) {
        Logger.t("LOG").i(getMsg(msg));
    }

    public synchronized static void d(String msg) {
        Logger.t("LOG").i(getMsg(msg));
    }

    public synchronized static void i(String msg) {
        Logger.t("LOG").i(getMsg(msg));
    }

    public synchronized static void w(String msg) {
        Logger.t("LOG").w(getMsg(msg));
    }

    public synchronized static void e(String msg) {
        Logger.t("LOG").e(getMsg(msg));
    }

    private static String getMsg(String msg) {
        return msg;
//        StackTraceElement traceElement = ((new Exception()).getStackTrace())[1];
//        return "[" + traceElement.getFileName() + " | " +
//                traceElement.getLineNumber() + " | " + traceElement.getMethodName() + "] \n" + msg;
    }


    public synchronized static void v(String... msgs) {
        Logger.t("LOG").i(getMsg(msgs, "Log.v"));
    }


    public synchronized static void d(String... msgs) {
        Logger.t("LOG").i(getMsg(msgs, "Log.d"));
    }

    public synchronized static void i(String... msgs) {
        Logger.t("LOG").i(getMsg(msgs, "Log.i"));
    }

    public synchronized static void w(String... msgs) {
        Logger.t("LOG").w(getMsg(msgs, "Log.w"));
    }

    public synchronized static void e(String... msgs) {
        Logger.t("LOG").e(getMsg(msgs, "Log.e"));
    }

    @NotNull
    private static String getMsg(String[] msgs, String s) {
//        StackTraceElement traceElement = ((new Exception()).getStackTrace())[1];
////        StringBuilder toStringBuffer = new StringBuilder("[").append(traceElement.getFileName()).append(" | ")
////                .append(traceElement.getLineNumber()).append(" | ").append(traceElement.getMethodName()).append("] ");
////        if (msgs != null) {
////            toStringBuffer.append(s);
////        }
////        assert msgs != null;
////        for (String msg : msgs) {
////            toStringBuffer.append(String.format("===%s", msg));
////        }
////        return toStringBuffer.toString();
        StringBuilder toStringBuffer = new StringBuilder();
        for (String msg : msgs) {
            toStringBuffer.append(String.format("===%s", msg));
        }
        return toStringBuffer.toString();
    }


    // 当前文件名
    public static String file() {
        StackTraceElement traceElement = ((new Exception()).getStackTrace())[1];
        return traceElement.getFileName();
    }

    // 当前方法名
    public static String func() {
        StackTraceElement traceElement = ((new Exception()).getStackTrace())[1];
        return traceElement.getMethodName();
    }

    // 当前行号
    public static int line() {
        StackTraceElement traceElement = ((new Exception()).getStackTrace())[1];
        return traceElement.getLineNumber();
    }

    // 当前时间
    @SuppressLint("SimpleDateFormat")
    public static String time() {
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        return sdf.format(now);
    }
}
