package com.eleven.icode.algorithm.leetcode;

import com.eleven.icode.algorithm.leetcode.entity.TreeNode;
import com.eleven.icode.algorithm.leetcode.tree.AVLTree;
import com.eleven.icode.algorithm.leetcode.tree.TreeBaseTraversal;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author by YingLong on 2020/9/2
 */
public class AVLTreeTest {

    @Test
    public void insertAvlOrderTest() {
        AVLTree avlTree = new AVLTree();
        TreeNode root = null;
        for (int i = 0; i < 100; i++) {
            root = avlTree.insertAvl(root, i);
            TreeBaseTraversal traversal = new TreeBaseTraversal();
            traversal.inOrder(root);
            System.out.println(avlTree.isBalanced(root));
        }
        System.out.println("------------------------------------");
        for (int i = 0; i < 100; i++) {
            root = avlTree.remove(root, i);
            TreeBaseTraversal traversal = new TreeBaseTraversal();
            traversal.inOrder(root);
            System.out.println(avlTree.isBalanced(root));
        }
    }


    @Test
    public void insertAvlOrderHalfTest() {
        AVLTree avlTree = new AVLTree();
        TreeNode root = null;
        for (int i = 0; i < 100; i++) {
            root = avlTree.insertAvl(root, i);
            TreeBaseTraversal traversal = new TreeBaseTraversal();
            traversal.inOrder(root);
            System.out.println(avlTree.isBalanced(root));
        }
        System.out.println("------------------------------------");
        for (int i = 0; i < 50; i++) {
            root = avlTree.remove(root, i);
            TreeBaseTraversal traversal = new TreeBaseTraversal();
            traversal.inOrder(root);
            System.out.println(avlTree.isBalanced(root));
        }
    }

    @Test
    public void insertAvlOrderDescTest() {
        AVLTree avlTree = new AVLTree();
        TreeNode root = null;
        for (int i = 100; i > 0; i--) {
            root = avlTree.insertAvl(root, i);
            TreeBaseTraversal traversal = new TreeBaseTraversal();
            traversal.inOrder(root);
            System.out.println(avlTree.isBalanced(root));
        }
        System.out.println("------------------------------------");
        for (int i = 100; i > 0; i--) {
            root = avlTree.remove(root, i);
            TreeBaseTraversal traversal = new TreeBaseTraversal();
            traversal.inOrder(root);
            System.out.println(avlTree.isBalanced(root));
        }
    }


    @Test
    public void insertAvlOrderDescHalfTest() {
        AVLTree avlTree = new AVLTree();
        TreeNode root = null;
        for (int i = 100; i > 0; i--) {
            root = avlTree.insertAvl(root, i);
            TreeBaseTraversal traversal = new TreeBaseTraversal();
            traversal.inOrder(root);
            System.out.println(avlTree.isBalanced(root));
        }
        System.out.println("------------------------------------");
        for (int i = 50; i > 0; i--) {
            root = avlTree.remove(root, i);
            TreeBaseTraversal traversal = new TreeBaseTraversal();
            traversal.inOrder(root);
            System.out.println(avlTree.isBalanced(root));
        }
    }

    @Test
    public void insertAvlRandomTest() {
        AVLTree avlTree = new AVLTree();
        TreeNode root = null;
        List<Integer> targetList = Arrays.asList(50, 78, 69, 88, 2, 6, 55, 44, 99, 33, 22, 11, 7, 5, 8, 100, 1, 34, 46, 75, 28);
        for (Integer i : targetList) {
            root = avlTree.insertAvl(root, i);
            TreeBaseTraversal traversal = new TreeBaseTraversal();
            traversal.inOrder(root);
            System.out.println(avlTree.isBalanced(root));
        }
        System.out.println("------------------------------------");
        for (Integer i : targetList) {
            root = avlTree.remove(root, i);
            TreeBaseTraversal traversal = new TreeBaseTraversal();
            traversal.inOrder(root);
            System.out.println(avlTree.isBalanced(root));
        }
    }
}
