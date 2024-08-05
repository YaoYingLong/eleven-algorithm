package com.eleven.icode.algorithm.leetcode.graph;

import javax.xml.transform.Result;
import java.awt.datatransfer.ClipboardOwner;
import java.util.*;

/**
 * @author by YingLong on 2020/9/3
 */
public class GraphDfsTraversal {

    private Map<Node, Node> nodeMap = new HashMap<>();

    /**
     * 133
     * 克隆图
     *
     * @param node
     * @return
     */
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        if (nodeMap.containsKey(node)) {
            return nodeMap.get(node);
        }

        Node cloneNode = new Node(node.val, new ArrayList<>());
        nodeMap.put(node, cloneNode);

        for (Node neighbor : node.neighbors) {
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }
        return cloneNode;
    }

    /**
     * 133
     * 克隆图
     *
     * @param node
     * @return
     */
    public Node cloneGraphBfs(Node node) {
        if (node == null) {
            return null;
        }

        Map<Node, Node> nodeMap = new HashMap<>();
        Node cloneNode = new Node(node.val, new ArrayList<>());
        nodeMap.put(node, cloneNode);

        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);

        while (!queue.isEmpty()) {
            Node n = queue.poll();
            for (Node neighbor : n.neighbors) {
                if (!nodeMap.containsKey(neighbor)) {
                    queue.offer(neighbor);
                    Node cloneNeighNode = new Node(neighbor.val, new ArrayList<>());
                    nodeMap.put(neighbor, cloneNeighNode);
                }
                nodeMap.get(n).neighbors.add(nodeMap.get(neighbor));
            }
        }
        return cloneNode;
    }

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }


    /**
     * 841
     * 钥匙和房间
     *
     * @param rooms
     * @return
     */
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] vst = new boolean[rooms.size()];
        dfsRooms(rooms, 0, vst);
        for (boolean b : vst) {
            if (!b) {
                return false;
            }
        }
        return true;
    }

    public void dfsRooms(List<List<Integer>> rooms, Integer key, boolean[] vst) {
        vst[key] = true;
        List<Integer> keyList = rooms.get(key);
        for (Integer room : keyList) {
            if (!vst[room]) {
                dfsRooms(rooms, room, vst);
            }
        }
    }

    /**
     * 79. 单词搜索
     */
    public boolean exist(char[][] board, String word) {
        int h = board.length, w = board[0].length;
        boolean[][] mark = new boolean[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                boolean flag = dfs(board, mark, i, j, word, 0);
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }

    int[][] next = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public boolean dfs(char[][] board, boolean[][] mark, int x, int y, String word, int index) {
        if (board[x][y] != word.charAt(index)) {
            return false;
        }
        if (index == word.length() - 1) {
            return true;
        }
        mark[x][y] = true;
        boolean result = false;
        int h = board.length, w = board[0].length;
        for (int i = 0; i < 4; i++) {
            int nextx = x + next[i][0];
            int nexty = y + next[i][1];
            if (nextx < 0 || nexty < 0 || nextx > h - 1 || nexty > w - 1) {
                continue;
            }
            if (!mark[nextx][nexty]) {
                boolean flag = dfs(board, mark, nextx, nexty, word, index + 1);
                if (flag) {
                    result = true;
                    break;
                }
            }
        }
        mark[x][y] = false;
        return result;
    }

}
