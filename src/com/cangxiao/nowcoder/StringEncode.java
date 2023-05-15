package com.cangxiao.nowcoder;

import java.util.Scanner;

/**
 * @Author cangxiao
 * @Date 2023/5/14
 * @Desc 字符串编码
 * 给定一个字符串，请你将字符串重新编码，将连续的字符替换成“连续出现的个数+字符”。比如字符串AAAABCCDAA会被编码成4A1B2C1D2A。
 * 示例1
 * 输入：
 * AAAABCCDAA
 * 输出：
 * 4A1B2C1D2A
 */
public class StringEncode {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String str = in.nextLine();

            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (i<str.length()){
                char c = str.charAt(i);
                int count = 0;
                while (i<str.length() && c == str.charAt(i)){
                    //累计当前字母出现次数
                    count++;
                    //判断下一个字符
                    i++;
                }
               sb.append(count).append(c);
            }
            System.out.println(sb);
        }
    }
}
