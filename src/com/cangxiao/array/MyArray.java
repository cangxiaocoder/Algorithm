package com.cangxiao.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author cangxiao
 * @Date 2024/6/16
 * @Desc 自定义动态数组
 */
public class MyArray {
    /**
     * 数组长度
     */
    int len;
    int[] array;
    int capacity;
    public MyArray() {
        capacity = 4;
        len = 0;
        array = new int[capacity];
    }

    public boolean insert(int index, int value) {
        // 超出范围
        if (index > len || index < 0){
            return false;
        }
        // 等于容量则需要扩容
        if (len == capacity) {
            reSize();
            array[index] = value;
        }
        for (int i = len - 1; i >= index; i--) {
            array[i+1] = array[i];
        }
        array[index] = value;
        len++;
        return true;
    }

    /**
     * 扩容两倍
     */
    private void reSize() {
        int[] tempArray = new int[ this.capacity * 2];
        for (int i = 0; i < array.length; i++) {
            tempArray[i] = array[i];
        }
        this.capacity *= 2;
        array = tempArray;
    }

    public int deleteElem(int index) {
        if (index >= len || index < 0){
            return -1;
        }
        int result = array[index];
        for (int i = index; i < len - 1; i++) {
            array[i] = array[i+1];
        }
        array[len - 1] = 0;
        len--;
        return result;
    }

    public int get(int index) {
        if (index >= len || index < 0){
            return -1;
        }
        return array[index];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < array.length; i++) {
            if (i==array.length - 1){
                sb.append(array[i]);
                break;
            }
            sb.append(array[i]).append(",");
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        MyArray myArray = new MyArray();
        myArray.insert(4,4);
        myArray.insert(0,0);
        myArray.insert(1,1);
        myArray.insert(2,2);
        myArray.insert(8,3);
        System.out.println(myArray.deleteElem(8));
        myArray.insert(4,4);
        System.out.println(myArray);
        System.out.println(myArray.deleteElem(8));
        System.out.println(myArray.deleteElem(3));
        System.out.println(myArray);
        System.out.println(myArray.deleteElem(1));
        System.out.println(myArray);
        myArray.insert(1,1);
        myArray.insert(1,11);
        System.out.println(myArray);

    }
}

