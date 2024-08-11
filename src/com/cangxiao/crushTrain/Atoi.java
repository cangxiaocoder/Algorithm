package com.cangxiao.crushTrain;

/**
 * @Author cangxiao
 * @Date 2024/8/11
 * @Desc 请你实现一个 atoi() 函数，将字符串转换成一个 32 位有符号整数。atoi() 函数的功能逻辑如下：
 * (1) 忽略字符串前后的空格。
 * (2) 如果字符串在数字之前包含非数字字符（除-和+符号外），则转换失败，返回 0。
 * (3) 如果字符串在数字之后包含非数字字符，则只转换非数字字符之前的数字部分。
 * (4) 题目确保字符串转化成的整型数能够用 int 来表示，不需要考虑溢出情况。
 */
public class Atoi {

    public int atoi(String str) {
        long result = 0;
        Boolean flag = null;
        int i = 0;
        int len = str.length();
        // 去除前空格
        while (i<len && str.charAt(i)==' '){
            i++;
        }
        while (i<len){
            if (str.charAt(i) == '+' && flag == null){
                flag = true;
                i++;
                continue;
            }
            if (str.charAt(i) == '-' && flag == null){
                flag = false;
                i++;
                continue;
            }
            if (str.charAt(i)>='0' && str.charAt(i)<='9'){
                if (flag == null){
                    flag = true;
                }
                if (result > Integer.MAX_VALUE/10){
                    return 0;
                }
                result = result * 10;
                int temp = str.charAt(i) - '0';
                // 如果result加上最后以为超过了Integer.MAX_VALUE，则str可能是Integer.MIN_VALUE或不合法
                if (Integer.MAX_VALUE - result < temp){
                    // 可能是负数最小值
                    if (Integer.MAX_VALUE - result == temp - 1){
                        if (flag){
                            return 0;
                        }
                        result = Integer.MIN_VALUE;
                        break;
                    }
                    return 0;
                }
                result = result + temp;
            }else {
                break;
            }
            i++;
        }
        // 没有数字
        if (flag==null){
            return 0;
        }
        // 正数
        if (flag){
            return (int) result;
        }
        // 负数
        return (int) (-result);
    }

    public static void main(String[] args) {
        Atoi atoi = new Atoi();
        System.out.println("2147483648 = " + atoi.atoi("2147483648"));
        System.out.println("0-1 = " + atoi.atoi("0-1"));
        System.out.println("-123 = " + atoi.atoi("-123"));
        System.out.println("++123 = " + atoi.atoi("++123"));
        System.out.println("--123 = " + atoi.atoi("--123"));
        System.out.println("+-123 = " + atoi.atoi("+-123"));
        System.out.println("-+123 = " + atoi.atoi("-+123"));
        System.out.println("123 = " + atoi.atoi("123"));
        System.out.println("a123 = " + atoi.atoi("a123"));
        System.out.println("123a = " + atoi.atoi("123a"));
        System.out.println("1a23 = " + atoi.atoi("1a23"));
        System.out.println("   123 = " + atoi.atoi("    123"));
        System.out.println("   123     = " + atoi.atoi("    123   "));
        System.out.println("   1 23     = " + atoi.atoi("    1 23   "));
        System.out.println("MAX_VALUE = " + atoi.atoi(String.valueOf(Integer.MAX_VALUE)));
        System.out.println("MIN_VALUE = " + atoi.atoi(String.valueOf(Integer.MIN_VALUE)));
    }
}
