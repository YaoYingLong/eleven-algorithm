package com.eleven.icode.algorithm.classic;

/**
 * @author by Eleven on 2022/3/2
 */
public class SquareRoot {
    public static int binarySearch(int x) {
        int left = 0, right = x, index = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (mid * mid <= x) {
                index = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return index;
    }

    public static int newton(int x) {
        if (x == 0) return 0;
        return (int) sqrts(x, x);
    }

    public static double sqrts(double i, int x) {
        double res = (i + x / i) / 2;
        if (res == i) {
            return i;
        } else {
            return sqrts(res, x);
        }
    }
}
