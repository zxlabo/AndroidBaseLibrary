package com.design.decorator;

public class Coffee extends Drink {

    @Override
    public float cost() {
        return getPrice();
    }

    @Override
    public String getDes() {
        return des + getPrice() + "元";
    }
}
