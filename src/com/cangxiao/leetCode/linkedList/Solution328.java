package com.cangxiao.leetCode.linkedList;

import com.cangxiao.linkedlist.ListNode;

/**
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 * 示例 1:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 *
 * @Author cangxiao
 * @Date 2021/8/28
 * @Desc 328. 奇偶链表
 */
public class Solution328 {

    public ListNode oddEvenList(ListNode head) {
        if (head==null)return null;

        ListNode oddHead = new ListNode();
        ListNode evenHead = new ListNode();
        oddHead.next = head;
        evenHead.next = head.next;
        ListNode odd = oddHead.next;
        ListNode even = evenHead.next;
        while (odd.next!=null && even.next!=null){
            odd.next = odd.next.next;
            odd = odd.next;
            even.next = even.next.next;
            even = even.next;
        }
        odd.next = evenHead.next;
        return oddHead.next;
    }

    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
        l1.add(1);
        l1.add(2);
        l1.add(3);
        l1.add(4);
        l1.add(5);

        Solution328 solution328 = new Solution328();
        ListNode listNode = solution328.oddEvenList(l1.head);
        ListNode.print(listNode);
    }
}
