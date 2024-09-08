package com.cangxiao.crushTrain;

import java.util.ArrayList;
import java.util.List;

/**
  * @Author cangxiao
  * @Date 2024/9/5
  * @Desc 给定一个32位无符号整数，打印该整数的英文描述。
 *  and 连接
  */
public class IntegerFormatEN {
    private final String[] LESS_THAN_20 = {"", "One ", "Two ", "Three ", "Four ", "Five ", "Six ", "Seven ", "Eight ",
            "Nine ", "Ten ", "Eleven ", "Twelve ", "Thirteen ", "Fourteen ", "Fifteen ", "Sixteen ", "Seventeen ",
            "Eighteen ", "Nineteen "};
    private final String[] TENS = {"", "", "Twenty ", "Thirty ", "Forty ", "Fifty ", "Sixty ", "Seventy ", "Eighty ",
            "Ninety "};
    private final String[] THOUSANDS = {"", "Thousand ", "Million ", "Billion "};
    private final String HUNDRED  = "Hundred";
    String zero = "Zero";
    public String formatInteger(int num) {
        if (num == 0) return zero;
        List<Integer> group = this.getGroup(num);
        String result = "";
        for (int i = 0; i < group.size(); i++) {
            String formatTen = this.formatTen(group.get(i));
            if (!formatTen.isEmpty()){
                result = formatTen + THOUSANDS[i] + result;
            }
        }
        return result;
    }

    public List<Integer> getGroup(int nums){
        List<Integer> ints = new ArrayList<>();
        while (nums / 1000 > 0){
            ints.add(nums % 1000);
            nums /= 1000;
        }
        ints.add(nums);
        return ints;
    }

    private String formatTen(int num){
        if (num == 0) return "";
        if (num < 20) return LESS_THAN_20[num];
        if (num < 100) {
            // 51, 前面处理了50，还需要处理1
            return TENS[num / 10] + formatTen(num % 10);
        }
        //小于1000的 999
        return LESS_THAN_20[num / 100] + HUNDRED + " " + formatTen(num % 100);
    }

    public static void main(String[] args) {
//        System.out.println(new IntegerFormatEN().formatInteger(10111));
        System.out.println(Integer.MAX_VALUE);
//        System.out.println(new IntegerFormat().formatInteger(Integer.MAX_VALUE));
//        System.out.println(new IntegerFormat().formatInteger(1147483647));
//        System.out.println(new IntegerFormat().formatInteger(123));
//        System.out.println(new IntegerFormat().formatInteger(1234));
//        System.out.println(new IntegerFormat().formatInteger(12345));
//        System.out.println(new IntegerFormat().formatInteger(123456));
//        System.out.println(new IntegerFormatEN().formatInteger(10000001));
//        System.out.println(new IntegerFormatEN().formatInteger(100000000));
//        System.out.println(new IntegerFormatEN().formatInteger(1000000000));
        System.out.println(new IntegerFormatEN().formatInteger(12345));
        System.out.println(new IntegerFormatEN().formatInteger(1001));
        System.out.println(new IntegerFormatEN().formatInteger(10001));
        System.out.println(new IntegerFormatEN().formatInteger(1000000001));
        System.out.println(new IntegerFormatEN().formatInteger(1234567));
    }
}
