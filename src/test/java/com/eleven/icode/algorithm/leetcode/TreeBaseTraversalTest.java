package com.eleven.icode.algorithm.leetcode;

import com.eleven.icode.algorithm.leetcode.entity.TreeNode;
import com.eleven.icode.algorithm.leetcode.tree.TreeBaseTraversal;
import org.junit.Test;

/**
 * @author by YingLong on 2020/8/5
 */
public class TreeBaseTraversalTest {

    @Test
    public void preOrderTest() {
        /**
         * [3,5,6,2,7,4,1,9,8]
         */
        TreeNode root = generateTree();
        TreeBaseTraversal traversal = new TreeBaseTraversal();
        traversal.preOrder(root);
    }

    @Test
    public void preOrderDfsTest() {
        /**
         * [3,5,6,2,7,4,1,9,8]
         */
        TreeNode root = generateTree();
        TreeBaseTraversal traversal = new TreeBaseTraversal();
        traversal.preOrderDfs(root);
    }

    @Test
    public void inOrderTest() {
        /**
         * [6,5,7,2,4,3,9,1,8]
         */
        TreeNode root = generateTree();
        TreeBaseTraversal traversal = new TreeBaseTraversal();
        traversal.inOrder(root);
    }

    @Test
    public void inOrderDfsTest() {
        /**
         * [6,5,7,2,4,3,9,1,8]
         */
        TreeNode root = generateTree();
        TreeBaseTraversal traversal = new TreeBaseTraversal();
        traversal.inOrderDfs(root);
    }

    @Test
    public void backOrderTest() {
        /**
         * [6,7,4,2,5,9,8,1,3]
         */
        TreeNode root = generateTree();
        TreeBaseTraversal traversal = new TreeBaseTraversal();
        traversal.backOrder(root);
    }

    @Test
    public void backOrderDfsTest() {
        /**
         * [6,7,4,2,5,9,8,1,3]
         */
        TreeNode root = generateTree();
        TreeBaseTraversal traversal = new TreeBaseTraversal();
        traversal.backOrderDfs(root);
        System.out.println();
        traversal.backOrderDfsV2(root);
    }


    @Test
    public void bfsTest() {
        /**
         * [3,5,1,6,2,9,8,7,4]
         */
        TreeNode root = generateTree();
        TreeBaseTraversal traversal = new TreeBaseTraversal();
        traversal.bfs(root);
    }

    /**
     * [3,5,1,6,2,9,8,null,null,7,4]
     */
    private TreeNode generateTree() {
        TreeNode node4 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);
        TreeNode node2 = new TreeNode(2, node7, node4);
        TreeNode node6 = new TreeNode(6);
        TreeNode node5 = new TreeNode(5, node6, node2);
        TreeNode node9 = new TreeNode(9);
        TreeNode node8 = new TreeNode(8);
        TreeNode node1 = new TreeNode(1, node9, node8);
        TreeNode node3 = new TreeNode(3, node5, node1);
        return node3;
    }
}
