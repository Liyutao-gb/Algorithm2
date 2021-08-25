package com.liyutao.sort.external;

import java.util.Arrays;

/**
 * @Author liyutao
 * @Date 2021/8/24 22:23
 * @Description
 * 快速排序可以用来找第 K 大的数字，枢纽元素的下标如果等于 K 的话，那么第 K 大的元素就是 arr[k]
 *
 * 枢纽元素选择第一个或者最后一个，对于正序或反序的数组，所有的元素不是在S1中就是在S2中，这种情况毫无例外地发生在所有的递归调用中。
 * 一种错误的做法：选择第一个或者最后一个最为枢纽元素
 * 一种安全的做法：随机选取枢纽元素。
 * 三数中值分割法：一组N个数的中值是第N/2个最大的数。但是很难算出并明显减慢快速排序的速度。
 *      但可以通过随机选取三个元素并使用他们的中值作为枢纽元而得到。一般采用左端、中间、右端位置上的三个元素的中值作为枢纽元素。
 *
 * 时间复杂度：两个递归调用的运行时间加上花费在分割上的线性时间(枢纽元的选取仅花费常数的时间)
 *      最坏情况：T(N) = T(N+1) + cN，N > 1
 *              T(N-1) = T(N-2) + c(N-1)
 *              ...
 *              T(2) = T(1) + c(2)
 *         两边相加 T(N) = T(1) + ci(i=2...N) = O(N²)
 *      最好情况：T(N) = 2T(N/2) + cN  两边同时除以N
 *              T(N)/N = T(N/2)/(N/2) + c
 *              ...
 *              T(N)/N = T(1) + clogN
 *         T(N) = cNlogN + N = O(NlogN)  分析和归并排序完全相同
 *  空间复杂度：O(logN)
 *
 *  决策树：证明下界的抽象概念。
 *
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
