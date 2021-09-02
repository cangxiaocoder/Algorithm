package com.cangxiao.leetCode.stack;

/**
 * @Author cangxiao
 * @Date 2021/8/31
 * @Desc 栈
 */
public interface Stack<T> {
    /**
     * 入栈
     * @param value
     * @return
     */
    boolean push(T value);

    /**
     * 出栈并弹出栈顶元素
     * @param value
     * @return
     */
    T pop(T value);

    /**
     * 取出栈顶元素
     * @param value
     * @return
     */
    T peek(T value);

    /**
     * 栈是否为空
     * @return
     */
    boolean isEmpty();
}
