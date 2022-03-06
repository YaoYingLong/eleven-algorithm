package com.eleven.icode.algorithm.leetcode;

import com.eleven.icode.algorithm.leetcode.entity.ListNode;
import org.junit.Test;

import java.util.*;

/**
 * @author by YingLong on 2022/3/5
 */
public class LinkedListSolution {
    /**
     * 21. 合并两个有序链表
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(-1), tail = head;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }
        tail.next = list1 == null ? list2 : list1;
        return head.next;
    }


    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        } else if (list1.val > list2.val) {
            list2.next = mergeTwoLists2(list1, list2.next);
            return list2;
        } else {
            list1.next = mergeTwoLists2(list1.next, list2);
            return list1;
        }
    }


    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode res = new ListNode(-1), tmp = head, tail = res, next;
        int count = k;
        while (head != null) {
            --count;
            if (count == 0) {
                next = head.next;
                head.next = null;
                head = next;
                // 翻转
                tail.next = reverseList(tmp);
                tail = tmp;
                tmp = head;
                count = k;
            } else {
                head = head.next;
            }
        }
        tail.next = tmp;
        return res.next;
    }

    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                max = Math.max(sum, max);
            }
        }
        return max;
    }

    public int maxSubArray2(int[] nums) {
        int max = nums[0], prevMax = 0;
        for (int i = 0; i < nums.length; i++) {
            prevMax = Math.max(nums[i], prevMax + nums[i]);
            max = Math.max(max, prevMax);
        }
        return max;
    }

    public int maxArea(int[] height) {
        int len = height.length;
        int left = 0, max = Integer.MIN_VALUE;
        int right = len - 1;
        while (left < right) {
            if (height[left] < height[right]) {
                max = Math.max(max, height[left] * (right - left));
                left++;
            } else {
                max = Math.max(max, height[right] * (right - left));
                right--;
            }
        }
        return max;
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> markList = new ArrayList<>();
        for (int num : nums) {
            markList.add(num);
        }
        backup(nums.length, res, markList, 0);
        return res;
    }

    public void backup(int n, List<List<Integer>> res, List<Integer> markList, int first) {
        if (first == n) {
            res.add(new ArrayList<>(markList));
        }
        for (int i = first; i < n; i++) {
            Collections.swap(markList, first, i);
            backup(n, res, markList, first + 1);
            Collections.swap(markList, first, i);
        }
    }

    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            if (res < Integer.MIN_VALUE / 10 || res > Integer.MAX_VALUE / 10) {
                return 0;
            }
            int score = x % 10;
            x /= 10;
            res = res * 10 + score;
        }
        return res;
    }

    @Test
    public void test() {
        System.out.println(reverse(2147483647));
    }


    public int maxProfit(int[] prices) {
        int max = 0, minIndex = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[minIndex] > prices[i]) {
                minIndex = i;
            }
            max = Math.max(max, prices[i] - prices[minIndex]);
        }
        return max;
    }


    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    public int climbStairs2(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int a = 1;
        int b = 2;
        int c = 0;
        for (int i = 3; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }


    public int climbStairs3(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return fab(1, 2, n);
    }

    public int fab(int pre, int res, int n) {
        if (n < 3) {
            return res;
        }
        return fab(res, res + pre, n - 1);
    }


    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            if (a == '(' || a == '[' || a == '{') {
                stack.push(a);
            } else if (a == ')' || a == ']' || a == '}') {
                if (stack.isEmpty()) {
                    return false;
                }
                char b = stack.pop();
                if (a == ')' && b != '(') {
                    return false;
                }
                if (a == ']' && b != '[') {
                    return false;
                }
                if (a == '}' && b != '{') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public int search(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public int search2(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return -1;
        }

        if (len == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int left = 0, right = len - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target <= nums[len - 1] && target > nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    class NodeStatus implements Comparable {
        public ListNode node;
        public int val;

        public NodeStatus(ListNode node, int val) {
            this.node = node;
            this.val = val;
        }

        @Override
        public int compareTo(Object o) {
            return this.val - ((NodeStatus) o).val;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<NodeStatus> queue = new PriorityQueue<>();
        for (ListNode list : lists) {
            if (list != null) {
                queue.offer(new NodeStatus(list, list.val));
            }
        }
        if (queue.isEmpty()) {
            return null;
        }
        ListNode head = new ListNode(-1), tail = head;
        while (!queue.isEmpty()) {
            tail.next = queue.poll().node;
            tail = tail.next;
            if (tail.next != null) {
                queue.offer(new NodeStatus(tail.next, tail.next.val));
            }
        }
        return head.next;
    }

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<int[]> merge = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int left = intervals[i][0], right = intervals[i][1];
            if (merge.isEmpty() || merge.get(merge.size() - 1)[1] < left) {
                merge.add(new int[]{left, right});
            } else {
                int[] before = merge.get(merge.size() - 1);
                before[1] = Math.max(before[1], right);
            }
        }
        return merge.toArray(new int[merge.size()][]);
    }

    public void nextPermutation(int[] nums) {
        int len = nums.length;
        int i = len - 2;
        for (; i > -1; i--) {
            if (nums[i] < nums[i + 1]) {
                break;
            }
        }

        if (i > -1) {
            for (int j = len - 1; j > i; j--) {
                if (nums[i] < nums[j]) {
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                    break;
                }
            }
        }
        i++;
        int right = len - 1;
        while (i < right) {
            int tmp = nums[i];
            nums[i] = nums[right];
            nums[right] = tmp;
            i++;
            right--;
        }
    }

    @Test
    public void test001() {
        int[] nums = new int[]{1, 7, 2, 6, 5, 3};
        nextPermutation(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
