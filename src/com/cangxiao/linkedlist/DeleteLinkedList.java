package com.cangxiao.linkedlist;

/**
 * @Author cangxiao
 * @Date 2024/6/16
 * @Desc 删除链表元素
 */
public class DeleteLinkedList {

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        while (head != null && head.val == val) {
            head = head.next;
        }
        ListNode node = head;
        while (node!=null && node.next != null) {
            if (node.next.val == val) {
                node.next = node.next.next;
                continue;
            }
            node = node.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        OrderLinkedList list = new OrderLinkedList();
        head = list.insert(head, 1);
        head = list.insert(head, 1);
        head = list.insert(head, 1);
//        head = list.insert(head, 10);
//        head = list.insert(head, 2);
//        head = list.insert(head, 9);
//        head = list.insert(head, 3);
//        head = list.insert(head, 8);
//        head = list.insert(head, 4);
//        head = list.insert(head, 7);
//        head = list.insert(head, 5);
//        head = list.insert(head, 6);
        ListNode.print(head);
        DeleteLinkedList deleteLinkedList = new DeleteLinkedList();
        head = deleteLinkedList.removeElements(head, 5);
        ListNode.print(head);
        head = deleteLinkedList.removeElements(head, 1);
        head = deleteLinkedList.removeElements(head, 10);
        ListNode.print(head);

    }
}
