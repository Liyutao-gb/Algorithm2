package com.liyutao.sort.external;

import java.util.Arrays;

/**
 * @Author liyutao
 * @Date 2021/8/24 22:23
 * @Description
 * 快速排序可以用来找第 K 大的数字，枢纽元素的下标如果等于 K 的话，那么第 K 大的元素就是 arr[k]
 *
 */
public class QuickSort {

    public static void main(String[] args) {

        //时间复杂度/平均时间复杂度：O(nlogn)
        //最坏时间复杂度：O(N²)
        //空间复杂度：logN
        // 不稳定
        int[] arr = { 9, 6, 11, 3, 5, 12, 8, 7, 10, 15, 14, 4, 1, 13, 2 };
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int index = sort(arr, left, right);
            quickSort(arr, left, index - 1);
            quickSort(arr, index + 1, right);
        }
    }

    public static int sort(int[] arr, int left, int right) {
        int tmp = arr[left];

        while (left < right) {
            while (left < right && arr[right] >= tmp) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= tmp) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = tmp;
        return left;
    }
}
