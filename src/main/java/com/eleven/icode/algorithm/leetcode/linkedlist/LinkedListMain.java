package com.eleven.icode.algorithm.leetcode.linkedlist;

/**
 * @author by Eleven on 2022/3/4
 */
public class LinkedListMain {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(), tail = head;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int val = n1 + n2 + carry;
            carry = val / 10;
            tail.next = new ListNode(val % 10);
            tail = tail.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head.next;
    }

    /**
     * 剑指 Offer 24. 反转链表
     */
    public ListNode reverseList(ListNode head) {
        ListNode tail = head, prev = null, next;
        while (tail != null) {
            next = tail.next;
            tail.next = prev;
            prev = tail;
            tail = next;
        }
        return prev;
    }
}
