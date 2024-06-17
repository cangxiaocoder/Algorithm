package com.cangxiao.leetCode.linkedList;

import com.cangxiao.linkedlist.ListNode;

/**
 * @Author cangxiao
 * @Date 2021/8/28
 * @Desc 单链表
 */
public class LinkedList {
    public ListNode head;

    /**
     * 带虚拟头节点的链表
     */
    public LinkedList() {

    }

    /**
     * 不带虚拟头节点的链表
     * @param val
     */
    public LinkedList(int val) {
        this.head = new ListNode(val,null);
    }

    /**
     * 从尾部插入，如果head为空则不带虚拟头节点
     * @param val
     */
    public void add(int val){
        ListNode newNode = new ListNode(val);
        if(head==null){
            head = newNode;
        }else {
            ListNode p = head;
            while (p.next!=null){
                p = p.next;
            }
            p.next = newNode;
        }
    }
    /**
     * 从头部插入，不带虚拟头节点
     * @param val
     */
    public void addHead(int val){
        ListNode newNode = new ListNode(val);
        if(head==null){
            head = newNode;
        }else {
            ListNode temp = head;
            head = newNode;
            head.next = temp;
        }
    }
    /**
     * 从头部插入，带虚拟头节点
     * @param val
     */
    public void addToHead(int val){
        ListNode newNode = new ListNode(val);
        if(head==null){
            head = new ListNode();
        }
        newNode.next = head.next;
        head.next = newNode;
    }

    @Override
    public String toString() {
        ListNode p = head;
        StringBuilder sb = new StringBuilder();
        sb.append("LinkedList{");
        while (p!=null){
            sb.append(p.val).append(",");
            p = p.next;
        }
        sb.append("}");
        return sb.toString();
    }
}
