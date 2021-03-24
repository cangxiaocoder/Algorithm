package com.cangxiao.structure.tree;


import java.util.Arrays;
import java.util.LinkedList;

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

    public static void pre(Node node){
        if(node!=null){
            System.out.println(node.value);
            pre(node.left);
            pre(node.right);
        }
    }
    public static void mid(Node node){
        if(node!=null){
            mid(node.left);
            System.out.println(node.value);
            mid(node.right);
        }
    }
    public static void after(Node node){
        if(node!=null){
            after(node.left);
            after(node.right);
            System.out.println(node.value);
        }
    }

    //3,2,9,10,8,4
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(3,2,9,10,8,4));
        BinaryTree binaryTree = new BinaryTree(5);
        list.forEach(binaryTree::add);
        pre(BinaryTree.root);
        System.out.println("=============");
        mid(BinaryTree.root);
        System.out.println("=============");
        after(BinaryTree.root);
    }
}










