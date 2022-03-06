package com.eleven.icode.algorithm.leetcode.dynamic;

import org.junit.Test;

/**
 * @author by Eleven on 2022/2/15
 */
public class DynamicProgram {

    /**
     * 121. 买卖股票的最佳时机
     */
    public int maxProfit(int[] prices) {
        int res = 0;
        int index = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i - 1] < prices[index]) {
                index = i - 1;
                res = Math.max(prices[i] - prices[i - 1], res);
            } else {
                res = Math.max(prices[i] - prices[index], res);
            }
        }
        return res;
    }

    /**
     * 42. 接雨水
     */
    public int trap(int[] height) {
        int left = 0, right = height.length - 1, res = 0;
        for (int leftIndex = 1, rightIndex = height.length - 2; leftIndex < height.length && rightIndex > -1; leftIndex++, rightIndex--) {
            if (height[left] <= height[leftIndex]) {
                for (int k = left + 1; k < leftIndex; k++) {
                    res += height[left] - height[k];
                }
                left = leftIndex;
            }
            if (height[right] < height[rightIndex]) {
                for (int k = right - 1; k > rightIndex; k--) {
                    res += height[right] - height[k];
                }
                right = rightIndex;
            }
        }
        return res;
    }


    public int trap2(int[] height) {
        int len = height.length;
        if (len == 0) {
            return 0;
        }

        int[] leftMax = new int[len];
        leftMax[0] = height[0];
        int[] rightMax = new int[len];
        rightMax[len - 1] = height[len - 1];
        for (int left = 1, right = len - 2; left < len || right > -1; left++, right--) {
            leftMax[left] = Math.max(leftMax[left - 1], height[left]);
            rightMax[right] = Math.max(rightMax[right + 1], height[right]);
        }

        int res = 0;
        for (int i = 0; i < len; i++) {
            res += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return res;
    }

    public int trap3(int[] height) {
        int len = height.length;
        if (len == 0) {
            return 0;
        }

        int res = 0;
        int leftMax = 0, rightMax = 0;
        int left = 0, right = len - 1;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (height[left] < height[right]) {
                res += leftMax - height[left];
                left++;
            } else {
                res += rightMax - height[right];
                right--;
            }
        }
        return res;
    }

    @Test
    public void test() {
        int[] prices = new int[]{7, 1, 3, 5, 0, 2, 5};
        int[] prices2 = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap3(prices2));
    }
}
