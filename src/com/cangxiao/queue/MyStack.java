package com.cangxiao.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author cangxiao
 * @Date 2022/10/5
 * @Desc 用队列实现栈
 */
public class MyStack {

    private final Queue<Integer> queue1;
    private final Queue<Integer> queue2;
    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int x) {
        while (!queue1.isEmpty()){
            queue2.offer(queue1.poll());
        }
        queue1.offer(x);
        while (!queue2.isEmpty()){
            queue1.offer(queue2.poll());
        }

    }

    public int pop() {
        if (!queue1.isEmpty()){
            return queue1.poll();
        }
        return -1;
    }

    public int top() {
        if (!queue1.isEmpty()){
            return queue1.peek();
        }
        return -1;
    }

    public boolean empty() {
        return queue1.isEmpty()&&queue2.isEmpty();
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        System.out.println("stack.top() = " + stack.top());
        System.out.println("stack.pop() = " + stack.pop());
        System.out.println("stack.empty() = " + stack.empty());
    }
}
