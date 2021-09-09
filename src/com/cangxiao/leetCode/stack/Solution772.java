package com.cangxiao.leetCode.stack;

import java.util.Stack;

/**
 * 给定一个包含正整数、加(+)、减(-)、乘(*)、除(/)、左括号、 右括号，计算其结果。
 * <p>
 * 表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格。 整数除法仅保留整数部分。
 *
 * @Author cangxiao
 * @Date 2021/9/6
 * @Desc 基本计算器
 */
public class Solution772 {

    public int calculate(String s) {
        Stack<Integer> stackNumber = new Stack<>();
        Stack<Character> stackSymbol = new Stack<>();
        int i = 0;
        int len = s.length();
        while (i < len) {
            char c = s.charAt(i);
            if (c == ' ') {
                i++;
                continue;
            }
            if (isDigit(c)) {
                int num = 0;
                while (i < len && isDigit(s.charAt(i))) {
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }
                stackNumber.push(num);
                continue;
            }
            if (c == '(') {
                stackSymbol.push(c);
                i++;
                continue;
            }
            if (c == ')') {
                while (!stackSymbol.isEmpty() && stackSymbol.peek() != '(') {
                    calculate(stackNumber, stackSymbol);
                }
                stackSymbol.pop();
                i++;
                continue;
            }
            //剩余的都是运算符
            if (stackSymbol.isEmpty() || priority(c, stackSymbol.peek())){
                stackSymbol.push(c);
            }else {
                while (!stackSymbol.isEmpty() && !priority(c, stackSymbol.peek())){
                    calculate(stackNumber, stackSymbol);
                }
                stackSymbol.push(c);
            }
            i++;
        }
        if (stackNumber.isEmpty()) return 0;
        while (!stackNumber.isEmpty() && !stackSymbol.isEmpty()){
            calculate(stackNumber, stackSymbol);
        }
        return stackNumber.pop();
    }

    /**
     *
     * @param c1 新来的符号
     * @param c2 栈顶符号
     * @return
     */
    private boolean priority(char c1, char c2){
        //栈顶符号是乘除则之前的可以直接计算
        if (c2=='*' || c2=='/'){
            return false;
        }
        //栈顶符号是加减，如果新符号也是加减则之前的可以直接计算，如果新符号也是乘除则不能直接计算
        if (c1 == '+' || c1 == '-'){
            return true;
        }
        return c1 == '*' || c1 == '/';
    }

    private void calculate(Stack<Integer> stackNumber, Stack<Character> stackSymbol) {
        switch (stackSymbol.pop()){
            case '+':
                stackNumber.push(stackNumber.pop() + stackNumber.pop());
                break;
            case '-':
                stackNumber.push(-stackNumber.pop() + stackNumber.pop());
                break;
            case '*':
                stackNumber.push(stackNumber.pop() * stackNumber.pop());
                break;
            case '/':
                int value = stackNumber.pop();
                stackNumber.push( stackNumber.pop()/value);
                break;
        }
    }

    private boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    public static void main(String[] args) {
        Solution772 solution = new Solution772();
        System.out.println(solution.calculate("3"));
        System.out.println(solution.calculate("2*3"));
        System.out.println(solution.calculate("2+3*4"));
        System.out.println(solution.calculate("(2+4)/2"));
        System.out.println(solution.calculate("4/2+(2*2+2*2-(4-2))"));
        System.out.println(solution.calculate("4/2+(2*(2+2)*2-(4-2))"));
        System.out.println(solution.calculate("4/2+(2*(6/2)*2-(4/2))"));
        System.out.println(solution.calculate("4/(2+2)*(2+2*(6/2)*2-(4/2))"));
    }
}
