package com.cangxiao.leetCode.queue;

/**
 * 留一个位置不插入元素，用于判断队列是否已满
 * @Author cangxiao
 * @Date 2021/8/31
 * @Desc 循环队列
 */
public class CircularQueue<T> implements Queue<T>{

    private Object[] queue;
    /**
     * 队列大小
     */
    private int n;

    /**
     * head表示队头下标
     */
    private int head;
    /**
     * tail表示队尾下标，队尾下标不存储元素，比存储元素的索引大1
     */
    private int tail;

    public CircularQueue() {
        this(10);
    }

    /**
     * 留一个位置不插入元素，用于判断队列是否已满
     * @param capacity - 初始化大小
     */
    public CircularQueue(int capacity) {
        this.n = capacity+1;
        queue = new Object[n];
    }


    @Override
    public boolean enqueue(T value) {
        if((tail+1)%(n)==head) return false;
        queue[tail++%n] = value;
        return true;
    }

    @Override
    public T dequeue() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return head==tail;
    }

    public static void main(String[] args) {
        CircularQueue<Integer> queue = new CircularQueue<>(5);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        System.out.println(queue.head);
        System.out.println(queue.tail);
    }
}
