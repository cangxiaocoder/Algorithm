package com.cangxiao.leetCode.queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 *
 * 若队列为空，pop_front 和 max_value 需要返回 -1
 *
 * @Author cangxiao
 * @Date 2021/9/7
 * @Desc 剑指 Offer 59 - II. 队列的最大值
 */
public class SolutionOffer59_2 {

    Queue<Integer> queue1;
    Deque<Integer> queue2;

    public SolutionOffer59_2() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public int max_value() {
        if (queue2.isEmpty()){
            return -1;
        }
        return queue2.peek();
    }

    public void push_back(int value) {
        queue1.offer(value);
        while (!queue2.isEmpty() && queue2.peekLast()<value){
            queue2.pollLast();
        }
        queue2.offer(value);
    }

    public int pop_front() {
        if (queue1.isEmpty()){
            return -1;
        }
        if (queue1.peek().equals(queue2.peek())){
            queue2.poll();
            return queue1.poll();
        }
        return queue1.poll();
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.offer(1);
        list.offer(2);
        list.offer(3);
        System.out.println(list.peek());
        System.out.println(list.poll());
        System.out.println(list.peek());
        System.out.println(list.poll());
        System.out.println(list.peek());
    }
}
