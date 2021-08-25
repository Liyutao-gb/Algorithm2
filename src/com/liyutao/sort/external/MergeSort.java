package com.liyutao.sort.external;

import java.util.Arrays;

/**
 * @Author liyutao
 * @Date 2021/8/23 23:46
 * @Description  合并K和有序链表类似
 * 分解 -> 递归 -> 合并
 * 时间复杂度：T(1) = 1
 *      T(N) = 2T(N/2) + N      用N除两边    T(N)/N = T(N/2)/(N/2) + 1
 *  该方程对作为2的幂的任意的N是成立的：
 *      T(N/2)/(N/2) = T(N/4)/(N/4) + 1
 *      ...
 *      T(2)/2 = T(1) + 1
 *   两边同时相加：
 *      T(N)/N = T(1) + logN
 *   时间复杂度：
 *    T(N) = N + NlogN
 *         = O(NlogN)
 * 解法二：蛮力法
 */
public class MergeSort {

    public static void main(String[] args) {

        // 时间复杂度/平均时间复杂度：O(nlogn)
        // 空间复杂度：O(N) 临时表的长度
        // 稳定
        int[] arr = { 9, 6, 11, 3, 5, 12, 8, 7, 10, 15, 14, 4, 1, 13, 2 };
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            sort(arr, left, mid, right);
        }
    }

    public static void sort(int[] arr, int left, int mid, int right) {
        int[] tmp = new int[right - left + 1];

        int l = left;
        int r = mid + 1;
        int k = 0;

        while (l <= mid && r <= right) {
            tmp[k++] = arr[l] <= arr[r] ? arr[l++] : arr[r++];
        }
        while (l <= mid) {
            tmp[k++] = arr[l++];
        }
        while (r <= right) {
            tmp[k++] = arr[r++];
        }
        for (int i = 0; i < tmp.length; i++) {
            arr[left++] = tmp[i];
        }
    }
}
