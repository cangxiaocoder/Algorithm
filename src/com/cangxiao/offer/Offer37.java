package com.cangxiao.offer;

import com.cangxiao.offer.common.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author cangxiao
 * @Date 2022/4/4
 * @Desc 剑指 Offer 37. 序列化二叉树
 */
public class Offer37 {
    /**
     * 层序遍历二叉树
     * @param root
     * @return
     */
    public String serialize(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        if (root == null) {
            return sb.append("null").toString();
        }
        sb.append("[");
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                sb.append(node.val).append(",");
                queue.add(node.left);
                queue.add(node.right);
            } else {
                sb.append("null,");
            }
        }
        //删除最后一个逗号再返回
        return sb.deleteCharAt(sb.length() - 1).append("]").toString();
    }


    /**
     * 按照序列化顺序处理；第一个为根节点，第二个为左子树，第三个为右子树
     * @param data
     * @return
     */
    public TreeNode deserialize(String data) {
        if (data==null || data.equals("[]"))return null;
        String[] values = data.substring(1, data.length() - 1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (!"null".equals(values[i])) {
                node.left = new TreeNode(Integer.parseInt(values[i]));
                queue.add(node.left);
            }
            i++;
            if (!"null".equals(values[i])) {
                node.right = new TreeNode(Integer.parseInt(values[i]));
                queue.add(node.right);
            }
            i++;

        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        Offer37 offer37 = new Offer37();
        String serialize = offer37.serialize(root);
        System.out.println("serialize = " + serialize);
        String[] values = serialize.substring(1, serialize.length() - 1).split(",");
        System.out.println("data = " + Arrays.toString(values));

        TreeNode node = offer37.deserialize("[]");
        System.out.println("node = " + node);
    }
}
