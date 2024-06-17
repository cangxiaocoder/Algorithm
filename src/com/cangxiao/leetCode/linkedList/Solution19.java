package com.cangxiao.leetCode.linkedList;

import com.cangxiao.linkedlist.ListNode;

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * <p>
 * 进阶：你能尝试使用一趟扫描实现吗？
 * 示例：
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 *
 * @Author cangxiao
 * @Date 2021/8/29
 * @Desc 19. 删除链表的倒数第 N 个结点
 */
public class Solution19 {
    /**
     * forward比rear多走n步，当forward走到最后一个节点。
     * rear即为倒数第n个节点
     *
     * @param head
     * @param n
     * @return
     */

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null)return head;
        ListNode newHead = new ListNode();
        newHead.next = head;
        ListNode forward = newHead;
        ListNode rear = newHead;
        int i = 0;

        while (forward.next != null) {
            if (++i > n) {
                rear = rear.next;
            }
            forward = forward.next;
        }
        rear.next = rear.next.next;
        return newHead.next;
    }
}
