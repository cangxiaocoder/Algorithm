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

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode p = l1;
        ListNode q = l2;
        ListNode newHead = new ListNode();
        ListNode tail = newHead;
        while (p!=null && q!=null){
            if(p.val <= q.val){
                tail.next = p;
                tail = p;
                p = p.next;
            }else {
                tail.next = q;
                tail = q;
                q = q.next;
            }
        }
        if (p!=null)tail.next = p;
        if (q!=null)tail.next = q;
        return newHead.next;

    }

    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
        l1.add(1);
        l1.add(2);
        l1.add(4);
        LinkedList l2 = new LinkedList();
        l2.add(1);
        l2.add(3);
        l2.add(4);
        SolutionOffer25 solutionOffer25 = new SolutionOffer25();
        ListNode listNode = solutionOffer25.mergeTwoLists2(l1.head, l2.head);
        ListNode.print(listNode);
    }
}
