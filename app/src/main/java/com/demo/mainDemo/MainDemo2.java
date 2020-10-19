package com.demo.mainDemo;


import com.base.Person;

import java.util.LinkedHashMap;

/**
 * author : Naruto
 * date   : 2020-08-31
 * desc   :
 * version:
 */
public class MainDemo2 {
    public static void main(String[] args) {

//        Person[] tab = new Person[10];
//        tab[0] = new Person("xm");
//        tab[1] = new Person("lingling");
//        for (Person person : tab) {
//            System.out.println(person);
//        }
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
//        map.put()
//        Node<K,V>[] table;
//        table= (Node<K,V>[])new Node[newCap];//newCap，默认初始为1 << 4（16），之后会扩容，左移1位。
//        //通过数组长度和hash值，计算当前的索引。然后把几点存到数组对应的索引中。
//        tab[i = (n - 1) & hash]= newNode(hash, key, value, null);
//        //注意：node是链表，当链表长度超过 8 时(大于等于9)，链表转换为红黑树。
//
////        HashMap<String, String> map = new HashMap<>();
//        map.put()

        Person name = new Person(Person.PersonType.STUDENT, "name");
    }



}
