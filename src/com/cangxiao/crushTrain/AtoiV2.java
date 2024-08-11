package com.cangxiao.crushTrain;

/**
 * @Author cangxiao
 * @Date 2024/8/11
 * @Desc 请你实现一个 atoi() 函数，将字符串转换成一个 32 位有符号整数（int类型）。atoi() 函数的功能逻辑如下：
 * (1) 忽略字符串前后的空格。
 * (2) 如果字符串在数字之前包含非数字字符（除-和+符号外），则转换失败，返回 0。
 * (3) 如果字符串在数字之后包含非数字字符，则只转换非数字字符之前的数字部分。
 * (4) 如果转换后的整数超过32位整型数（int类型）可表示的范围（即[-2^31, 2^31-1]），则返回 0
 */
public class AtoiV2 {

    public int atoi(String s) {
        int result = 0;
        Boolean flag = null;
        int i = 0;
        int len = s.length();
        // 去除前空格
        while (i<len && s.charAt(i)==' '){
            i++;
        }
        while (i<len){
            if (s.charAt(i) == '+' && flag == null){
                flag = true;
                i++;
                continue;
            }
            if (s.charAt(i) == '-' && flag == null){
                flag = false;
                i++;
                continue;
            }
            if (s.charAt(i)>='0' && s.charAt(i)<='9'){
                if (flag==null){
                    // 已经存在数字不能再有‘+’ 或 ‘-’
                    flag = true;
                }
                if (result > Integer.MAX_VALUE/10){
                    return 0;
                }
                result = result * 10;
                int temp = s.charAt(i) - '0';
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
        // -2147483648 结束后还有数字则不合法
        if (i + 1<len && s.charAt(i+1)>='0' && s.charAt(i+1)<='9' && result == Integer.MIN_VALUE){
            return 0;
        }

        // 不合法
        if (flag==null){
            return 0;
        }
        // 正数
        if (flag){
            return result;
        }
        // 负数
        return -result;
    }

    public static void main(String[] args) {
        AtoiV2 atoi = new AtoiV2();
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
        System.out.println("21474836470 = " + atoi.atoi("21474836470"));
        System.out.println("2147483646 = " + atoi.atoi("2147483646"));
        System.out.println("2147483647 = " + atoi.atoi("2147483647 "));
        System.out.println("21474836460 = " + atoi.atoi("21474836460"));
        System.out.println("-21474836480 = " + atoi.atoi("-21474836480"));
        System.out.println("-2147483647 = " + atoi.atoi("-2147483647"));
        System.out.println("-2147483648 = " + atoi.atoi("-2147483648 "));
        System.out.println("-21474836470 = " + atoi.atoi("-21474836470"));
    }
}
