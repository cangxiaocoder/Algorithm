package com.cangxiao.stack;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 示例 1：
 *
 * 输入：s = "()"
 * 输出：true：
 *
 * 输入：s = "()[]{}"
 * 输出：true
 * @Author cangxiao
 * @Date 2021/4/18
 * @Desc 有效括号
 */
public class Valid {
    /*
     * 左右括号不好比较，将左括号转成右括号，若遇到相等的括号，说明左右括号正好配对！
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] array = s.toCharArray();
        boolean flag = false;
        for (char c : array) {
            if('('==c){
                stack.push(')');
            }else if('['==c){
                stack.push(']');
            }else if('{'==c){
                stack.push('}');
            }else if(stack.isEmpty() || c != stack.pop()){
                return false;
            };
        }
        //栈中的元素匹配完，说明所有的括号都正好配对。
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "()";
        Valid valid = new Valid();
        boolean flag = valid.isValid(s);
        System.out.println("flag = " + flag);
    }
}
