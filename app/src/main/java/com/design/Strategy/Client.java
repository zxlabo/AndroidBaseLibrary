package com.design.Strategy;

public class Client {

    public static void main(String[] args) {
        //创建context处方类
        Kitchen kitchen = new Kitchen();
        //创建策略:红烧大闸蟹
        CrabCooking braisedCrabs = new BraisedCrabs();
        //创建策略:清蒸大闸蟹
        CrabCooking steamedCrabs = new SteamedCrabs();
        //我们要制作红烧大闸蟹
        System.out.println("----我们要制作红烧大闸蟹----");
        kitchen.setStrategy(braisedCrabs);
        kitchen.CookingMethod();
        System.out.println("----我们要制作清蒸大闸蟹----");
        //我们要制作清蒸大闸蟹
        kitchen.setStrategy(steamedCrabs);
        kitchen.CookingMethod();
    }

}
