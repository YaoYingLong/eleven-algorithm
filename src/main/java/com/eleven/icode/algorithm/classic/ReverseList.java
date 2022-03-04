package com.eleven.icode.algorithm.classic;

import com.eleven.icode.algorithm.classic.entity.ListNode;

/**
 * @author by YingLong on 2022/2/26
 */
public class ReverseList {

    public static ListNode iterate(ListNode head) {
        ListNode prev = null, curr, next;
        curr = head;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static ListNode recursion(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = recursion(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        // ListNode node = iterate(node1);
        ListNode node_1 = recursion(node1);
        System.out.println(node_1);
    }
}
