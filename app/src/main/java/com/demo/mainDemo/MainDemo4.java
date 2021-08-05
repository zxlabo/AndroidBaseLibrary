package com.demo.mainDemo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * author : Naruto
 * date   : 4/6/21
 * desc   :
 * version:
 */
class MainDemo4 {

    static ReentrantLock lock = new ReentrantLock();
    static Condition condition1 = lock.newCondition();
    static Condition condition2 = lock.newCondition();

    public static void main(String[] args) {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                while (true) {
                    if (isInterrupted()){
                        break;
                    }
                    System.out.println("111");
                }
            }
        };
        t1.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.interrupt();
    }


    private static void log(String msg) {
        System.out.println(Thread.currentThread().getName() + msg);
    }


}

