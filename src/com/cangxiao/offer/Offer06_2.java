package com.cangxiao.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author cangxiao
 * @Date 2022/2/22
 * @Desc 剑指 Offer 06. 从尾到头打印链表
 */
public class Offer06_2 {
    List<Integer> list = new ArrayList<>();
    public int[] reversePrint(ListNode head) {
        if (head==null) return new int[0];
        print(head);
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    private void print(ListNode node){
        if (node!=null){
            print(node.next);
            list.add(node.val);
        }
    }

}
