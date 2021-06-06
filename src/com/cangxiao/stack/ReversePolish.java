package com.cangxiao.stack;

import java.util.LinkedHashMap;
import java.util.Stack;

/**
 * 逆波兰表达式：
 * 逆波兰表达式是一种后缀表达式，所谓后缀就是指算符写在后面。
 * 平常使用的算式则是一种中缀表达式，如 ( 1 + 2 ) * ( 3 + 4 ) 。
 * 该算式的逆波兰表达式写法为 ( ( 1 2 + ) ( 3 4 + ) * ) 。
 * 逆波兰表达式主要有以下两个优点：
 *
 * 去掉括号后表达式无歧义，上式即便写成 1 2 + 3 4 + * 也可以依据次序计算出正确结果。
 * 适合用栈操作运算：遇到数字则入栈；遇到算符则取出栈顶两个数字进行计算，并将结果压入栈中。
 * @Author cangxiao
 * @Date 2021/4/27
 * @Desc 逆波兰式（Reverse Polish notation，RPN，或逆波兰记法），也叫后缀表达式（将运算符写在操作数之后）
 */
public class ReversePolish {


    private Stack<Integer> stack = new Stack<>();

    public int evalRPN(String[] tokens) {
        int result;
        for (String token : tokens) {
            switch (token){
                case "+":
                    result = stack.pop();
                    result = stack.pop() + result;
                    stack.push(result);
                    break;
                case "-":
                    result = stack.pop();
                    result = stack.pop() - result;
                    stack.push(result);
                    break;
                case "*":
                    result = stack.pop();
                    result = stack.pop() * result;
                    stack.push(result);
                    break;
                case "/":
                    result = stack.pop();
                    result = stack.pop() / result;
                    stack.push(result);
                    break;
                default:
                    stack.push(Integer.parseInt(token));
                    break;
            }

        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String[] tokens = {"2","1","+","3","*"};
        ReversePolish reversePolish = new ReversePolish();

        System.out.println(reversePolish.evalRPN(tokens));
    }
}
