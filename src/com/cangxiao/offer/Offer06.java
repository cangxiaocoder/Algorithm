package com.cangxiao.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author cangxiao
 * @Date 2022/2/22
 * @Desc 剑指 Offer 06. 从尾到头打印链表
 */
public class Offer06 {

    public int[] reversePrint(ListNode head) {
        if (head==null) return new int[0];
        List<Integer> list = new ArrayList<>();
        ListNode p = head;
        while (p!=null){
            list.add(p.val);
            p = p.next;
        }
        int[] result = new int[list.size()];
        int k = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            result[k++] = list.get(i);
        }
        return result;
    }

}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}