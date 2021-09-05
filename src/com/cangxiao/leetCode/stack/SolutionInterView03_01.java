package com.cangxiao.leetCode.stack;

import sun.awt.ScrollPaneWheelScroller;

import java.util.Stack;

/**
 * 栈排序。 编写程序，对栈进行排序使最小元素位于栈顶。最多只能使用一个其他的临时栈存放数据，但不得将元素复制到别的数据结构（如数组）中。该栈支持如下操作：push、pop、peek 和 isEmpty。当栈为空时，peek 返回 -1。
 *
 * @Author cangxiao
 * @Date 2021/9/2
 * @Desc 面试题 03.05. 栈排序
 */
public class SolutionInterView03_01 {

    private int[][] array; //每个栈中的数据
    private int[] indexs;  //每个栈数据的个数，

    public SolutionInterView03_01(int stackSize) {
        array = new int[3][stackSize];
        this.indexs = new int[3];
    }

    public void push(int stackNum, int value) {
        if (indexs[stackNum] >= array[stackNum].length){
            return;
        }
        array[stackNum][indexs[stackNum]++] = value;
    }

    public int pop(int stackNum) {
        if (indexs[stackNum] == 0) {
            return -1;
        }
        return array[stackNum][--indexs[stackNum]];
    }

    public int peek(int stackNum) {
        if (indexs[stackNum] == 0) {
            return -1;
        }
        return array[stackNum][indexs[stackNum]-1];
    }

    public boolean isEmpty(int stackNum) {

        return indexs[stackNum] == 0;
    }

    /**
     * ["TripleInOne", "peek", "pop", "isEmpty", "push", "pop", "push", "push", "pop", "push",
     * "push", "isEmpty", "pop", "peek", "push", "peek", "isEmpty", "peek", "pop", "push", "isEmpty",
     * "pop", "peek", "peek", "pop", "peek", "isEmpty", "pop", "push", "isEmpty", "peek", "push", "peek",
     * "isEmpty", "isEmpty", "isEmpty", "isEmpty", "peek", "push", "push", "peek", "isEmpty", "peek",
     * "isEmpty", "push", "push", "push", "peek", "peek", "pop", "push", "push", "isEmpty", "peek", "pop",
     * "push", "peek", "peek", "pop", "isEmpty", "pop", "peek", "peek", "push", "push"]
     * [[18], [1], [2], [1], [2, 40], [2], [0, 44], [1, 40], [0], [1, 54], [0, 42], [0], [1], [1],
     * [0, 56], [2], [0], [2], [2], [1, 15], [1], [1], [0], [2], [0], [0], [1], [0], [0, 32], [0],
     * [0], [0, 30], [2], [1], [1], [0], [0], [0], [0, 56], [1, 40], [2], [0], [0], [0], [2, 11],
     * [0, 16], [0, 3], [2], [0], [2], [0, 39], [0, 63], [1], [2], [0], [2, 36], [1], [0], [2], [1], [0], [1], [2], [0, 8], [0, 38]]
     *
     *
     * [null,-1,-1,true,null,40,null,null,44,null,null,false,54,54,null,-1,false,
     * -1,-1,null,false,15,0,-1,56,56,false,42,null,false,56,null,-1,false,false,false,
     * false,0,null,null,-1,false,0,false,null,null,null,0,0,11,null,null,false,-1,63,null,0,63,36,false,39,0,-1,null,null]
     * @param args
     */
    public static void main(String[] args) {
        SolutionInterView03_01 solution = new SolutionInterView03_01(5);
//        solution.push(2, 40);
//        solution.push(0, 44);
//        solution.push(1, 40);
//        solution.push(1, 54);
//        solution.push(0, 42);
        solution.push(0, 1);
        solution.push(0, 2);
        solution.push(0, 3);
        System.out.println(solution.pop(0));
        System.out.println(solution.peek(0));
        System.out.println(solution.pop(0));
        System.out.println(solution.peek(0));
        System.out.println(solution.pop(0));
        System.out.println(solution.peek(0));
    }
}
