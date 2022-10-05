package com.cangxiao.stack;

import com.cangxiao.offer.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author cangxiao
 * @Date 2022/10/5
 * @Desc 二叉树中序遍历
 */
public class InorderTraversal {

    private final List<Integer> result = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root==null)return result;
        /*inorderTraversal(root.left);
        result.add(root.val);
        inorderTraversal(root.right);
        return result;*/
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode current = root;
        while (current!=null || !stack.isEmpty()){
            //遍历左子树
            while (current!=null){
                stack.push(current);
                current = current.left;
            }
            //左子树遍历完成，遍历右子树
            if (!stack.isEmpty()){
                TreeNode node = stack.pop();
                result.add(node.val);
                current = node.right;
            }
        }
        return result;

    }


}
