package com.eleven.icode.algorithm.leetcode.tree;

import com.eleven.icode.algorithm.leetcode.entity.ListNode;
import com.eleven.icode.algorithm.leetcode.entity.Location;
import com.eleven.icode.algorithm.leetcode.entity.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 前序遍历相关的题
 *
 * @author by YingLong on 2020/7/31
 */
public class PreorderTraversal {

    /**
     * 404
     * 左叶子之和
     *
     * @param root
     * @return
     */
    public int sumOfLeftLeaves(TreeNode root) {
        return leftLeaves(root.right, false);
    }

    public int leftLeaves(TreeNode root, boolean flag) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return flag ? root.val : 0;
        }
        int leftVal = leftLeaves(root.left, true);
        int rightVal = leftLeaves(root.right, false);
        return leftVal + rightVal;
    }

    /**
     * 404
     * 左叶子之和
     *
     * @param root
     * @return
     */
    public int sumOfLeftLeavesV2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int ans = 0;
        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) {
                ans += root.left.val;
            } else {
                ans += sumOfLeftLeavesV2(root.left);
            }
        }
        if (root.right != null) {
            ans += sumOfLeftLeavesV2(root.right);
        }
        return ans;
    }

    /**
     * 572
     * 另一个树的子树
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }
        return isSameTree(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;

        }
        boolean isSame = isSameTree(p.left, q.left);
        if (!isSame) {
            return false;
        }
        return isSameTree(p.right, q.right);
    }


    /**
     * 617
     * 合并二叉树
     *
     * @param t1
     * @param t2
     * @return
     */
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }

    /**
     * 剑指 Offer 26
     * 树的子结构
     *
     * @param A
     * @param B
     * @return
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B == null || A == null) {
            return false;
        }
        return isSubTree(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    public boolean isSubTree(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null || A.val != B.val) {
            return false;
        }
        return isSubTree(A.left, B.left) && isSubTree(A.right, B.right);
    }

    /**
     * 1008
     * 先序遍历构造二叉树
     *
     * @param preorder
     * @return
     */
    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        int[] inorder = Arrays.copyOf(preorder, preorder.length);
        Arrays.sort(inorder);
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        return generateTree(preorder, 0, preorder.length - 1, 0, indexMap);
    }

    public TreeNode generateTree(int[] preorder, int preLeft, int preRight, int inLeft, Map<Integer, Integer> indexMap) {
        if (preLeft > preRight) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preLeft]);
        if (preLeft == preRight) {
            return root;
        }
        int rootIndex = indexMap.get(root.val);
        int leftNodes = rootIndex - inLeft;
        root.left = generateTree(preorder, preLeft + 1, preLeft + leftNodes, inLeft, indexMap);
        root.right = generateTree(preorder, preLeft + leftNodes + 1, preRight, rootIndex + 1, indexMap);
        return root;
    }

    public TreeNode bstFromPreorderV2(int[] preorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        int[] inorder = Arrays.copyOf(preorder, preorder.length);
        Arrays.sort(inorder);
        TreeNode root = new TreeNode(preorder[0]);
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int inorderIndex = 0;
        for (int i = 1; i < preorder.length; i++) {
            int preVal = preorder[i];
            TreeNode node = stack.peek();
            if (node.val != inorder[inorderIndex]) {
                node.left = new TreeNode(preVal);
                stack.push(node.left);
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex++;
                }
                node.right = new TreeNode(preVal);
                stack.push(node.right);
            }
        }
        return root;
    }

    public int index = 0;

    public TreeNode bstFromPreorderV3(int[] preorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        return generateTreeV3(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public TreeNode generateTreeV3(int[] preorder, int lower, int upper) {
        if (index == preorder.length) {
            return null;
        }
        int rootVal = preorder[index];
        if (rootVal > upper || rootVal < lower) {
            return null;
        }
        index++;
        TreeNode root = new TreeNode(rootVal);
        root.left = generateTreeV3(preorder, lower, rootVal);
        root.right = generateTreeV3(preorder, rootVal, upper);
        return root;
    }

    public TreeNode bstFromPreorderV4(int[] preorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        for (int i = 1; i < preorder.length; i++) {
            TreeNode node = stack.peek();
            TreeNode child = new TreeNode(preorder[i]);
            while (!stack.isEmpty() && stack.peek().val < child.val) {
                node = stack.pop();
            }
            if (node.val > child.val) {
                node.left = child;
            } else {
                node.right = child;
            }
            stack.push(child);
        }
        return root;
    }

    /**
     * @param root
     * @return
     */
    private int maxDepth = -1;
    private int total = 0;

    public int deepestLeavesSum(TreeNode root) {
        deepestLeavesSumDfs(root, 0);
        return total;
    }

    public void deepestLeavesSumDfs(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (depth > maxDepth) {
            maxDepth = depth;
            total = root.val;
        } else if (depth == maxDepth) {
            total += root.val;
        }
        deepestLeavesSumDfs(root.left, depth + 1);
        deepestLeavesSumDfs(root.right, depth + 1);
    }

    /**
     * @param root
     */
    public TreeNode cur = new TreeNode(0);

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode leftNode = root.left;
        TreeNode rightNode = root.right;
        cur.left = null;
        cur.right = root;
        cur = root;
        flatten(leftNode);
        flatten(rightNode);
    }

    public void flattenV2(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode ans = new TreeNode(0);
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            ans.left = null;
            ans.right = node;
            ans = node;
            TreeNode left = node.left, right = node.right;
            if (right != null) {
                stack.push(right);
            }
            if (left != null) {
                stack.push(left);
            }
        }
    }

    /**
     * 1379
     * 找出克隆二叉树中的相同节点
     *
     * @param original
     * @param cloned
     * @param target
     * @return
     */
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (cloned == null || target == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(cloned);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.val == target.val) {
                return node;
            }
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return null;
    }

    public final TreeNode getTargetCopyV2(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (cloned == null || target == null) {
            return null;
        }
        if (cloned.val == target.val) {
            return cloned;
        }
        TreeNode leftNode = getTargetCopy(original, cloned.left, target);
        TreeNode rightNode = getTargetCopy(original, cloned.right, target);
        if (leftNode == null) {
            return rightNode;
        }
        return leftNode;
    }

    /**
     * 1028
     * 从先序遍历还原二叉树
     *
     * @param S
     * @return
     */
    public TreeNode recoverFromPreorder(String S) {
        if (S == null || S.length() == 0) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        int index = 0;
        while (index < S.length()) {
            int level = 0;
            while (S.charAt(index) == '-') {
                ++level;
                ++index;
            }
            int value = 0;
            while (index < S.length() && Character.isDigit(S.charAt(index))) {
                value = value * 10 + S.charAt(index) - '0';
                ++index;
            }
            TreeNode node = new TreeNode(value);
            if (level == stack.size()) {
                if (!stack.isEmpty()) {
                    stack.peek().left = node;
                }
            } else {
                while (level != stack.size()) {
                    stack.pop();
                }
                stack.peek().right = node;
            }
            stack.push(node);
        }
        while (stack.size() > 1) {
            stack.pop();
        }
        return stack.peek();
    }

    /**
     * 113
     * 路径总和 II
     *
     * @param root
     * @param sum
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> resultList = new ArrayList<>();
        if (root == null) {
            return resultList;
        }
        sum -= root.val;
        List<List<Integer>> left = pathSum(root.left, sum);
        List<List<Integer>> right = pathSum(root.right, sum);
        for (List<Integer> subList : left) {
            subList.add(0, root.val);
        }
        for (List<Integer> subList : right) {
            subList.add(0, root.val);
        }
        if (root.left == null && root.right == null && sum == 0) {
            List<Integer> subList = new ArrayList<>();
            subList.add(root.val);
            resultList.add(subList);
            return resultList;
        }
        resultList.addAll(left);
        resultList.addAll(right);
        return resultList;
    }

    List<List<Integer>> res = new ArrayList();

    public List<List<Integer>> pathSumV2(TreeNode root, int sum) {
        // 定义一个有序list来存储路径
        LinkedList<Integer> temp = new LinkedList<>();
        helper(root, sum, temp);
        return res;
    }

    public void helper(TreeNode node, int sum, LinkedList<Integer> temp) {
        if (node == null) {
            return;
        }
        // 记录路径
        temp.addLast(node.val);
        if (node.left == null && node.right == null && sum == node.val) {
            res.add(new ArrayList(temp));
        }
        helper(node.left, sum - node.val, temp);
        helper(node.right, sum - node.val, temp);
        // 重点，遍历完后，需要把当前节点remove出去，因为用的是同一个list对象来存所有的路径
        temp.removeLast();
    }

    /**
     * 971
     * 翻转二叉树以匹配先序遍历
     *
     * @param root
     * @param voyage
     * @return
     */
    public int flipIndex = 0;
    public List<Integer> resultList = new ArrayList<>();

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        flipMatchVoyageDfs(root, voyage);
        return resultList;
    }

    public boolean flipMatchVoyageDfs(TreeNode root, int[] voyage) {
        if (root == null || flipIndex > voyage.length - 1) {
            return true;
        }
        if (root.val != voyage[flipIndex++]) {
            resultList.clear();
            resultList.add(-1);
            return false;
        }
        if (root.left != null && voyage[flipIndex] != root.left.val) {
            resultList.add(root.val);
            return flipMatchVoyageDfs(root.right, voyage) && flipMatchVoyageDfs(root.left, voyage);
        }
        return flipMatchVoyageDfs(root.left, voyage) && flipMatchVoyageDfs(root.right, voyage);
    }

    /**
     * 987
     * 二叉树的垂序遍历
     *
     * @param root
     * @return
     */
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, List<Location>> resultMap = new TreeMap<>();
        verticalTraversalDfs(root, 0, 0, resultMap);

        List<List<Integer>> result = new ArrayList<>();
        for (Integer index : resultMap.keySet()) {
            List<Location> subList = resultMap.get(index);
            Collections.sort(subList);
            result.add(subList.stream().map(Location::getVal).collect(Collectors.toList()));
        }
        return result;
    }

    public void verticalTraversalDfs(TreeNode root, int x, int y, Map<Integer, List<Location>> resultMap) {
        if (root == null) {
            return;
        }
        List<Location> subList = resultMap.getOrDefault(x, new ArrayList<>());
        subList.add(new Location(x, y, root.val));
        resultMap.put(x, subList);
        verticalTraversalDfs(root.left, x - 1, y + 1, resultMap);
        verticalTraversalDfs(root.right, x + 1, y + 1, resultMap);
    }

    /**
     * 1367
     * 二叉树中的列表
     *
     * @param head
     * @param root
     * @return
     */
    public boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null) {
            return false;
        }
        return isSubPathDfs(head, root)|| isSubPath(head, root.left)|| isSubPath(head, root.right);
}

    public boolean isSubPathDfs(ListNode head, TreeNode root) {
        if (head == null) {
            return true;
        }

        if (root == null || root.val != head.val) {
            return false;
        }

        return isSubPathDfs(head.next, root.left) || isSubPathDfs(head.next, root.right);
    }
}
