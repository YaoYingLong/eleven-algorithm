package com.eleven.icode.algorithm;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        heapSort(data);
        for (int datum : data) {
            System.out.println(datum);
        }
    }


    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int first = 0; first < len; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            int third = len - 1;
            int target = -nums[first];
            for (int second = first + 1; second < len; second++) {
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                while (second < third && nums[second] + nums[third] > target) {
                    third--;
                }
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> subList = new ArrayList<>();
                    subList.add(nums[first]);
                    subList.add(nums[second]);
                    subList.add(nums[third]);
                    res.add(subList);
                }
            }
        }
        return res;
    }

    public void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int dl = left, dr = right, target = nums[left];
            while (dl < dr) {
                while (dl < dr && nums[dr] > target) {
                    dr--;
                }
                if (dl < dr) {
                    nums[dl++] = nums[dr];
                }
                while (dl < dr && nums[dl] < target) {
                    dl++;
                }
                if (dl < dr) {
                    nums[dr--] = nums[dl];
                }
                nums[dl] = target;
                quickSort(nums, left, dl - 1);
                quickSort(nums, dl + 1, right);
            }
        }
    }

    public void heapSort(int[] nums) {
        int len = nums.length;
        for (int start = (len >> 1) - 1; start >= 0; start--) {
            maxHeap(nums, start, len);
        }
        for (int end = len - 1; end > 0; end--) {
            int temp = nums[end];
            nums[end] = nums[0];
            nums[0] = temp;
            maxHeap(nums, 0, end);
        }
    }

    private void maxHeap(int[] nums, int start, int end) {
        int parent = start;
        int left = (parent << 1) + 1;
        while (left < end) {
            int max = left;
            if (left + 1 < end && nums[left + 1] > nums[max]) {
                max = left + 1;
            }
            if (nums[parent] >= nums[max]) {
                return;
            }
            int temp = nums[max];
            nums[max] = nums[parent];
            nums[parent] = temp;
            parent = max;
            left = (parent << 1) + 1;
        }
    }


    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        for (int start = len / 2 - 1; start > -1; start--) {
            maxHeap(nums, start, len);
        }
        for (int i = len - 1; i > len - k; i--) {
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;
            maxHeap(nums, 0, i);
        }
        return nums[0];
    }
}
