package com.eleven.icode.algorithm.leetcode.pointer;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author by Eleven on 2022/3/4
 */
public class PointerList {

    /**
     * 3. 无重复字符的最长子串
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int maxLen = 0, rightIndex = -1;
        Set<Character> window = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (i != 0) {
                window.remove(s.charAt(i - 1));
            }
            while (rightIndex + 1 < s.length() && !window.contains(s.charAt(rightIndex + 1))) {
                window.add(s.charAt(rightIndex + 1));
                rightIndex++;
            }
            maxLen = Math.max(rightIndex - i + 1, maxLen);
        }
        return maxLen;
    }

    @Test
    public void tet() {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

}
