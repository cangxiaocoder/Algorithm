package com.cangxiao.leetCode.hard;

import com.cangxiao.linkedlist.ListNode;

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
        for (ListNode list : lists) {
            if (list != null)
                minQueue.offer(new QElement(list));
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
class Solution {
    /**
     * 用于存储当前节点，只存储当前节点的值无法找到下一个节点
     */
    private static class QElement{
        private ListNode curNode;

        public QElement(ListNode curNode) {
            this.curNode = curNode;
        }
    }


    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length==0) return null;

        PriorityQueue<QElement> minQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o.curNode.val));
        for (ListNode listNode : lists) {
            minQueue.offer(new QElement(listNode));
        }
        ListNode head = new ListNode();
        ListNode tail = head;
        while (!minQueue.isEmpty()){
            ListNode curNode = minQueue.poll().curNode;
            tail.next = curNode;
            tail = tail.next;
            if (curNode.next!=null){
                minQueue.offer(new QElement(curNode.next));
            }
        }
        return head.next;
    }

}