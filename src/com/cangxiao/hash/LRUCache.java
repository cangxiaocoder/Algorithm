package com.cangxiao.hash;

import sun.net.idn.Punycode;
import sun.security.krb5.internal.EncKDCRepPart;
import sun.security.krb5.internal.tools.Klist;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author cangxiao
 * @Date 2021/10/1
 * @Desc LRU缓存
 */
public class LRUCache {

    private Map<Integer, DLinkedNode> map;
    private int size;
    private int capacity;
    /**
     * 虚拟头节点
     */
    private DLinkedNode head;
    /**
     * 虚拟尾节点
     */
    private DLinkedNode tail;

    public LRUCache(int capacity) {
        this.map = new HashMap<>(capacity);
        this.size = 0;
        this.capacity = capacity;
        this.head = new DLinkedNode(-1,-1);
        this.tail = new DLinkedNode(-1,-1);
        this.head.prev = null;
        this.head.next = tail;
        this.tail.prev = head;
        this.tail.next = null;
    }

    public int get(int key){
        if (size==0) return -1;
        DLinkedNode node = map.get(key);
        if (node==null) return -1;
        /*
         * 值被使用， 将当前结点移动到头部
         */
        removeNode(node, key);
        addToHead(node, key);
        return node.value;
    }

    public void remove(int key){
        DLinkedNode node = map.get(key);
        if (node!=null){
            //从缓存中删除
            removeNode(node, key);
        }
    }


    public void add(int key, int value){
        DLinkedNode node = map.get(key);
        if (node!=null){
            //更新当前节点的值
            node.value = value;
            /*
                更新节点的位置到头节点
             */
            removeNode(node, key);
            addToHead(node, key);
            return;
        }
        if (size==capacity){
            /*
                删除尾节点
             */
            removeNode(tail.prev, tail.prev.key);
            size--;
        }
        node = new DLinkedNode(key, value);
        addToHead(node,key);
        size++;
    }
    private void addToHead(DLinkedNode node, int key) {
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
        map.put(key,node);
    }

    /**
     * 当前结点的前置节点的后置节点指向当前节点的下一个节点
     * 当前节点的后置节点的前置节点指向当前节点的前一个节点
     * @param node
     */
    private void removeNode(DLinkedNode node, int key) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        map.remove(key);
    }

    /**
     * 双向链表
     */
    private class DLinkedNode{
        private int key;
        private int value;
        private DLinkedNode prev;
        private DLinkedNode next;

        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
