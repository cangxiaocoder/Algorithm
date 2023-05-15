package com.cangxiao.nowcoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author cangxiao
 * @Date 2023/5/13
 * @Desc HJ6 质数因子
 * 质因数（素因数或质因子）在数论里是指能整除给定正整数的质数。除了1以外，两个没有其他共同质因子的正整数称为互质。
 * 因为1没有质因子，1与任何正整数（包括1本身）都是互质。正整数的因数分解可将正整数表示为一连串的质因子相乘，质因子如重复可以用指数表示。
 * 根据算术基本定理，任何正整数皆有独一无二的质因子分解式 [1] 。只有一个质因子的正整数为质数。
 */

public class HJ6 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Long> result = new ArrayList<>();
        long num = scanner.nextLong();

        while (num != 1) {

            long k = (long) StrictMath.sqrt(num) + 1;
            for (long i = 2; i < k; i++) {
                //只要当前数字能被整除就需要一直除以这个数，直到不能被整除为止
                while (num % i == 0) {
                    result.add(i);
                    num = num / i;
                    k = (long) StrictMath.sqrt(num) + 1;
                }
            }
            if (num != 1) {
                result.add(num);
            }
            System.out.println(result);

            //方便再次输入执行测试
            result.clear();
            num = scanner.nextLong();
        }
    }
}
