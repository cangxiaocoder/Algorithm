package com.cangxiao.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author cangxiao
 * @Date 2022/10/5
 * @Desc 用单队列实现栈
 */
public class MyStack2 {

    private final Queue<Integer> queue;
    public MyStack2() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        queue.offer(x);
    }

    public int pop() {
        if (queue.isEmpty()) return -1;
        for (int i = 0; i < queue.size() - 1; i++) {
            queue.offer(queue.poll());
        }
        return queue.poll();
    }

    public int top() {
        if (queue.isEmpty()) return -1;
        for (int i = 0; i < queue.size() - 1; i++) {
            queue.offer(queue.poll());
        }
        Integer result = queue.poll();
        queue.offer(result);
        return result;
    }

    public boolean empty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        MyStack2 stack = new MyStack2();
        stack.push(1);
        stack.push(2);
        System.out.println("stack.top() = " + stack.top());
        System.out.println("stack.pop() = " + stack.pop());
        System.out.println("stack.empty() = " + stack.empty());
    }
}
