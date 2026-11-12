package com.cangxiao.linkedlist;

/**
 * @Author: cangxiao
 * @Since: 11/11/2026
 * @description: 2. 两数相加
 */
public class NumAdd {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        int carry = 0;
        ListNode listNode = head;
        while (l1 != null && l2 != null) {
            int value = l1.val + l2.val + carry;
            carry = value >= 10 ? 1 : 0;
            listNode.val = value >= 10 ? value - 10 : value;
            if (l1.next != null && l2.next!=null){
                listNode.next = new ListNode();
                listNode = listNode.next;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int value = carry + l1.val;
            carry = value >= 10 ? 1 : 0;
            listNode.next = new ListNode(value >= 10 ? value - 10 : value);
            listNode = listNode.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            int value = carry + l2.val;
            carry = value >= 10 ? 1 : 0;
            listNode.next = new ListNode(value >= 10 ? value - 10 : value);
            listNode = listNode.next;
            l2 = l2.next;
        }
        if (carry > 0) {
            listNode.next = new ListNode(carry);
        }
        return head;
    }

    public static void main(String[] args) {
//        ListNode l1 = new ListNode(2);
//        ListNode l1_2 = new ListNode(4);
//        ListNode l1_3 = new ListNode(3);
//        l1.next = l1_2;
//        l1_2.next = l1_3;
//
//        ListNode l2 = new ListNode(5);
//        ListNode l2_2 = new ListNode(6);
//        ListNode l2_3 = new ListNode(4);
//        l2.next = l2_2;
//        l2_2.next = l2_3;
        ListNode l1 = new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9, new ListNode(9, new ListNode(9)))))));
        ListNode l2 = new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9))));

        new NumAdd().addTwoNumbers(l1, l2).print();
    }
}
