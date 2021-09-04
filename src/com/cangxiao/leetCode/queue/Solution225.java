package com.cangxiao.leetCode.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、top、pop 和 empty）。
 *
 * 实现 MyStack 类：
 *
 * void push(int x) 将元素 x 压入栈顶。
 * int pop() 移除并返回栈顶元素。
 * int top() 返回栈顶元素。
 * boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。
 *
 * 注意：
 *
 * 你只能使用队列的基本操作 —— 也就是push to back、peek/pop from front、size 和is empty这些操作。
 * 你所使用的语言也许不支持队列。你可以使用 list （列表）或者 deque（双端队列）来模拟一个队列, 只要是标准的队列操作即可。
 * @Author cangxiao
 * @Date 2021/9/2
 * @Desc 225. 用队列实现栈
 */
public class Solution225 {

    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    /** Initialize your data structure here. */
    public Solution225() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue1.offer(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        while (!queue1.isEmpty()){
            int value = queue1.poll();
            if(queue1.isEmpty()){
                return value;
            }
            queue2.offer(value);
        }
        while (!queue2.isEmpty()){
            int value = queue2.poll();
            if(queue2.isEmpty()){
                return value;
            }
            queue1.offer(value);
        }
        return -1;
    }

    /** Get the top element. */
    public int top() {
        int value = -1;
        while (!queue1.isEmpty()){
            int temp = queue1.poll();
            if(queue1.isEmpty()){
                value =temp;
            }
            queue2.offer(temp);
        }
        while (!queue2.isEmpty()){
            int temp = queue2.poll();
            if(queue2.isEmpty()){
                value =temp;
            }
            queue1.offer(temp);
        }
        return value;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {

        return queue1.isEmpty() && queue2.isEmpty();
    }

    public static void main(String[] args) {

    }
}
