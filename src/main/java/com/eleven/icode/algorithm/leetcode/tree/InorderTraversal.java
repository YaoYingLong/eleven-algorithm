package com.eleven.icode.algorithm.leetcode.tree;

import com.eleven.icode.algorithm.leetcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author by YingLong on 2020/7/31
 */
public class InorderTraversal {

    /**
     * 1305
     * 两棵二叉搜索树中的所有元素
     *
     * @param root1
     * @param root2
     * @return
     */
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> oneList = inorder1350(root1);
        List<Integer> twoList = inorder1350(root2);
        oneList.addAll(twoList);
        oneList.sort(Integer::compare);
        return oneList;
    }

    public List<Integer> inorder1350(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        if (root == null) {
            return resultList;
        }
        List<Integer> leftList = inorder1350(root.left);
        resultList.addAll(leftList);
        resultList.add(root.val);
        List<Integer> rightList = inorder1350(root.right);
        resultList.addAll(rightList);
        return resultList;
    }

    /**
     * 1379
     * 找出克隆二叉树中的相同节点
     *
     * @param original
     * @param cloned
     * @param target
     * @return
     */
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (cloned == null || target == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = cloned;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            if (node.val == target.val) {
                return node;
            }
            node = node.right;
        }
        return null;
    }

    /**
     * 1530
     * 好叶子节点对的数量
     *
     * @param root
     * @param distance
     * @return
     */
    int count = 0;
    public int countPairs(TreeNode root, int distance) {
        countPairsDfs(root, distance);
        return count;
    }

    public List<List<Integer>> countPairsDfs(TreeNode root, int distance) {
        List<List<Integer>> resultList = new ArrayList<>();
        if (root == null) {
            return resultList;
        }
        List<List<Integer>> leftList = countPairsDfs(root.left, distance);
        List<List<Integer>> rightList = countPairsDfs(root.right, distance);
        if (!leftList.isEmpty() && !rightList.isEmpty()) {
            for (List<Integer> leftSubList : leftList) {
                for (List<Integer> rightSubList : rightList) {
                    if (leftSubList.size() + rightSubList.size() <= distance) {
                        count++;
                    }
                }
            }
        }
        for (List<Integer> subList : leftList) {
            subList.add(0, root.val);
        }
        for (List<Integer> subList : rightList) {
            subList.add(0, root.val);
        }
        if (root.left == null && root.right == null) {
            List<Integer> subList = new ArrayList<>();
            subList.add(root.val);
            resultList.add(subList);
        }
        resultList.addAll(leftList);
        resultList.addAll(rightList);
        return resultList;
    }
}
