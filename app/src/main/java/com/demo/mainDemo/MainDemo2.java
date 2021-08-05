package com.demo.mainDemo;


import kotlin.Pair;
import kotlin.TuplesKt;

/**
 * author : Naruto
 * date   : 2020-08-31
 * desc   :
 * version:
 */
public class MainDemo2 {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        int[] array = new int[]{10,8,4,6,5,4};
        insertSort(array);
        for (int i : array) {
            System.out.println(i);
        }
    }
    private static void insertSort(int[] a) {
        if (a == null || a.length < 1) return;
        //第一层循环标识未排好序的数组
        for (int i = 1; i < a.length; i++) {
            int value = a[i];
            //从未排好序数组中取出元素value，从已排好序的数组中最后一个元素开始比较。
            int j = i - 1;
            for (; j >= 0; j--) {
                if (value < a[j]) {
                    //如果value小于 a[j]，那么继续比较。当前数据往后移动一位。
                    a[j + 1] = a[j];
                }else {
                    //如果value大于 a[j]，跳出循环。
                    break;
                }
            }
            a[j + 1]=value;
        }
    }
}
