package com.eleven.icode.algorithm.leetcode;

import org.checkerframework.checker.units.qual.Length;
import org.junit.Test;

import java.util.*;

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

    @Test
    public void test001() {
        List<String> strings = generateParenthesis(3);
        for (String string : strings) {
            System.out.println(string);
        }
    }

    public int longestValidParentheses(String s) {
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }


    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] <= 0) {
                nums[i] = len + 1;
            }
        }

        for (int i = 0; i < len; i++) {
            int num = Math.abs(nums[i]);
            if (num <= len) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return len + 1;
    }

    Map<Character, Integer> need = new HashMap<>();
    Map<Character, Integer> has = new HashMap<>();
    public String minWindow(String s, String t) {
        for (int i = 0; i < t.length(); i++) {
            need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0) + 1);
        }

        int l = 0, r = -1;
        int ansLen = Integer.MAX_VALUE, ansL = -1, ansR = -1;
        while (r < s.length()) {
            r++;
            if (r < s.length() && need.containsKey(s.charAt(r))) {
                has.put(s.charAt(r), has.getOrDefault(s.charAt(r), 0) + 1);
            }
            while (check() && l <= r) {
                if (r - l + 1 < ansLen) {
                    ansLen = r - l + 1;
                    ansL = l;
                    ansR = l + ansLen;
                }
                if (need.containsKey(s.charAt(l))) {
                    has.put(s.charAt(l), has.getOrDefault(s.charAt(l), 0) - 1);
                }
                l++;
            }
        }
        return ansL == -1 ? "" : s.substring(ansL, ansR);
    }

    private boolean check() {
        for (Character key : need.keySet()) {
            if (has.getOrDefault(key, 0) < need.get(key)) {
                return false;
            }
        }
        return true;
    }

    List<Integer> subList = new ArrayList<>();
    List<List<Integer>> resList = new ArrayList<>();
    /**
     * 78. 子集
     */
    public List<List<Integer>> subsets(int[] nums) {
        subsetsDfs(0, nums);
        return resList;
    }

    public void subsetsDfs(int curr, int[] nums) {
        if (curr == nums.length) {
            resList.add(new ArrayList<>(subList));
            return;
        }
        subList.add(nums[curr]);
        subsetsDfs(curr + 1, nums);
        subList.remove(subList.size() - 1);
        subsetsDfs(curr + 1, nums);
    }

    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            numSet.add(nums[i]);
        }

        int max = 0;
        for (Integer num : numSet) {
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int len = 1;
                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    len++;
                }
                max = Math.max(max, len);
            }
        }
        return max;
    }

    /**
     * 69. x 的平方根
     */
    public int mySqrt(int x) {
        int left = 0, right = x, index = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if ((long) mid * mid <= x) {
                index = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return index;
    }

    public int mySqrtV2(int x) {
        if (x == 0) {
            return 0;
        }
        return (int) sqrts(x, x);
    }

    public double sqrts(double i, int x) {
        double res = (i + x / i) / 2;
        if (res == i) {
            return i;
        } else {
            return sqrts(res, x);
        }
    }
}
