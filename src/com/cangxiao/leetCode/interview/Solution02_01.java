package com.cangxiao.leetCode.interview;

import com.cangxiao.leetCode.linkedList.LinkedList;
import com.cangxiao.linkedlist.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author cangxiao
 * @Date 2021/10/1
 * @Desc 面试题 02.01. 移除重复节点
 */
public class Solution02_01 {

    public ListNode removeDuplicateNodes(ListNode head) {
        ListNode newHead = new ListNode();
        newHead.next = head;
        ListNode p = newHead;
        Map<Integer,Integer> map = new HashMap<>();
        while (p.next != null){
            if (map.containsKey(p.next.val)){
                p.next = p.next.next;
                continue;
            }
            map.put(p.next.val,1);
            p = p.next;
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        Solution02_01 solution = new Solution02_01();
        LinkedList list = new LinkedList();//1, 2, 3, 3, 2, 1
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(2);
        list.add(1);
        ListNode listNode = solution.removeDuplicateNodes(list.head);
        ListNode.print(listNode);
    }
}
