package com.cangxiao.leetCode.linkedList;

/**
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
 *
 * 返回同样按升序排列的结果链表。
 * 示例 1：
 * 输入：head = [1,1,2]
 * 输出：[1,2]
 * @Author cangxiao
 * @Date 2021/8/24
 * @Desc 83. 删除排序链表中的重复元素
 */
public class Solution83 {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode newHead = new ListNode();
        newHead.next = head;
        ListNode p = newHead;
        while (p.next!=null && p.next.next!=null){
            if(p.next.val==p.next.next.val){
                p.next = p.next.next;
                continue;
            }
            p = p.next;
        }
        return newHead.next;
    }
}
