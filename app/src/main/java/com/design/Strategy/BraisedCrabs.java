package com.design.Strategy;

//具体策略类：红烧大闸蟹
class BraisedCrabs implements CrabCooking {
    private static final long serialVersionUID = 1L;
    public void CookingMethod() {
       System.out.println("红烧大闸蟹");
    }
}