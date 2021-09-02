package com.cangxiao.leetCode.queue;

/**
 * @Author cangxiao
 * @Date 2021/8/31
 * @Desc 数组实现队列
 */
public class ArrayQueue<T> implements Queue<T>{

    private Object[] queue;
    /**
     * head表示队头下标
     */
    private int head;
    /**
     * tail表示队尾下标，队尾下标不存储元素，比存储元素的索引大1
     */
    private int tail;
    private int n; //队列大小

    public ArrayQueue() {
        this(10);
    }

    public ArrayQueue(int capacity) {
        this.n = capacity;
        queue = new Object[n];
    }

    /**
     * 队列满了tail = n;
     * @param value
     * @return
     */
    @Override
    public boolean enqueue(T value) {
        if(tail==n){//队尾没有空间了
            if(head==0)return false;//队列已满
//            for (int i = head; i< tail; i++){
//                queue[i-head] = queue[i];
//            }
            if (tail - head >= 0) System.arraycopy(queue, head, queue, 0, tail - head);
            tail = tail-head;
            head = 0;
        }

        queue[tail++] = value;
        return true;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T dequeue() {
        if(isEmpty())return null;
        return (T) queue[head++];
    }

    @Override
    public boolean isEmpty() {
        return head==tail;
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        queue.enqueue(1);
        queue.enqueue(1);
        queue.enqueue(1);
    }
}
