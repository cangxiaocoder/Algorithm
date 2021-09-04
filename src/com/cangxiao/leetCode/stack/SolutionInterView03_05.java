package com.cangxiao.leetCode.stack;

import java.util.Stack;
/**
 * 栈排序。 编写程序，对栈进行排序使最小元素位于栈顶。最多只能使用一个其他的临时栈存放数据，但不得将元素复制到别的数据结构（如数组）中。该栈支持如下操作：push、pop、peek 和 isEmpty。当栈为空时，peek 返回 -1。
 *
 * @Author cangxiao
 * @Date 2021/9/2
 * @Desc 面试题 03.05. 栈排序
 */
public class SolutionInterView03_05 {

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public SolutionInterView03_05() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int val) {
        while (!stack1.isEmpty() && stack1.peek()<val){
            stack2.push(stack1.pop());
        }
        stack1.push(val);
        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
    }

    public void pop() {
        if (isEmpty())return;
        stack1.pop();
    }

    public int peek() {
        if (isEmpty())return -1;
        return stack1.peek();
    }

    public boolean isEmpty() {

        return stack1.isEmpty();
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        System.out.println(stack.pop());
        System.out.println(stack.peek());
    }
}
