package com.wyh.quicksort;

import java.util.Arrays;

public class Main {

    // 比较Merge Sort和Quick Sort两种排序算法的性能效率
    // 两种排序算法虽然都是O(nlogn)级别的, 但是Quick Sort算法有常数级的优势
    // Quick Sort要比Merge Sort快, 即使我们对Merge Sort进行了优化
    public static void main(String[] args) {

        int N = 10000000;

        // 测试1 一般性测试
        System.out.println("Test for random array, size = " + N + " , random range [0, " + N + "]");

        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("com.wyh.quicksort.MergeSort2", arr1);
        SortTestHelper.testSort("com.wyh.quicksort.quickSort", arr2);

        System.out.println();


        // 测试2 测试近乎有序的数组
        // 但是对于近乎有序的数组, 我们的快速排序算法退化成了O(n^2)级别的算法
        // 思考一下为什么对于近乎有序的数组, 快排退化成了O(n^2)的算法? :)
        int swapTimes = 100;
        assert swapTimes >= 0;

        System.out.println("Test for nearly ordered array, size = " + N + " , swap time = " + swapTimes);

        arr1 = SortTestHelper.generateNearOrderedArray(N, swapTimes);
        arr2 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("com.wyh.quicksort.MergeSort2", arr1);
        SortTestHelper.testSort("com.wyh.quicksort.quickSort", arr2);

        return;
    }
}
