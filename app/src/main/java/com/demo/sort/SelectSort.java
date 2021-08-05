package com.demo.sort;

import java.util.Arrays;

/**
 * author : Naruto
 * date   : 2020/12/3
 * desc   :
 * version:
 */
class SelectSort {
    public static void main(String[] args) {
        int[] array = {0, 1, 2, 5, 6, 8,22, 9, 4, 7};
        selectSort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void selectSort(int[] a) {
        if (a == null || a.length < 1) return;
        //i表示未排序区间的最末尾元素
        for (int i = a.length - 1; i > 0; i--) {
            //默认最大元素是0，然后和未排序的序列的第一个元素开始比较。
            int maxIndex = 0;
            for (int j = 1; j <= i; j++) {
                //如果最大元素小于当前元素，就把最大元素的所以赋值为当前元素的索引
                 if (a[j]>a[maxIndex]){
                     maxIndex=j;
                 }
            }
            //最大元素和未排序序列最末尾元素交换位置
            int temp = a[maxIndex];
            a[maxIndex]=a[i];
            a[i] = temp;
        }
    }
}
