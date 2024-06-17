package com.cangxiao.linkedlist;

import java.lang.reflect.Modifier;

/**
 * @Author cangxiao
 * @Date 2023/6/16
 */
public class BaseOperationLinkedList {


    public ListNode insertAtHead(ListNode head, int value) {
        ListNode listNode = new ListNode(value);
        listNode.next = head;
        return listNode;
    }

    public ListNode insertAtTail(ListNode head, int value) {
        ListNode node = head;
        ListNode listNode = new ListNode(value);
        if (node==null){
            return listNode;
        }
        while (node.next!=null){
            node = node.next;
        }
        node.next = listNode;
        return head;
    }

    public int size(ListNode head) {
        int size = 0;
        ListNode node = head;
        while (node!=null){
            size++;
            node = node.next;
        }
        return size;
    }

    public ListNode prev(ListNode head, ListNode enode) {
        if (head==null || enode==null || head == enode) {
            return null;
        }
        ListNode node = head;
        while (node.next != null){
            if (node.next == enode){
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public ListNode delete(ListNode head, ListNode enode) {
        if (head==null || enode==null) return head;
        ListNode node = head;
        if (head == enode){
            return head.next;
        }
        while (node.next!=null){
            if (node.next == enode){
               node.next = node.next.next;
               break;
            }
            node = node.next;
        }
        return head;
    }

    public static String toString(ListNode head) {
        StringBuilder sb = new StringBuilder();
        ListNode node = head;
        while (node!=null){
            sb.append(node.val).append(",");
            node = node.next;
        }
        return sb.deleteCharAt(sb.length()-1).toString();
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        BaseOperationLinkedList list = new BaseOperationLinkedList();
        head = list.insertAtHead(head, 2);
        ListNode.print(head);
        System.out.println(list.size(head));
        list.insertAtTail(head, 3);
        ListNode.print(head);
        System.out.println(list.size(head));
        ListNode prev = list.prev(head, head.next);
        ListNode.print(prev);
        System.out.println(list.size(head));
        list.delete(head, head.next);
        ListNode.print(head);
        System.out.println(list.size(head));

    }
}
