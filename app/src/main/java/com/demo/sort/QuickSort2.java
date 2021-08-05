package com.demo.sort;

import java.util.Arrays;

/**
 * author : Naruto
 * date   : 2020/12/6
 * desc   :
 * version:
 */

class QuickSort2 {

    public static void main(String[] args) {
        int[] array = new int[10];
        for (int i = 0; i < 10; i++) {
            array[i] = (int) (Math.random() * 100);
        }
        quickSort(0, array.length - 1, array);
        System.out.println(Arrays.toString(array));
    }


    private static void quickSort(int begin, int end, int[] array) {
        //1、对要排序的数组进行判断，如果数组只有一个元素，跳出循环
        if (end <= begin) return;

        /**
         * 2、获得轴点元素的位置
         *   利用轴点元素pivot将序列分成2个子序列, 小于轴点数据的放在pivot的左侧，大于轴点数据的放在pivot的右侧。
         *   最后的位置就是轴点元素的位置，返回最后的位置
         *  时间复杂度：O(n)。
         *  解析：这个方法是扫描所有元素，然后将元素和轴点数据进行比较。所以时间复杂度是O(n)。
         */
        int pivotIndex = getPivotIndex(begin, end, array);

        //3、对数组进行切割,并进行排序。小于轴点元素的为一个数组，大于轴点元素的为一个数组。pivot保持在原地。
        //小于pivot的放在左边
        quickSort(begin, pivotIndex - 1, array);//时间复杂度：T(n/2)
        //大于pivot的放在右边
        quickSort(pivotIndex + 1, end, array);//时间复杂度：T(n/2)
    }


    /**
     * desc：获得轴点元素的位置
     * (1)我们选择数组开始位置的数据为轴点数据pivot，并保存轴点数据。也就是 pivotValue = array[begin]
     * (2)对数组元素从右边开始扫描和轴点数据进行比较，
     * 如果数据大于轴点元素，end--数据右移一位，继续进行比较。
     * 如果小于等于轴点元素，将右边的数据移动到左边去。现在换边比较。
     * return 返回轴点元素的位置
     */
    private static int getPivotIndex(int begin, int end, int[] array) {
        //1、我们选择数组开始位置的数据为轴点数据pivot，并保存轴点数据pivotValue。
        //目的：为了让数组的元素和轴点元素数据进行比较。
        int pivotValue = array[begin];
        /**
         * 2、根据数组里的数据和轴点数据的大小关系，如果数据大于轴点元素从右边开始比较。如果小于从左边开始比较。
         * begin记录从左边开始的位置，end记录从右边开始的位置。当begin < end的时候，说明两边还没有相遇比较没有结束，要继续进行比较。
         * 否则也就是begin==end，说明两边的数据比较相遇了，也就是已经比较结束了。此时begin==end，也就是轴点元素的位置。
         */
        //不会有begin大于end的时候，因为我们的begin和end每次只有一个进行增加或减少。
        while (begin < end) {
            //3、从右往左开始进行比较，如果数据大于轴点数据，比较位置往左移动一位，也就是end--。
            //如果数据小于等于轴点数据，将end位置的元素赋值到begin位置。然后begin++，进行换边，从左边开始扫描比较数据。
            while (begin < end) {
                if (array[end] > pivotValue) {
                    //右边元素大于轴点数据，end往左边移动一位， end--
                    end--;
                } else {
                    //数据小于等于轴点数据，将end位置的元素赋值到begin位置。然后begin++，从左边开始扫描比较数据。
                    //注意：此时end位置的数据是无效数据。
                    //问题：为什么选择相等的，将数据切换到另一边呢：为了将数据平均分割，提高效率。如果相等不换边的话，会将数据偏向某一边。
                    array[begin] = array[end];
                    begin++;
                    break;//进行换边比较
                }
            }

            //4、从左往右开始扫描进行比较，如果左边元素小于轴点数据，比较位置往右边移动一位，也就是 begin++;
            //否则，数据大于等于轴点数据，将begin位置的数据赋值到end位置，然后end--。进行换边，从右边开始扫描比较数据。
            while (begin < end) {
                if (array[begin] < pivotValue) {
                    //左边元素小于轴点数据，比较位置往右边移动一位，也就是 begin++;
                    begin++;
                } else {
                    //数据大于等于轴点数据，将begin位置的数据赋值到end位置，然后end--。进行换边，从右边开始扫描比较数据。
                    array[end] = array[begin];
                    end--;
                    break;//进行换边比较
                }
            }

        }
        //5、此时begin==end，也就是比较已经结束。此时begin和end的位置，就是轴点元素的位置。
        //将轴点元素数据放入到轴点位置。
        array[begin] = pivotValue;
        return begin;
    }


}
