package com.cangxiao.leetCode.stack;

import java.util.LinkedList;

/**
 * @Author cangxiao
 * @Date 2021/8/31
 * @Desc 链表实现栈
 */
public class LinkedListStack<T> implements Stack<T>{

    private Node<T> head;
    private int size;

    private static class Node<T>{
        T data;
        Node<T> next;

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }

    @Override
    public boolean push(T value) {
        Node<T> node = new Node<>(value,null);
        node.next = head;
        head = node;
        size++;
        return true;
    }

    @Override
    public T pop(T value) {
        if (isEmpty()) return null;
        Node<T> next = head.next;
        T data = head.data;
        head = next;
        return data;
    }

    @Override
    public T peek(T value) {
        if (isEmpty()) return null;
        return head.data;
    }

    @Override
    public boolean isEmpty() {
        return head==null;
    }
}
