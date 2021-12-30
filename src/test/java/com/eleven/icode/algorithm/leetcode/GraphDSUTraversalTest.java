package com.eleven.icode.algorithm.leetcode;

import com.eleven.icode.algorithm.leetcode.graph.GraphDSUTraversal;
import org.junit.Test;

/**
 * @author by YingLong on 2020/12/16
 */
public class GraphDSUTraversalTest {

    @Test
    public void regionsBySlashesTest() {
        GraphDSUTraversal graphDSUTraversal = new GraphDSUTraversal();
        String[] grid = new String[]{"\\/", "/\\"};
        System.out.println(graphDSUTraversal.regionsBySlashes(grid));
        System.out.println(graphDSUTraversal.regionsBySlashesV2(grid));
    }


    @Test
    public void findRedundantConnectionTest() {
        GraphDSUTraversal graphDSUTraversal = new GraphDSUTraversal();
        int[][] data = {{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}};
        System.out.println(graphDSUTraversal.findRedundantConnection(data));
    }


}
