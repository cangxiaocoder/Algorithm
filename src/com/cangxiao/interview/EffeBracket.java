package com.cangxiao.interview;


import java.util.LinkedList;

/**
 * @Author: cangxiao
 * @Since: 9/11/2026
 * @description: 有效括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 1.左括号必须用相同类型的右括号闭合。
 * 2.左括号必须以正确的顺序闭合。
 * 3.每个右括号都有一个对应的相同类型的左括号。
 * 示例 1：
 * 输入：s = "()"
 * 输出：true
 * 示例 2：
 * 输入：s = "()[]{}"
 * 输出：true
 * 示例 3：
 * 输入：s = "(]"
 * 输出：false
 */
public class EffeBracket {

    public static void main(String[] args) {
        EffeBracket effeBracket = new EffeBracket();
        effeBracket.isValid("()[]{}");
    }

    private boolean isValid(String str){
        int length = str.length();
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            switch (str.charAt(i)){
                case '(':
                    stack.push(')');
                case '[':
                    stack.push(']');
                case '{':
                    stack.push('}');
                default:
                    if (stack.isEmpty() || stack.pop() != str.charAt(i)){
                        return false;
                    }
            }

        }
        return stack.isEmpty();
    }
}
