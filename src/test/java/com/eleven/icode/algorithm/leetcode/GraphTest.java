package com.eleven.icode.algorithm.leetcode;

import com.eleven.icode.algorithm.leetcode.graph.GraphBaseTraversal;
import org.junit.Test;

import java.util.List;

/**
 * @author by YingLong on 2020/9/4
 */
public class GraphTest {

    @Test
    public void getKthTest() {
        GraphBaseTraversal traversal = new GraphBaseTraversal();
        System.out.println(traversal.getKth(12, 13, 2));
    }

    @Test
    public void allCellsDistOrderTest() {
        GraphBaseTraversal traversal = new GraphBaseTraversal();
        int[][] ret = traversal.allCellsDistOrder(5, 4, 2, 2);
        for (int i = 0; i < ret.length; i++) {
            for (int j = ret[i].length - 1; j >= 0; j--) {
                System.out.print(ret[i][j] + " ");
            }
            System.out.println();
        }
    }

    @Test
    public void allPathsSourceTargetTest() {
        GraphBaseTraversal traversal = new GraphBaseTraversal();
        {
            int[][] graph = {{4,3,1},{3,2,4},{3},{4},{}};
            for (List<Integer> integers : traversal.allPathsSourceTarget(graph)) {
                for (Integer integer : integers) {
                    System.out.print(integer + " ");
                }
                System.out.println();
            }
        }
        System.out.println("--------------------");
        {
            int[][] graph = {{4,3,1},{3,2,4},{},{4},{}};
            for (List<Integer> integers : traversal.allPathsSourceTarget(graph)) {
                for (Integer integer : integers) {
                    System.out.print(integer + " ");
                }
                System.out.println();
            }
        }
    }
}
