package com.demo.design.proxy;



/**
 * author : Naruto
 * date   : 2020/12/20
 * desc   :
 * version:
 */
class ProxyDemo {
    public static void main(String[] args) {
        //创建目标对象
        IImageLoad imageLoad = new GlideImageLoad();
        //给目标对象创建动态代理对象
        IImageLoad imageLoadProxy = (IImageLoad) new ProxyFactory(imageLoad).getProxyInstance();
        //调用
        imageLoadProxy.loadImg("");
    }
}
