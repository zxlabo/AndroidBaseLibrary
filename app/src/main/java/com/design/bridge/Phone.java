package com.design.bridge;

/**
 * 手机抽象类
 */
public abstract class Phone {

    //组合的方式引入品牌
    private Brand brand;

    public Phone(Brand brand) {
        this.brand = brand;
    }

    protected void open() {
        this.brand.open();
    }

    protected void close() {
        brand.close();
    }

    protected void call() {
        brand.call();
    }

}
