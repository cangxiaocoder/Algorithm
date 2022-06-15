package com.cangxiao.offer;

/**
 * @Author cangxiao
 * @Date 2022/4/24
 * @Desc 剑指 Offer 35. 复杂链表的复制
 */
public class Offer35 {

    public Node copyRandomList(Node head) {

        if (head==null) return null;
        Node p = head;
        while (p!=null){
            Node newNode = new Node(p.val);
            newNode.next = p.next;
            p.next = newNode;
            p = p.next.next;
        }
        p = head;
        while (p!=null){
            Node newNode = p.next;
            newNode.random = p.random==null?null:p.random.next;
            p = p.next.next;
        }
        p = head;
        Node newHead = new Node(0);
        Node tail = newHead;
        while (p!=null){
            tail.next = p.next;
            tail = tail.next;
            Node temp = p.next.next;
            p.next = p.next.next;
            p = temp;
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        Node p1 = new Node(7);
        Node p2 = new Node(13);
        Node p3 = new Node(11);
        Node p4 = new Node(10);
        Node p5 = new Node(1);
        p1.next = p2;
        p1.random = null;
        p2.next = p3;
        p2.random = p1;
        p3.next = p4;
        p3.random = p5;
        p4.next = p5;
        p4.random = p3;
        p5.next = null;
        p5.random = p1;
        Offer35 offer35 = new Offer35();
        Node node = offer35.copyRandomList(p1);
        System.out.println(node);
    }
}


class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}