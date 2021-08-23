package com.liyutao.sort.external;

import java.util.Arrays;

/**
 * @Author liyutao
 * @Date 2021/8/22 23:58
 * @Description https://www.cs.usfca.edu/~galles/visualization/HeapSort.html
 * 升序：构建大顶堆   降序：构建小顶堆
 * 从上到下第一个非叶子节点：N/2 - 1，第一个叶子节点：N/2
 *
 */
public class HeapSort {

    public static void main(String[] args) {

        //时间复杂度/空间复杂度/平均时间复杂度：O(nlogn)
        // 不稳定
        int[] arr = { 9, 6, 11, 3, 5, 12, 8, 7, 10, 15, 14, 4, 1, 13, 2 };
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void heapSort(int[] arr) {
        //1.构建大顶堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length - 1);
        }

        //2.交换元素
        for (int i = arr.length - 1; i > 0; i--) {
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, i - 1);
        }


    }

    public static void adjustHeap(int[] arr, int start, int end) {
        int temp = arr[start];
        for (int i = 2 * start + 1; i <= end; i = 2 * i + 1) {
            if (i + 1 <= end && arr[i] < arr[i + 1]) {
                i++;
            }
            //一直需要比较的是temp,不符合条件的话就推出循环
            if (arr[i] < temp)
                break;
            arr[start] = arr[i];
            start = i;

        }
        arr[start] = temp;
    }

}
