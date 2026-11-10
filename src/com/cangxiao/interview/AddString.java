package com.cangxiao.interview;

/**
 * @Author: cangxiao
 * @Since: 8/11/2026
 * @description: 两个字符串相加
 * 2. 两个字符串相加
 * 别名：大数相加
 * 描述：给两个大整数, 用字符串表示, 比如”21543655"", ""4332656442"", 都可能超过1万位, 写一个函数输出他们之和. 需要自己实现加法过程, 不能用某些语言自带的高精度加法函数.
 * 输入：""21543655”, ""4332656442""
 * 输出：""4354200097"""
 */
public class AddString {

    public static void main(String[] args) {
        String str1 = "99";
        String str2 = "1";
        AddString addString = new AddString();
        System.out.println(addString.add(str1, str2));
    }

    private String add(String str1, String str2){
        int length1 = str1.length();
        int length2 = str2.length();
        int length = Math.max(length1, length2);
        int i = length - 1;
        StringBuilder sb = new StringBuilder();
        StringBuilder str1Builder = new StringBuilder(str1);
        while (length1 < length){
            str1Builder.insert(0, '0');
            length1++;
        }
        str1 = str1Builder.toString();
        StringBuilder str2Builder = new StringBuilder(str2);
        while (length2 < length){
            str2Builder.insert(0, '0');
            length2++;
        }
        str2 = str2Builder.toString();
        int carry = 0;
        int value;
        while (i >= 0){
            int num1 = str1.charAt(i) - '0';
            int num2 = str2.charAt(i) - '0';
            int count = num1 + num2 + carry;
            if (count >= 10){
                carry = 1;
                value = count - 10;
            }else {
                carry = 0;
                value = count;
            }
            sb.insert(0, value);
            i--;
        }
        // 处理最高位剩余的进位
        if (carry > 0){
            sb.insert(0, carry);
        }

        return sb.toString();
    }
}
