package com.eleven.icode.algorithm.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author by YingLong on 2020/9/3
 */
public class BucketSort {

    public void bucketSort(Integer[] arr, int n, int max) {
        int[] buckets = new int[max];
        for (int index = 0; index < n; index++) {
            buckets[arr[index]]++;
        }
        for (int bucketIndex = 0, arrIndex = 0; bucketIndex < max; bucketIndex++) {
            while (buckets[bucketIndex]-- > 0) {
                arr[arrIndex++] = bucketIndex;
            }
        }
    }

    @Test
    public void sortTest() {
        Integer[] arr = {8, 6, 4, 9, 74, 25, 1, 3, 5, 28, 35, 0, 22, 2, 7, 10, 26, 29};
        System.err.println("before:" + Arrays.asList(arr));
        bucketSort(arr, arr.length, 75);
        System.err.println(" after:" + Arrays.asList(arr));
    }

}
