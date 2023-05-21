package com.cangxiao.nowcoder.string;
import java.util.Scanner;
/*
 * @author: cangxiao zhandchn@qq.com
 * @date: 
 * @desc: HJ2 计算某字符出现次数
 * 2809226095
 * Copyright (c) 2023 by zhandchn@163.com, All Rights Reserved. 
 */


public class HJ2 {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       
        while (scanner.hasNext()){
            String str = scanner.nextLine();
            String letter = scanner.nextLine();
            char c = letter.toLowerCase().charAt(0);
            int length = str.length();
            int result = 0;
            for (int i = 0; i < length; i++) {
                if(c==str.charAt(i) || c==str.charAt(i) + 32){
                    System.out.println(c+"======="+str.charAt(i));
                    result++;
                }
            }
            System.out.println(result);
        }
        scanner.close();
    }
    
}
