package com.eleven.icode.algorithm.leetcode.graph;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 通过并查集的方式
 *
 * @author by YingLong on 2020/12/16
 */
public class GraphDSUTraversal {

    /**
     * 959. 由斜杠划分区域
     * <p>
     * 创建 4*N*N 个顶点，每个代表一个三角形，按照如上的方式连接它们。然后使用并查集算法找到连通块的总数。
     * 这里将每个最小的正方形分成是个小三角形，并对每个小三角形进行编号标记，这里的编号顺序是：上0，下3，左1，右2
     *
     * @param grid
     * @return
     */
    public int regionsBySlashes(String[] grid) {
        int N = grid.length;
        DSU dsu = new DSU(4 * N * N);
        for (int r = 0; r < N; ++r) {
            for (int c = 0; c < N; ++c) {
                int root = 4 * (r * N + c);
                char val = grid[r].charAt(c);
                if (val != '\\') {
                    dsu.union(root + 0, root + 1);
                    dsu.union(root + 2, root + 3);
                }
                if (val != '/') {
                    dsu.union(root + 0, root + 2);
                    dsu.union(root + 1, root + 3);
                }

                if (r + 1 < N) {
                    dsu.union(root + 3, (root + 4 * N) + 0);
                }
                if (c + 1 < N) {
                    dsu.union(root + 2, (root + 4) + 1);
                }
            }
        }
        int ans = 0;
        for (int x = 0; x < 4 * N * N; ++x) {
            if (dsu.find(x) == x) {
                ans++;
            }
        }
        return ans;
    }

    public int regionsBySlashesV2(String[] grid) {
        int N = grid.length;
        DSU dsu = new DSU(4 * N * N);
        dsu.init(4 * N * N);
        for (int r = 0; r < N; ++r) {
            for (int c = 0; c < N; ++c) {
                int root = 4 * (r * N + c);
                char val = grid[r].charAt(c);
                if (val != '\\') {
                    dsu.merge(root + 0, root + 1);
                    dsu.merge(root + 2, root + 3);
                }
                if (val != '/') {
                    dsu.merge(root + 0, root + 2);
                    dsu.merge(root + 1, root + 3);
                }

                if (r + 1 < N) {
                    dsu.merge(root + 3, (root + 4 * N) + 0);
                }
                if (c + 1 < N) {
                    dsu.merge(root + 2, (root + 4) + 1);
                }
            }
        }
        int ans = 0;
        for (int x = 0; x < 4 * N * N; ++x) {
            if (dsu.find(x) == x) {
                ans++;
            }
        }
        return ans;
    }

    class DSU {
        int[] parent;
        int[] rank;

        public DSU(int N) {
            parent = new int[N];
            for (int n = 0; n < N; ++n) {
                parent[n] = n;
            }
        }

        public void init(int N) {
            parent = new int[N];
            rank = new int[N];
            for (int n = 0; n < N; ++n) {
                parent[n] = n;
                rank[n] = 1;
            }
        }

        public int find(int x) {
            return parent[x] == x ? x : find(parent[x]);
        }

        public int findCompress(int x) {
            return parent[x] == x ? x : (parent[x] = find(parent[x]));
        }

        public void merge(int i, int j) {
            int x = find(i), y = find(j);
            if (rank[x] <= rank[y]) {
                parent[x] = y;
            } else {
                parent[y] = x;
            }
            if (rank[x] == rank[y] && x != y) {
                rank[y]++;
            }
        }

        public void union(int x, int y) {
            parent[find(x)] = find(y);
        }
    }

    int[] result = new int[2];

    /**
     * 684
     * 冗余连接
     *
     * @param edges
     * @return
     */
    public int[] findRedundantConnection(int[][] edges) {
        int[] fa = new int[edges.length + 1];
        for (int i = 0; i < fa.length; i++) {
            fa[i] = i;
        }

        for (int[] edge : edges) {
            union(fa, edge[0], edge[1]);
        }
        return result;
    }

    public void union(int[] fa, int a, int b) {
        int rootA = find(fa, a);
        int rootB = find(fa, b);
        if (rootA != rootB) {
            fa[rootA] = rootB;
        } else {
            result[0] = a;
            result[1] = b;
        }
    }

    public int find(int[] fa, int a) {
        return fa[a] == a ? a : (fa[a] = find(fa, fa[a]));
    }

    /**
     * 1267
     * 统计参与通信的服务器
     *
     * @param grid
     * @return
     */
    public int countServers(int[][] grid) {
        int[] row = new int[grid.length];
        int[] col = new int[grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    row[i]++;
                    col[j]++;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && (row[i] > 1 || col[j] > 1)) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 990
     * 等式方程的可满足性
     *
     * @param equations
     * @return
     */
    public boolean equationsPossible(String[] equations) {
        int[] fa = new int[26];
        for (int i = 0; i < 26; i++) {
            fa[i] = i;
        }
        for (String equation : equations) {
            if (equation.charAt(1) == '=') {
                int left = equation.charAt(0) - 'a';
                int right = equation.charAt(3) - 'a';
                union990(fa, left, right);
            }
        }
        for (String equation : equations) {
            if (equation.charAt(1) == '!') {
                int left = equation.charAt(0) - 'a';
                int right = equation.charAt(3) - 'a';
                if (find990(fa, left) == find990(fa, right)) {
                    return false;
                }
            }
        }
        return true;
    }

    private int find990(int[] fa, int left) {
        return fa[left] == left ? left : (fa[left] = find990(fa, fa[left]));
    }

    private void union990(int[] fa, int left, int right) {
        fa[find990(fa, left)] = find990(fa, right);
    }

    /**
     * 399
     * 除法求值
     *
     * @param equations
     * @param values
     * @param queries
     * @return
     */
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        UnionFind unionFind = new UnionFind(2 * equations.size());
        int id = 0;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            String varX = equation.get(0);
            String varY = equation.get(1);
            if (!map.containsKey(varX)) {
                map.put(varX, id++);
            }
            if (!map.containsKey(varY)) {
                map.put(varY, id++);
            }
            unionFind.union(map.get(varX), map.get(varY), values[i]);
        }

        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String varX = query.get(0);
            String varY = query.get(1);
            if (map.get(varX) == null || map.get(varY) == null) {
                result[i] = -1.0d;
                continue;
            }
            result[i] = unionFind.isConnect(map.get(varX), map.get(varY));
        }
        return result;
    }

    private class UnionFind {
        private int[] fa;

        private double[] weight;

        public UnionFind(int n) {
            fa = new int[n];
            weight = new double[n];
            for (int i = 0; i < n; i++) {
                fa[i] = i;
                weight[i] = 1.0d;
            }
        }

        public void union(int x, int y, double value) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }
            fa[rootX] = rootY;
            weight[rootX] = weight[y] * value / weight[x];
        }

        public int find(int x) {
            if (fa[x] != x) {
                int origin = fa[x];
                fa[x] = find(fa[x]);
                weight[x] *= weight[origin];
            }
            return fa[x];
        }

        public double isConnect(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return weight[x] / weight[y];
            } else {
                return -1.0d;
            }
        }
    }
}
