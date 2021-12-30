package com.eleven.icode.algorithm.leetcode;

/**
 * @author by YingLong on 2020/7/27
 */
public class ReverseInt32 {

    public static int reverse(int innerX) {
        long result = 0;
        while (innerX != 0) {
            int remainder = innerX % 10;
            innerX /= 10;
            result = result * 10 + remainder;
        }
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) result;
    }

}
