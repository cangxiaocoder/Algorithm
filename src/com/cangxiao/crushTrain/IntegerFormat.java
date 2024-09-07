package com.cangxiao.crushTrain;

/**
  * @Author cangxiao
  * @Date 2024/9/5
  * @Desc 给定一个32位无符号整数，打印该整数的中文描述。
  */
public class IntegerFormat {
    String[] numStr = {"","一","二","三","四","五","六","七","八","九"};
    String[] digitals = {"","十","百","千"};
    String[] units = {"","万","亿"};
    String zero = "零";
    public String formatInteger(int num) {
        if (num == 0) return zero;
        int unit = 100000000;
        StringBuilder result = new StringBuilder();
        for (int i = 2; i >= 0; i--) {
            int cur = num / unit;
            if (cur > 0) {
                int digital = 1000;
                StringBuilder sb = new StringBuilder();
                int last = -1;
                for (int j = 3; j>=0; j--) {
                    int value = cur / digital;
                    if (value > 0){
                        sb.append(numStr[value]);
                        sb.append(digitals[j]);
                    }else if (last != 0 && (!sb.isEmpty() || !result.isEmpty())){
                        sb.append(zero);
                    }
                    last = value;
                    cur = cur % digital;
                    digital = digital / 10;
                }
                if (sb.length()>1 && sb.toString().endsWith(zero)){
                    sb.deleteCharAt(sb.length() - 1);
                }
                sb.append(units[i]);
                num = num%unit;
                result.append(sb);
            }
            unit = unit/10000;
        }
        // 一十前面的一可以省略
        return result.toString().startsWith("一十")?result.substring(1):result.toString();
    }

    public static void main(String[] args) {

        System.out.println(Integer.MAX_VALUE);
//        System.out.println(new IntegerFormat().formatInteger(Integer.MAX_VALUE));
//        System.out.println(new IntegerFormat().formatInteger(1147483647));
//        System.out.println(new IntegerFormat().formatInteger(123));
//        System.out.println(new IntegerFormat().formatInteger(1234));
//        System.out.println(new IntegerFormat().formatInteger(12345));
//        System.out.println(new IntegerFormat().formatInteger(123456));
        System.out.println(new IntegerFormat().formatInteger(10000001));
        System.out.println(new IntegerFormat().formatInteger(100000000));
        System.out.println(new IntegerFormat().formatInteger(1000000000));
        System.out.println(new IntegerFormat().formatInteger(10));
        System.out.println(new IntegerFormat().formatInteger(1001));
        System.out.println(new IntegerFormat().formatInteger(0));
    }
}
