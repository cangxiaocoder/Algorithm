package com.cangxiao.linkedlist;

/**
 * @Author: cangxiao
 * @Since: 12/11/2026
 * @description: 86. 分隔链表
 */
public class PartitionList {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1,new ListNode(4,new ListNode(3,new ListNode(2,new ListNode(5, new ListNode(2))))));
        PartitionList partitionList = new PartitionList();
        partitionList.partition(l1, 3).print();
    }

    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode();
        ListNode smallHead = small;
        ListNode large = new ListNode();
        ListNode largeHead = large;
        ListNode node = head;
        while (node != null) {
            if (node.val >= x){
                large.next = node;
                large = large.next;
            }else {
                small.next = node;
                small = small.next;
            }
            node = node.next;
        }
        large.next = null;
        small.next = largeHead.next;
        return smallHead.next;
    }
}
