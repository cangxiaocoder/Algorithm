package com.cangxiao.leetCode.easy;

import com.cangxiao.leetCode.linkedList.LinkedList;
import com.cangxiao.linkedlist.ListNode;

/**
 * @Author cangxiao
 * @Date 2021/9/12
 * @Desc 147. 对链表进行插入排序
 */
public class Solution147 {

    public ListNode insertionSortList(ListNode head) {

        ListNode newHead = new ListNode(Integer.MIN_VALUE);
        ListNode q = newHead;
        ListNode p = head;
        while (p!=null){
            ListNode next = p.next;
            p.next = null;
            if (q.next==null){
                q.next = p;
                p = next;
                continue;
            }
            q = newHead;
            while (q.next!=null && p.val > q.next.val){
                q = q.next;
            }
            ListNode tem = q.next;
            q.next = p;
            q.next.next = tem;
            p = next;
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(-1);
        list.add(5);
        list.add(3);
        list.add(4);
        list.add(0);
        Solution147 solution147 = new Solution147();
        ListNode listNode = solution147.insertionSortList(list.head);
        ListNode.print(listNode);
    }
}
