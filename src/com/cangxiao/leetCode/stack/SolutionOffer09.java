package com.cangxiao.leetCode.stack;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead操作返回 -1 )
 *
 * @Author cangxiao
 * @Date 2021/9/1
 * @Desc 剑指 Offer 09. 用两个栈实现队列
 */
public class SolutionOffer09 {

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public SolutionOffer09() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
//======================================================================================================================
    public void appendTail(int value) {
        if (stack1.isEmpty()){
            stack1.push(value);
            return;
        }
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        stack1.push(value);
        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }

    }

    public int deleteHead() {
        if (stack1.isEmpty())return -1;
        return stack1.pop();
    }
//======================================================================================================================
    public void appendTail2(int value) {
        if (stack1.isEmpty() && stack2.isEmpty()){
            stack1.push(value);
            return;
        }
        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        stack1.push(value);

    }

    public int deleteHead2() {
        if (stack1.isEmpty() && stack2.isEmpty())return -1;
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }

//======================================================================================================================
    public void appendTail3(int value) {
        stack1.push(value);
    }

    public int deleteHead3() {
        if (stack1.isEmpty() && stack2.isEmpty())return -1;
        if(!stack2.isEmpty())return stack2.pop();
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }

    public static void main(String[] args) {
        SolutionOffer09 solutionOffer09 = new SolutionOffer09();
        System.out.println(solutionOffer09.deleteHead());
        solutionOffer09.appendTail(12);
        System.out.println(solutionOffer09.deleteHead());
        solutionOffer09.appendTail(10);
        solutionOffer09.appendTail(9);
        System.out.println(solutionOffer09.deleteHead());
        System.out.println(solutionOffer09.deleteHead());
        System.out.println(solutionOffer09.deleteHead());
        solutionOffer09.appendTail(20);
        System.out.println(solutionOffer09.deleteHead());
        solutionOffer09.appendTail(1);
        solutionOffer09.appendTail(8);
        solutionOffer09.appendTail(20);
        solutionOffer09.appendTail(1);
        solutionOffer09.appendTail(11);
        solutionOffer09.appendTail(12);
        System.out.println(solutionOffer09.deleteHead());
        System.out.println(solutionOffer09.deleteHead());
        System.out.println(solutionOffer09.deleteHead());
        System.out.println(solutionOffer09.deleteHead());

    }
}
