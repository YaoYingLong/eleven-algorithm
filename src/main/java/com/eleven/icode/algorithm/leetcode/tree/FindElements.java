package com.eleven.icode.algorithm.leetcode.tree;

import com.eleven.icode.algorithm.leetcode.entity.TreeNode;

import java.util.Stack;

/**
 * 1261
 * 在受污染的二叉树中查找元素
 * @author by YingLong on 2020/8/15
 */
public class FindElements {
    public TreeNode root;
    public FindElements(TreeNode root) {
        if (root == null) {
            this.root = null;
            return;
        }
        preGenerTree(root, -1, 2);
        this.root = root;
    }

    public boolean find(int target) {
        if (root == null) {
            return false;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            if (node.val == target) {
                return true;
            }
            node = node.right;
        }
        return false;
    }

    public void preGenerTree(TreeNode root, int rootVal, int add) {
        if (root == null) {
            return;
        }
        root.val = 2 * rootVal + add;
        preGenerTree(root.left, root.val, 1);
        preGenerTree(root.right, root.val, 2);
    }
}
