package com.cangxiao.queue;

import java.util.Arrays;

/**
 * @Author cangxiao
 * @Date 2021/6/13
 * @Desc 数组实现队列 - 顺序队列
 */
public class ArrayQueue<T> {
    private Object[] items;
    //数组大小
    private int n;
    //head表示队头下标，tail表示队尾下标
    private int head = 0, tail = 0;

    public ArrayQueue(int capacity) {
        this.n = capacity;
        items = new Object[capacity];
    }

    public boolean enqueue(T value) {
        //队尾没有空间了
        if(tail==n){
            //队列已满
            if(head==0){
                return false;
            }
            /*for (int i = head; i< tail; i++){
                items[i-head] = items[i];
            }*/
            //数据搬移,移到从0开始
            if (tail - head >= 0) System.arraycopy(items, head, items, 0, tail - head);
            //搬移完之后重新更新head和tail
            tail = tail - head;
            head = 0;
        }
        items[tail] = value;
        tail++;
        return true;
    }

    @Override
    public String toString() {
        return "ArrayQueue{" +
                "items=" + Arrays.toString(items) +
                '}';
    }

    public T dequeue() {
        if(head==tail) return null; //队列为空
        T data = (T) items[head];
        head++;
        return data;
    }

    public static void main(String[] args) {
        ArrayQueue<String > queue = new ArrayQueue<>(5);
        queue.enqueue("hello");
        queue.enqueue("world");
        queue.enqueue("我");
        queue.enqueue("爱");
        queue.enqueue("你");
        System.out.println(queue);
        System.out.println(queue.head+"<==>"+ queue.tail);
        queue.dequeue();
        queue.dequeue();
        System.out.println(queue);
        System.out.println(queue.head+"<==>"+ queue.tail);
        queue.enqueue("hello");
        queue.enqueue("world");
        System.out.println(queue);
        System.out.println(queue.head+"<==>"+ queue.tail);
    }

}
