package com.cangxiao.leetCode.recursion;

/**
 * @Author cangxiao
 * @Date 2021/9/10
 * @Desc 面试题 08.01. 三步问题
 */
public class SolutionInterview08_01 {

    public int waysToStep(int n) {
        if (n==1) return 1;
        if (n==2) return 2;
        if (n==3) return 4;
        int mod = 1000000007;
        return (waysToStep(n-1)+waysToStep(n-2)+waysToStep(n-3))%mod;
    }

    public int waysToStep2(int n) {
        int a = 1, b =2, c = 4;
        if (n==1) return a;
        if (n==2) return b;
        if (n==3) return c;
        int mod = 1000000007;
        for (int i = 4; i <= n; i++) {
            int temp = ((a + b)%mod + c)%mod;
            a = b;
            b = c;
            c = temp;
        }
        return c;
    }

    public int waysToStep3(int n) {
        int a = 1, b =2, c = 4;
        if (n==1) return a;
        if (n==2) return b;
        if (n==3) return c;
        int mod = 1000000007;
        for (int i = 4; i <= n; i++) {
            int temp = (a+b)%mod;
            c = (c + temp)%mod;

        }
        return c;
    }

    public static void main(String[] args) {
        SolutionInterview08_01 solution = new SolutionInterview08_01();
        System.out.println(solution.waysToStep2(39));
        System.out.println(solution.waysToStep2(40));
        System.out.println(solution.waysToStep2(41));
        System.out.println(solution.waysToStep2(42));
        System.out.println(solution.waysToStep2(39)+solution.waysToStep2(40)+solution.waysToStep2(41));
    }
}
