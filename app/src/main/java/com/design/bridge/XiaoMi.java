package com.design.bridge;

/**
 * 小米品牌
 */
public class XiaoMi implements Brand {

    @Override
    public void open() {
        System.out.println("小米open");
    }

    @Override
    public void close() {
        System.out.println("小米close");
    }

    @Override
    public void call() {
        System.out.println("小米call");
    }

}
