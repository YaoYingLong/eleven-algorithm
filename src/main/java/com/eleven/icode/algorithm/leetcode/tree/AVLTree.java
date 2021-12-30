package com.eleven.icode.algorithm.leetcode.tree;

import com.eleven.icode.algorithm.leetcode.entity.TreeNode;

import java.util.Random;

/**
 * 平衡二叉树相关
 *
 * @author by YingLong on 2020/7/31
 */
public class AVLTree {
    /**
     * 110
     * 平衡二叉树
     * <p>
     * 面试题 04.04
     * 检查平衡性
     * <p>
     * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1
     *
     * @param treeNode
     * @return
     */
    public boolean isBalanced(TreeNode treeNode) {
        return recur(treeNode) != -1;
    }

    public int recur(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        int leftDepth = recur(treeNode.left);
        if (leftDepth == -1) {
            return -1;
        }
        int rightDepth = recur(treeNode.right);
        if (rightDepth == -1 || Math.abs(leftDepth - rightDepth) > 1) {
            return -1;
        }
        return Math.max(leftDepth, rightDepth) + 1;
    }

    /**
     * 108
     * 将有序数组转换为二叉搜索树
     * <p>
     * 面试题 04.02
     * 最小高度树
     *
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToAVL(int[] nums) {
        return toAVLTraversalLeft(nums, 0, nums.length - 1);
    }

    // 总是选择中间位置左边的数字作为根节点
    public TreeNode toAVLTraversalLeft(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = toAVLTraversalLeft(nums, left, mid - 1);
        root.right = toAVLTraversalLeft(nums, mid + 1, right);
        return root;
    }

    // 总是选择中间位置右边的数字作为根节点
    public TreeNode toAVLTraversalRight(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right + 1) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = toAVLTraversalRight(nums, left, mid - 1);
        root.right = toAVLTraversalRight(nums, mid + 1, right);
        return root;
    }

    // 选择任意一个中间位置数字作为根节点
    public TreeNode toAVLTraversalRandom(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right + new Random().nextInt(2)) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = toAVLTraversalRandom(nums, left, mid - 1);
        root.right = toAVLTraversalRandom(nums, mid + 1, right);
        return root;
    }

    /**
     * 左旋
     *
     * @param root 左旋后的根节点
     * @return
     */
    public TreeNode leftLeftRotation(TreeNode root) {
        TreeNode left = root.left;
        root.left = left.right;
        left.right = root;
        return left;
    }

    /**
     * 右旋
     *
     * @param root 右旋后的根节点
     * @return
     */
    public TreeNode rightRightRotation(TreeNode root) {
        TreeNode right = root.right;
        root.right = right.left;
        right.left = root;
        return right;
    }

    /**
     * 左右旋
     *
     * @param root 左右旋后的根节点
     * @return
     */
    public TreeNode leftRightRotation(TreeNode root) {
        root.left = rightRightRotation(root.left);
        return leftLeftRotation(root);
    }

    /**
     * 左右旋
     *
     * @param root 左右旋后的根节点
     * @return
     */
    public TreeNode rightLeftRotation(TreeNode root) {
        root.right = leftLeftRotation(root.right);
        return rightRightRotation(root);
    }

    public TreeNode insertAvl(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (val == root.val) {
            throw new RuntimeException("不允许添加相同的节点");
        }
        if (val < root.val) {
            root.left = insertAvl(root.left, val);
            // 插入节点后，若AVL树失去平衡，则进行相应的调节
            if (maxDepth(root.left) - maxDepth(root.right) == 2) {
                if (val < root.left.val) {
                    return leftLeftRotation(root);
                } else {
                    return leftRightRotation(root);
                }
            }
        } else {
            root.right = insertAvl(root.right, val);
            // 插入节点后，若AVL树失去平衡，则进行相应的调节
            if (maxDepth(root.right) - maxDepth(root.left) == 2) {
                if (val > root.right.val) {
                    return rightRightRotation(root);
                } else {
                    return rightLeftRotation(root);
                }
            }
        }
        return root;
    }

    public TreeNode remove(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (val < root.val) {
            root.left = remove(root.left, val);
            if (maxDepth(root.right) - maxDepth(root.left) == 2) {
                if (maxDepth(root.right.left) > maxDepth(root.right.right)) {
                    return rightLeftRotation(root);
                } else {
                    return rightRightRotation(root);
                }
            }
        } else if (val > root.val) {
            root.right = remove(root.right, val);
            if (maxDepth(root.left) - maxDepth(root.right) == 2) {
                if (maxDepth(root.left.right) > maxDepth(root.left.left)) {
                    return leftRightRotation(root);
                } else {
                    return leftLeftRotation(root);
                }
            }
        } else {
            if (root.left != null && root.right != null) {
                if (maxDepth(root.left) > maxDepth(root.right)) {
                    int maxVal = findMax(root.left);
                    root.val = maxVal;
                    root.left = remove(root.left, maxVal);
                } else {
                    int minVal = findMin(root.right);
                    root.val = minVal;
                    root.right = remove(root.right, minVal);
                }
            } else {
                return root.left != null ? root.left : root.right;
            }
        }
        return root;
    }

    public int findMax(TreeNode root) {
        if (root.left == null || root.right == null) {
            return root.val;
        }
        return findMax(root.right);
    }

    public int findMin(TreeNode root) {
        if (root.right == null || root.left == null) {
            return root.val;
        }
        return findMin(root.left);
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
