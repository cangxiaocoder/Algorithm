package com.cangxiao.stack;

import java.util.Stack;

/**
 * @Author cangxiao
 * @Date 2021/3/24
 * @Desc 最小栈
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 */
public class MinStack {

    private Integer min = Integer.MAX_VALUE;
    private static Stack<Integer> stack;

    public MinStack() {
        stack = new Stack<>();
    }
    //-2 0 -3

    /**
     * 若当前值小于最小值，现将最小值min栈中，在将当前值放进栈中，
     *
     * @param x
     * @return
     */
    public boolean push(int x) {
        if (x < min) {
            stack.push(min);
        }
        stack.push(x);
        return true;
    }

    /**
     * 如果栈顶元素为最小值，栈顶弹出后，新的栈顶也一定是最小值；
     * 因为新的栈顶元素是 min,
     * 由于min不是我们push的元素，所以需要在pop一次，
     * @return
     */
    public boolean pop() {
        isEmpty();
        if (stack.pop().equals(min)) {
            min = stack.pop();
        }
        return true;
    }

    public int top() {
        isEmpty();
        return stack.get(stack.size() - 1);
    }

    public int getMin() {
        return min;
    }

    public void isEmpty() {
        if (stack.isEmpty()) {
            throw new RuntimeException("栈为空");
        }
    }

}
