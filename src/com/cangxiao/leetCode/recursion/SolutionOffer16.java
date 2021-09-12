package com.cangxiao.leetCode.recursion;

/**
 * @Author cangxiao
 * @Date 2021/9/11
 * @Desc 剑指 Offer 16. 数值的整数次方
 */
public class SolutionOffer16 {

    public double myPow(double x, int n) {
        if (x == 0) return 0;
        double result = 1;
        //当n = -2147483648 n = -n 会越界
        long b = n;
        if (b<0){
            x = 1/x;
            b = -b;
        }
        while (b!=0){
            if ((b&1)==1){
                result  *= x;
            }
            x *= x;
            b = b>>1;
        }

        return result;
    }



    public static void main(String[] args) {
        SolutionOffer16 solution = new SolutionOffer16();
        System.out.println(solution.myPow(1, -2147483648));
    }
}
