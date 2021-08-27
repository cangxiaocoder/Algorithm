package com.cangxiao.leetCode.linkedList;

import com.cangxiao.leetCode.linkedList.ListNode;

/**
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 *
 * 示例 1：
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 *
 * @Author cangxiao
 * @Date 2021/8/24
 * @Desc 203. 移除链表元素
 */
public class Solution203 {

    public ListNode removeElements(ListNode head, int val) {
        ListNode newHead = new ListNode();
        newHead.next = head;
        ListNode p = newHead;
        while (p.next != null){
            if(p.next.val==val){
                p.next = p.next.next;
                continue;
            }
            p = p.next;
        }
        return newHead.next;
    }

}


