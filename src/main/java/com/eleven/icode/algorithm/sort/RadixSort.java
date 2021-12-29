package com.eleven.icode.algorithm.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author by YingLong on 2020/9/3
 */
public class RadixSort {

    public void radixSort(Integer[] arr) {
        int max = getMax(arr);
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countSort(arr, exp);
        }
    }

    public void countSort(Integer[] arr, int exp) {
        int[] output = new int[arr.length];
        int[] buckets = new int[10];
        for (int index = 0; index < arr.length; index++) {
            buckets[arr[index] / exp % 10]++;
        }

        for (int index = 1; index < 10; index++) {
            buckets[index] += buckets[index - 1];
        }

        for (int index = arr.length - 1; index >= 0; index--) {
            output[buckets[arr[index] / exp % 10] - 1] = arr[index];
            buckets[arr[index] / exp % 10]--;
        }

        for (int index = 0; index < arr.length; index++) {
            arr[index] = output[index];
        }
    }

    public int getMax(Integer[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    @Test
    public void sortTest() {
        Integer[] arr = {8, 6, 4, 9, 74, 25, 1, 3, 5, 28, 35, 0, 22, 2, 7, 10, 26, 29};
        System.err.println("before:" + Arrays.asList(arr));
        radixSort(arr);
        System.err.println(" after:" + Arrays.asList(arr));
    }
}
