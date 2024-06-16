package com.cangxiao.structure.tree;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: cangxiao
 * @Date: 2021/2/9
 * @des; 二叉树三种遍历方式
 */
public class BinaryTree {

    public static Node root;
    private static int size;

    public BinaryTree() {

    }

    public BinaryTree(int value) {
        root = new Node(value,null,null);
        size = 1;
    }

    private static class Node{

        public int value;
        public Node left;
        public Node right;

        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
    public boolean add(int value){
        Node node = new Node(value,null,null);
        size++;
        if(root==null){
            root = node;
        }
        Node currentNode = root;
        Node parentNode;
        while (true){
            parentNode = currentNode;
            //根节点大于当前值放左边，否则放右边
            if(parentNode.value>value){
                if(parentNode.left==null) {

                    parentNode.left = node;
                    return true;
                }
                //当前父节点的左节点不为空，所以将父节点下移
                currentNode = parentNode.left;
            }else {
                if(parentNode.right==null){
                    parentNode.right = node;
                    return true;
                }
                //当前父节点的右节点不为空，所以将父节点下移
                currentNode = parentNode.right;
            }

        }
    }

    /**
     * 前序遍历 根 - 左 - 右
     * @param node
     */
    public static void pre(Node node){
        if(node!=null){
            System.out.println(node.value);
            pre(node.left);
            pre(node.right);
        }
    }

    public static void pre2(Node node){
        List<Integer> result = new ArrayList<>();
        LinkedList<Node> stack = new LinkedList<>();
        stack.push(node);
        while (!stack.isEmpty()){
            Node current = stack.pop();
            result.add(current.value);
            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }
        }
        System.out.println(result);
    }

    /**
     * 中序遍历 左 - 根 - 右
     * @param node
     */
    public static void mid(Node node){
        if(node!=null){
            mid(node.left);
            System.out.println(node.value);
            mid(node.right);
        }
    }

    public static void mid2(Node node){
        List<Integer> result = new ArrayList<>();
        LinkedList<Node> stack = new LinkedList<>();
        Node current = node;
        while (current!=null || !stack.isEmpty()){
            while (current!=null){
                stack.push(current);
                current = current.left;
            }
            Node tempNode = stack.pop();
            result.add(tempNode.value);
            if (tempNode.right!=null){
                current = tempNode.right;
            }
        }

        System.out.println(result);
    }

    /**
     * 后序遍历 左 - 右 - 根
     * @param node
     */
    public static void post(Node node){
        if(node!=null){
            post(node.left);
            post(node.right);
            System.out.println(node.value);
        }
    }

    public static void post2(Node node){
        List<Integer> result = new ArrayList<>();
        LinkedList<Node> stack = new LinkedList<>();
        LinkedList<Node> resultStack = new LinkedList<>();
        stack.push(node);
        while (!stack.isEmpty()){
            Node current = stack.pop();
            resultStack.push(current);
            if (current.left!=null){
                stack.push(current.left);
            }
            if (current.right!=null){
                stack.push(current.right);
            }
        }
        while (!resultStack.isEmpty()){
            result.add(resultStack.pop().value);
        }
        System.out.println(result);
    }

    /**
     * 层序遍历
     */
    public static void leve(Node node){
        List<Integer> result = new ArrayList<>();
        LinkedList<Node> queue= new LinkedList<>();
        queue.push(node);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();
                if (cur!=null){
                    result.add(cur.value);
                    if (cur.left!=null){
                        queue.offer(cur.left);
                    }
                    if (cur.right!=null){
                        queue.offer(cur.right);
                    }
                }

            }
        }
        System.out.println(result);
    }
    public static void leve2(Node node){
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Node> queue= new LinkedList<>();
        queue.push(node);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> levelResult = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();
                if (cur!=null){
                    levelResult.add(cur.value);
                    if (cur.left!=null){
                        queue.offer(cur.left);
                    }
                    if (cur.right!=null){
                        queue.offer(cur.right);
                    }
                }
            }
            result.add(levelResult);
        }
        System.out.println(result);
    }

    //3,2,9,10,8,4
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(3,2,9,10,8,4));
        BinaryTree binaryTree = new BinaryTree(5);
        list.forEach(binaryTree::add);
        pre(BinaryTree.root);
        pre2(BinaryTree.root);
        System.out.println("=============");
        mid(BinaryTree.root);
        mid2(BinaryTree.root);
        System.out.println("=============");
        post(BinaryTree.root);
        post2(BinaryTree.root);
        System.out.println("=============");
        leve(BinaryTree.root);
        leve2(BinaryTree.root);
    }
}










