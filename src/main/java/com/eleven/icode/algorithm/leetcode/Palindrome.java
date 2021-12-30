package com.eleven.icode.algorithm.leetcode;

/**
 * @author by YingLong on 2020/7/27
 */
public class Palindrome {
    public static boolean isPalindrome(String s) {
        String pure = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int len = pure.length() - 1;
        for (int i = 0; i < len; i++) {
            if (pure.charAt(i) != pure.charAt(len - i)) {
                return false;
            }
            if (i >= len - i) {
                break;
            }
        }
        return true;
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        long result = 0;
        int innerX = x;
        while (innerX != 0) {
            int remainder = innerX % 10;
            innerX /= 10;
            result = result * 10 + remainder;
        }

        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return false;
        }
        return (int) result == x;
    }

    public static boolean isPalindromeV2(String s) {
        StringBuffer sgood = new StringBuffer();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                sgood.append(Character.toLowerCase(ch));
            }
        }
        StringBuffer sgood_rev = new StringBuffer(sgood).reverse();
        return sgood.toString().equals(sgood_rev.toString());
    }
}
