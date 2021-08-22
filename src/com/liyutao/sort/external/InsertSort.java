package com.liyutao.sort.external;

import java.util.Arrays;

/**
 * @Author liyutao
 * @Date 2021/8/22 14:21
 * @Description https://www.cs.usfca.edu/~galles/visualization/Algorithms.html
 * 假设不存在重复元素,可设输入数据是前N个整数的某个排列(只有相对顺序才是最重要的)并设所有的排列都是等可能的。
 * 在这些假设下，有如下定理：
 *  定理1: N个互异数的数组的平均逆序数是N(N-1)/4
 *      证明：正序表列逆序对 + 逆序表列逆序对 = 总逆序对 = N * (N - 1) / 2
 *  定理2: 通过交换相邻元素进行排序的任何算法平均都需要O(N²)
 *      证明：初始的平均逆序对是O(N²)，而每次交换只减少一个逆序，因此需要O(N²)次交换
 */
public class InsertSort {

    public static void main(String[] args) {

        // 插入排序, 冒泡排序, 选择排序
        // 最好时间复杂度O(N); 最坏时间复杂度O(N²),平均时间复杂度O(N²)
        // 时间复杂度(I + N) I:是逆序对的个数   如果有O(N)个逆序对   是时间复杂度O(N²)
        // 空间复杂度O(1)
        // 稳定   (选择排序不稳定)
        // 用于已经基本排好序的数组,一般不适用于数据量很大的情况

        int[] arr = {34, 8, 64, 51, 32, 21}; // 9个逆序对
        //insertSort(arr);
        //bubbleSort(arr);
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void insertSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }

        int count = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j] < arr[j - 1]; j--) {
                swap(arr, j, j - 1);
                count++;
            }
        }
        System.out.println("数组中的逆序对有：" + count + " 对");

    }

    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }

        boolean flag = true;
        for (int i = arr.length - 1; i > 0 && flag; i--) {
            flag = false;
            for (int j = 0; j < i ; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    flag = true;
                }
            }
        }
    }

    public static void selectSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }

        for (int i = arr.length - 1; i > 0; i--) {
            int maxPos = i;
            for (int j = 0; j < i; j++) {
                maxPos = arr[maxPos] < arr[j] ? j : maxPos;
            }
            swap(arr, maxPos, i);
        }

    }

    static void swap(int[] arr, int j, int i) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

}
