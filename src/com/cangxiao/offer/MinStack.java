package com.cangxiao.offer;

import java.util.Stack;

/**
 * @Author cangxiao
 * @Date 2021/8/17
 * @Desc 最小栈
 */
public class MinStack {

    private Stack<Integer> stack;
    private int min = Integer.MAX_VALUE;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
    }

    /**
     * 如果之前的值是最小值就多放一次作为之前值的最小值记录
     * @param x
     */
    public void push(int x) {
        if (stack.isEmpty()){
            min = x;
            stack.push(x);
            return;
        }
        if (x<=min){
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
        if (stack.isEmpty())return;

        if (stack.pop().equals(min)){
            if (stack.isEmpty())return;
            min = stack.pop();
            return;
        }
        stack.pop();
    }

    public int top() {
        if (stack.isEmpty())return -1;
        return stack.peek();
    }

    public int min() {
        return min;
    }
}
