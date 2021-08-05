package com.hook;

/**
 * author : Naruto
 * date   : 4/21/21
 * desc   :
 * version:
 */
class PerSonDemo {

    public static void main(String[] args) {
        PersonA a=   new PersonA("小明");
        PersonA b=a;
        PersonA c=a;
        b.name = "大岭";
        System.out.println("a:"+a.toString());
        System.out.println("b:"+b.toString());
        System.out.println("c:"+c.toString());
    }


}
