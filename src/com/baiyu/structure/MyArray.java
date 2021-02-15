package com.baiyu.structure;

import com.sun.java.swing.plaf.windows.WindowsDesktopIconUI;
import com.sun.prism.impl.shape.BasicRoundRectRep;

/**
 * @Author: cangxiao
 * @Date: 2021/2/8
 * @des; 数组基本操作
 */
public class MyArray {

    private int[] array;
    private int size;

    public MyArray(int capacity) {
        this.array = new int[capacity];
        size = 0;
    }

    /**
     * 随机读取元素
     */
    public int get(int index) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException("索引越界");
        }
        return array[index];
    }

    /**
     * 更新元素
     */
    public void set(int index, int value) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException("索引越界");
        }
        array[index] = value;
    }

    /**
     * 插入元素
     */
    public boolean insert(int index, int value) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException("索引越界");
        }
        //3. 超出数组范围的插入
        if (size >= array.length) {
            //扩容数组
            resize();
        }
        //1. 尾部插入
        /*if (index == size) {
            array[index] = value;
            size++;
            return true;
        }*/
        //2. 中间插入（包含头部插入）
        if (index > 0) {
            for (int i = size - 1; i >= index; i--) {
                array[i + 1] = array[i];
            }

        }
        array[index] = value;
        size++;
        return true;

    }


    private void resize() {
        int[] arrayNew = new int[array.length * 2];
        System.arraycopy(array,0,arrayNew,0,array.length);
        array = arrayNew;
    }

    /**
     * 删除元素
     */
    public boolean delete(int index){
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException("索引越界");
        }
        for (int i = index; i < size; i++) {
            array[i] = array[i+1];
        }
        size--;
        return true;
    }
    public void output(){
        for (int i = 0; i < size; i++) {
            System.out.println(array[i]);
        }
    }
    public static void main(String[] args) {
        MyArray array = new MyArray(4);
        array.insert(0,3);
        array.insert(1,7);
        array.insert(2,5);
        array.set(2,6);
        array.output();
        System.out.println("===========");
        array.insert(2,2);
        array.output();
        System.out.println("===========");
        array.insert(2,8);
        array.insert(2,1);
        array.output();
        System.out.println("===========");
        array.delete(1);
        array.output();
        System.out.println("===========");
        array.delete(4);
        array.output();
        System.out.println("===========");
//        array.delete(5);
        array.output();
    }
}
