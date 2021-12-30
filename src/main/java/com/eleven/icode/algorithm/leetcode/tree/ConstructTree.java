package com.eleven.icode.algorithm.leetcode.tree;

import com.eleven.icode.algorithm.leetcode.entity.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author by YingLong on 2020/8/9
 */
public class ConstructTree {


    /**
     * 剑指 Offer 07
     * 重建二叉树
     * <p>
     * 前序遍历 preorder = [3,9,20,15,7]
     * 中序遍历 inorder = [9,3,15,20,7]
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTreeFromPreIn(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || preorder.length != inorder.length) {
            return null;
        }
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        return buildTravFromPreIn(preorder, 0, preorder.length - 1, 0, indexMap);
    }

    public TreeNode buildTravFromPreIn(int[] preorder, int preLeft, int preRight, int inLeft, Map<Integer, Integer> indexMap) {
        if (preLeft > preRight) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preLeft]);
        if (preLeft == preRight) {
            return root;
        }
        int rootIndex = indexMap.get(preorder[preLeft]);
        int leftNodes = rootIndex - inLeft;
        root.left = buildTravFromPreIn(preorder, preLeft + 1, leftNodes + preLeft, inLeft, indexMap);
        root.right = buildTravFromPreIn(preorder, preLeft + leftNodes + 1, preRight, rootIndex + 1, indexMap);
        return root;
    }

    /**
     * preorder = [3, 9, 8, 5, 4, 10, 20, 15, 7]
     * inorder = [4, 5, 8, 10, 9, 3, 15, 20, 7]
     */
    public TreeNode buildTreeFromPreInV2(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || preorder.length != inorder.length) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int inorderIndex = 0;
        for (int i = 1; i < preorder.length; i++) {
            int preorderVal = preorder[i];
            TreeNode node = stack.peek();
            if (node.val != inorder[inorderIndex]) {
                node.left = new TreeNode(preorderVal);
                stack.push(node.left);
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex++;
                }
                node.right = new TreeNode(preorderVal);
                stack.push(node.right);
            }
        }
        return root;
    }

    /**
     * 106
     * 从中序与后序遍历序列构造二叉树
     *
     * @param inorder
     * @param postorder
     * @return
     */
    public int postIndex;
    public TreeNode buildTreeFromInPost(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length == 0 || inorder.length != postorder.length) {
            return null;
        }
        postIndex = inorder.length - 1;
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        return buildTreeTravFromInPost(postorder, 0, postIndex, indexMap);
    }

    public TreeNode buildTreeTravFromInPost(int[] postorder, int inLeft, int inRight, Map<Integer, Integer> indexMap) {
        if (inLeft > inRight) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postIndex]);
        postIndex--;
        int rootIndex = indexMap.get(root.val);
        root.right = buildTreeTravFromInPost(postorder, rootIndex + 1, inRight, indexMap);
        root.left = buildTreeTravFromInPost(postorder, inLeft, rootIndex - 1, indexMap);
        return root;
    }

    /**
     *	889
     * 根据前序和后序遍历构造二叉树
     * @param pre
     * @param post
     * @return
     */
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        int N = pre.length;
        if (N == 0) {
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);
        if (N == 1) {
            return root;
        }
        int L = 0;
        for (int i = 0; i < N; i++) {
            if (post[i] == pre[1]) {
                L = i + 1;
                break;
            }
        }
        root.left = constructFromPrePost(Arrays.copyOfRange(pre, 1, L + 1),
                Arrays.copyOfRange(post, 0, L));
        root.right = constructFromPrePost(Arrays.copyOfRange(pre, L + 1, N),
                Arrays.copyOfRange(post, L, N - 1));
        return root;
    }

    public TreeNode constructFromPrePostV2(int[] pre, int[] post) {
        return constructFromPrePostTrav(pre, post, 0, 0, pre.length);
    }

    public TreeNode constructFromPrePostTrav(int[] pre, int[] post, int preLeft, int preRight, int N) {
        if (N == 0) {
            return null;
        }
        TreeNode root = new TreeNode(pre[preLeft]);
        if (N == 1) {
            return root;
        }
        int L = 1;
        for (; L < N; ++L) {
            if (post[preRight + L - 1] == pre[preLeft + 1]) {
                break;
            }
        }
        root.left = constructFromPrePostTrav(pre, post, preLeft + 1, preRight, L);
        root.right = constructFromPrePostTrav(pre, post, preLeft + L + 1, preRight + L, N-L-1);
        return root;
    }
}
