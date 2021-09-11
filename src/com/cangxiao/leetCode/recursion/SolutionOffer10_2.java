package com.cangxiao.leetCode.recursion;

/**
 * @Author cangxiao
 * @Date 2021/9/10
 * @Desc 剑指 Offer 10- II. 青蛙跳台阶问题
 */
public class SolutionOffer10_2 {

    public int numWays(int n) {
        if (n==0) return 1;
        if (n==1) return 1;
//        if (n==2) return 2;
        int mod = (int) (1e9+7);
        return (numWays(n-1)+numWays(n-2))%mod;
    }
    public int numWays2(int n) {
        if (n==0) return 1;
        if (n==1) return 1;
        int mod = (int) (1e9+7);
        int a = 1;
        int b = 1;
        for (int i = 2; i <= n; i++) {
            b = a+b;
            a = b -a ;
            b = b%mod;
        }
        return b;
    }

    public static void main(String[] args) {
        int mod = (int) (1e9+7);
        SolutionOffer10_2 solution = new SolutionOffer10_2();
//        System.out.println(solution.numWays2(43));
//        System.out.println(solution.numWays2(44));
        System.out.println(solution.numWays2(45));
        System.out.println((701408733+134903163)%mod);
//        System.out.println(solution.numWays(44));
        System.out.println(mod+mod);
        System.out.println(Integer.MAX_VALUE);
    }

}
