package com.eleven.icode.algorithm.leetcode.graph;

import java.util.List;

/**
 * @author by YingLong on 2020/9/3
 */
public class GraphBfsTraversal {

    /**
     * 1203
     * 项目管理
     *
     * @param n
     * @param m
     * @param group
     * @param beforeItems
     * @return
     */
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        int[] result = new int[n];
        return null;
    }

    /**
     * 200. 岛屿数量
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;

        int landNum = 0;
        for (int rowIndex = 0; rowIndex < row; rowIndex++) {
            for (int colIndex = 0; colIndex < col; colIndex++) {
                if (grid[rowIndex][colIndex] == '1') {
                    landNum++;
                    dfs(grid, rowIndex, colIndex);
                }
            }
        }
        return landNum;
    }

    private void dfs(char[][] grid, int rowIndex, int colIndex) {
        if (rowIndex < 0 || colIndex < 0 || rowIndex >= grid.length
                || colIndex >= grid[0].length || grid[rowIndex][colIndex] == '0') {
            return;
        }
        grid[rowIndex][colIndex] = '0';

        dfs(grid, rowIndex + 1, colIndex);
        dfs(grid, rowIndex - 1, colIndex);
        dfs(grid, rowIndex, colIndex + 1);
        dfs(grid, rowIndex, colIndex - 1);
    }
}
