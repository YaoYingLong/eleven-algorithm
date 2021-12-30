package com.eleven.icode.algorithm.leetcode.tree;

import com.eleven.icode.algorithm.leetcode.entity.NTreeNode;
import com.eleven.icode.algorithm.leetcode.entity.TreeNode;

import java.util.*;

/**
 * @author by YingLong on 2020/7/27
 */
public class TreeTraversal {

    /**
     * 剑指 Offer 55 - I
     * 二叉树的深度
     */
    public int maxDepthV1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepthV1(root.left), maxDepthV1(root.right)) + 1;
    }

    /**
     * 剑指 Offer 55 - I
     * 二叉树的深度
     */
    public int maxDepthV2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        int maxDepth = 0;
        queue.add(root);
        while (!queue.isEmpty()) {
            maxDepth++;
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode treeNode = queue.poll();
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
            }
        }
        return maxDepth;
    }

    /**
     * 543
     * 二叉树的直径
     */
    int diameter = 0;

    public int diameter(TreeNode root) {
        depth(root);
        return diameter;
    }

    public int depth(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        int left = depth(treeNode.left);
        int right = depth(treeNode.right);
        diameter = Math.max(left + right, diameter);
        return Math.max(left, right) + 1;
    }


    /**
     * 606
     * 根据二叉树创建字符串
     *
     * @param root
     * @return
     */
    public String tree2str(TreeNode root) {
        if (root == null) {
            return "";
        }
        String result = root.val + "";
        if (root.left == null && root.right == null) {
            return result;
        }
        result += "(" + tree2str(root.left) + ")";
        if (root.right != null) {
            result += "(" + tree2str(root.right) + ")";
        }
        return result;
    }

    /**
     * 993
     * 二叉树的堂兄弟节点
     *
     * @param root
     * @param x
     * @param y
     * @return
     */
    public static boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            int xIndex = -1, yIndex = -1;
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                if (node == null) {
                    continue;
                }
                if (node.val == x) {
                    xIndex = i;
                }
                if (node.val == y) {
                    yIndex = i;
                }
                queue.offer(node.left);
                queue.offer(node.right);
            }
            if (yIndex == -1 || xIndex == -1) {
                continue;
            }
            if (Math.abs(yIndex - xIndex) > 1 || Math.max(xIndex, yIndex) % 2 == 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * 559
     * N叉树的最大深度
     *
     * @param root
     * @return
     */
    public int maxDepth(NTreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxDepth = 0;
        for (NTreeNode node : root.nodes) {
            maxDepth = Math.max(maxDepth(node), maxDepth);
        }
        return maxDepth + 1;
    }

    /**
     * 1145
     * 二叉树着色游戏
     *
     * @param root
     * @param n
     * @param x
     * @return
     */
    int leftNum = 0, rightNum = 0;

    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        backorder1145(root, x);
        int half = n / 2;
        return leftNum > half || rightNum > half || leftNum + rightNum < half;
    }

    public int backorder1145(TreeNode root, int x) {
        if (root == null) {
            return 0;
        }
        int left = backorder1145(root.left, x);
        int right = backorder1145(root.right, x);
        if (root.val == x) {
            leftNum = left;
            rightNum = right;
        }
        return left + right + 1;
    }

    /**
     * 面试题 04.10
     * 检查子树
     *
     * @param t1
     * @param t2
     * @return
     */
    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return false;
        }
        return isSameTree(t1, t2) || checkSubTree(t1.left, t2) || checkSubTree(t1.right, t2);
    }

    public boolean isSameTree(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        if (t1.val != t2.val) {
            return false;
        }
        return isSameTree(t1.left, t2.left) && isSameTree(t1.right, t2.right);
    }

    /**
     * 222
     * 完全二叉树的节点个数
     *
     * @param root
     * @return
     */
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = countNodes(root.left);
        int right = countNodes(root.right);
        return left + right + 1;
    }

    /**
     * 1448
     * 统计二叉树中好节点的数目
     *
     * @param root
     * @return
     */
    public int count = 0;

    public int goodNodes(TreeNode root) {
        traversal1448(root, Integer.MIN_VALUE);
        return count;
    }

    public void traversal1448(TreeNode root, int max) {
        if (root == null) {
            return;
        }
        if (root.val >= max) {
            max = root.val;
            count++;
        }
        traversal1448(root.left, max);
        traversal1448(root.right, max);
    }

    /**
     * 1110
     * 删点成林
     *
     * @param root
     * @param to_delete
     * @return
     */
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> nodeList = new ArrayList<>();
        if (root == null) {
            return nodeList;
        }
        List<Integer> deleteList = new ArrayList<>();
        for (int val : to_delete) {
            deleteList.add(val);
        }
        if (!deleteList.contains(root.val)) {
            nodeList.add(root);
        }
        nodeList.addAll(delSubNodes(root, null, deleteList, null));
        return nodeList;
    }


    public List<TreeNode> delSubNodes(TreeNode root, TreeNode parent, List<Integer> deleteList, Boolean isLeft) {
        List<TreeNode> nodeList = new ArrayList<>();
        if (root == null) {
            return nodeList;
        }
        nodeList.addAll(delSubNodes(root.left, root, deleteList, true));
        nodeList.addAll(delSubNodes(root.right, root, deleteList, false));
        if (deleteList.contains(root.val)) {
            if (root.left != null) {
                nodeList.add(root.left);
            }
            if (root.right != null) {
                nodeList.add(root.right);
            }
            if (isLeft != null) {
                if (isLeft) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            }
        }
        return nodeList;
    }

    public List<TreeNode> delNodesV2(TreeNode root, int[] to_delete) {
        List<TreeNode> nodeList = new ArrayList<>();
        List<Integer> deleteList = new ArrayList<>();
        for (int val : to_delete) {
            deleteList.add(val);
        }
        delSubNodesV2(root, nodeList, deleteList, false);
        return nodeList;
    }

    public boolean delSubNodesV2(TreeNode root, List<TreeNode> nodeList, List<Integer> deleteList, boolean parentExists) {
        boolean del;
        if (root == null) {
            return false;
        }
        del = deleteList.contains(root.val);
        if (delSubNodesV2(root.left, nodeList, deleteList, !del)) {
            root.left = null;
        }
        if (delSubNodesV2(root.right, nodeList, deleteList, !del)) {
            root.right = null;
        }
        if (!del && !parentExists) {
            nodeList.add(root);
        }
        return del;
    }

    /**
     * 654
     * 最大二叉树
     *
     * @param nums
     * @return
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return maximumBinaryTreeDfs(nums, 0, nums.length);
    }

    public TreeNode maximumBinaryTreeDfs(int[] nums, int leftIndex, int rightIndex) {
        if (leftIndex == rightIndex) {
            return null;
        }
        int maxIndex = getMaxIndex(nums, leftIndex, rightIndex);
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = maximumBinaryTreeDfs(nums, leftIndex, maxIndex);
        root.right = maximumBinaryTreeDfs(nums, maxIndex + 1, rightIndex);
        return root;
    }

    private int getMaxIndex(int[] nums, int leftIndex, int rightIndex) {
        int maxIndex = leftIndex;
        for (int i = leftIndex; i < rightIndex; i++) {
            if (nums[maxIndex] < nums[i]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    /**
     * 1315
     * 祖父节点值为偶数的节点和
     *
     * @param root
     * @return
     */
    public int sumEvenGrandparent(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = sumEvenGrandparent(root.left);
        int right = sumEvenGrandparent(root.right);
        int result = right + left;
        if (root.val % 2 == 0) {
            if (root.left != null) {
                result += root.left.left != null ? root.left.left.val : 0;
                result += root.left.right != null ? root.left.right.val : 0;
            }
            if (root.right != null) {
                result += root.right.left != null ? root.right.left.val : 0;
                result += root.right.right != null ? root.right.right.val : 0;
            }
        }
        return result;
    }

    public int sumEvenGrandparentV2(TreeNode root) {
        return sumEvenGrandparentV2Dfs(root, 1, 1);
    }

    public int sumEvenGrandparentV2Dfs(TreeNode root, int gpVal, int pVal) {
        if (root == null) {
            return 0;
        }

        int left = sumEvenGrandparentV2Dfs(root.left, pVal, root.val);
        int right = sumEvenGrandparentV2Dfs(root.right, pVal, root.val);
        return gpVal % 2 == 0 ? root.val + left + right : right + left;
    }

    /**
     * 1104
     * 二叉树寻路
     *
     * @param label
     * @return
     */
    public List<Integer> pathInZigZagTree(int label) {
        int level = (int) (Math.log(label) / Math.log(2));
        List<Integer> result = new ArrayList<>(level);
        while (label > 1) {
            result.add(label);
            label = (int) (3 * Math.pow(2, --level) - label / 2 - 1);
        }
        result.add(1);
        Collections.reverse(result);
        return result;
    }

    /**
     * 1123
     * 最深叶节点的最近公共祖先
     *
     * @param root
     * @return
     */
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        if (left > right) {
            return lcaDeepestLeaves(root.left);
        }
        if (left < right) {
            return lcaDeepestLeaves(root.right);
        }
        return root;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

    /**
     * 236
     * 二叉树的最近公共祖先
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
    }

    /**
     * 951
     * 翻转等价二叉树
     *
     * @param root1
     * @param root2
     * @return
     */
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null || root1.val != root2.val) {
            return false;
        }
        boolean left = flipEquiv(root1.left, root2.right) || flipEquiv(root1.left, root2.left);
        if (!left) {
            return false;
        }
        return flipEquiv(root1.right, root2.left) || flipEquiv(root1.right, root2.right);
    }

    /**
     * 129
     * 求根到叶子节点数字之和
     *
     * @param root
     * @return
     */
    public int sumNumbers(TreeNode root) {
        return sumNumbersDfs(root, 0);
    }

    public int sumNumbersDfs(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }
        k = k * 10 + root.val;
        int left = sumNumbersDfs(root.left, k);
        int right = sumNumbersDfs(root.right, k);
        if (root.left == null && root.right == null) {
            return k;
        }
        return left + right;
    }

    /**
     * 1457
     * 二叉树中的伪回文路径
     * 众所周知 n & (n - 1) 可以用来消除最后一个1
     * 举例: 以下都是二进制表示
     * 假设 n = 100100 那么 n - 1 = 100011 因为100 - 1 = 011
     * 那么 n & (n - 1) = 100000 所以这是去掉了最后的一个1
     * <p>
     * 因为异或的性质是 位相同异或为0 位不同异或为1 例如 1 ^ 1 = 0 ; 1 ^ 0 =1
     * 然后比如 5 二进制为 1001 , 依据异或的性质 1001 ^ 1001 = 0
     * 所以异或的性质就是两个相同的数 异或为0
     * <p>
     * 然后回文串只会有两种情况 要么 1221 要么 121 所以异或后，要么是0 要么是个数为奇数的数字。
     * 然后因为题目取值范围是1～9 所以可以用每一位代表一个数字。
     * 比如5写成100000，这样哪怕是 121 这种情况 也只会剩下2 也就是100
     * 这样我们就可以根据 n & (n - 1) 来消除1 所以判断是否为回文数字的条件就变成了
     * <p>
     * <p>
     * (n == 0 || (n & (n - 1)) == 0)
     *
     * @param root
     * @return
     */
    public int pseudoPalindromicPaths(TreeNode root) {
        int count = 0;
        List<LinkedList<Integer>> pathList = treePathsDfs(root);
        for (LinkedList<Integer> path : pathList) {
            int v = 0;
            for (Integer val : path) {
                v ^= 1 << val;
            }
            if (v == 0 || (v & (v - 1)) == 0) {
                count++;
            }
        }
        return count;
    }

    public List<LinkedList<Integer>> treePathsDfs(TreeNode root) {
        List<LinkedList<Integer>> resultList = new ArrayList<>();
        if (root == null) {
            return resultList;
        }
        List<LinkedList<Integer>> leftList = treePathsDfs(root.left);
        List<LinkedList<Integer>> rightList = treePathsDfs(root.right);
        for (LinkedList<Integer> subList : leftList) {
            subList.addFirst(root.val);
        }
        for (LinkedList<Integer> subList : rightList) {
            subList.addFirst(root.val);
        }
        resultList.addAll(leftList);
        resultList.addAll(rightList);
        if (root.left == null && root.right == null) {
            LinkedList<Integer> subList = new LinkedList<>();
            subList.addFirst(root.val);
            resultList.add(subList);
        }
        return resultList;
    }


    /**
     * 1026
     * 节点与其祖先之间的最大差值
     *
     * @param root
     * @return
     */
    public int maxRes = -1;

    public int maxAncestorDiff(TreeNode root) {
        maxAncestorDiffDfs(root, root.val, root.val);
        return maxRes;
    }

    public void maxAncestorDiffDfs(TreeNode root, int maxParent, int minParent) {
        if (root == null) {
            return;
        }
        maxParent = Math.max(root.val, maxParent);
        minParent = Math.min(root.val, minParent);
        maxRes = Math.max(maxRes, maxParent - minParent);
        maxAncestorDiffDfs(root.left, maxParent, minParent);
        maxAncestorDiffDfs(root.right, maxParent, minParent);
    }

    /**
     * 998
     * 最大二叉树 II
     *
     * @param root
     * @param val
     * @return
     */
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if (root == null || root.val < val) {
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }

        TreeNode right = insertIntoMaxTree(root.right, val);
        root.right = right;
        return root;
    }

    /**
     * 337
     * 打家劫舍 III
     * 用 f(o) 表示选择 o 节点的情况下，o 节点的子树上被选择的节点的最大权值和；g(o) 表示不选择 o 节点的情况下，o 节点的子树上被选择的节点的最大权值和；l 和 r 代表 o 的左右孩子。
     * <p>
     * 当 o 被选中时，o 的左右孩子都不能被选中，故 o 被选中情况下子树上被选中点的最大权值和为 l 和 r 不被选中的最大权值和相加，即 f(o) = g(l) + g(r)。
     * 当 o 不被选中时，o 的左右孩子可以被选中，也可以不被选中。对于 o 的某个具体的孩子 xx，它对 o 的贡献是 xx 被选中和不被选中情况下权值和的较大值。故g(o)=max{f(l),g(l)}+max{f(r),g(r)}。
     *
     * @param root
     * @return
     */
    public int rob(TreeNode root) {
        int[] res = robDfs(root);
        return Math.max(res[0], res[1]);
    }

    public int[] robDfs(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] left = robDfs(root.left);
        int[] rigt = robDfs(root.right);
        int selected = root.val + left[1] + rigt[1];
        int notSelected = Math.max(left[0], left[1]) + Math.max(rigt[0], rigt[1]);
        return new int[]{selected, notSelected};
    }

    /**
     * 865
     * 具有所有最深结点的最小子树
     *
     * @param root
     * @return
     */
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        if (left < right) {
            return subtreeWithAllDeepest(root.right);
        }
        if (left > right) {
            return subtreeWithAllDeepest(root.left);
        }
        return root;
    }

    /**
     * 655
     * 输出二叉树
     *
     * @param root
     * @return
     */
    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> resultList = new ArrayList<>();
        if (root == null) {
            return resultList;
        }
        int maxDepth = maxDepth(root);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int levelCount = 1;
        while (!queue.isEmpty()) {
            int len = queue.size();
            List<String> subList = new ArrayList<>();
            int fillCount = (1 << maxDepth - levelCount) - 1;
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                for (int i1 = 0; i1 < fillCount; i1++) {
                    subList.add("");
                }
                if (node == null) {
                    subList.add("");
                } else {
                    subList.add(String.valueOf(node.val));
                }
                for (int i1 = 0; i1 < fillCount; i1++) {
                    subList.add("");
                }
                if (len > 1 && i < len - 1) {
                    subList.add("");
                }
                queue.offer(node == null ? null : node.left);
                queue.offer(node == null ? null : node.right);
            }
            resultList.add(subList);
            if (maxDepth == levelCount) {
                return resultList;
            }
            levelCount++;
        }
        return resultList;
    }

    /**
     * 437
     * 路径总和 III
     * <p>
     * 面试题 04.12
     * 求和路径
     *
     * @param root
     * @param sum
     * @return
     */
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int left = pathSum(root.left, sum);
        int right = pathSum(root.right, sum);
        int count = pathSumDfs(root, sum);
        return left + right + count;
    }

    public int pathSumDfs(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        sum -= root.val;
        int left = pathSumDfs(root.left, sum);
        int right = pathSumDfs(root.right, sum);
        return sum == 0 ? left + right + 1 : left + right;
    }

    public int pathSumV2(TreeNode root, int sum) {
        Map<Integer, Integer> resMap = new HashMap<>();
        resMap.put(0, 1);
        return pathSumDfsV2(root, resMap, sum, 0);
    }

    public int pathSumDfsV2(TreeNode root, Map<Integer, Integer> resMap, int sum, int current) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        current += root.val;
        count += resMap.getOrDefault(current - sum, 0);
        resMap.put(current, resMap.getOrDefault(current, 0) + 1);
        int left = pathSumDfsV2(root.left, resMap, sum, current);
        int right = pathSumDfsV2(root.right, resMap, sum, current);
        resMap.put(current, resMap.getOrDefault(current, 0) - 1);
        return left + right + count;
    }


    List<TreeNode> dupSubTreeList = new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String, Integer> subTreeMap = new HashMap<>();
        findDuplicateSubtreesDfs(root, subTreeMap);
        return dupSubTreeList;
    }

    public String findDuplicateSubtreesDfs(TreeNode root, Map<String, Integer> subTreeMap) {
        if (root == null) {
            return "#";
        }
        String key = root.val + "," + findDuplicateSubtreesDfs(root.left, subTreeMap)
                + "," + findDuplicateSubtreesDfs(root.right, subTreeMap);
        subTreeMap.put(key, subTreeMap.getOrDefault(key, 0) + 1);
        if (subTreeMap.getOrDefault(key, 0) == 2) {
            dupSubTreeList.add(root);
        }
        return key;
    }

    /**
     * 1372
     * 二叉树中的最长交错路径
     *
     * @param root
     * @return
     */
    public int maxAns = 0;

    public int longestZigZag(TreeNode root) {
        if (root == null) {
            return 0;
        }
        longestZigZagDfs(root, true, 0);
        longestZigZagDfs(root, false, 0);
        return maxAns;
    }

    public void longestZigZagDfs(TreeNode root, boolean flag, int len) {
        maxAns = Math.max(maxAns, len);
        if (flag) {
            if (root.left != null) {
                longestZigZagDfs(root.left, false, len + 1);
            }
            if (root.right != null) {
                longestZigZagDfs(root.right, true, 1);
            }
        } else {
            if (root.right != null) {
                longestZigZagDfs(root.right, true, len + 1);
            }
            if (root.left != null) {
                longestZigZagDfs(root.left, false, 1);
            }
        }
    }

    /**
     * 988
     * 从叶结点开始的最小字符串
     *
     * @param root
     * @return
     */
    String ans = "~";

    public String smallestFromLeaf(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        smallestFromLeafDfs(root, sb);
        return ans;
    }

    public void smallestFromLeafDfs(TreeNode root, StringBuffer sb) {
        if (root == null) {
            return;
        }
        sb.append((char) ('a' + root.val));
        if (root.left == null && root.right == null) {
            sb.reverse();
            String s = sb.toString();
            sb.reverse();
            if (s.compareTo(ans) < 0) {
                ans = s;
            }
        }
        smallestFromLeafDfs(root.left, sb);
        smallestFromLeafDfs(root.right, sb);
        sb.deleteCharAt(sb.length() - 1);
    }

    /**
     * 662
     * 二叉树最大宽度
     *
     * @param root
     * @return
     */
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<AnnotatedNode> queue = new LinkedList<>();
        queue.offer(new AnnotatedNode(root, 0, 0));
        int maxWidth = 0;
        int left = 0, currDepth = 0;
        while (!queue.isEmpty()) {
            AnnotatedNode node = queue.poll();
            if (node.node != null) {
                queue.offer(new AnnotatedNode(node.node.left, node.depth + 1, node.pos * 2));
                queue.offer(new AnnotatedNode(node.node.right, node.depth + 1, node.pos * 2 + 1));
                if (currDepth != node.depth) {
                    currDepth = node.depth;
                    left = node.pos;
                }
                maxWidth = Math.max(maxWidth, node.pos - left + 1);
            }
        }
        return maxWidth;
    }

    private int maxWidth = 0;
    private Map<Integer, Integer> leftMap = new HashMap<>();

    public int widthOfBinaryTreeV2(TreeNode root) {
        widthOfBinaryTreeDfs(root, 0, 0);
        return maxWidth;
    }

    public void widthOfBinaryTreeDfs(TreeNode root, int depth, int pos) {
        if (root == null) {
            return;
        }
        leftMap.computeIfAbsent(depth, x -> pos);
        maxWidth = Math.max(maxWidth, pos - leftMap.get(depth) + 1);
        widthOfBinaryTreeDfs(root.left, depth + 1, pos * 2);
        widthOfBinaryTreeDfs(root.right, depth + 1, pos * 2 + 1);
    }

    class AnnotatedNode {
        TreeNode node;
        int depth, pos;

        AnnotatedNode(TreeNode n, int d, int p) {
            node = n;
            depth = d;
            pos = p;
        }
    }


    /**
     * 1443
     * 收集树上所有苹果的最少时间
     * 思路：标记所有走过的路线
     * 注意点：树的父节点是惟一的，在从下往上构建树的路径时，如果路径已存在，说明不需要反转，因为给到的数据是没有方向的
     *
     * @param n
     * @param edges
     * @param hasApple
     * @return int
     * n = 7,
     * edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]],
     * hasApple = [false,false,true,false,true,true,false]
     * <p>
     * n = 7,
     * edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]],
     * hasApple = [false,false,true,false,false,true,false]
     * <p>
     * [[0,2],[0,3],[1,2]]
     */
    int minTimeAns = 0;
    boolean[] visited;

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        Integer[] toFrom = new Integer[n];
        for (int[] edge : edges) {
            if (toFrom[edge[1]] != null) {
                toFrom[edge[0]] = edge[1];
            } else {
                toFrom[edge[1]] = edge[0];
            }
        }
        visited = new boolean[n];
        visited[0] = true;
        for (int i = 0; i < n; i++) {
            if (hasApple.get(i)) {
                minTimeDfs(i, toFrom);
            }
        }
        return minTimeAns * 2;
    }

    public void minTimeDfs(int i, Integer[] toFrom) {
        if (!visited[i]) {
            visited[i] = true;
            minTimeAns++;
            minTimeDfs(toFrom[i], toFrom);
        }
    }


    /**
     * 124
     * 二叉树中的最大路径和
     *
     * @param root
     * @return
     */
    public int maxPathSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxPathSum;
    }

    public int maxGain(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(maxGain(root.left), 0);
        int right = Math.max(maxGain(root.right), 0);
        maxPathSum = Math.max(root.val + left + right, maxPathSum);
        return root.val + Math.max(left, right);
    }
}
