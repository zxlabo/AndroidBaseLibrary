package com.demo.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * author : Naruto
 * date   : 2020/12/2
 * desc   :
 * version:
 */
class ReflectDemo {
    public static void main(String[] args) {
        String bookPath = "com.demo.reflect.Book";
        try {
            //1、获取反射中的class对象
            Class clz = Class.forName("com.demo.reflect.Book");

            //2、通过反射创建类对象
            //2.1、通过 Class 对象的 newInstance() 方法,缺点：通过 Class 对象则只能使用默认的无参数构造方法
//            Book book = (Book) clz.newInstance();
//            System.out.println(book.toString());

            //2.2、通过 Constructor 对象的 newInstance() 方法，优点：通过Constructor创建类对象可以选择特定构造方法
//            Constructor constructor = clz.getConstructor(String.class);
//            Book book2 = (Book) constructor.newInstance("名字：小明");
//            System.out.println(book2.toString());
//            Constructor constructor2 = clz.getDeclaredConstructor(String.class, String.class);
//            constructor2.setAccessible(true);
//            Book book3 = (Book) constructor2.newInstance("名字：小明", "作者：打铃");
//            System.out.println(book3.toString());
            // （3）通过反射获取类的属性
            //通过 Class 对象的 getFields() 方法可以获取 Class 类的属性，但无法获取私有属性。
//            Field[] fields = clz.getFields();
//            for (Field field : fields) {
//                System.out.println(field.getName());
//            }
//            clz.getField("field_name");
//            System.out.println("--------");
            //使用 Class 对象的 getDeclaredFields() 方法则可以获取包括私有属性在内的所有属性
//            Field[] declaredFields = clz.getDeclaredFields();
//            for (Field declaredField : declaredFields) {
//                System.out.println(declaredField.getName());
//            }

//            System.out.println("--------");
//            // （4）通过反射获取类的方法
//            Method[] methods = clz.getMethods();
//            for (Method method : methods) {
//                System.out.println(method.getName());
//            }
//            System.out.println("--------");
//            Method[] declaredMethods = clz.getDeclaredMethods();
//            for (Method declaredMethod : declaredMethods) {
//                System.out.println(declaredMethod.getName());
//
//            }

            Method declaredMethod = clz.getDeclaredMethod("declaredMethod", int.class);
            declaredMethod.setAccessible(true);
            Object instance = clz.newInstance();
            String msg = (String) declaredMethod.invoke(instance, 1);
            System.out.println(msg);


        } catch (Exception e) {
            e.printStackTrace();
        }


        // 1、

    }
}
