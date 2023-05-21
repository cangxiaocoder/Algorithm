package com.cangxiao.nowcoder.string;

import java.util.Scanner;

/*
 * @author: cangxiao zhandchn@qq.com
 * @date: Do not edit
 * @desc: HJ4 字符串分隔
 * 2809226095
 * Copyright (c) 2023 by zhandchn@163.com, All Rights Reserved. 
 */
public class HJ4 {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String str = in.nextLine();
            StringBuilder sb = new StringBuilder();
            int length = str.length();
            int i = 0;
            while (i<length){
                while (sb.length() < 8 && i < length) {
                    sb.append(str.charAt(i));
                    i++;
                }
                if (sb.length()==8){
                    System.out.println(sb);
                    sb = new StringBuilder();
                }
                
            }
            if (!sb.isEmpty()){
                while (sb.length()<8){
                    sb.append('0');
                }
                System.out.println(sb);
            }
            
        }
        in.close();
    }
}
