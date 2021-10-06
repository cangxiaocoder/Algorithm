package com.cangxiao.leetCode.middle;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author cangxiao
 * @Date 2021/10/2
 * @Desc 146. LRU 缓存机制
 */
public class LRUCache {

    private Map<Integer,DLinkedList> cache;
    private int size;
    private int capacity;
    private DLinkedList head;
    private DLinkedList tail;

    public LRUCache(int capacity) {
        cache = new HashMap<>(capacity);
        this.capacity = capacity;
        this.size = 0;
        head = new DLinkedList(-1,-1);
        tail = new DLinkedList(-1,-1);
        head.next = tail;
        head.prev = null;
        tail.next = null;
        tail.prev = head;
    }

    public int get(int key) {
        if (size==0) return -1;
        DLinkedList node = cache.get(key);
        if (node==null) return -1;
        remove(node,key);
        addToHead(node, key);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedList node = cache.get(key);
        if (node!=null){
            node.value = value;
            remove(node,key);
            addToHead(node,key);
            return;
        }
        node = new DLinkedList(key, value);
        if (size==capacity){
            remove(tail.prev, tail.prev.key);
        }
        addToHead(node,key);
    }

    private void remove(DLinkedList node, int key){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        cache.remove(key);
        size--;
    }

    private void addToHead(DLinkedList node, int key){
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
        cache.put(key, node);
        size++;
    }


    private class DLinkedList{
        private int key;
        private int value;
        private DLinkedList prev;
        private DLinkedList next;

        public DLinkedList(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache =  new LRUCache(2);
        lruCache.put(1,1);
        lruCache.put(2,2);
        System.out.println("lruCache.get(1) = " + lruCache.get(1));
        lruCache.put(3,3);
        System.out.println("lruCache.get(2) = " + lruCache.get(2));
        lruCache.put(4,4);
        System.out.println("lruCache.get(1) = " + lruCache.get(1));
        System.out.println("lruCache.get(2) = " + lruCache.get(3));
        System.out.println("lruCache.get(4) = " + lruCache.get(4));

    }
}
