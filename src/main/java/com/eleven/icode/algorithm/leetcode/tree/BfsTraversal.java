package com.eleven.icode.algorithm.leetcode.tree;

import com.eleven.icode.algorithm.leetcode.entity.ListNode;
import com.eleven.icode.algorithm.leetcode.entity.NTreeNode;
import com.eleven.icode.algorithm.leetcode.entity.Node;
import com.eleven.icode.algorithm.leetcode.entity.TreeNode;

import java.util.*;

/**
 * @author by YingLong on 2020/7/31
 */
public class BfsTraversal {

    /**
     * 872
     * 叶子相似的树
     *
     * @param root1
     * @param root2
     * @return
     */
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> treeOneLeafList = new ArrayList<>();
        List<Integer> treeTwoLeafList = new ArrayList<>();
        getLeafs(root1, treeOneLeafList);
        getLeafs(root2, treeTwoLeafList);
        return treeOneLeafList.equals(treeTwoLeafList);
    }

    public void getLeafs(TreeNode root, List<Integer> resultList) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            resultList.add(root.val);
        }
        getLeafs(root.left, resultList);
        getLeafs(root.right, resultList);
    }

    /**
     * 637
     * 二叉树的层平均值
     *
     * @param root
     * @return
     */
    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<Double> resultList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            long levelSum = 0;
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                levelSum += node.val;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            resultList.add(levelSum * 1.0 / len);
        }
        return resultList;
    }

    /**
     * 二叉树的层次遍历
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resultList = new ArrayList<>();
        if (root == null) {
            return resultList;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> levelList = new ArrayList<>();
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode treeNode = queue.poll();
                if (treeNode.left != null) {
                    queue.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.offer(treeNode.right);
                }
                levelList.add(treeNode.val);
            }
            resultList.add(levelList);
        }
        return resultList;
    }


    /**
     * 107
     * 二叉树的层次遍历 II
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> resultList = new ArrayList<>();
        if (root == null) {
            return resultList;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> levelList = new ArrayList<>();
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode treeNode = queue.poll();
                if (treeNode.left != null) {
                    queue.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.offer(treeNode.right);
                }
                levelList.add(treeNode.val);
            }
            resultList.add(0, levelList);
        }
        return resultList;
    }

    /**
     * 剑指 Offer 32 - I
     * 从上到下打印二叉树
     *
     * @param root
     * @return
     */
    public int[] levelOrderV2(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        List<Integer> resList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                resList.add(node.val);
            }
        }
        int[] res = new int[resList.size()];
        for (int i = 0; i < resList.size(); i++) {
            res[i] = resList.get(i);
        }
        return res;
    }

    /**
     * 剑指 Offer 32 - III
     * 从上到下打印二叉树 III
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderV3(TreeNode root) {
        List<List<Integer>> resultList = new ArrayList<>();
        if (root == null) {
            return resultList;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int levelTh = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            List<Integer> subList = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (levelTh % 2 == 0) {
                    subList.add(node.val);
                } else {
                    subList.add(0, node.val);
                }
            }
            resultList.add(subList);
            levelTh++;
        }
        return resultList;
    }

    /**
     * 623
     * 在二叉树中增加一行
     *
     * @param root
     * @param v
     * @param d
     * @return
     */
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode nodeV = new TreeNode(v);
            nodeV.left = root;
            return nodeV;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int levelNum = 1;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                if (levelNum == d - 1) {
                    TreeNode nodeVLeft = new TreeNode(v);
                    nodeVLeft.left = node.left;
                    node.left = nodeVLeft;
                    TreeNode nodeVRight = new TreeNode(v);
                    nodeVRight.right = node.right;
                    node.right = nodeVRight;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            if (levelNum == d - 1) {
                return root;
            }
            levelNum++;
        }
        return root;
    }

    /**
     * 623
     * 在二叉树中增加一行
     *
     * @param root
     * @param v
     * @param d
     * @return
     */
    public TreeNode addOneRowV2(TreeNode t, int v, int d) {
        if (d == 1) {
            TreeNode n = new TreeNode(v);
            n.left = t;
            return n;
        }
        insert(v, t, 1, d);
        return t;
    }

    public void insert(int val, TreeNode node, int depth, int n) {
        if (node == null) {
            return;
        }
        if (depth == n - 1) {
            TreeNode t = node.left;
            node.left = new TreeNode(val);
            node.left.left = t;
            t = node.right;
            node.right = new TreeNode(val);
            node.right.right = t;
        } else {
            insert(val, node.left, depth + 1, n);
            insert(val, node.right, depth + 1, n);
        }
    }

    /**
     * 863
     * 二叉树中所有距离为 K 的结点
     *
     * @param root
     * @param target
     * @param K
     * @return
     */
    public Map<TreeNode, TreeNode> parentMap = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        if (root == null) {
            return new ArrayList<>();
        }
        parent(root, null);

        Set<TreeNode> containSet = new HashSet<>();
        containSet.add(target);
        containSet.add(null);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(target);
        int depth = 0;
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                if (depth == K) {
                    result.add(node.val);
                    continue;
                }
                if (!containSet.contains(node.left)) {
                    containSet.add(node.left);
                    queue.offer(node.left);
                }
                if (!containSet.contains(node.right)) {
                    containSet.add(node.right);
                    queue.offer(node.right);
                }
                TreeNode parent = parentMap.get(node);
                if (!containSet.contains(parent)) {
                    containSet.add(parent);
                    queue.offer(parent);
                }
            }
            if (depth == K) {
                return result;
            }
            depth++;
        }
        return result;
    }

    public void parent(TreeNode node, TreeNode parentNode) {
        if (node != null) {
            parentMap.put(node, parentNode);
            parent(node.left, node);
            parent(node.right, node);
        }
    }

    /**
     * 199
     * 二叉树的右视图
     *
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        if (root == null) {
            return resultList;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = len; i > 0; i--) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (i == 1) {
                    resultList.add(node.val);
                }
            }
        }
        return resultList;
    }

    /**
     * 103
     * 二叉树的锯齿形层次遍历
     *
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> resultList = new ArrayList<>();
        if (root == null) {
            return resultList;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            List<Integer> subResultList = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                if (resultList.size() % 2 == 0) {
                    subResultList.add(node.val);
                } else {
                    subResultList.add(0, node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            resultList.add(subResultList);
        }
        return resultList;
    }

    /**
     * 958
     * 二叉树的完全性检验
     *
     * @param root
     * @return
     */
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int k = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                if (node == null) {
                    k = 1;
                    continue;
                }
                if (k == 1 && node != null) {
                    return false;
                }
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        return true;
    }

    public List<List<Integer>> levelOrder(NTreeNode root) {
        List<List<Integer>> resultList = new ArrayList<>();
        if (root == null) {
            return resultList;
        }
        Queue<NTreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            List<Integer> subList = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                NTreeNode nTreeNode = queue.poll();
                subList.add(nTreeNode.value);
                for (NTreeNode node : nTreeNode.nodes) {
                    if (node != null) {
                        queue.offer(node);
                    }
                }
            }
            resultList.add(subList);
        }
        return resultList;
    }

    /**
     * 1302
     * 层数最深叶子节点的和
     *
     * @param root
     * @return
     */
    public int deepestLeavesSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int result = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            int levelResult = 0;
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                levelResult += node.val;
            }
            result = levelResult;
        }
        return result;
    }

    /**
     * 513
     * 找树左下角的值
     *
     * @param root
     * @return
     */
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode node = null;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                node = queue.poll();
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
            }
        }
        return node.val;
    }

    /**
     * 面试题 04.03
     * 特定深度节点链表
     *
     * @param tree
     * @return
     */
    public ListNode[] listOfDepth(TreeNode tree) {
        if (tree == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(tree);
        List<ListNode> listNodes = new ArrayList<>();
        while (!queue.isEmpty()) {
            int len = queue.size();
            ListNode listNode = new ListNode(0);
            ListNode cur = listNode;
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                cur.next = new ListNode(node.val);
                cur = cur.next;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            listNodes.add(listNode.next);
        }
        ListNode[] arrays = new ListNode[listNodes.size()];
        listNodes.toArray(arrays);
        return arrays;
    }

    /**
     * 116
     * 填充每个节点的下一个右侧节点指针
     * <p>
     * 117
     * 填充每个节点的下一个右侧节点指针 II
     *
     * @param root
     * @return
     */
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Node currentNode = queue.poll();
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
                if (i < len - 1) {
                    currentNode.next = queue.peek();
                }
            }
        }
        return root;
    }

    public Node connectV2(Node root) {
        if (root == null) {
            return null;
        }
        Node leftMost = root;
        while (leftMost.left != null) {
            Node head = leftMost;
            while (head != null) {
                head.left.next = head.right;
                if (head.next != null) {
                    head.right.next = head.next.left;
                }
                head = head.next;
            }
            leftMost = leftMost.left;
        }
        return root;
    }

    public Node connectV3(Node root) {
        if (root == null) {
            return null;
        }
        Node leftMost = root;
        Node cur;
        Node prev;
        while (leftMost != null) {
            prev = null;
            cur = leftMost;
            leftMost = null;
            while (cur != null) {
                if (cur.left != null) {
                    if (prev != null) {
                        prev.next = cur.left;
                    } else {
                        leftMost = cur.left;
                    }
                    prev = cur.left;
                }
                if (cur.right != null) {
                    if (prev != null) {
                        prev.next = cur.right;
                    } else {
                        leftMost = cur.right;
                    }
                    prev = cur.right;
                }
                cur = cur.next;
            }
        }
        return root;
    }

    /**
     * 515
     * 在每个树行中找最大值
     *
     * @param root
     * @return
     */
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        if (root == null) {
            return resultList;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            int levelMax = Integer.MIN_VALUE;
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                levelMax = Math.max(levelMax, node.val);
            }
            resultList.add(levelMax);
        }
        return resultList;
    }

    /**
     * 1161
     * 最大层内元素和
     *
     * @param root
     * @return
     */
    public int maxLevelSum(TreeNode root) {
        if (root == null) {
            return -1;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int minSumLevel = 0;
        int levelNum = 0;
        double minSum = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            int len = queue.size();
            double levelSum = 0.0;
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                levelSum += node.val;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            levelNum++;
            if (minSum < levelSum) {
                minSum = levelSum;
                minSumLevel = levelNum;
            }
        }
        return minSumLevel;
    }

    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxPathSumDfs(root);
        return max;
    }

    public int maxPathSumDfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(maxPathSumDfs(root.left), 0);
        int right = Math.max(maxPathSumDfs(root.right), 0);
        max = Math.max(max, root.val + left + right);
        return root.val + Math.max(left, right);
    }
}
