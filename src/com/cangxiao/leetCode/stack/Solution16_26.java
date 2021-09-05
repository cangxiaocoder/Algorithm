package com.cangxiao.leetCode.stack;

import java.util.Stack;

/**
 * 给定一个包含正整数、加(+)、减(-)、乘(*)、除(/)的算数表达式(括号除外)，计算其结果。
 *
 * 表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格。 整数除法仅保留整数部分。
 *
 * 示例1:
 *
 * 输入: "3+2*2"
 * 输出: 7
 * @Author cangxiao
 * @Date 2021/9/4
 * @Desc 面试题 16.26. 计算器
 */
public class Solution16_26 {

    public int calculate(String s) {
        Stack<Integer> stackNumber = new Stack<>();
        Stack<Character> stackSymbol = new Stack<>();
        int length = s.length();
        int i = 0;
        while (i < length){
            char c = s.charAt(i);
            if (c==' '){
                i++;
                continue;
            }
            if (isDigit(c)){
                int num = 0;
                while (i<length && isDigit(s.charAt(i))){
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }
                if (stackSymbol.isEmpty()){
                    stackNumber.push(num);
                    continue;
                }
                if (stackSymbol.peek()=='*'){
                    num = stackNumber.pop() * num;
                    stackSymbol.pop();
                }else if (stackSymbol.peek()=='/'){
                    num = stackNumber.pop() / num;
                    stackSymbol.pop();
                }
                stackNumber.push(num);
            }
            if (c=='+' || c == '-'){
                if (stackSymbol.isEmpty()){
                    stackSymbol.push(c);
                    i++;
                    continue;
                }
                if (stackSymbol.peek()=='+'){
                    int num = stackNumber.pop() + stackNumber.pop();
                    stackSymbol.pop();
                    stackNumber.push(num);
                }else if (stackSymbol.peek()=='-'){

                    int num = -stackNumber.pop() + stackNumber.pop();
                    stackSymbol.pop();
                    stackNumber.push(num);
                }
                stackSymbol.push(c);
                i++;
            }
            if (c=='*' || c=='/'){
                stackSymbol.push(c);
                i++;
            }
        }
        if (!stackSymbol.isEmpty()){
            if (stackSymbol.peek()=='+'){
                int num = stackNumber.pop() + stackNumber.pop();
                stackSymbol.pop();
                stackNumber.push(num);
            }else if (stackSymbol.peek()=='-'){
                int num = -stackNumber.pop() + stackNumber.pop();
                stackSymbol.pop();
                stackNumber.push(num);
            }
        }
        if (stackNumber.isEmpty())return 0;
        return stackNumber.pop();
    }

    private boolean isDigit(char c){
        return c>='0' && c <= '9';
    }

    public static void main(String[] args) {
        Solution16_26 solution = new Solution16_26();
        System.out.println(solution.calculate("5+3*2+1+1-2*3-4")+"======"+(5+3*2+1+1-2*3-4));
        System.out.println(solution.calculate("3+2*2")+"======"+(3+2*2));
        System.out.println(solution.calculate("3")+"======"+(3));
        System.out.println(solution.calculate("3+1")+"======"+(3+1));
        System.out.println(solution.calculate("")+"======"+(0));
        System.out.println(solution.calculate("42+42")+"======"+(42+42));
    }
}
