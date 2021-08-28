package com.cangxiao.leetCode.linkedList;

/**
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * 示例 1：
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 * @Author cangxiao
 * @Date 2021/8/27
 * @Desc 206. 反转链表
 */
public class Solution206 {

    public ListNode reverseList(ListNode head) {
        ListNode reverse = null;
        ListNode p = head ;
        while (p!=null){
            ListNode newNode = new ListNode(p.val);
            ListNode temp = reverse;
            reverse = newNode;
            reverse.next = temp;
            p = p.next;
        }
        return reverse;
    }

    public ListNode reverseList2(ListNode head) {
        ListNode reverse = new ListNode();
        ListNode p = head ;
        while (p!=null){
            ListNode temp = reverse.next;
            ListNode next = p.next;
            reverse.next = p;
            reverse.next.next = temp;
            p = next;
        }
        return reverse.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        Solution206 solution206 = new Solution206();
        ListNode reverseList = solution206.reverseList2(listNode);
        System.out.println(reverseList);
    }
}
