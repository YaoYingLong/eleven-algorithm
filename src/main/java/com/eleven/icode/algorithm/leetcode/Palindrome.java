package com.eleven.icode.algorithm.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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

    /**
     * 5. 最长回文子串
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        int start = 0, end = 1;
        for (int i = 0; i < s.length(); i++) {
            int len1 = isPalindrome(s, i, i);   // 中心是一个字符，如abcdcba
            int len2 = isPalindrome(s, i, i + 1); // 中心是两个字符，如abcddcba
            int len = Math.max(len1, len2);
            if (len > end - start + 1) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }


    public int isPalindrome(String s, int start, int end) {
        while (start > -1 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        return end - start - 1;
    }

    @Test
    public void test() {
        String s = "babad";
        System.out.println(longestPalindrome(s));
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(res, new StringBuilder(), 0, 0, n);
        return res;
    }

    public void backtrack(List<String> res, StringBuilder sb, int open, int close, int max) {
        if (sb.length() == max * 2) {
            res.add(sb.toString());
            return;
        }
        if (open < max) {
            sb.append("(");
            backtrack(res, sb, open + 1, close, max);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (close < open) {
            sb.append(")");
            backtrack(res, sb, open, close + 1, max);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}
