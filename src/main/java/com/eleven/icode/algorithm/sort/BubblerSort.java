package com.eleven.icode.algorithm.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by YLongYao on 2016/10/13.
 */
public class BubblerSort {

    private void bubblerSort(Integer[] arr) {
        boolean flag = true;
        for (int i = 0; i < arr.length && flag; i++) {
            flag = false;
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j - 1] > arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    flag = true;
                }
            }
        }
    }

    private void bubblerSort01(Integer[] arr) {
        boolean flag = true;
        for (int i = 0; i < arr.length && flag; i++) {
            flag = false;
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j - 1] > arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    flag = true;
                }
            }
        }
    }

    @Test
    public void BubblerSortTest() {
        Integer[] arr = {8, 6, 4, 9, 74, 25, 1, 3, 5, 28, 35, 0, 22, 2, 7, 10, 26, 29};
        System.err.println("before:" + Arrays.asList(arr));
        bubblerSort01(arr);
        System.err.println(" after:" + Arrays.asList(arr));
    }

}
