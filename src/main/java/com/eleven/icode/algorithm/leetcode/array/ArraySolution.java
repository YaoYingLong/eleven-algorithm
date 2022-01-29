package com.eleven.icode.algorithm.leetcode.array;

import org.junit.Test;

import java.util.*;

/**
 * @author by Eleven on 2022/1/28
 */
public class ArraySolution {

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public int[] twoSumV2(int[] nums, int target) {
        Map<Integer, Integer> result = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (result.containsKey(target - nums[i])) {
                return new int[]{result.get(target - nums[i]), i};
            } else {
                result.put(nums[i], i);
            }
        }
        return null;
    }

    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int slow = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[slow] = nums[i];
                ++slow;
            }
        }
        return slow;
    }

    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index] = nums[i];
                ++index;
            }
        }
        return index;
    }


    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left <= right) {
            // mid = (left + right) / 2;
            mid = ((right - left) >> 1) + left;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public int maxSubArray(int[] nums) {
        int mid = 0, result = nums[0];
        for (int i = 0; i < nums.length; i++) {
            mid = Math.max(mid + nums[i], nums[i]);
            result = Math.max(result, mid);
        }
        return result;
    }

    public int[] plusOne(int[] digits) {
        int index;
        for (index = digits.length - 1; index >= 0 ; index--) {
            if (digits[index] != 9) {
                break;
            }
        }
        int[] res = new int[digits.length];
        if (index == -1) {
            res = new int[digits.length + 1];
        }
        for (int i = 0; i < digits.length; i++) {
            if (i > index) {
                res[i] = 0;
            }
            if (i == index) {
                res[i] = digits[i] + 1;
            }
            if (i < index){
                res[i] = digits[i];
            }
        }
        if (res[0] == 0) {
            res[0] = 1;
        }
        return res;
    }


    public int[] plusOneV2(int[] digits) {
        int index;
        for (index = digits.length - 1; index >= 0 ; index--) {
            if (digits[index] != 9) {
                ++digits[index];
                for (int j = index + 1; j < digits.length; j++) {
                    digits[j] = 0;
                }
                return digits;
            }
        }
        int[] res = new int[digits.length + 1];
        res[0] = 1;
        return res;
    }

    @Test
    public void test() {
        int[] digits = new int[]{9, 9, 9};
        for (int i : plusOne(digits)) {
            System.out.println(i);
        }
    }
}
