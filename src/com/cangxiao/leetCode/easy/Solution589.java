package com.cangxiao.leetCode.easy;

import java.util.*;

/**
 * @Author cangxiao
 * @Date 2021/10/14
 * @Desc 589. N 叉树的前序遍历
 */
public class Solution589 {
    List<Integer> result = new ArrayList<>();
    public List<Integer> preorder1(Node root) {
        print1(root);
        return result;
    }

    private void print1(Node node){
        if (node==null) return;;
        result.add(node.val);
        List<Node> children = node.children;
        for (Node child : children) {
            result.add(child.val);
            print1(child);
        }
    }

    public List<Integer> preorder(Node root) {
        if (root==null) return new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        result.add(root.val);
        LinkedList<Node> stack = new LinkedList<>(root.children);
        while (!stack.isEmpty()){
            Node node = stack.pop();
            result.add(node.val);
            //倒序遍历， 可以将左边的节点放到栈顶
            for (int i = node.children.size() - 1; i >= 0; i--) {
                stack.push(node.children.get(i));
            }
        }
        return result;
    }

}
