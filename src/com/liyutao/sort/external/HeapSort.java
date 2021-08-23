package com.liyutao.sort.external;

import java.util.Arrays;

/**
 * @Author liyutao
 * @Date 2021/8/22 23:58
 * @Description https://www.cs.usfca.edu/~galles/visualization/HeapSort.html
 * 升序：构建大顶堆   降序：构建小顶堆
 * 从上到下第一个非叶子节点：N/2 - 1，第一个叶子节点：N/2
 * 定理1：对N个互异项的随机排列进行堆排序所用比较的平均次数为2NlogN - O(NloglogN)
 *
 * 初始化堆的时候，对于每个非叶子结点，都要调用上述函数，将它与它的孩子结点进行比较和交换，顺序是从后向前。
 *   以操作2作为基本操作，对每一层都完全铺满的堆进行分析，
 *      设元素个数为n，则堆的高度k=log（n+1）≈log n，非叶子结点的个数为2^（k-1）-1
 *      假设每个非叶子结点都需要进行调整，则第i层的非叶子结点需要的操作次数为k-i，
 *      第i层共有2^（i-1）个结点，则第i层的所有结点所做的操作为 k*2^（i-1）- i*2^（i-1），
 *      共k-1层非叶子结点，总的操作次数为
 *      i=1...k-1,   k*2^（i-1）- i*2^（i-1），
 *   数学公式求证：
 *     原式 = (k * 2^0 - 1 * 2^0) + (k * 2^1- 2 * 2^1) + (k * 2^2 - 3 * 2^2) + ... + (k * 2^(k-2) - (k-1) * 2^(k-2)
 *         = k * (2^0 + 2^1 + 2^2 + ... + 2^(k-2)) - (1 * 2^0 + 2 * 2^1 + 3 * 2^2 + ... + (k-1) * 2^(k-2))
 *         = k * (2^(k-1) - 1) - (k * 2^(k-1) - 2^k + 1)
 *         = k * 2^(k-1) - k -  k * 2^(k-1) + 2^k - 1
 *         = 2^k - k - 1
 *  化简可得，上式=2^k-k+1，将k=log（n+1）≈log n代入，得n - log n +1，
 *  所以，初始化堆的复杂度为O(n)
 *
 *  调整堆的时间复杂度分析
 *      调整堆的复杂度计算和初始化堆差不多，
 *      假设根节点和排在最后的序号为m的叶子结点交换，并进行调整，那么调整的操作次数 = 原来m结点所在的层数 = 堆的高度（因为m结点在堆的最后）= log m
 *  共n个结点，调整的总操作次数为
 * 化简可得，上式=log (n-1)! ≈ n*log n
 *
 *  所以，调整堆的复杂度为O(n*log n)
 */
public class HeapSort {

    public static void main(String[] args) {

        //设S＝1*2^0+2*2+3*2^2+.+n*2^(n-1)
        //2S=1*2+2*2^2+3*2^3+.+n*2^n
        //二式相减得：S-2S=(2^0+2^1+2^2+...+2^(n-1)-n*2^n=1*(2^n-1)/(2-1)-n*2^n
        //即原式＝S=n*2^n-2^n+1

        //时间复杂度/平均时间复杂度：O(nlogn)
        //空间复杂度：O(1)
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
