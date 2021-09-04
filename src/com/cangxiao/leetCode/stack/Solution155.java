package com.cangxiao.leetCode.stack;

import java.util.Stack;

/**
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) —— 将元素 x 推入栈中。
 * pop()—— 删除栈顶的元素。
 * top()—— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 *
 * @Author cangxiao
 * @Date 2021/9/2
 * @Desc 155. 最小栈
 */
public class Solution155 {

    private Stack<Integer> stack;

    private int min = Integer.MAX_VALUE;

    /** initialize your data structure here. */
    public Solution155() {
        stack = new Stack<>();
    }

    public void push(int val) {
        if (stack.isEmpty()){
            stack.push(val);
            min = val;
            return;
        }
        if(val<=min){
            stack.push(min);
            min = val;
        }
        stack.push(val);
    }

    public void pop() {
        if (stack.isEmpty()) return;
        if (stack.pop().equals(min)){
            if (stack.isEmpty())return;
            min = stack.pop();
        }
    }

    public int top() {
        if (stack.isEmpty())return -1;
       return stack.peek();
    }

    public int getMin() {
        return min;
    }

    public static void main(String[] args) {
        Solution155 solution155 = new Solution155();
        solution155.push(Integer.MAX_VALUE);
        solution155.push(Integer.MAX_VALUE);
        solution155.push(Integer.MAX_VALUE);
        System.out.println(solution155.top());
        solution155.pop();
        System.out.println(solution155.getMin());
        solution155.pop();
        System.out.println(solution155.getMin());
        solution155.pop();
        solution155.push(Integer.MAX_VALUE);
        System.out.println(solution155.top());
        System.out.println(solution155.getMin());
        solution155.push(Integer.MIN_VALUE);
        System.out.println(solution155.top());
        System.out.println(solution155.getMin());
        solution155.pop();
        System.out.println(solution155.getMin());

    }
}
