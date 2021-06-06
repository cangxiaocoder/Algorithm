package com.cangxiao.linkedlist;

import javax.naming.NoPermissionException;
import java.util.LinkedList;
import java.util.Objects;

/**
 * @Author cangxiao
 * @Date 2021/6/6
 * @Desc 单链表的插入、删除、查找、链表翻转操作
 */
public class SinglyLinkedList<T> {

    private Node<T> head;

    private int size;

    public SinglyLinkedList() {
    }

    public int findByValue(T value) {
        int index = 0;
        Node<T> node = head;
        while (node.next != null) {
            if (node.data == value) {
                return index;
            }
            node = node.next;
            index++;
        }
        return -1;
    }

    public Node<T> findByIndex(int index) {

        if (index < size) {
            Node<T> node = head;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        }
        return null;
    }

    public void add(T value) {
        Node<T> newNode = new Node<>(value, null);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> pre = head;
            while (pre.next != null) {
                pre = pre.next;
            }
            pre.next = newNode;

        }
        size++;
    }

    /**
     * 从头部插入
     */
    public void addToHead(T value) {
        Node<T> newNode = new Node<>(value, null);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    /**
     * 删除一个节点
     */

    public void deleteByValue(T value) {
        if (head == null || value == null) {
            return;
        }
        if (value.equals(head.data)) {
            head = head.next;
        }
        Node<T> node = head;
        while (node.next != null) {
            if (node.next.data.equals(value)) {
                Node<T> temp = node.next;
                node.next = temp.next;
                temp = null;
            }
            node = node.next;
        }
    }


    public static class Node<T> {
        private final T data;
        private Node<T> next;

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

        public T getData() {
            return data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node<?> node = (Node<?>) o;
            return Objects.equals(data, node.data) && Objects.equals(next, node.next);
        }

        @Override
        public int hashCode() {
            return Objects.hash(data, next);
        }
    }

    public String print(Node<T> node) {
        return "node.data = " + node.data;
    }


    public static void main(String[] args) {
       /* LinkedList<String > list = new LinkedList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.remove("2");
//        list.get(1);
        System.out.println(list.get(0));*/

        SinglyLinkedList<Integer> link = new SinglyLinkedList<>();

        int data[] = {1, 2, 5, 3, 1};

        for (int i = 0; i < data.length; i++) {
            //link.insertToHead(data[i]);
            link.addToHead(data[i]);
        }

        System.out.println(link.head);
        link.deleteByValue(2);
        System.out.println(link.head);
//        System.out.println(link.findByValue(5));
//        System.out.println(link.print(link.findByIndex(3)));
    }
}
