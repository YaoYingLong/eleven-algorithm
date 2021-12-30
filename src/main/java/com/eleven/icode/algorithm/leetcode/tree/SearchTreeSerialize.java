package com.eleven.icode.algorithm.leetcode.tree;

import com.eleven.icode.algorithm.leetcode.entity.TreeNode;

import java.util.ArrayDeque;

/**
 * 449
 * 序列化和反序列化二叉搜索树
 *
 * @author by YingLong on 2020/8/25
 */
public class SearchTreeSerialize {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return null;
        }
        String rs = postorder(root);
        return rs.substring(0, rs.length() - 1);
    }

    private String postorder(TreeNode root) {
        if (root == null) {
            return "";
        }
        String left = postorder(root.left);
        String right = postorder(root.right);
        return left + right + root.val + "-";
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) {
            return null;
        }

        String[] reArr = data.split("-");
        ArrayDeque<Integer> nums = new ArrayDeque<>();
        for (String s : reArr) {
            nums.add(Integer.valueOf(s));
        }
        return buildTree(Integer.MIN_VALUE, Integer.MAX_VALUE, nums);
    }

    private TreeNode buildTree(int lower, int upper, ArrayDeque<Integer> nums) {
        if (nums.isEmpty()) {
            return null;
        }
        int rootVal = nums.getLast();
        if (rootVal > upper || rootVal < lower) {
            return null;
        }
        nums.removeLast();
        TreeNode root = new TreeNode(rootVal);
        root.right = buildTree(rootVal, upper, nums);
        root.left = buildTree(lower, rootVal, nums);
        return root;
    }
}
