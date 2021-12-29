package com.eleven.icode.algorithm.sort;

import org.junit.Test;

/**
 * Created by YLongYao on 2016/10/19.
 */
public class Fibonacci {

    private int FibonacciFirst(int n) {
        int f0 = 0, f1 = 1, f = 0;
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        for (int k = 2; k <= n; k++) {
            f = f0 + f1;
            f0 = f1;
            f1 = f;
        }
        return f;
    }

    private int FibonacciSecond(int n) throws Exception {
        if (n < 0) {
            throw new Exception("Place input n > 0");
        }
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return FibonacciSecond(n - 1) + FibonacciSecond(n - 2);
    }

    @Test
    public void FibonacciTest() throws Exception {
        for (int k = 1; k < 15; k++) {
            System.out.println("FibonacciFirst(" + k + "):" + FibonacciFirst(k));
        }
        System.out.println("-----------------------------");
        System.out.println("FibonacciSecond():" + FibonacciSecond(-2));
        for (int k = 1; k < 15; k++) {
            System.out.println("FibonacciSecond(" + k + "):" + FibonacciSecond(k));
        }
    }

}
