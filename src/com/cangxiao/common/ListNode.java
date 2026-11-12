package com.cangxiao.common;

/**
 * @Author cangxiao
 * @Date 2022/3/18
 * @Desc
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static void print(ListNode listNode) {
        ListNode p = listNode;
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        while (p != null) {
            sb.append(p.val).append(", ");
            p = p.next;
        }
        sb.append("null}");
        System.out.println(sb);

    }
    public void print() {
        ListNode p = this;
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        while (p != null) {
            sb.append(p.val).append(", ");
            p = p.next;
        }
        sb.append("null}");
        System.out.println(sb);

    }
}
