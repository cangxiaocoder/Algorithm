package com.cangxiao.leetCode.recursion;

import com.cangxiao.linkedlist.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author cangxiao
 * @Date 2021/9/10
 * @Desc 剑指 Offer 06. 从尾到头打印链表
 */
public class SolutionOffer06 {

    public int[] reversePrint(ListNode head) {

        Stack<Integer> stack = new Stack<>();
        ListNode p = head;
        while (p != null) {
            stack.push(p.val);
            p = p.next;
        }
        int[] result = new int[stack.size()];
        int i = 0;
        while (!stack.isEmpty()) {
            result[i++] = stack.pop();
        }
        return result;
    }

    List<Integer> list = new ArrayList<>();

    public int[] reversePrint2(ListNode head) {
        print(head);
        int[] result = new int[list.size()];
        int i = 0;
        for (Integer v : list) {
            result[i++] = v;
        }
        return result;
    }


    private void print(ListNode node) {
        if (node != null) {
            print(node.next);
            list.add(node.val);
        }
    }

}
