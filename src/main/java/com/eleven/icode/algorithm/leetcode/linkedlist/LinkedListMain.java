package com.eleven.icode.algorithm.leetcode.linkedlist;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.CRC32;

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

    /**
     * 19. 删除链表的倒数第 N 个结点
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int nth = removeNthFromEndDfs(head, head.next, n);
        return nth > 1 ? head.next : head;
    }

    public int removeNthFromEndDfs(ListNode before, ListNode curr, int n) {
        if (curr == null) {
            return n + 1;
        }
        int nth = removeNthFromEndDfs(curr, curr.next, n) - 1;
        if (nth == 1) {
            before.next = curr.next;
        }
        return nth;
    }

    public ListNode removeNthFromEndV2(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode first = head;
        ListNode second = dummy;
        for (int i = 0; i < n; ++i) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        ListNode ans = dummy.next;
        return ans;
    }

    /**
     * 141. 环形链表
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head, fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    /**
     * 160. 相交链表
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

    /**
     * 24. 两两交换链表中的节点
     */
    public ListNode swapPairs(ListNode head) {
        ListNode preHead = new ListNode(-1), curr = preHead;
        preHead.next = head;
        while (curr.next != null && curr.next.next != null) {
            ListNode node1 = curr.next;
            ListNode node2 = curr.next.next;
            curr.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            curr = node1;
        }
        return preHead.next;
    }

    public ListNode swapPairsV2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        head.next = swapPairsV2(newHead.next);
        newHead.next = head;
        return newHead;
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode slow = head, fast = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }


    /**
     * 82. 删除排序链表中的重复元素 II
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(0, head), cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int x = cur.next.val;
                while (cur.next != null && cur.next.val == x) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
