package com.eleven.icode.algorithm.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author by YingLong on 2020/9/2
 */
public class MergeSort {

    public void mergeSortUp2Down(Integer[] arr, int start, int end) {
        if (arr == null || start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSortUp2Down(arr, start, mid);
        mergeSortUp2Down(arr, mid + 1, end);
        merge(arr, start, mid, end);
    }

    public void mergeSortDown2Up(Integer[] arr, int len) {
        if (arr == null || len < 0) {
            return;
        }
        for (int n = 1; n < len; n *= 2) {
            mergeGroups(arr, len, n);
        }
    }

    void mergeGroups(Integer[] arr, int len, int gap) {
        int i;
        for (i = 0; i + 2 * gap - 1 < len; i += 2 * gap) {
            merge(arr, i, i + gap - 1, i + 2 * gap - 1);
        }
        if (i + gap - 1 < len - 1) {
            merge(arr, i, i + gap - 1, len - 1);
        }
    }

    public void merge(Integer[] arr, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int i = start;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= end) {
            temp[k++] = arr[j++];
        }
        for (i = 0; i < k; i++) {
            arr[start + i] = temp[i];
        }
    }

    @Test
    public void sortTest01() {
        Integer[] arr = {8, 6, 4, 9, 74, 25, 1, 3, 5, 28, 35, 0, 22, 2, 7, 10, 26, 29};
        System.err.println("before:" + Arrays.asList(arr));
        mergeSortUp2Down(arr, 0, arr.length - 1);
        System.err.println(" after:" + Arrays.asList(arr));
    }

    @Test
    public void sortTest02() {
        Integer[] arr = {8, 6, 4, 9, 74, 25, 1, 3, 5, 28, 35, 0, 22, 2, 7, 10, 26, 29};
        System.err.println("before:" + Arrays.asList(arr));
        mergeSortDown2Up(arr, arr.length);
        System.err.println(" after:" + Arrays.asList(arr));
    }

}
