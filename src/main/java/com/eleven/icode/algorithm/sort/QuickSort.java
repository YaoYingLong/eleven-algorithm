package com.eleven.icode.algorithm.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by YLongYao on 2016/10/12.
 */
public class QuickSort {

    public void quicksort(Integer[] arr, int left, int right) {
        if (left < right) {
            int dp = partition(arr, left, right);
            quicksort(arr, left, dp - 1);
            quicksort(arr, dp + 1, right);
        }
    }

    public int partition(Integer[] arr, int left, int right) {
        int pivot = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= pivot)
                right--;
            if (left < right)
                arr[left++] = arr[right];
            while (left < right && arr[left] <= pivot)
                left++;
            if (left < right)
                arr[right--] = arr[left];
        }
        arr[left] = pivot;
        return left;
    }

    private void quickSort(Integer[] arr, int left, int right) {
        if (left < right) {
            int dl = left, dr = right, pivot = arr[left];
            while (dl < dr) {
                while (dl < dr && arr[dr] > pivot)
                    dr--;
                if (dl < dr)
                    arr[dl++] = arr[dr];
                while (dl < dr && arr[dl] < pivot)
                    dl++;
                if (dl < dr)
                    arr[dr--] = arr[dl];
            }
            arr[dl] = pivot;
            quickSort(arr, left, dl - 1);
            quickSort(arr, dl + 1, right);
        }
    }

    private void quickSort01(Integer[] arr, int left, int right) {
        if (left < right) {
            int dl = left, dr = right, pivot = arr[left];
            while (dl < dr) {
                while (dl < dr && arr[dr] > pivot)
                    dr--;
                if (dl < dr)
                    arr[dl++] = arr[dr];
                while (dl < dr && arr[dl] < pivot)
                    dl++;
                if (dl < dr)
                    arr[dr--] = arr[dl];
            }
            arr[dl] = pivot;
            quickSort01(arr, left, dl - 1);
            quickSort01(arr, dl + 1, right);
        }
    }

    public void quickSort02(Integer[] arr, int left, int right) {
        if (left < right) {
            int dl = left, dr = right, pivot = arr[left];
            while (dl < dr) {
                while (dl < dr && arr[dr] > pivot) {
                    dr--;
                }
                if (dl < dr) {
                    arr[dl++] = arr[dr];
                }
                while (dl < dr && arr[dl] < pivot) {
                    dl++;
                }
                if (dl < dr) {
                    arr[dr--] = arr[dl];
                }
            }
            arr[dl] = pivot;
            quickSort02(arr, left, dl - 1);
            quickSort02(arr, dl + 1, right);
        }
    }


    @Test
    public void QuickSortTest() {
        Integer[] arr = {8, 6, 4, 9, 74, 25, 1, 3, 5, 28, 35, 0, 22, 2, 7, 10, 26, 29};
        System.err.println("before:" + Arrays.asList(arr));
        quickSort02(arr, 0, arr.length - 1);
        System.err.println(" after:" + Arrays.asList(arr));
    }
}
