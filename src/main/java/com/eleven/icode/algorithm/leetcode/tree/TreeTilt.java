package com.eleven.icode.algorithm.leetcode.tree;

import com.eleven.icode.algorithm.leetcode.entity.TreeNode;

/**
 * @author by YingLong on 2020/7/30
 */
public class TreeTilt {
    /**
     * 563
     * 二叉树的坡度
     */
    int tilt = 0;

    public int findTilt(TreeNode root) {
        traversal(root);
        return tilt;
    }

    public int traversal(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = traversal(root.left);
        int right = traversal(root.right);
        tilt += Math.abs(left - right);
        return left + right + root.val;
    }
}
