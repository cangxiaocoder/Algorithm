package com.cangxiao.nowcoder;

import java.util.Scanner;

/**
 * @Author cangxiao
 * @Date 2023/5/13
 * @Desc <a href="https://www.nowcoder.com/practice/66ca0e28f90c42a196afd78cc9c496ea?tpId=37&difficulty=&judgeStatus=&tags=&title=&gioEnter=menu">HJ33 整数与IP地址间的转换</a>
 * 原理：ip地址的每段可以看成是一个0-255的整数，把每段拆分成一个二进制形式组合起来，然后把这个二进制数转变成
 * 一个长整数。
 * 举例：一个ip地址为10.0.3.193
 * 每段数字             相对应的二进制数
 * 10                   00001010
 * 0                    00000000
 * 3                    00000011
 * 193                  11000001
 * <p>
 * 组合起来即为：00001010 00000000 00000011 11000001,转换为10进制数就是：167773121，即该IP地址转换后的数字就是它了。
 */
public class HJ33 {

    /**
     * 把IP当做256进制
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String ip = in.next();
            if (ip.contains(".")){
                long num = 0;
                String[] strs = ip.split("\\.");
                for (String str : strs) {
                    num = num * 256 + Integer.parseInt(str);
                }
                System.out.println(num);
            }else {
                long ipDecimal = Long.parseLong(ip);
                String result = "";
                while (ipDecimal>0){
                    result = ipDecimal%256 + (result.isEmpty()?"":".") + result;
                    ipDecimal = ipDecimal / 256;
                }
                System.out.println(result);
            }
        }
    }

}
