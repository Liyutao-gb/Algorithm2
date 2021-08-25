package com.liyutao.sort.external;

import java.util.Arrays;

/**
 * @Author liyutao
 * @Date 2021/8/26 0:24
 * @Description
 * 技术排序，使用场景：高考成绩统计排序
 */
public class CountSort {


    public static void main(String[] args) {

        int[] arr = new int[] { 2, 5, 4, 1, 4, 9, 8, 5, 6, 0, 4, 0, 2, 2 };
        System.out.println("arr :" + Arrays.toString(arr));

        int[] result = new int[arr.length];
        int[] count = new int[10];

        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }

        for (int i = 1; i < count.length; i++) {
            count[i] = count[i] + count[i - 1];
        }

        for (int i = result.length - 1; i >= 0; i--) {
            result[--count[arr[i]]] = arr[i];

        }

        System.out.println(Arrays.toString(result));
    }


}
