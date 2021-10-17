package com.cangxiao.leetCode.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author cangxiao
 * @Date 2021/10/14
 * @Desc 590. N 叉树的后序遍历
 */
public class Solution590 {
    /**
     * @param root 根节点
     * @return
     */
    public List<Integer> postorder(Node root) {
        if (root==null) return new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        LinkedList<Node> stack = new LinkedList<>();
        LinkedList<Node> resultStack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node node = stack.pop();
            resultStack.push(node);
            for (int i = 0; i < node.children.size(); i++) {
                stack.push(node.children.get(i));
            }
        }
        while (!resultStack.isEmpty()){
            result.add(resultStack.pop().val);
        }
        return result;
    }

    public List<Integer> postorder2(Node root) {
        if (root==null) return new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        print(root, result);
        result.add(root.val);
        return result;
    }

    public void print(Node node, List<Integer> result){
        if (node==null) return;
        List<Node> children = node.children;
        for (Node child : children) {
            print(child, result);
            result.add(child.val);
        }

    }
}




