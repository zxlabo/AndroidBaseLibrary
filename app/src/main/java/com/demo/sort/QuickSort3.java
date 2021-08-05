package com.demo.sort;

import java.util.Arrays;

/**
 * author : Naruto
 * date   : 2020/12/3
 * desc   :
 * version:
 */
class QuickSort3 {
    public static void main(String[] args) {
        int[] array = new int[20];
        for (int i = 0; i < 20; i++) {
            array[i] = (int) (Math.random() * 100);
        }
        quickSort(array, array.length);
        System.out.println(Arrays.toString(array));
    }


    // 快速排序，a是数组，n表示数组的大小
    public static void quickSort(int[] a, int n) {
        quickSortInternally(a, 0, n - 1);
    }

    // 快速排序递归函数，p,r为下标
    private static void quickSortInternally(int[] a, int begin, int end) {
        if (begin >= end) return;

        int mid = partition(a, begin, end); // 获取分区点
        quickSortInternally(a, begin, mid - 1);
        quickSortInternally(a, mid + 1, end);
    }

    private static int partition(int[] a, int begin, int end) {
        int pivot = a[end];
        int i = begin;
        for (int j = begin; j < end; ++j) {
            if (a[j] < pivot) {
                if (i == j) {
                    ++i;
                } else {
                    int tmp = a[i];
                    a[i] = a[j];
                    a[j] = tmp;
                    i++;
                }
            }
        }
//        System.out.println(Arrays.toString(a));
        int tmp = a[i];
        a[i] = a[end];
        a[end] = tmp;
        System.out.println("i=" + i);
//        System.out.println(Arrays.toString(a));
        return i;
    }
}


