package com.eleven.icode.algorithm.leetcode.entity;

/**
 * @author by YingLong on 2020/8/30
 */
public class Location implements Comparable<Location> {
    public int x, y, val;

    public Location(int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    @Override
    public int compareTo(Location o) {
        if (this.x != o.x) {
            return Integer.compare(this.x, o.x);
        } else if (this.y != o.y) {
            return Integer.compare(this.y, o.y);
        } else {
            return Integer.compare(this.val, o.val);
        }
    }
}
