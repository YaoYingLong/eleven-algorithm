package com.eleven.icode.algorithm.leetcode;

import org.junit.Test;

/**
 * @author by YingLong on 2022/3/28
 */
public class SimpleString {
    /**
     * 415. 字符串相加
     */
    public String addStrings(String num1, String num2) {
        int len1 = num1.length() - 1;
        int len2 = num2.length() - 1;
        int k = 0;
        String res = "";
        while (len1 > -1 || len2 > -1) {
            int a = len1 > -1 ? num1.charAt(len1--) - '0' : 0;
            int b = len2 > -1 ? num2.charAt(len2--) - '0' : 0;
            int s = a + b + k;
            k = s > 9 ? 1 : 0;
            res = s % 10 + res;
        }
        return k > 0 ? 1 + res : res;
    }

    @Test
    public void test() {
        System.out.println(lengthOfLastWord("H"));
    }

    /**
     * 58. 最后一个单词的长度
     */
    public int lengthOfLastWord(String paragraph) {
        int len = paragraph.length() - 1;
        int index = len, wordLength = 0;
        while (paragraph.charAt(index) == ' ') {
            index--;
        }
        while (index >= 0 && paragraph.charAt(index) != ' ') {
            wordLength++;
            index--;
        }
        return wordLength;
    }
}
