package com.eleven.icode.algorithm.leetcode.array;

import com.eleven.icode.algorithm.leetcode.entity.ListNode;
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
        for (index = digits.length - 1; index >= 0; index--) {
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
            if (i < index) {
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
        for (index = digits.length - 1; index >= 0; index--) {
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

    /**
     * 2006. 差的绝对值为 K 的数对数目
     */
    public int countKDifference(int[] nums, int k) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (Math.abs(nums[i] - nums[j]) == k) {
                    res++;
                }
            }
        }
        return res;
    }

    public int countKDifferenceV2(int[] nums, int k) {
        int res = 0;
        Map<Integer, Integer> midMap = new HashMap<>();
        for (int num : nums) {
            res += midMap.getOrDefault(num - k, 0) + midMap.getOrDefault(num + k, 0);
            midMap.put(num, midMap.getOrDefault(num, 0) + 1);
        }
        return res;
    }

    /**
     * 13. 罗马数字转整数
     */
    public int romanToInt(String s) {
        Map<Character, Integer> charMap = new HashMap<>();
        charMap.put('I', 1);
        charMap.put('V', 5);
        charMap.put('X', 10);
        charMap.put('L', 50);
        charMap.put('C', 100);
        charMap.put('D', 500);
        charMap.put('M', 1000);
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            int current = charMap.get(s.charAt(i));
            if (i + 1 < s.length() && current < charMap.get(s.charAt(i + 1))) {
                res -= current;
            } else {
                res += current;
            }
        }
        return res;
    }

    public int romanToIntV2(String s) {
        Integer before = null, current = null;
        int res = 0;
        for (int i = s.length() - 1; i > -1; i--) {
            before = current;
            switch (s.charAt(i)) {
                case 'I':
                    current = 1;
                    break;
                case 'V':
                    current = 5;
                    break;
                case 'X':
                    current = 10;
                    break;
                case 'L':
                    current = 50;
                    break;
                case 'C':
                    current = 100;
                    break;
                case 'D':
                    current = 500;
                    break;
                case 'M':
                    current = 1000;
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + s.charAt(i));
            }
            if (before == null) {
                res += current;
            } else if (current.equals(1) && (before.equals(5) || before.equals(10))) {
                res -= current;
            } else if (current.equals(10) && (before.equals(50) || before.equals(100))) {
                res -= current;
            } else if (current.equals(100) && (before.equals(500) || before.equals(1000))) {
                res -= current;
            } else {
                res += current;
            }
        }
        return res;
    }

    /**
     * 1447. 最简分数
     */
    public List<String> simplifiedFractions(int n) {
        List<String> res = new ArrayList<>();
        for (int k = 2; k <= n; k++) {
            for (int i = 1; i < k; i++) {
                int maxDivisor = 1;
                for (int j = i; j >= 1; j--) {
                    if (i % j == 0 && k % j == 0) {
                        maxDivisor = j;
                        break;
                    }
                }
                String target = i / maxDivisor + "/" + k / maxDivisor;
                if (!res.contains(target)) {
                    res.add(target);
                }
            }
        }
        return res;
    }

    public List<String> simplifiedFractionsV2(int n) {
        List<String> ans = new ArrayList<>();
        for (int denominator = 2; denominator <= n; ++denominator) {
            for (int numerator = 1; numerator < denominator; ++numerator) {
                if (gcd(numerator, denominator) == 1) {
                    ans.add(numerator + "/" + denominator);
                }
            }
        }
        return ans;
    }

    public int gcd(int a, int b) {
        return b != 0 ? gcd(b, a % b) : a;
    }

    /**
     * 14. 最长公共前缀
     */
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs[0].length(); i++) {
            char tmp = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() - 1 < i || tmp != strs[j].charAt(i)) {
                    return sb.toString();
                }
            }
            sb.append(tmp);
        }
        return sb.toString();
    }

    public String longestCommonPrefixV2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        int count = strs.length;
        for (int i = 1; i < count; i++) {
            prefix = longestCommonPrefix(prefix, strs[i]);
            if (prefix.length() == 0) {
                break;
            }
        }
        return prefix;
    }

    public String longestCommonPrefix(String str1, String str2) {
        int length = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < length && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        return str1.substring(0, index);
    }

    public String longestCommonPrefixV3(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int length = strs[0].length();
        int count = strs.length;
        for (int i = 0; i < length; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < count; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    public String longestCommonPrefixV4(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        } else {
            return longestCommonPrefix(strs, 0, strs.length - 1);
        }
    }

    public String longestCommonPrefix(String[] strs, int start, int end) {
        if (start == end) {
            return strs[start];
        } else {
            int mid = (end - start) / 2 + start;
            String lcpLeft = longestCommonPrefix(strs, start, mid);
            String lcpRight = longestCommonPrefix(strs, mid + 1, end);
            return commonPrefix(lcpLeft, lcpRight);
        }
    }

    public String commonPrefix(String lcpLeft, String lcpRight) {
        int minLength = Math.min(lcpLeft.length(), lcpRight.length());
        for (int i = 0; i < minLength; i++) {
            if (lcpLeft.charAt(i) != lcpRight.charAt(i)) {
                return lcpLeft.substring(0, i);
            }
        }
        return lcpLeft.substring(0, minLength);
    }

    /**
     * 20. 有效的括号
     */
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.keySet().contains(s.charAt(i))) {
                stack.push(s.charAt(i));
            }
            if (map.values().contains(s.charAt(i))) {
                if (stack.isEmpty() || !map.get(stack.pop()).equals(s.charAt(i))) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    /**
     * 21. 合并两个有序链表
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(-1);
        ListNode res = head;
        while (list1 != null || list2 != null) {
            if (list2 == null || !(list1 == null || list1.val > list2.val)) {
                res.next = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                res.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            res = res.next;
        }
        return head.next;
    }

    @Test
    public void test() {
        System.out.println(gcd(2, 3));
    }
}
