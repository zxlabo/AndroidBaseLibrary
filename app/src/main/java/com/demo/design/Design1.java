package com.demo.design;

/**
 * author : Naruto
 * date   : 2020/12/13
 * desc   :
 * version:
 */

/**
 * 使用这种方式的弊端：
 * <p>
 * 1、如果新增微信、短信的消息。我们需要在Person类新增方法，这样就会Person类的修改，可能会产生问题。
 * 解决思路：引入一个接口IReceiver，表示接收者。这样Person类和IReceiver发生依赖。
 */
class Design1 {
    public static void main(String[] args) {
        Person person = new Person();
        person.receive(new Email());
        WeiXin weiXin = new WeiXin();
        person.receive(weiXin);
    }
}

/**
 * 完成Person接受消息的功能
 */
class Email {
    public String getInfo() {
        return "Email接收到信息";
    }
}

class Person {
    public void receive(Email email) {
        System.out.println(email.getInfo());
    }
    public void receive(IReceiver receiver){
        System.out.println(receiver.getInfo());
    }
}
/**
 * 新增IReceiver接口,表示接收者。
 */
interface IReceiver{
    public String getInfo();
}
/**
 * WeiXin实现IReceiver，这样实现了依赖倒置。
 */
class WeiXin implements IReceiver{

    @Override
    public String getInfo() {
        return "WeiXin接收到信息";
    }
}