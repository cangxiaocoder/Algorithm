package com.cangxiao.linkedlist.base;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 缓存淘汰策略来决定。常见的策略有三种：
 * 先进先出策略 FIFO（First In，First Out）、
 * 最少使用策略 LFU（Least Frequently Used）、
 * 最近最少使用策略 LRU（Least Recently Used）。
 *
 * @Author cangxiao
 * @Date 2021/6/6
 * @Desc 缓存淘汰策略 - 基于数组实现
 */
public class LRUBasedArray<T> {

    private static final int DEFAULT_CAPACITY = 1 << 3;

    private int capacity;
    private T[] value;
    private int count;
    /**
     * 存储缓存对象的索引
     */
    private Map<T, Integer> holder;

    public LRUBasedArray() {
        this(DEFAULT_CAPACITY);
    }

    public LRUBasedArray(int capacity) {
        this.capacity = capacity;
        value = (T[]) new Object[capacity];
        count = 0;
        holder = new HashMap<>(capacity);
    }

    /**
     * 模拟访问某个值, 访问之后将这个值放到最前面
     */
    public void offer(T object) {
        if (object == null) {
            throw new IllegalArgumentException("不支持存储Null对象");
        }
        Integer index = holder.get(object);
        if (index == null) {
            //值不存在，需要缓存这个值
            if (isFull()) {
                removeAndCache(object);
            } else {
                cache(object);
            }
        } else {
            update(index);
        }
    }

    private void cache(T object) {
        rightShift(count);
        value[0] = object;
        holder.put(object,0);
        count++;
    }

    /**
     * 将缓存中的值右移
     * @param end 数组右移的边界
     */
    private void rightShift(int end) {
        for (int i = end-1; i >= 0; i--) {
            value[i+1] = value[i];
            holder.put(value[i+1], i+1);
            //holder.put(value[i], i+1);
        }
    }

    public boolean isFull() {return count == capacity;}

    public boolean isEmpty() {return count == 0;}

    private void removeAndCache(T object) {
        rightShift(count-1);
        value[0] = object;
        holder.put(object,0);
        /* T key = value[--count];
        holder.remove(key);
        cache(object, count); */
    }

    public void update(int index) {
        T key = value[index];
        rightShift(index);
        value[0] = key;
        holder.put(key,0);
    }

    @Override
    public String toString() {
        return "LRUBasedArray{" +
                "capacity=" + capacity +
                ", value=" + Arrays.toString(value) +
                ", count=" + count +
                ", holder=" + holder +
                '}';
    }

    public static void main(String[] args) {
        System.out.println(1 << 3);
        Integer[] val = new Integer[3];
        val[1] = null;
        val[2] = val[1];
        System.out.println(val[1]);
        System.out.println(val[2]);
    }
    static class TestLRUBasedArray {

        public static void main(String[] args) {
//            testDefaultConstructor();
//            testSpecifiedConstructor(4);
            testWithException();
        }

        private static void testWithException() {
            LRUBasedArray<Integer> lru = new LRUBasedArray<Integer>();
            lru.offer(null);
        }

        public static void testDefaultConstructor() {
            System.out.println("======无参测试========");
            LRUBasedArray<Integer> lru = new LRUBasedArray<Integer>();
            lru.offer(1);
            lru.offer(2);
            lru.offer(3);
            lru.offer(4);
            lru.offer(5);
            System.out.println(lru);
            lru.offer(6);
            lru.offer(7);
            lru.offer(8);
            lru.offer(9);
            System.out.println(lru);
        }

        public static void testSpecifiedConstructor(int capacity) {
            System.out.println("======有参测试========");
            LRUBasedArray<Integer> lru = new LRUBasedArray<Integer>(capacity);
            lru.offer(1);
            System.out.println(lru);
            lru.offer(2);
            System.out.println(lru);
            lru.offer(3);
            System.out.println(lru);
            lru.offer(4);
            System.out.println(lru);
            lru.offer(2);
            System.out.println(lru);
            lru.offer(4);
            System.out.println(lru);
            lru.offer(7);
            System.out.println(lru);
            lru.offer(1);
            System.out.println(lru);
            lru.offer(2);
            System.out.println(lru);
        }
    }
}
