package com.eleven.icode.algorithm.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author by YingLong on 2020/9/3
 */
public class CountingSort {

    public void countingSort(Integer[] arr) {
        int max = arr[0];
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        int[] countArray = new int[max + 1];
        for (int i = 0; i < arr.length; i++) {
            countArray[arr[i] - min]++;
        }

        int sum = 0;
        for (int i = 0; i < countArray.length; i++) {
            sum += countArray[i];
            countArray[i] = sum;
        }

        int[] sortedArray = new int[arr.length];
        for (int i = arr.length - 1; i > 0; i--) {
            sortedArray[countArray[arr[i] - min] - 1] = arr[i];
            countArray[arr[i] - min]--;
        }
    }

    @Test
    public void sortTest() {
        Integer[] arr = {8, 6, 4, 9, 74, 25, 1, 3, 5, 28, 35, 0, 22, 2, 7, 10, 26, 29};
        System.err.println("before:" + Arrays.asList(arr));
        countingSort(arr);
        System.err.println(" after:" + Arrays.asList(arr));
    }
}
