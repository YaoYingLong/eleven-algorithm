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
     * 122. 买卖股票的最佳时机 II
     */
    public int maxProfit2(int[] prices) {
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            res += Math.max(0, prices[i] - prices[i - 1]);
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
        int[] prices2 = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap3(prices2));
    }

    /**
     * 72. 编辑距离
     * 给你两个单词word1 和word2， 请返回将word1转换成word2 所使用的最少操作数。
     * <p>
     * 你可以对一个单词进行如下三种操作：
     * - 插入一个字符
     * - 删除一个字符
     * - 替换一个字符
     */
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        if (m * n == 0) {
            return m + n;
        }
        int[][] res = new int[m + 1][n + 1];
        for (int i = 0; i < m + 1; i++) {
            res[i][0] = i;
        }
        for (int i = 0; i < n + 1; i++) {
            res[0][i] = i;
        }
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                int left = res[i - 1][j] + 1;
                int down = res[i][j - 1] + 1;
                int left_down = res[i - 1][j - 1];
                if (word2.charAt(i - 1) != word1.charAt(j - 1)) {
                    left_down += 1;
                }
                res[i][j] = Math.min(left_down, Math.min(left, down));
            }
        }
        return res[m][n];
    }

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 0; i <= amount; i++) {
            dp[i] = amount + 1;
        }
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    /**
     * 45. 跳跃游戏 II
     */
    public int jump(int[] nums) {
        int len = nums.length - 1;
        int steps = 0;
        int maxPosition = 0, end = 0;
        for (int i = 0; i < len; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }

    /**
     * 55. 跳跃游戏
     */
    public boolean canJump(int[] nums) {
        int len = nums.length - 1;
        int max = 0;
        for (int i = 0; i <= len; i++) {
            max = Math.max(max, i + nums[i]);
            if (i == max && i < len) {
                return false;
            }
        }
        return max >= len;
    }
}
