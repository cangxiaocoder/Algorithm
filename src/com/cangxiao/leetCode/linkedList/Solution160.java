package com.cangxiao.leetCode.linkedList;

/**
 * 给你两个单链表的头节点headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
 * 图示两个链表在节点 c1 开始相交：
 *       a1 -> a2
 *                  -> c1 -> c2 -> c3
 * b1 -> b2 -> b3
 * 题目数据 保证 整个链式结构中不存在环。
 *
 * 注意，函数返回结果后，链表必须 保持其原始结构 。
 * @Author cangxiao
 * @Date 2021/8/29
 * @Desc 160. 相交链表
 */
public class Solution160 {
    /**
     * 你们本彼此独立，各自沿着自己路在走， 当你们去过彼此的城市之后，才发现你心中有她，她心中有你，
     * 也许你们很幸运，在相遇之前你们就走过了相同的路，
     * 即使并非如此，你们也不远轻易放弃，你们做了共同的决定：
     * 你追寻她的脚步走一遍她曾走过的路；她追寻你的脚步去走一遍你曾走过的路，
     * 倘若你们有缘，你们终将在某一处彼此相遇.然后沿着相同的路继续向前
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode you = headA;
        ListNode she = headB;
        while (you!=she){
            you = you == null? headB : you.next;
            she = she == null? headA : she.next;
        }
        return you;
    }
}
