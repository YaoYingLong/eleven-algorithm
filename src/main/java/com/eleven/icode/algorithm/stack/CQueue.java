package com.eleven.icode.algorithm.stack;

import java.util.Stack;

/**
 * @author by YingLong on 2022/3/25
 */
public class CQueue {
    private Stack<Integer> inStack;
    private Stack<Integer> outStack;
    public CQueue() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    public void appendTail(int value) {
        inStack.push(value);
    }

    public int deleteHead() {
        if (outStack.isEmpty()) {
            if (inStack.isEmpty()) {
                return -1;
            }
            in2Out();
        }
        return outStack.pop();
    }

    private void in2Out() {
        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
    }
}
