package com.cangxiao.leetCode.hard;

import com.cangxiao.leetCode.linkedList.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author cangxiao
 * @Date 2021/11/21
 * @Desc 23. 合并K个升序链表
 */
public class Solution23 {
    /**
     * 用于存储当前节点，只存储当前节点的值无法找到下一个节点
     */
    private class QElement{
        ListNode currentNode;

        public QElement(ListNode currentNode) {
            this.currentNode = currentNode;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists==null || lists.length==0) return null;

        int length = lists.length;
        PriorityQueue<QElement> minQueue = new PriorityQueue<>(Comparator.comparingInt(q -> q.currentNode.val));
        //将所有的链表的第一个节点放到最小堆中，找到最小值
        for (int i = 0; i < length; i++) {
            if (lists[i]!=null)
                minQueue.offer(new QElement(lists[i]));
        }
        ListNode head = new ListNode();
        ListNode tail = head;
        while (!minQueue.isEmpty()){
            ListNode listNode = minQueue.poll().currentNode;
            tail.next = listNode;
            tail = tail.next;
            /*
                不能使用while, 否则会重复添加节点，如链表[1,4,5] ，当listNode = 1时，会添加1之后的4,5;
                当listNode = 4时又会再次添加节点5;
             */
            if (listNode.next!=null){
                minQueue.offer(new QElement(listNode.next));
            }
        }
        return head.next;
    }
}
