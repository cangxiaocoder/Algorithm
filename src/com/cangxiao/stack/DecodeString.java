package com.cangxiao.stack;

import com.cangxiao.leetCode.stack.LinkedListStack;
import com.cangxiao.leetCode.stack.Stack;
import com.cangxiao.search.Test;

import java.io.BufferedReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author cangxiao
 * @Date 2022/10/12
 * @Desc 字符串解码
 */
public class DecodeString {
    //"3[ab2[cd]]"
    public String decodeString(String s) {
        char[] chars = s.toCharArray();
        int num = 0;
        StringBuilder sb = new StringBuilder();
        Deque<Integer> numStack = new LinkedList<>();
        Deque<StringBuilder> strStack = new LinkedList<>();
        for (char c : chars) {
            if (Character.isDigit(c)){
                num = num * 10 + c - '0';
            }else if (c=='['){
                numStack.push(num);
                //第一次放的是空值， 最后一个字母串没有放进去，依然保存在sb
                strStack.push(sb);
                sb = new StringBuilder();
                num = 0;
            }else if (c==']'){
                int n = numStack.pop();
                //拿到之前一个字母串
                StringBuilder temp = strStack.pop();
                for (int i = 0; i < n; i++) {
                    temp.append(sb);
                }
                //消除一个中括号好中括号中的字母串更新为temp
                sb = temp;
            }else {
                sb.append(c);
            }
        }
        return String.valueOf(sb);
    }

    public static void main(String[] args) {
        DecodeString decodeString = new DecodeString();
//        System.out.println("decodeString = " + decodeString.decodeString("3[a]2[bc]"));
        System.out.println("decodeString = " + decodeString.decodeString("3[a2[c]]"));
    }
}
