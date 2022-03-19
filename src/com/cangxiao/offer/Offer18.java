package com.cangxiao.offer;

import com.cangxiao.leetCode.linkedList.ListNode;

/**
 * @Author cangxiao
 * @Date 2022/3/18
 * @Desc 剑指 Offer 18. 删除链表的节点剑指 Offer 18. 删除链表的节点
 */
public class Offer18 {

    public ListNode deleteNode(ListNode head, int val) {
        ListNode newHead = new ListNode();
        newHead.next = head;
        ListNode p = newHead;
        while (p.next!=null){
            if (p.next.val==val){
                p.next=p.next.next;
                break;
            }
            p = p.next;
        }
        return newHead.next;
    }
}

