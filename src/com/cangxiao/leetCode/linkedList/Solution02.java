package com.cangxiao.leetCode.linkedList;

import com.cangxiao.linkedlist.ListNode;

/**
 * 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
 * <p>
 * 示例 1：
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 *
 * @Author cangxiao
 * @Date 2021/8/27
 * @Desc 2. 两数相加
 */
public class Solution02 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p = l1;
        ListNode q = l2;
        int temp = 0;
        ListNode head = new ListNode();
        ListNode l = head;
        while (p != null && q != null) {
            ListNode current = new ListNode();
            int sum = p.val + q.val + temp;
            current.val = sum % 10;
            temp = sum / 10;
            p = p.next;
            q = q.next;
            l.next = current;
            l = l.next;
        }
        while (p != null) {
            ListNode current = new ListNode();
            int sum = p.val + temp;
            current.val = sum % 10;
            temp = sum / 10;
            l.next = current;
            p = p.next;
            l = l.next;
        }
        while (q != null) {
            ListNode current = new ListNode();
            int sum = q.val + temp;
            current.val = sum % 10;
            temp = sum / 10;
            l.next = current;
            q = q.next;
            l = l.next;
        }
        if (temp != 0) {
            l.next = new ListNode(temp);
        }
        return head.next;
    }


    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode p = l1;
        ListNode q = l2;
        int temp = 0;
        ListNode head = new ListNode();
        ListNode l = head;
        while (p != null || q != null) {
            ListNode current = new ListNode();
            int sum;
            if (p != null && q != null) {
                sum = p.val + q.val + temp;
                p = p.next;
                q = q.next;
            } else if (p != null) {
                sum = p.val + temp;
                p = p.next;
            } else {
                sum = q.val + temp;
                q = q.next;
            }
            current.val = sum % 10;
            temp = sum / 10;

            l.next = current;
            l = l.next;
        }
        /*while (p!=null){
            ListNode current = new ListNode();
            int sum = p.val + temp;
            current.val = sum%10;
            temp = sum/10;
            l.next = current;
            p = p.next;
            l = l.next;
        }
        while (q!=null){
            ListNode current = new ListNode();
            int sum = q.val + temp;
            current.val = sum%10;
            temp = sum/10;
            l.next = current;
            q = q.next;
            l = l.next;
        }*/
        if (temp != 0) {
            l.next = new ListNode(temp);
        }
        return head.next;
    }

    public ListNode addTwoNumbers3(ListNode l1, ListNode l2) {
        ListNode p = l1;
        ListNode q = l2;
        int temp = 0;
        ListNode head = new ListNode();
        ListNode l = head;
        while (p != null || q != null) {
            ListNode current = new ListNode();
            int pVal = p != null ? p.val : 0;
            int qVal = q != null ? q.val : 0;
            int sum = pVal + qVal + temp;
            if (p != null) {
                p = p.next;
            }
            if (q != null) {
                q = q.next;
            }
            current.val = sum % 10;
            temp = sum / 10;
            l.next = current;
            l = l.next;
        }
        /*while (p!=null){
            ListNode current = new ListNode();
            int sum = p.val + temp;
            current.val = sum%10;
            temp = sum/10;
            l.next = current;
            p = p.next;
            l = l.next;
        }
        while (q!=null){
            ListNode current = new ListNode();
            int sum = q.val + temp;
            current.val = sum%10;
            temp = sum/10;
            l.next = current;
            q = q.next;
            l = l.next;
        }*/
        if (temp != 0) {
            l.next = new ListNode(temp);
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);
        l1.next.next.next = new ListNode(9);

        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
//        l2.next.next = new ListNode(4);

        Solution02 solution02 = new Solution02();
        ListNode listNode = solution02.addTwoNumbers(l1, l2);
        while (listNode != null) {
            System.out.print(listNode.val);
            listNode = listNode.next;
        }
    }
}

