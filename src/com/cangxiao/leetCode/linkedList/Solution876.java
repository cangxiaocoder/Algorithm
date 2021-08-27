package com.cangxiao.leetCode.linkedList;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author cangxiao
 * @Date 2021/8/24
 * @Desc 876. 链表的中间结点
 */
public class Solution876 {

    public ListNode middleNode(ListNode head) {
        Map<Integer, ListNode> map = new HashMap<>();
        ListNode p = head;
        int i = 0;
        while (p != null) {
            map.put(++i, p);
            p = p.next;
        }
        return map.get(i / 2 + 1);
    }

    public ListNode middleNode2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast!=null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        System.out.println(2 & 1);
    }
}
