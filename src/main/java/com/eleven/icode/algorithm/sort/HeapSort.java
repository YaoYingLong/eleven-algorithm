package com.eleven.icode.algorithm.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author by YingLong on 2020/9/3
 */
public class HeapSort {

    public void heapSortAsc(Integer[] arr, int n) {
        for (int start = n / 2 - 1; start >= 0; start--) {
            maxHeapDown(arr, start, n - 1);
        }

        for (int index = n - 1; index > 0; index--) {
            int temp = arr[0];
            arr[0] = arr[index];
            arr[index] = temp;
            maxHeapDown(arr, 0, index - 1);
        }
    }

    public void maxHeapDown(Integer[] arr, int start, int end) {
        int left = 2 * start + 1;
        int tmp = arr[start];
        for (; left <= end; start = left, left = 2 * left + 1) {
            if (left < end && arr[left] < arr[left + 1]) {
                left++;
            }
            if (tmp >= arr[left]) {
                break;
            }
            arr[start] = arr[left];
            arr[left] = tmp;
        }
    }

    public void heapSortDesc(Integer[] arr, int n) {
        for (int start = n / 2 - 1; start >= 0; start--) {
            minHeapDown(arr, start, n - 1);
        }

        for (int index = n - 1; index > 0; index--) {
            int tmp = arr[0];
            arr[0] = arr[index];
            arr[index] = tmp;
            minHeapDown(arr, 0, index - 1);
        }
    }

    public void minHeapDown(Integer[] arr, int start, int end) {
        int left = 2 * start + 1;
        int tmp = arr[start];
        for (; left <= end; start = left, left = 2 * left + 1) {
            if (left < end && arr[left] > arr[left + 1]) {
                left++;
            }
            if (tmp <= arr[left]) {
                break;
            }
            arr[start] = arr[left];
            arr[left] = tmp;
        }
    }

    @Test
    public void InsertSortTest() {
        {
            Integer[] arr = {8, 6, 4, 9, 74, 25, 1, 3, 5, 28, 35, 0, 22, 2, 7, 10, 26, 29};
            System.err.println("before:" + Arrays.asList(arr));
            heapSortAsc(arr, arr.length);
            System.err.println(" after:" + Arrays.asList(arr));
        }
        {
            Integer[] arr = {8, 6, 4, 9, 74, 25, 1, 3, 5, 28, 35, 0, 22, 2, 7, 10, 26, 29};
            System.err.println("before:" + Arrays.asList(arr));
            heapSortDesc(arr, arr.length);
            System.err.println(" after:" + Arrays.asList(arr));
        }
    }
}
