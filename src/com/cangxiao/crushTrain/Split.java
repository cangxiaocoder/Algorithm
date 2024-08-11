package com.cangxiao.crushTrain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author cangxiao
 * @Date 2024/8/11
 * @Desc 实现一个 split() 函数，将字符按照分割符进行分割，输出分割后的非空字符串。分割符只包含一个字符。
 */
public class Split {

    public List<String> split(String s, char t) {

        List<String> result = new ArrayList<>();
        int i = 0;
        int len = s.length();
        while (i < len){
            StringBuilder sb = new StringBuilder();
            while (i < len && s.charAt(i)!=t){
                sb.append(s.charAt(i));
                i++;
            }
            if (sb.length()>0)
                result.add(sb.toString());
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        String str = "aaaaa";
        System.out.println(Arrays.toString(str.split("a")));
        Split split = new Split();
        System.out.println(split.split(str, 'a'));
    }
}
