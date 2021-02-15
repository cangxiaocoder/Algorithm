package com.baiyu.structure.tree;


import java.util.Arrays;
import java.util.LinkedList;

/**
 * @Author: cangxiao
 * @Date: 2021/2/9
 * @des; 二叉树三种遍历方式
 */
public class BinaryTree<T> {

    private static Node root;

    public BinaryTree() {
    }

    public BinaryTree(T value) {
        root = new Node<>(root,null,null);
        currentNode = root;
    }

    private static class Node<T>{
        public T value;
        public Node left;
        public Node right;

        public Node(T value, Node left, Node right) {
            root.value = value;
            root.left = left;
            root.right = right;
        }
    }
    private static Node currentNode;
    public void add(T t){
        Node<T> node = new Node<>(t,null,null);
        if(root==null){
            root = node;
        }

        Node parentNode = currentNode;
        if(node.left==null){
            currentNode =
            parentNode.left = node;
        }
        if(node.right==null){
            parentNode.right = node;
        }
    }


    //3,2,9,10,8,4
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(3,2,9,10,8,4));

    }
}
