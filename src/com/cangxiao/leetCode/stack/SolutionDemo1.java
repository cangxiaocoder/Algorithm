package com.cangxiao.leetCode.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**字符串删除两个连续重复的元素
 * 如 abbbc 返回ac
 *    abbbaac 返回c
 * @Author cangxiao
 * @Date 2021/9/4
 * @Desc 删除连续重复的元素
 */
public class SolutionDemo1 {

    private Stack<Character> characterStack = new Stack<>();
    private Stack<Integer> integerStack = new Stack<>();

    public String remove(String str){
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (characterStack.isEmpty()){
                characterStack.push(c);
                integerStack.push(1);
                continue;
            }
            if (c!=characterStack.peek()){
                characterStack.push(c);
                integerStack.push(1);
                continue;
            }

            int count = integerStack.pop();
            if (count==2){
                characterStack.pop();
            }else {
                integerStack.push(count+1);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!characterStack.isEmpty()){
            Character character = characterStack.pop();
            Integer count = integerStack.pop();
            for (int i = 0; i < count; i++) {
                sb.append(character);
            }
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
       SolutionDemo1 solution = new SolutionDemo1();
        System.out.println(solution.remove("aabbbaac"));
    }
}
