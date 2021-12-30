package com.eleven.icode.algorithm.leetcode.tree;

import com.eleven.icode.algorithm.leetcode.entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author by YingLong on 2020/7/31
 */
public class TreeBaseTraversal {
    /**
     * 前序遍历
     */
    public void preOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        System.out.print(treeNode.val);
        preOrder(treeNode.left);
        preOrder(treeNode.right);
    }

    /**
     * 深度优先遍历——前序非递归遍历
     */
    public void preOrderDfs(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode tree = stack.pop();
            System.out.print(tree.val);
            if (tree.right != null) {
                stack.push(tree.right);
            }
            if (tree.left != null) {
                stack.push(tree.left);
            }
        }
    }

    /**
     * 中序遍历
     */
    public void inOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        inOrder(treeNode.left);
        System.out.print(treeNode.val + " ");
        inOrder(treeNode.right);
    }

    /**
     * 深度优先遍历——中序非递归遍历
     */
    public void inOrderDfs(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            System.out.print(root.val);
            root = root.right;
        }
    }

    /**
     * 后序遍历
     */
    public void backOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        backOrder(treeNode.left);
        backOrder(treeNode.right);
        System.out.print(treeNode.val);
    }

    /**
     * 深度优先遍历——后序非递归遍历
     */
    public void backOrderDfs(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            TreeNode right = null;
            while (root.right == null || root.right == right) {
                System.out.print(root.val);
                right = root;
                if (stack.isEmpty()) {
                    return;
                }
                root = stack.pop();
            }
            stack.push(root);
            root = root.right;
        }
    }

    public void backOrderDfsV2(TreeNode root) {
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> markStack = new Stack<>();
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            while (!markStack.isEmpty() && markStack.peek() == stack.peek()) {
                markStack.pop();
                System.out.print(stack.pop().val);
            }
            if (!stack.isEmpty()) {
                node = stack.peek();
                markStack.push(node);
                node = node.right;
            }
        }
    }

    /**
     * 层序遍历—广度优先遍历
     */
    public void bfs(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode tree = queue.poll();
            if (tree.left != null) {
                queue.offer(tree.left);
            }
            if (tree.right != null) {
                queue.offer(tree.right);
            }
            System.out.print(tree.val);
        }
    }
}
