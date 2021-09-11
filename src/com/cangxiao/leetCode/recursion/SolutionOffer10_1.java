package com.cangxiao.leetCode.recursion;

/**
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
 *
 * F(0) = 0, F(1)= 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * @Author cangxiao
 * @Date 2021/9/10
 * @Desc 剑指 Offer 10- I. 斐波那契数列
 */
public class SolutionOffer10_1 {
    /**
     * 递归
     * @param n
     * @return
     */
    public int fib(int n) {
        if (n==0) return 0;
        if (n==1) return 1;
        return (fib(n-1)+fib(n-2))%(1000000007);
    }

    /**
     * 递归 + 备忘录
     * @param n
     * @return
     */

    public int fib2(int n) {
        if (n==0) return 0;
        if (n==1) return 1;
        int[] cache = new int[n+1];
        return fib(n, cache);
    }
    private int fib(int n, int[] cache){
        int mod = (int)(1e9+7);
        cache[n] = (fib(n-1)+fib(n-2))%mod;
        return cache[n];
    }

    /**
     *
     * @param n
     * @return
     */
    public int fib3(int n) {
        if (n==0) return 0;
        if (n==1) return 1;
        int mod = (int)(1e9+7);
        int one = 0;
        int two = 1;
        for (int i = 2; i <= n; i++) {
            two = one+two;
            one = two -one ;
            two = two%mod;
        }
        return two;
    }

    public static void main(String[] args) {
        SolutionOffer10_1 solution = new SolutionOffer10_1();
        System.out.println(solution.fib3(3));
        System.out.println(solution.fib2(11));
        System.out.println(solution.fib(3));
    }
}
