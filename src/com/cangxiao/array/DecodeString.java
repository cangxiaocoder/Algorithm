package com.cangxiao.array;

import java.util.LinkedList;

public class DecodeString {

    public static String decodeString(String s) {
        int i = 0;
        StringBuilder sb = new StringBuilder();
        LinkedList<Integer> numList = new LinkedList<>();
        LinkedList<StringBuilder> strList = new LinkedList<>();
        int count = 0;
        while (i < s.length()) {
            if ('0' <= s.charAt(i) && s.charAt(i) <= '9'){
                count = s.charAt(i)-'0'+10*count;
            }else if (s.charAt(i) == '['){
                //之前可能已经存在字母串,所有先需要将字母串平接进去
                strList.push(sb);
                //根据题意，中括号之前一定存在数字
                numList.push(count);
                //置空count和temp
                count=0;
                sb = new StringBuilder();
            }else if (s.charAt(i) == ']'){
                int n = numList.pop();
                StringBuilder res = strList.pop();
                for(int j =0; j < n;j++){
                    res.append(sb);
                }
                sb = res;
            }else {
                sb.append(s.charAt(i));
            }

            i++;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str= "100[leetcode]";

        System.out.println(DecodeString.decodeString(str));
    }
}