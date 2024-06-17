package com.cangxiao.leetCode.linkedList;

import com.cangxiao.linkedlist.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个链表，判断链表中是否有环。
 * <p>
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，
 * 我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 * 注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * <p>
 * 如果链表中存在环，则返回 true 。 否则，返回 false 。
 * 进阶：
 * <p>
 * 你能用 O(1)（即，常量）内存解决此问题吗？
 * 示例 1：
 * <p>
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 * @Author cangxiao
 * @Date 2021/8/29
 * @Desc 141. 环形链表
 */
public class Solution141 {

    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != slow && fast != null && fast.next != null) {

            fast = fast.next.next;
            slow = slow.next;
        }
        return fast != null && fast.next != null;
    }

    public boolean hasCycle2(ListNode head) {
        if (head == null) return false;
        Map<ListNode, Integer> map = new HashMap<>();
        ListNode p = head;
        while (p !=null){
            if (map.containsKey(p)){
                return true;
            }
            map.put(p,1);
            p = p.next;
        }
        return false;
    }


}
