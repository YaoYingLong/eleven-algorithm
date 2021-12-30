package com.eleven.icode.algorithm.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author by YingLong on 2020/7/27
 */
public class ReverseInt32Test {

    @Test
    public void reverseInt32Test() {
        assertEquals(ReverseInt32.reverse(1), 1);
        assertEquals(ReverseInt32.reverse(16), 61);
        assertEquals(ReverseInt32.reverse(163), 361);
        assertEquals(ReverseInt32.reverse(1632), 2361);
        assertEquals(ReverseInt32.reverse(16325), 52361);
        assertEquals(ReverseInt32.reverse(163257), 752361);
        assertEquals(ReverseInt32.reverse(1632579), 9752361);
        assertEquals(ReverseInt32.reverse(16325790), 9752361);
        assertEquals(ReverseInt32.reverse(163257902), 209752361);
        assertEquals(ReverseInt32.reverse(1632579021), 1209752361);
        assertEquals(ReverseInt32.reverse(-1), -1);
        assertEquals(ReverseInt32.reverse(-16), -61);
        assertEquals(ReverseInt32.reverse(-163), -361);
        assertEquals(ReverseInt32.reverse(-1632), -2361);
        assertEquals(ReverseInt32.reverse(-16325), -52361);
        assertEquals(ReverseInt32.reverse(-163257), -752361);
        assertEquals(ReverseInt32.reverse(-1632579), -9752361);
        assertEquals(ReverseInt32.reverse(-16325790), -9752361);
        assertEquals(ReverseInt32.reverse(-163257902), -209752361);
        assertEquals(ReverseInt32.reverse(-1632579021), -1209752361);
    }

}
