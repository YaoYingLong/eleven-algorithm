package com.eleven.icode.algorithm.leetcode;

/**
 * @author by YingLong on 2020/7/27
 */
public class Subsequence {

    public static boolean isSubsequence(String s, String t) {
        if (s == null || s.length() < 1) {
            return true;
        }
        int beginIndex = t.indexOf(s.charAt(0));
        if (beginIndex == -1) {
            return false;
        }
        int fromIndex = beginIndex + 1;
        for (int i = 1; i < s.length(); i++) {
            int index = t.indexOf(s.charAt(i), fromIndex);
            if (index == -1) {
                return false;
            }
            fromIndex = index + 1;
        }
        return true;
    }
}
