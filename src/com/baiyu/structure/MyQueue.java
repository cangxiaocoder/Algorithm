package com.baiyu.structure;

/**
 * @Author: cangxiao
 * @Date: 2021/2/8
 * @des; 循环队列，对位指针指向的位置永远空出一位，所以队列的最大长度比数组长度小1；
 */
public class MyQueue {

    private int head, tail;
    private int[] array;

    public MyQueue(int capacity) {
        array = new int[capacity];
    }

    /**
     * 入队
     *
     * @param element 入队元素
     */
    public void enQueue(int element) {
        //如果（尾部的下标 + 1）% = 对头下标，说明队列满了。
        if ((tail + 1) % array.length == head) {
            throw new ArrayIndexOutOfBoundsException("队列已满");
        }
        array[tail] = element;
        tail = (tail + 1) % array.length;
    }


    /**
     * 出队
     *
     * @return 出队元素
     */
    public int deQueue() {
        if (head == tail) {
            throw new ArrayIndexOutOfBoundsException("队列已空");
        }
        int temp = array[head];
        head = (head + 1) % array.length;
        return temp;
    }

    public void output(){
        for (int i = head; i != tail; i= (i+1)%array.length) {
            System.out.println(array[i]);
        }
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue(5);
        queue.enQueue(3);
        queue.enQueue(5);
        queue.enQueue(6);
        queue.output();
        System.out.println("========");
        queue.deQueue();
        queue.output();
        System.out.println("========");
        queue.enQueue(8);
        queue.enQueue(1);
        queue.output();
        System.out.println("========");
    }
}
