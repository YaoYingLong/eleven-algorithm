package com.eleven.icode.algorithm.leetcode.graph;

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


}
