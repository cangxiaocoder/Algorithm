package com.cangxiao.nowcoder.string;

import java.util.Scanner;

/**
 * @author cangxiao
 * @date 
 * HJ1 字符串最后一个单词的长度
 */
public class HJ1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String str = scanner.nextLine();
            int count = 0;
            int i = str.length();
            while (i >= 0 && str.charAt(i--) != ' ') {
                count++;

            }
            
            System.out.println(count);
        }
        scanner.close();
    }
    
}
