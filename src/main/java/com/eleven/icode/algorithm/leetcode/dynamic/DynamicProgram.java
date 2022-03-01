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

    @Test
    public void test() {
        int[] prices = new int[]{7, 1, 3, 5, 0, 2, 5};
        System.out.println(maxProfit(prices));
    }
}
