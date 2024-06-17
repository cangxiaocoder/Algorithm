package com.cangxiao.linkedlist.base;

/**
 * @Author cangxiao
 * @Date 2022/8/6
 * @Desc
 */
public class MyLinkedList {

    private final Node head;
    private int size;

    public MyLinkedList() {
        head = new Node();
        size = 0;
    }

    public int get(int index) {
        if (index >= size){
            return -1;
        }
        Node resultNode = head.next;
        while (resultNode != null){
            if (index == 0){
                return resultNode.val;
            }
            resultNode = resultNode.next;
            index--;
        }
        return -1;
    }

    public void addAtHead(int val) {
        Node p = head.next;
        Node newNode = new Node(val);
        newNode.next = p;
        head.next = newNode;
        size++;
    }

    public void addAtTail(int val) {
        Node newNode = new Node(val);
        Node p = head;
        while (p.next != null){
            p = p.next;
        }
        p.next = newNode;
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index > size) return;
        Node newNode = new Node(val);
        Node p = head;
        while (p != null){
            if (index <= 0){
                newNode.next = p.next;
                p.next = newNode;
                size++;
                return;
            }
            p = p.next;
            index--;
        }
    }

    public void deleteAtIndex(int index) {
        if (index >= size || index < 0) return;
        Node p = head;
        while (p.next != null){
            if (index == 0){
                p.next = p.next.next;
                return;
            }
            p = p.next;
            index--;
        }
    }

    static class Node{
        int val;
        Node next;
        private Node() {
        }
        private Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        /*linkedList.addAtHead(7);
        linkedList.addAtTail(2);
        linkedList.addAtTail(1);
        linkedList.addAtIndex(3,0);   //链表变为1-> 2-> 3
        linkedList.deleteAtIndex(2);   //链表变为1-> 2-> 3
        linkedList.addAtHead(6);   //链表变为1-> 2-> 3
        linkedList.addAtTail(4);
        System.out.println("linkedList.get(1) = " + linkedList.get(4));
        linkedList.addAtHead(4);   //链表变为1-> 2-> 3
        linkedList.addAtIndex(5,0);   //链表变为1-> 2-> 3
        linkedList.addAtHead(6);   //链表变为1-> 2-> 3*/
        linkedList.addAtIndex(0,10);
        linkedList.addAtIndex(0,20);
        linkedList.addAtIndex(1,30);
        linkedList.get(0);
    }
}
