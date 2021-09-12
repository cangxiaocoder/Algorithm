package com.cangxiao.leetCode.middle;

import com.cangxiao.leetCode.easy.Solution147;
import com.cangxiao.leetCode.linkedList.LinkedList;
import com.cangxiao.leetCode.linkedList.ListNode;

/**
 * 给你链表的头结点head，请将其按 升序 排列并返回 排序后的链表 。
 *
 * 进阶：
 *
 * 你可以在O(nlogn) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 *
 * @Author cangxiao
 * @Date 2021/9/12
 * @Desc 148. 排序链表
 */
public class Solution148 {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode temp = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(temp);
        ListNode newHead = new ListNode(0);
        ListNode p = newHead;
        while (left!=null && right!=null){
            if (left.val < right.val){
                p.next = left;
                left = left.next;
            }else {
                p.next = right;
                right = right.next;
            }
            p = p.next;
        }
        p.next = left != null ? left : right;
        return newHead.next;
    }

    public ListNode sortList1(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tmp = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);
        ListNode h = new ListNode(0);
        ListNode res = h;
        while (left != null && right != null) {
            if (left.val < right.val) {
                h.next = left;
                left = left.next;
            } else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }
        h.next = left != null ? left : right;
        return res.next;
    }


    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(-1);
        list.add(5);
        list.add(3);
        list.add(4);
        list.add(0);
        Solution148 solution = new Solution148();
        ListNode listNode = solution.sortList(list.head);
        ListNode.print(listNode);
    }
}
