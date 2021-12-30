package com.eleven.icode.algorithm.leetcode;

import com.eleven.icode.algorithm.leetcode.entity.TreeNode;
import com.eleven.icode.algorithm.leetcode.tree.*;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author by YingLong on 2020/7/30
 */
public class TreeTest {

    @Test
    public void isCousinsTest() {
        TreeNode node4 = new TreeNode(4);
        TreeNode node3 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2, null, node4);
        TreeNode node1 = new TreeNode(1, node2, node3);
        System.out.println(TreeTraversal.isCousins(node1, 2, 3));
    }

    @Test
    public void increasingBSTTest() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2, node1, null);
        TreeNode node4 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);
        TreeNode node9 = new TreeNode(9);
        TreeNode node8 = new TreeNode(8, node7, node9);
        TreeNode node6 = new TreeNode(6, null, node8);
        TreeNode node3 = new TreeNode(3, node2, node4);
        TreeNode node5 = new TreeNode(5, node3, node6);

        SearchTree searchTree = new SearchTree();
        TreeNode result = searchTree.increasingBST(node5);

    }

    @Test
    public void findSecondMinimumValueTest() {
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2, node1, node2);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(2, node4, node3);

        BackorderTraversal backorderTraversal = new BackorderTraversal();
        int result = backorderTraversal.findSecondMinimumValue(node5);
        System.out.println(result);
    }

    @Test
    public void leafSimilarTest() {
        /**
         * [3,5,1,6,2,9,8,null,null,7,4]
         * [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
         */
        TreeNode node14 = new TreeNode(4);
        TreeNode node17 = new TreeNode(7);
        TreeNode node16 = new TreeNode(6);
        TreeNode node15 = new TreeNode(5, node16, node17);
        TreeNode node19 = new TreeNode(9);
        TreeNode node18 = new TreeNode(8);
        TreeNode node12 = new TreeNode(2, node19, node18);
        TreeNode node11 = new TreeNode(1, node14, node12);
        TreeNode node13 = new TreeNode(3, node15, node11);

        TreeNode node24 = new TreeNode(4);
        TreeNode node27 = new TreeNode(7);
        TreeNode node22 = new TreeNode(2, node27, node24);
        TreeNode node26 = new TreeNode(6);
        TreeNode node25 = new TreeNode(5, node26, node22);
        TreeNode node29 = new TreeNode(9);
        TreeNode node28 = new TreeNode(8);
        TreeNode node21 = new TreeNode(1, node29, node28);
        TreeNode node23 = new TreeNode(3, node25, node21);

        BfsTraversal bfsTraversal = new BfsTraversal();
        System.out.println(bfsTraversal.leafSimilar(node23, node13));
    }

    @Test
    public void lowestCommonAncestorTest() {
        {
            TreeNode node0 = new TreeNode(0);
            TreeNode node4 = new TreeNode(4);
            TreeNode node6 = new TreeNode(6);
            TreeNode node7 = new TreeNode(7);
            TreeNode node8 = new TreeNode(8);
            TreeNode node2 = new TreeNode(2, node7, node4);
            TreeNode node1 = new TreeNode(1, node0, node8);
            TreeNode node5 = new TreeNode(5, node6, node2);
            TreeNode node3 = new TreeNode(3, node5, node1);

            BackorderTraversal backorderTraversal = new BackorderTraversal();
            System.out.println(backorderTraversal.lowestCommonAncestor(node3, node5, node4));
        }
        {
            TreeNode node3 = new TreeNode(3);
            TreeNode node4 = new TreeNode(4);
            TreeNode node2 = new TreeNode(2, node4, null);
            TreeNode node1 = new TreeNode(1, node2, node3);
            BackorderTraversal backorderTraversal = new BackorderTraversal();
            System.out.println(backorderTraversal.lowestCommonAncestor(node1, node4, node3));
        }
    }

    @Test
    public void findTargetTest() {
        SearchTree searchTree = new SearchTree();
        TreeNode node2 = new TreeNode(2);
        TreeNode node4 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);
        TreeNode node3 = new TreeNode(3, node2, node4);
        TreeNode node6 = new TreeNode(6, null, node7);
        TreeNode node5 = new TreeNode(5, node3, node6);
        searchTree.findTarget(node5, 9);
    }

    @Test
    public void buildTreeTest() {
        int[] preorder = {3, 9, 8, 5, 4, 10, 1, 2, 6, 11, 20, 15, 7};
        int[] inorder = {4, 5, 8, 1, 10, 2, 11, 6, 9, 3, 15, 20, 7};
        ConstructTree constructTree = new ConstructTree();
        constructTree.buildTreeFromPreInV2(preorder, inorder);
    }

    @Test
    public void bstFromPreorderTest() {
        int[] preorder = {8, 5, 1, 7, 10, 12};
        PreorderTraversal preorderTraversal = new PreorderTraversal();
        preorderTraversal.bstFromPreorderV2(preorder);
    }

    @Test
    public void buildTreeByInAndPostTest() {
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        ConstructTree constructTree = new ConstructTree();
        constructTree.buildTreeFromInPost(inorder, postorder);
    }

    @Test
    public void delNodesTest() {
        TreeTraversal treeTraversal = new TreeTraversal();
//        {
//            TreeNode node4 = new TreeNode(4);
//            TreeNode node5 = new TreeNode(5);
//            TreeNode node6 = new TreeNode(6);
//            TreeNode node7 = new TreeNode(7);
//            TreeNode node3 = new TreeNode(3, node6, node7);
//            TreeNode node2 = new TreeNode(2, node4, node5);
//            TreeNode node1 = new TreeNode(1, node2, node3);
//
//            int[] to_delete = new int[]{3, 5};
//            treeTraversal.delNodes(node1, to_delete);
//        }
//        {
//            TreeNode node4 = new TreeNode(4);
//            TreeNode node3 = new TreeNode(3, null, node4);
//            TreeNode node2 = new TreeNode(2, null, node3);
//            TreeNode node1 = new TreeNode(1, null, node2);
//            int[] to_delete = new int[]{3};
//            treeTraversal.delNodes(node1, to_delete);
//        }
//        {
//            TreeNode node4 = new TreeNode(4);
//            TreeNode node3 = new TreeNode(3);
//            TreeNode node2 = new TreeNode(2, node4, node3);
//            TreeNode node1 = new TreeNode(1, node2, null);
//            int[] to_delete = new int[]{2, 3};
//            treeTraversal.delNodes(node1, to_delete);
//        }
        {
            TreeNode node4 = new TreeNode(4);
            TreeNode node3 = new TreeNode(3, null, node4);
            TreeNode node2 = new TreeNode(2);
            TreeNode node1 = new TreeNode(1, node2, node3);
            int[] to_delete = new int[]{2, 1};
            treeTraversal.delNodes(node1, to_delete);
        }
    }

    @Test
    public void lcaDeepestLeavesTest() {
        TreeNode node4 = new TreeNode(4);
        TreeNode node3 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2, node4, null);
        TreeNode node1 = new TreeNode(1, node2, node3);
        TreeTraversal treeTraversal = new TreeTraversal();
        treeTraversal.lcaDeepestLeaves(node1);
    }

    @Test
    public void pseudoPalindromicTest() {
//        int n = 36;
//        System.out.println(n & (n -1));
        List<Integer> list = Arrays.asList(1, 2, 1, 3, 3, 3);
        int v = 0;
        for (Integer val : list) {
            int k = 1 << val;
            v ^= k;
        }
        if (v == 0 || (v & (v - 1)) == 0) {
            System.out.println("1111");
        }
        System.out.println(v);
        System.out.println(v & (v - 1));
    }

    @Test
    public void printTreeTest() {
        TreeNode node4 = new TreeNode(4);
        TreeNode node3 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2, node4, null);
        TreeNode node1 = new TreeNode(1, node2, node3);
        TreeTraversal treeTraversal = new TreeTraversal();
        System.out.println(treeTraversal.printTree(node1));
    }

    @Test
    public void pathSumTest() {
        TreeNode node9 = new TreeNode(1);
        TreeNode node8 = new TreeNode(-2);
        TreeNode node7 = new TreeNode(3);
        TreeNode node6 = new TreeNode(11);
        TreeNode node5 = new TreeNode(2, null, node9);
        TreeNode node4 = new TreeNode(3, node7, node8);
        TreeNode node3 = new TreeNode(-3, null, node6);
        TreeNode node2 = new TreeNode(5, node4, node5);
        TreeNode node1 = new TreeNode(10, node2, node3);
        TreeTraversal treeTraversal = new TreeTraversal();
        System.out.println(treeTraversal.pathSum(node1, 8));

    }

    @Test
    public void findDuplicateSubtreesTest() {
        TreeNode node7 = new TreeNode(4);
        TreeNode node6 = new TreeNode(4);
        TreeNode node5 = new TreeNode(2, node7, null);
        TreeNode node4 = new TreeNode(4);
        TreeNode node3 = new TreeNode(3, node5, node6);
        TreeNode node2 = new TreeNode(2, node4, null);
        TreeNode node1 = new TreeNode(1, node2, node3);
        TreeTraversal treeTraversal = new TreeTraversal();
        System.out.println(treeTraversal.findDuplicateSubtrees(node1));
    }

    @Test
    public void pathSumV2Test() {
        TreeNode node10 = new TreeNode(1);
        TreeNode node9 = new TreeNode(5);
        TreeNode node8 = new TreeNode(2);
        TreeNode node7 = new TreeNode(7);
        TreeNode node6 = new TreeNode(4, node9, node10);
        TreeNode node5 = new TreeNode(13);
        TreeNode node4 = new TreeNode(11, node7, node8);
        TreeNode node3 = new TreeNode(8, node5, node6);
        TreeNode node2 = new TreeNode(4, node4, null);
        TreeNode node1 = new TreeNode(5, node2, node3);
        TreeTraversal treeTraversal = new TreeTraversal();
        System.out.println(treeTraversal.pathSumV2(node1, 22));
    }

    @Test
    public void treeSerializeTest() {
        TreeSerialize serialize = new TreeSerialize();
        TreeBaseTraversal treeBaseTraversal = new TreeBaseTraversal();
        {
            TreeNode node10 = new TreeNode(1);
            TreeNode node9 = new TreeNode(5);
            TreeNode node8 = new TreeNode(2);
            TreeNode node7 = new TreeNode(7);
            TreeNode node6 = new TreeNode(4, node9, node10);
            TreeNode node5 = new TreeNode(13);
            TreeNode node4 = new TreeNode(11, node7, node8);
            TreeNode node3 = new TreeNode(8, node5, node6);
            TreeNode node2 = new TreeNode(4, node4, null);
            TreeNode node1 = new TreeNode(5, node2, node3);
            String ser = serialize.serialize(node1);
            System.out.println(ser);

            TreeNode result = serialize.deserialize(ser);
            treeBaseTraversal.bfs(result);
        }
        {
            System.out.println();
            TreeNode node2 = new TreeNode(2);
            TreeNode node1 = new TreeNode(1, node2, null);
            String ser = serialize.serialize(node1);
            System.out.println(ser);

            TreeNode result = serialize.deserialize(ser);
            treeBaseTraversal.bfs(result);
        }

    }

    @Test
    public void testKK() {
        System.out.println(1 << 0);
        System.out.println(1 << 1);
        System.out.println(1 << 2);
        System.out.println(1 << 3);
        System.out.println(1 << 4);
        System.out.println();
        System.out.println(2 << 0);
        System.out.println(2 << 1);
        System.out.println(2 << 2);
        System.out.println(2 << 3);
        System.out.println(2 << 4);
    }

    @Test
    public void maxPathSumTest() {
        for (int binCount = 0; binCount < 10; ++binCount) {
            System.out.println(binCount);
        }
    }
}
