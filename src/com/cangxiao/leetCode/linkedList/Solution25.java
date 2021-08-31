package com.cangxiao.leetCode.linkedList;

/**
 * 给你一个链表，每k个节点一组进行翻转，请你返回翻转后的链表。
 *
 * k是一个正整数，它的值小于或等于链表的长度。
 *
 * 如果节点总数不是k的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 进阶：
 *
 * 你可以设计一个只使用常数额外空间的算法来解决此问题吗？
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 * 示例 1：
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[2,1,4,3,5]
 *
 * @Author cangxiao
 * @Date 2021/8/28
 * @Desc 25. K 个一组翻转链表
 */
public class Solution25 {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode newHead = new ListNode();
        ListNode tail = newHead;

        ListNode p = head;

        while (p!=null){
            ListNode q = p;
            int i = 1;
            while (q!=null){
                //q走了k步，结束循环，执行反转
                if(i%k==0){
                    break;
                }
                i++;
                q = q.next;

            }
            if(q==null){
                tail.next = p;
                return newHead.next;
            }else {
                ListNode temp = q.next;
                ListNode[] listNodes = this.reverse(p, q);
                /*
                 * tail最开始指向newHead即使头节点也是尾节点，
                 * 为节点指向反转后的链表的头节点
                 */
                tail.next = listNodes[0];
                //将tail重新指向尾节点
                tail = listNodes[1];
                p = temp;
            }
        }

        return newHead.next;
    }

    /**
     * 反转链表的一部分，
     * @param head - 反转部分的头节点
     * @param tail - 反转部分的尾节点
     * @return 反转后的头节点和尾节点
     */
    private ListNode[] reverse(ListNode head, ListNode tail) {
        ListNode newHead = new ListNode();
        ListNode p = head;
        while (p!=tail){
            ListNode next = p.next;
            ListNode temp = newHead.next;
            newHead.next = p;
            newHead.next.next = temp;
            p = next;
        }
        tail.next = newHead.next;
        return new ListNode[]{tail,head};
    }


    public static void main(String[] args) {
        System.out.println(0%2);
        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        linkedList.add(6);
        linkedList.add(7);
        linkedList.add(8);
        Solution25 solution25 = new Solution25();
        ListNode listNodes = solution25.reverseKGroup(linkedList.head, 3);
        ListNode.print(listNodes);
    }
}
