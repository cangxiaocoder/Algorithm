package com.cangxiao.linkedlist;

/**
 * @Author cangxiao
 * @Date 2024/6/16
 * @Desc 有序链表 维持链表有序
 */
public class OrderLinkedList {
    public ListNode insert(ListNode head, int value) {
        ListNode listNode = new ListNode(value);
        if (head==null){
            return listNode;
        }
        if (head.val > value){
            listNode.next = head;
            return listNode;
        }
        ListNode node = head;
        while (node.next!=null){
            if (node.next.val > value){
                listNode.next = node.next;
                break;
            }
            node = node.next;
        }
        node.next = listNode;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        OrderLinkedList list = new OrderLinkedList();
        head = list.insert(head,-2);
        head = list.insert(head,10);
        ListNode.print(head);
        head = list.insert(head,1);
        ListNode.print(head);
        head = list.insert(head,10);
        head = list.insert(head,2);
        head = list.insert(head,-2);
        head = list.insert(head,9);
        head = list.insert(head,3);
        head = list.insert(head,8);
        head = list.insert(head,4);
        head = list.insert(head,7);
        head = list.insert(head,5);
        head = list.insert(head,6);
        ListNode.print(head);
    }
}
