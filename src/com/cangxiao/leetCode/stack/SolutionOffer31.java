package com.cangxiao.leetCode.stack;

import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如，序列 {1,2,3,4,5} 是某栈的压栈序列，
 * 序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
 *
 * @Author cangxiao
 * @Date 2021/9/5
 * @Desc 剑指 Offer 31. 栈的压入、弹出序列
 */
public class SolutionOffer31 {


    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        int j = 0;
        while (i<popped.length  && j<popped.length){
            if (pushed[i]!=popped[j]){
                stack.push(pushed[i]);
                i++;
                continue;
            }
            j++;
            i++;
            while (!stack.isEmpty() && j<popped.length){
                if (stack.peek()!=popped[j]){
                    break;
                }
                j++;
                stack.pop();
            }
        }
        while (!stack.isEmpty() && j<popped.length){
            if (stack.peek()!=popped[j++]){
                break;
            }
            j++;
            stack.pop();
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        SolutionOffer31 solution = new SolutionOffer31();
        System.out.println(solution.validateStackSequences(new int[]{1,2,3,4,5}, new int[]{4,5,3,2,1}));
    }
}
