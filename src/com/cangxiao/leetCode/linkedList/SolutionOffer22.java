package com.cangxiao.leetCode.linkedList;

/**
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 *
 * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
 * 示例：
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 *
 * 返回链表 4->5.
 *
 * @Author cangxiao
 * @Date 2021/8/28
 * @Desc 剑指 Offer 22. 链表中倒数第k个节点
 */
public class SolutionOffer22 {

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode newHead = new ListNode();
        newHead.next = head;
        ListNode p = newHead;
        int count = 0;
        while (p.next!=null){
            p = p.next;
            count++;
        }
        if (count<=k){
            return head;
        }
        p = head;
        int n = count - k+1;
        int i = 1;
        while (p!=null){
            if (i==n){
                return p;
            }
            i++;
            p = p.next;
        }
        return null;
    }

    public ListNode getKthFromEnd2(ListNode head, int k) {
        ListNode newHead = new ListNode();
        newHead.next = head;
        ListNode p = newHead;
        ListNode q = newHead;
        int i = 0;
        while (i++<k && p!=null) p = p.next;

        while (p!=null){
            p = p.next;
            q = q.next;
        }
        return q==newHead?q.next:q;
    }

    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
        l1.add(1);
        l1.add(2);
        l1.add(3);
        l1.add(4);
        l1.add(5);

        SolutionOffer22 solution = new SolutionOffer22();
        ListNode listNode = solution.getKthFromEnd2(l1.head,2);
        ListNode.print(listNode);
    }
}
