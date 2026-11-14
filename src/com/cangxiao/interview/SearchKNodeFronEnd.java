package com.cangxiao.interview;

import com.cangxiao.common.ListNode;

/**
 * @Author: cangxiao
 * @Since: 13/11/2026
 * @description: 单向链表求最后第k个节点
 */
public class SearchKNodeFronEnd {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5)))));
        SearchKNodeFronEnd searchKNodeFronEnd = new SearchKNodeFronEnd();
        searchKNodeFronEnd.searchNthFromEnd(listNode,2).print();
        searchKNodeFronEnd.searchNthFromEnd2(listNode,2).print();
        searchKNodeFronEnd.removeNthFromEnd(listNode,2).print();
    }

    public ListNode searchNthFromEnd(ListNode head, int n) {
        if (head==null){
            return null;
        }
        ListNode fastNode = head;
        ListNode slowNode = head;
        int i = 1;
        while (fastNode != null){
            if (i++ > n){
                slowNode = slowNode.next;
            }
            fastNode = fastNode.next;
        }
        return slowNode;
    }

    public ListNode searchNthFromEnd2(ListNode head, int n) {
        if (head==null){
            return null;
        }
        ListNode newHead = new ListNode();
        newHead.next = head;
        ListNode fastNode = newHead;
        ListNode slowNode = newHead;
        int i = 1;
        while (fastNode.next != null){
            if (i++ > n){
                slowNode = slowNode.next;
            }
            fastNode = fastNode.next;
        }
        return  slowNode.next;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head==null){
            return null;
        }
        ListNode newHead = new ListNode();
        newHead.next = head;
        ListNode fastNode = newHead;
        ListNode slowNode = newHead;
        int i = 1;
        while (fastNode.next != null){
            if (i++ > n){
                slowNode = slowNode.next;
            }
            fastNode = fastNode.next;
        }
        slowNode.next = slowNode.next.next;
        return newHead.next;
    }
}
