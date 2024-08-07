package com.eleven.icode.algorithm.leetcode;

import com.sun.media.sound.RIFFInvalidDataException;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.zip.Inflater;

/**
 * @author by YingLong on 2024/8/7
 */
public class StringTest {

    public int maxRepeating(String sequence, String word) {
        int m = sequence.length();
        int n = word.length();
        if (m < n) {
            return 0;
        }
        int[] count = new int[m];
        int max = 0;
        for (int i = n - 1; i < m; i++) {
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if (sequence.charAt(i - n + j + 1) != word.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            count[i] = !flag ? 0 : count[Math.max(i - n, 0)] + 1;
            max = Math.max(max, count[i]);
        }
        return max;
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Set<Character> set = new HashSet<>();
        int max = 1;
        int k = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i != 0) {
                set.remove(s.charAt(i - 1));
            }
            while (k < s.length() && !set.contains(s.charAt(k))) {
                set.add(s.charAt(k));
                k++;
            }
            max = Math.max(max, k - i);
        }
        return max;
    }

    public int lengthOfLongestSubstring2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Set<Character> set = new HashSet<>();
        int max = 1;
        int k = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            while (set.contains(ch)) {
                set.remove(s.charAt(k));
                k++;
            }
            set.add(s.charAt(i));
            max = Math.max(max, i - k + 1);
        }
        return max;
    }

    @Test
    public void test() {
        System.out.println(lengthOfLongestSubstring("dvdf"));
    }

}
