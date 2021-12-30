package com.eleven.icode.algorithm.leetcode.tree;

import com.eleven.icode.algorithm.leetcode.entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 919
 * 完全二叉树插入器
 *
 * @author by YingLong on 2020/8/5
 */
public class CBTInserter {
    public TreeNode root;
    public Queue<TreeNode> notCbtQueue;

    public CBTInserter(TreeNode root) {
        this.root = root;
        notCbtQueue = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode tree = queue.poll();
            if (tree.left == null || tree.right == null) {
                notCbtQueue.offer(tree);
            }
            if (tree.left != null) {
                queue.offer(tree.left);
            }
            if (tree.right != null) {
                queue.offer(tree.right);
            }
        }
    }

    public int insert(int v) {
        if (root == null) {
            return -1;
        }
        TreeNode node = new TreeNode(v);
        TreeNode parent = notCbtQueue.peek();
        if (parent.left == null) {
            parent.left = node;
        } else {
            parent.right = node;
            notCbtQueue.poll();
        }
        notCbtQueue.offer(node);
        return parent.val;
    }

    public TreeNode get_root() {
        return root;
    }
}
