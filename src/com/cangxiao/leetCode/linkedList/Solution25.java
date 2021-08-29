package com.cangxiao.leetCode.linkedList;

/**
 * 给你一个链表，每k个节点一组进行翻转，请你返回翻转后的链表。
 *
 * k是一个正整数，它的值小于或等于链表的长度。
 *
 * 如果节点总数不是k的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 进阶：
 *
 * 你可以设计一个只使用常数额外空间的算法来解决此问题吗？
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 * 示例 1：
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[2,1,4,3,5]
 *
 * @Author cangxiao
 * @Date 2021/8/28
 * @Desc 25. K 个一组翻转链表
 */
public class Solution25 {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode newHead = new ListNode();
//        newHead.next = head;
        ListNode p = head;
        ListNode h = newHead;
        ListNode q = null;
        int i = 0;
        while (p!=null){
            if(i%k==0){
                q = p;

            }
            p = reverse(p, h);
            i++;
        }
        ListNode.print(q);
        ListNode.print(h);
        return newHead.next;
    }

    private ListNode reverse(ListNode p, ListNode h) {
        ListNode next = p.next;
        ListNode temp = h.next;
        h.next = p;
        h.next.next = temp;

        p = next;
        return p;
    }


    public static void main(String[] args) {
        System.out.println(0%2);
        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        Solution25 solution25 = new Solution25();
        ListNode listNode = solution25.reverseKGroup(linkedList.head, 10);
        ListNode.print(listNode);
    }
}
