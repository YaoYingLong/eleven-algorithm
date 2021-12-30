package com.eleven.icode.algorithm.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author by YingLong on 2020/7/27
 */
public class SubsequenceTest {

    @Test
    public void isSubsequenceTest() {
        {
            String s = "abc", t = "ahbgdc";
            assertTrue(Subsequence.isSubsequence(s, t));
        }
        {
            String s = "aabc", t = "aahbgdc";
            assertTrue(Subsequence.isSubsequence(s, t));
        }
        {
            String s = "axc", t = "ahbgdc";
            assertFalse(Subsequence.isSubsequence(s, t));
        }
        System.out.println("MAX_VALUE:" + Integer.MAX_VALUE);
        System.out.println("MIN_VALUE:" + Integer.MIN_VALUE);
        System.out.println("110:" + Integer.valueOf("110", 2));
    }

}
