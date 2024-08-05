package com.eleven.icode.algorithm.leetcode;

/**
 * @author by YingLong on 2022/3/28
 */
public class Bit {

    /**
     * 136. 只出现一次的数字
     */
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }

}
