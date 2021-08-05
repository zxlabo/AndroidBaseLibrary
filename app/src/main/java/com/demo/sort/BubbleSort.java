package com.demo.sort;

import java.util.Arrays;

/**
 * author : Naruto
 * date   : 2020/12/2
 * desc   :
 * version:
 */
class BubbleSort {
    public static void main(String[] args) {
        int[] array = { 0,1, 2, 5, 6, 8, 9, 4, 7};
//        bubbleSort(array);
//        System.out.println(Arrays.toString(array));
        bubbleSortOptimization(array);
        System.out.println(Arrays.toString(array));
    }

    //flag作用：当一整次循环都没有交换位置时，说明数组已经排好序了。所以不需要继续循环比较了。
    private static void bubbleSort(int[] array) {
        if (array == null) return;
        for (int i = 0; i < array.length; i++) {
            boolean flag = false;
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                    flag = true;
                }
            }
            if (!flag) break;
        }
    }


    private static void bubbleSortOptimization(int[] array) {
        /**
         * 1、内层循环：对0到i索引的数组进行排序
         * 2、sorted 标识已经排好序的数组的起始索引，
         * 理解：如果最后的几个数字都不需要交换顺序，那就说明从第一个不需要交换顺序的索引开始到最后是已经排好序的了。
         */
        for (int i = array.length - 1; i > 0; i--) {
            System.out.println(i+"");
             int sorted=1;
             //对0 到 i索引的数组进行排序
            for (int j = 0; j < i; j++) {
              if (array[j]>array[j+1]){
                  int temp = array[j + 1];
                  array[j + 1] = array[j];
                  array[j] = temp;
                  sorted=j+1;
              }
            }
            i=sorted;
        }
    }


}
