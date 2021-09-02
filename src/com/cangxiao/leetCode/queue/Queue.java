package com.cangxiao.leetCode.queue;

/**
 * @Author cangxiao
 * @Date 2021/8/31
 * @Desc 队列
 */
public interface Queue<T> {

    boolean enqueue(T value);

    T dequeue();

    boolean isEmpty();
}
