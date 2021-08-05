package com.demo.design.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * author : Naruto
 * date   : 2020/12/20
 * desc   :
 * version:
 */
public class ProxyFactory {
    //维护目标对象
    private Object target;

    //通过构造器传入目标对象
    public ProxyFactory(Object target) {
        this.target = target;
    }

    //给目标对象生成动态代理对象
    public Object getProxyInstance() {
        /**
         * 1、ClassLoader：指定当前目标对象使用的类加载器。
         *   获取类加载器的方法固定：target.getClass().getClassLoader()
         * 2、interfaces：目标对象实现的接口类型，使用泛型方法确认类型。
         *    方法固定：target.getClass().getInterfaces()
         *3、InvocationHandler：事件处理，执行目标对象方法时，会触发invoke方法。会把目标对象方法作为参数传入。
         */
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                /**
                 *  proxy:指的是我们所代理的那个真实对象
                 *  method:指的是我们所要调用真实对象的某个方法的Method对象
                 *  args:指的是调用真实对象某个方法时接受的参数
                 */
                Object val = method.invoke(target, args);
                return val;
            }
        });
    }
}
