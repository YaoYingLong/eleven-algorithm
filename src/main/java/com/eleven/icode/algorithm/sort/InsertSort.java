package com.eleven.icode.algorithm.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by YLongYao on 2016/10/13.
 */
public class InsertSort {

    private void insertSort(Integer[] arr) {
        int j, k;
        for (int i = 1; i < arr.length; i++) {
            for (j = i - 1; j >= 0; j--) {
                if (arr[i] > arr[j]) {
                    break;
                }
            }
            if (j != i - 1) {
                int temp = arr[i];
                for (k = i - 1; k > j; k--) {
                    arr[k + 1] = arr[k];
                }
                arr[k + 1] = temp;
            }
        }
    }

    private void insertSort01(Integer[] arr) {
        int j, k;
        for (int i = 1; i < arr.length; i++) {
            for (j = i - 1; j >= 0; j--) {
                if (arr[j] < arr[i]) {
                    break;
                }
            }
            if (j != i - 1) {
                int temp = arr[i];
                for (k = i - 1; k > j; k--) {
                    arr[k + 1] = arr[k];
                }
                arr[k + 1] = temp;
            }
        }
    }

    @Test
    public void InsertSortTest() {
        Integer[] arr = {8, 6, 4, 9, 74, 25, 1, 3, 5, 28, 35, 0, 22, 2, 7, 10, 26, 29};
        System.err.println("before:" + Arrays.asList(arr));
        insertSort(arr);
        System.err.println(" after:" + Arrays.asList(arr));
    }

}
