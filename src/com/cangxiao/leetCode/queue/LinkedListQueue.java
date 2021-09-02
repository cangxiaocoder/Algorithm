package com.cangxiao.leetCode.queue;

/**
 * @Author cangxiao
 * @Date 2021/8/31
 * @Desc 链表实现队列
 */
public class LinkedListQueue<T> implements Queue<T>{

    private Node<T> head;
    private Node<T> tail;

    private static class Node<T>{
        T data;
        Node<T> next;
        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }

    @Override
    public boolean enqueue(T value) {
        Node<T> newNode = new Node<>(value,null);
        if(head==null){
            head = newNode;
            tail = head;
            return true;
        }
        tail.next = newNode;
        tail = tail.next;
        return true;
    }

    @Override
    public T dequeue() {
        if(head==null) return null;//队列为空
        T data = head.data;
        head = head.next;
        //出队一个元素后，head==null,说明队列中只有一个元素
        if(head==null){
            tail=null   ;
        }
        return data;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
