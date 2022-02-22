package com.cangxiao.offer;

/**
 * @Author cangxiao
 * @Date 2022/2/21
 * @Desc 剑指 Offer 05. 替换空格
 */
public class Offer05 {

    public String replaceSpace(String s) {
        int count = 0;
        int length = s.length();
        char[] chars = new char[length * 3];
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == ' '){
                chars[count++] = '%';
                chars[count++] = '2';
                chars[count++] = '0';
            }else {
                chars[count++] = s.charAt(i);
            }
        }
        return String.valueOf(chars,0,count);
    }

    public static void main(String[] args) {
        Offer05 offer05 = new Offer05();
        String space = offer05.replaceSpace("We are happy.");
        System.out.println("space = " + space);
    }
}
