package com.eleven.icode.algorithm.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author by YingLong on 2020/9/2
 */
public class ShellSort {

    public void shellSort(Integer[] arr) {
        int i, j, gap;
        for (gap = arr.length / 2; gap > 0; gap /= 2) {
            for (i = 0; i < gap; i++) {
                for (j = i + gap; j < arr.length; j += gap) {
                    if (arr[j] < arr[j - gap]) {
                        int temp = arr[j];
                        int k = j - gap;
                        while (k >= 0 && arr[k] > temp) {
                            arr[k + gap] = arr[k];
                            k -= gap;
                        }
                        arr[k + gap] = temp;
                    }
                }
            }
        }
    }

    @Test
    public void sortTest() {
        Integer[] arr = {8, 6, 4, 9, 74, 25, 1, 3, 5, 28, 35, 0, 22, 2, 7, 10, 26, 29};
        System.err.println("before:" + Arrays.asList(arr));
        shellSort(arr);
        System.err.println(" after:" + Arrays.asList(arr));
    }

    @Test
    public void sortTestV2() {
        Integer[] arr = {29, 28, 27, 26, 25, 24, 23, 21, 20, 19, 18, 17, 16, 15, 14, 13, 12, 11};
        System.err.println("before:" + Arrays.asList(arr));
        shellSort(arr);
        System.err.println(" after:" + Arrays.asList(arr));
    }
}
