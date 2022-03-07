package com.eleven.icode.algorithm.leetcode.linkedlist;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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
     * 92. 反转链表 II
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode newHead = new ListNode(-1), prev = newHead;
        newHead.next = head;
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }
        ListNode curr = prev.next, next = null;
        ListNode tail = prev, revTail = curr;
        for (int i = 0; i <= right - left; i++) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        tail.next = prev;
        revTail.next = next;
        return newHead.next;
    }

    @Test
    public void test() {
        ListNode five = new ListNode(5);
        ListNode fore = new ListNode(4, five);
        ListNode three = new ListNode(3, fore);
        ListNode two = new ListNode(2, three);
        ListNode one = new ListNode(1, two);

        reverseBetween(one, 1, 5);
        System.out.println(1);
    }


    /**
     * 143. 重排链表
     */
    public void reorderList(ListNode head) {
        List<ListNode> nodes = new ArrayList<>();
        ListNode tail = head;
        while (tail != null) {
            nodes.add(tail);
            tail = tail.next;
        }
        int i = 0, j = nodes.size() - 1;
        while (i < j) {
            nodes.get(i++).next = nodes.get(j);
            if (i == j) {
                break;
            }
            nodes.get(j--).next = nodes.get(i);
        }
        nodes.get(i).next = null;
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
