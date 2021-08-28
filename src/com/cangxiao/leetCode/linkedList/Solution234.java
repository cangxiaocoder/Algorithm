package com.cangxiao.leetCode.linkedList;

/**
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 * 示例 1：
 * 输入：head = [1,2,2,1]
 * 输出：true
 * @Author cangxiao
 * @Date 2021/8/28
 * @Desc 234. 回文链表
 */
public class Solution234 {
    /**
     * 快慢指针 slow, fast
     * 当fast指针遍历完链表slow指针在中间
     * 翻转前半部分链表，与后半部分链表比较，相同则是回文链表。否则不是
     *
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode reverse = new ListNode();
        while (fast!=null && fast.next!=null){
            ListNode current = slow;
            slow = slow.next;
            fast = fast.next.next;

            ListNode temp = reverse.next;
            reverse.next = current;
            current.next = temp;
        }
        //去除反转链表的虚拟头节点
        reverse = reverse.next;
        //fast节点为空，链表节点偶数 说明slow节点正好走到一半
        if(fast==null){
            while (reverse!=null && slow!=null){
                if(reverse.val!=slow.val) return false;
                reverse = reverse.next;
                slow = slow.next;
            }
            return true;
        }
        //fast.next节点为空，链表节点为奇数 说明slow节点正好位于中间
        slow = slow.next;
        while (reverse!=null && slow!=null){
            if(reverse.val!=slow.val) return false;
            reverse = reverse.next;
            slow = slow.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(2);
        listNode.next.next.next = new ListNode(1);
        Solution234 solution234 = new Solution234();
        boolean flag = solution234.isPalindrome(listNode);
        System.out.println(flag);
    }
}
