package com.eleven.icode.algorithm.leetcode.tree;


import com.eleven.icode.algorithm.leetcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author by YingLong on 2020/7/30
 */
public class TreePath {

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<String> resultList = new ArrayList<>();
        List<String> leftList = binaryTreePaths(root.left);
        List<String> rightList = binaryTreePaths(root.right);
        if (leftList.isEmpty() && rightList.isEmpty()) {
            resultList.add(root.val + "");
            return resultList;
        }
        for (String path : leftList) {
            resultList.add(root.val + "->" + path);
        }
        for (String path : rightList) {
            resultList.add(root.val + "->" + path);
        }
        return resultList;
    }

    /**
     * 1022
     * 从根到叶的二进制数之和
     *
     * @param root
     * @return
     */
    public int sumRootToLeaf(TreeNode root) {
        List<String> resultList = treePaths(root);
        int result = 0;
        for (String pathValue : resultList) {
            result += Integer.valueOf(pathValue, 2);
        }
        return result;
    }

    public List<String> treePaths(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<String> resultList = new ArrayList<>();
        List<String> leftList = treePaths(root.left);
        List<String> rightList = treePaths(root.right);
        for (String s : leftList) {
            resultList.add(root.val + s);
        }
        for (String s : rightList) {
            resultList.add(root.val + s);
        }
        if (leftList.isEmpty() && resultList.isEmpty()) {
            resultList.add(root.val + "");
        }
        return resultList;
    }

    /**
     * 112
     * 路径总和
     *
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        sum -= root.val;
        if (sum == 0 && root.left == null && root.right == null) {
            return true;
        }
        boolean isPathSum = hasPathSum(root.left, sum);
        if (isPathSum) {
            return true;
        }

        isPathSum = hasPathSum(root.right, sum);
        if (isPathSum) {
            return true;
        }
        return false;
    }

}
