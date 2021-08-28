package com.cangxiao.leetCode.linkedList;

/**
 * @Author cangxiao
 * @Date 2021/8/24
 * @Desc 剑指 Offer 25. 合并两个排序的链表
 */
public class SolutionOffer25 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode();
        newHead.next = l1;
        ListNode p = newHead;
        ListNode q = l2;
        while (p.next!=null&&q!=null){
            if(p.next.val>q.val){
                ListNode temp = p.next;
                p.next = q;
                q = q.next;
                p.next.next = temp;
            }
            p = p.next;
        }
        if(q!=null) p.next = q;

        return newHead.next;
    }

}
