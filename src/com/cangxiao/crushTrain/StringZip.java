package com.cangxiao.crushTrain;

/**
 * @Author cangxiao
 * @Date 2024/8/11
 * @Desc 字符串压缩
 * 利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。
 * 比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没有变短，则返回原先的字符串。
 * 你可以假设字符串中只包含英文字母a~z和 A~Z。
 */
public class StringZip {

    public String zip(String str) {
        StringBuilder result = new StringBuilder();
        int i = 0;
        int j = 0;
        int len = str.length();
        while (i < len){
            int count = 0;
            char temp = str.charAt(i);
            while (j<len){
                if (temp != str.charAt(j)){
                    break;
                }
                count++;
                j++;
            }
            result.append(temp).append(count);
            i = j;
        }
        return result.length()<len?result.toString():str;
    }

    public static void main(String[] args) {
        StringZip stringZip = new StringZip();
        System.out.println(stringZip.zip("aabcccccaaa"));
        System.out.println(stringZip.zip("abbccd"));
    }
}
