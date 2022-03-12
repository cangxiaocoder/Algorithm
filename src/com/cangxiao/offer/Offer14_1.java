package com.cangxiao.offer;

/**
 * @Author cangxiao
 * @Date 2022/3/12
 * @Desc
 */
public class Offer14_1 {

    public int cuttingRope(int n) {
        if (n<=3)return n-1;
        int result = 1;
        while (n>4){
            result =result * 3;
            n = n-3;
        }
        result = result * n;
        return result;
    }

    /**
     * 当绳子长度为2时 最大乘积为f(2) = 1 * 1 = 1;
     * 当绳子长度为3时 最大乘积为f(3) = 1 * 2 = 2;
     * 当绳子长度超过3时 3不应该被切分;
     *
     * @param n
     * @return
     */
    public int cuttingRope2(int n) {
        if (n <= 3) return n-1;
        int[] results = new int[n+1];
        results[1] = 1;
        results[2] = 2;
        results[3] = 3;
        for (int i = 4; i <= n; i++) {
            int max = 0;
            for (int j = 1; j <= i / 2; j++) {
                max = Math.max(max,results[j] * results[i - j]);
            }
            results[i] = max;
        }
        return results[n];
    }

    public static void main(String[] args) {
        System.out.println("result = " + new Offer14_1().cuttingRope(58));
        System.out.println("result = " + new Offer14_1().cuttingRope2(58));
    }
}
