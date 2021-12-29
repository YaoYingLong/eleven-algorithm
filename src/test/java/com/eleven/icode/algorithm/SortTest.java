package com.eleven.icode.algorithm;

import org.junit.Test;

/**
 * @author by Eleven on 2021/12/29
 */
public class SortTest {

    @Test
    public void insertSortTest001() {
        int[] data = new int[]{9, 8, 7, 0, 1, 3, 2};
        for (int i = 1; i < data.length; i++) {
            int target = data[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (data[j] > target) {
                    break;
                }
                data[j + 1] = data[j];
            }
            data[j + 1] = target;
        }
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    @Test
    public void shellSortTest001() {
        int[] data = new int[]{9, 8, 7, 0, 1, 3, 2};
        for (int step = data.length / 2; step >= 1; step /= 2) {
            for (int i = step; i < data.length; i++) {
                int target = data[i];
                int j = i - step;
                for (; j >= 0; j -= step) {
                    if (data[j] > target) {
                        break;
                    }
                    data[j + step] = data[j];
                }
                data[j + step] = target;
            }
        }
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    @Test
    public void bulleSortTest001() {
        int[] data = new int[]{9, 8, 7, 0, 1, 3, 2};
        for (int i = 0; i < data.length; i++) {
            for (int j = data.length - 1; j > i; j--) {
                if (data[i] < data[j]) {
                    data[i] = data[j] + data[i];
                    data[j] = data[i] - data[j];
                    data[i] = data[i] - data[j];
                }
            }
        }
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    @Test
    public void bulleSortTest002() {
        int[] data = new int[]{9, 8, 7, 0, 1, 3, 2};
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length - i - 1; j++) {
                if (data[j] < data[j + 1]) {
                    data[j + 1] = data[j] + data[j + 1];
                    data[j] = data[j + 1] - data[j];
                    data[j + 1] = data[j + 1] - data[j];
                }
            }
        }
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    @Test
    public void quickSortTest002() {
        int[] data = new int[]{9, 8, 7, 0, 1, 3, 2};
    }
}
