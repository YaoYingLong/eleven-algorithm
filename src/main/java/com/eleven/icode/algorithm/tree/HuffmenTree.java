package com.eleven.icode.algorithm.tree;

import java.util.*;

/**
 * 哈夫曼树是利用，完全二叉树，即除了最底层都有两个子节点，而且叶子节点是靠左连续的树
 * 给定N个权值作为N个叶子结点，构造一棵二叉树，若该树带权路径长度最小，称这样的二叉树为最优二叉树，也称为哈夫曼树(Huffman Tree)。
 * 哈夫曼树是带权路径长度最短的树，权值较大的结点离根较近。
 * <p>
 * 这时候要想到二进制，二叉分左右，左节点的边设置为0，右节点的边设置为1
 * <p>
 * 核心思想：贪心算法：利用局部最优推出全局最优，把频率出现多的用短码表示，频率出现小的就用长一点。且任何一个字符编码都不是另一个的前缀，
 * 在解压缩时，每次会读取尽可能长的可解压的二进制串，所以在解压缩时也不会产生歧义。
 * <p>
 * 具体实现思路：
 * 1.每次取数值最小的两个节点，将之组成为一颗子树，可规定权值晓得为左节点，权值大的为右节点
 * 2.移除原来的两个点
 * 3.然后将组成的子树放入原来的序列中
 * 4.重复执行1 2 3 直到只剩最后一个点
 */
public class HuffmenTree {
    HfmNode root;
    List<HfmNode> leafs;                // 叶子节点
    Map<Character, Integer> weights;    // 叶子节点的权重, a,b,c,d,e

    public HuffmenTree(Map<Character, Integer> weights) {
        this.weights = weights;
        leafs = new ArrayList<HfmNode>();
    }

    public void decode() { // 解码

    }

    public void encode() { // 编码

    }

    // 叶子节点进行编码
    public Map<Character, String> code() {
        Map<Character, String> map = new HashMap<>();
        for (HfmNode node : leafs) {
            String code = "";
            Character c = new Character(node.chars.charAt(0)); // 叶子节点肯定只有一个字符
            HfmNode current = node; // 只有一个点
            do {
                if (current.parent != null && current == current.parent.left) { // 说明当前点是左边
                    code = "0" + code;
                } else {
                    code = "1" + code;
                }
                current = current.parent;
            } while (current.parent != null); // parent == null就表示到了根节点
            map.put(c, code);
            System.out.println(c + ":" + code);
        }
        return map;
    }

    public void creatTree() {
        Character keys[] = weights.keySet().toArray(new Character[0]);            // 拿出所有的点
        PriorityQueue<HfmNode> priorityQueue = new PriorityQueue<HfmNode>();    // jdk底层的优先队列
        for (Character c : keys) {
            HfmNode hfmNode = new HfmNode();
            hfmNode.chars = c.toString();
            hfmNode.fre = weights.get(c);    // 权重
            priorityQueue.add(hfmNode);    // 首先把优先队列初始化进去
            leafs.add(hfmNode);
        }
        int len = priorityQueue.size();
        for (int i = 1; i <= len - 1; i++) {    // 每次找最小的两个点合并
            HfmNode n1 = priorityQueue.poll();
            HfmNode n2 = priorityQueue.poll();    // 每次取优先队列的前面两个 就一定是两个最小的

            HfmNode newNode = new HfmNode();
            newNode.chars = n1.chars + n2.chars;    // 把值赋值一下，也可以不复制
            newNode.fre = n1.fre + n2.fre;            // 把权重相加
            // 维护出树的结构
            newNode.left = n1;
            newNode.right = n2;
            n1.parent = newNode;
            n2.parent = newNode;
            priorityQueue.add(newNode);
        }
        root = priorityQueue.poll();    // 最后这个点就是根节点
    }

    /**
     * a:10110
     * b:01
     * c:1010
     * d:00
     * e:11
     * f:10111
     * g:100
     */
    public static void main(String[] args) {
        Map<Character, Integer> weights = new HashMap<Character, Integer>();
        // 一般：动态加密，最开始是不知道里面有什么内容的。需要一个密码本，往往是某个字典。若是英文就用英文字典，统计次数。
        // 静态的文件。针对性的做编码，图像加密，没有特性的 hash加密（MD5）
        weights.put('a', 3);
        weights.put('b', 24);
        weights.put('c', 6);
        weights.put('d', 1);
        weights.put('e', 34);
        weights.put('f', 4);
        weights.put('g', 12);
        HuffmenTree huffmenTree = new HuffmenTree(weights);
        huffmenTree.creatTree();
        Map<Character, String> codeMap = huffmenTree.code();
        String str = "aceg";
        System.out.println("编码后的：");
        char[] tests = str.toCharArray();
        for (char test : tests) {
            System.out.print(codeMap.get(test));
        }
    }
}
