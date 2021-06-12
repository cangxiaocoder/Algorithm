package com.cangxiao.linkedlist;

import javax.naming.NoPermissionException;
import java.nio.channels.NotYetBoundException;
import java.util.LinkedList;
import java.util.Objects;

/**
 * 所有的链表都有一个头指针head，
 * 带头结点的链表中head的数据项为空，
 * 而不带头的链表直接在头结点存入数据，
 * 那么当从头插入数据时，head需要时刻变化。
 *
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
     * 不带头链表翻转 - 头插法反转
     * 带头结点的链表中head的数据项为空，
     * 而不带头的链表直接在头结点存入数据
     */
    public Node<T> inverseLinkList(Node<T> node) {
        if (node == null) return null;
        Node<T> current = node;
        Node<T> next = null;
        head = null;
        Node<T> Head;
        while (current != null) {
            next = current.next;
            addToHead(current.data);
            current = next;
        }
        Head = head;
        return Head;
    }

    /**
     * 每次取出一个结点，并且此结点的下一个结点指向pre，
     *
     * 不带头链表翻转
     * 带头结点的链表中head的数据项为空，
     * 而不带头的链表直接在头结点存入数据
     */
    public Node<T> inverseLinkList2(Node<T> node) {
        if (node == null) return null;
        Node<T> current = node;
        Node<T> pre = null;
        Node<T> next = null;
        while (current!=null) {
            //取当前结点的next结点
            next = current.next;
            //当前结点的next指针只想pre;
            current.next = pre;
            //pre指针向左移动
            pre = current;
            //向右移动指针到下一个结点
            current = next;

        }
        return pre;
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

    public void deleteByValue2(T value) {
        if (head == null || value == null) {
            return;
        }
        if (value.equals(head.data)) {
            head = head.next;
        }
        Node<T> node = head;
        while (node != null) {
            if (node.data.equals(value)) {
                Node<T> temp = node;
                node = temp.next;
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

        int data[] = {1, 2, 3, 4, 5};

        for (int datum : data) {
            //link.insertToHead(data[i]);
            link.add(datum);
        }

//        System.out.println(link.head);
        Node<Integer> list = link.inverseLinkList2(link.head);
        System.out.println(list);



//        System.out.println(link.findByValue(5));
//        System.out.println(link.print(link.findByIndex(3)));
    }
}
