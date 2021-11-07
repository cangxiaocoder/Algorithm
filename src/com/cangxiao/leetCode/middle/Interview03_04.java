package com.cangxiao.leetCode.middle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author cangxiao
 * @Date 2021/11/6
 * @Desc 面试题 04.03. 特定深度节点链表
 */
public class Interview03_04 {

    public ListNode[] listOfDepth(TreeNode tree) {
        if (tree==null) return null;
        List<ListNode> resultList = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(tree);
        while (!queue.isEmpty()){
            LinkedList<TreeNode> level = new LinkedList<>();
            ListNode head = new ListNode(-1);
            ListNode tail = head;
            //queue的大小在变，需要size临时存储
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                tail.next = new ListNode(node.val);
                tail = tail.next;
                if (node.left!=null){
                    level.offer(node.left);
                }
                if (node.right!=null){
                    level.offer(node.right);
                }
            }
            queue.addAll(level);
            resultList.add(head.next);
        }
        ListNode[] result = new ListNode[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }

    /**
     * @param tree
     * @return
     */
    public ListNode[] listOfDepth2(TreeNode tree) {
        if (tree==null) return null;
        List<ListNode> resultList = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(tree);
        while (!queue.isEmpty()){
            ListNode head = new ListNode(-1);
            ListNode tail = head;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                tail.next = new ListNode(node.val);
                tail = tail.next;
                if (node.left!=null){
                    queue.offer(node.left);
                }
                if (node.right!=null){
                    queue.offer(node.right);
                }
            }
            resultList.add(head.next);
        }
        ListNode[] result = new ListNode[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }
}

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}
