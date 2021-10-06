package com.cangxiao.leetCode.easy;

import java.util.LinkedList;

/**
 * @Author cangxiao
 * @Date 2021/10/2
 * @Desc 706. 设计哈希映射
 */
public class MyHashMap {

    private class Node{
        int key;
        int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private static final int COUNT = 10000;
    private LinkedList<Node>[] map;
    public MyHashMap() {
        map = new LinkedList[COUNT];
    }

    private int hash(int key){
        return key%COUNT;
    }

    public void put(int key, int value) {
        LinkedList<Node> linkedList = map[hash(key)];
        if (linkedList==null){
            map[hash(key)] = new LinkedList<>();
            linkedList = map[hash(key)];
        }
        for (int i = 0; i < linkedList.size(); i++) {
            if (linkedList.get(i).key == key){
                linkedList.remove(i);
                break;
            }
        }
        linkedList.add(new Node(key, value));
    }

    public int get(int key) {
        LinkedList<Node> linkedList = map[hash(key)];
        if (linkedList==null) return -1;
        for (Node node : linkedList) {
            if (node.key == key) {
                return node.value;
            }
        }
        return -1;
    }

    public void remove(int key) {
        LinkedList<Node> linkedList = map[hash(key)];
        if (linkedList==null) return;
        for (int i = 0; i < linkedList.size(); i++) {
            if (linkedList.get(i).key == key){
                linkedList.remove(i);
                break;
            }
        }
    }

    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();
        map.put(1,1);
        map.put(2,2);
        System.out.println("map.get(1) = " + map.get(1));
    }
}
