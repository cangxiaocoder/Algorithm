package com.cangxiao.leetCode.stack;

/**
 * @Author cangxiao
 * @Date 2021/8/31
 * @Desc 数组实现栈
 */
public class ArrayStack<T> implements Stack<T>{
    Object[] stack;
    int size = 0; //数据大小
    int n; // 栈大小

    public ArrayStack() {
        this(10);
    }

    public ArrayStack(int n) {
        this.n = n;
        stack = new Object[n];
    }

    @Override
    public boolean push(T value) {
        if(size==n)return false;//栈已满
        stack[size++] = value;
        return false;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T pop(T value) {
        if(isEmpty()) return null;
        return (T) stack[--size];
    }

    @Override
    @SuppressWarnings("unchecked")
    public T peek(T value) {
        if(isEmpty()) return null;
        return (T) stack[size-1];
    }

    @Override
    public boolean isEmpty(){
        return size==0;
    }
}
