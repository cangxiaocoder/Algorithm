package com.cangxiao.queue;

/**
 * @Author cangxiao
 * @Date 2021/6/13
 * @Desc 链表实现队列 - 链式队列
 */
public class linkedQueue<T> {

    private Node<T> head;
    private Node<T> tail;



    public boolean enqueue(T value) {
        //第一次入队
        if(tail==null){
            Node<T> node = new Node<>(value,null);
            head = node;
            tail = node;
        }else {
            tail.next = new Node<>(value,null);
            //向后移动tail指针，
            tail = tail.next;
        }
        return true;
    }


    public void printAll() {
        Node p = head;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }
    public T dequeue() {
        if(head==null)return null;
        Node<T> temp = head;
        head = head.next;
        //当head为null时，队列为空，将tail赋值为null.
        if (head == null) {
            tail = null;
        }
        T data = temp.data;
        temp = null;
        return data;
    }

    private static class Node<T>{
        private final T data;
        private Node<T> next;

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

        public T getData() {
            return data;
        }
    }

    public static void main(String[] args) {
        linkedQueue<String> queue = new linkedQueue<>();
        queue.enqueue("hello");
        queue.enqueue("world");
        queue.enqueue("我");
        queue.enqueue("爱");
        queue.enqueue("你");
        System.out.println("queue.dequeue() = " + queue.dequeue());

        queue.printAll();
    }
}
