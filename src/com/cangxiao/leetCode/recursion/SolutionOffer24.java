package com.cangxiao.leetCode.recursion;

import com.cangxiao.leetCode.linkedList.LinkedList;
import com.cangxiao.leetCode.linkedList.ListNode;


/**
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *
 * @Author cangxiao
 * @Date 2021/9/11
 * @Desc 剑指 Offer 24. 反转链表
 */
public class SolutionOffer24 {

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur!=null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public ListNode reverseList2(ListNode head) {
        ListNode newHead = new ListNode();
        ListNode p = head;
        while (p!=null){
            ListNode next = p.next;
            ListNode tem = newHead.next;
            newHead.next = p;
            p.next = tem;
            p = next;
        }
        return newHead.next;
    }

    public ListNode reverseList3(ListNode head) {
        if (head==null) return null;
        if (head.next==null) return head;
        ListNode newHead = reverseList3(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }


    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        SolutionOffer24 solution = new SolutionOffer24();
        ListNode.print(list.head);
        ListNode listNode = solution.reverseList3(list.head);
        ListNode.print(listNode);
    }
}
