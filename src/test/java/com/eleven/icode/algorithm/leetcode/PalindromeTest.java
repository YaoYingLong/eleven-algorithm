package com.eleven.icode.algorithm.leetcode;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import static org.junit.Assert.assertEquals;

/**
 * @author by YingLong on 2020/6/19
 */
public class PalindromeTest {
    @Test
    public void isPalindromeTest() {
        System.out.println(Palindrome.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(Palindrome.isPalindrome("race a car"));

        assertEquals(Palindrome.isPalindrome(1), true);
        assertEquals(Palindrome.isPalindrome(11), true);
        assertEquals(Palindrome.isPalindrome(12), false);
        assertEquals(Palindrome.isPalindrome(111), true);
        assertEquals(Palindrome.isPalindrome(121), true);
        assertEquals(Palindrome.isPalindrome(1221), true);
        assertEquals(Palindrome.isPalindrome(12221), true);
        assertEquals(Palindrome.isPalindrome(-1), true);
        assertEquals(Palindrome.isPalindrome(-11), true);
        assertEquals(Palindrome.isPalindrome(-12), false);
        assertEquals(Palindrome.isPalindrome(-111), true);
        assertEquals(Palindrome.isPalindrome(-121), true);
        assertEquals(Palindrome.isPalindrome(-1221), true);
        assertEquals(Palindrome.isPalindrome(-12221), true);
    }

    @Test
    public void stackTestV1() {
        Deque<String> stack = new LinkedList<>();
        stack.push("one");
        stack.push("two");
        stack.push("three");
        stack.push("four");
        System.out.println(stack);
        while (stack.size() > 0) {
            String str = stack.pop();
            System.out.println(str);
        }
    }

    @Test
    public void stackTestV2() {
        Stack<String> stack = new Stack<>();
        stack.push("one");
        stack.push("two");
        stack.push("three");
        stack.push("four");
        System.out.println(stack);
        while (stack.size() > 0) {
            String str = stack.pop();
            System.out.println(str);
        }
    }

    @Test
    public void queueTest() {
        Queue<String> stack = new LinkedList<>();
        stack.offer("one");
        stack.offer("two");
        stack.offer("three");
        stack.offer("four");
        System.out.println(stack);
        while (stack.size() > 0) {
            String str = stack.poll();
            System.out.println(str);
        }
    }
}
