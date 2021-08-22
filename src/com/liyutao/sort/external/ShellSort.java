package com.liyutao.sort.external;

import java.util.Arrays;

/**
 * @Author liyutao
 * @Date 2021/8/22 16:56
 * @Description 希尔排序，缩减增量排序
 * 希尔排序的运行时间依赖于增量序列的选择：
 *      定理1：使用希尔增量时希尔排序的最坏情形运行时间为O(N²)
 *      定理2：使用Hibbard增量的希尔排序的最坏情形运行时间为O(N的3/2次方)
 *
 */
public class ShellSort {

    public static void main(String[] args) {

        //
        int[] arr = {1,9,2,10,3,11,4,12,5,13,6,14,7,15,8,16};
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void shellSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int h = 1;
        while (h <= arr.length / 3) // Knuth序列
            h = h * 3 + 1;

        for (int gap = h; gap > 0; gap = (gap - 1) / 3) {
            for (int i = gap; i < arr.length; i++) {
                //类似插入排序
                for (int j = i; j >= gap; j -= gap) {
                    if (arr[j] < arr[j - gap]) {
                        swap(arr, j, j - gap);
                    }
                }
            }
        }

    }

    static void swap(int[] arr, int j, int i) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}
