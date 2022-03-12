package com.cangxiao.offer;

/**
 * @Author cangxiao
 * @Date 2022/3/12
 * @Desc 剑指 Offer 15. 二进制中1的个数
 */
public class Offer15 {

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while (n!=0){
            if ((n&1)==1){
                count++;
            }
            n = n>>>1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println("二进制包含 1 的个数 = " + new Offer15().hammingWeight(3));
        System.out.println("二进制包含 1 的个数 = " + new Offer15().hammingWeight(-3));
        System.out.println("二进制包含 1 的个数 = " + new Offer15().hammingWeight(10));
        System.out.println("二进制包含 1 的个数 = " + new Offer15().hammingWeight(2));
        System.out.println("二进制包含 1 的个数 = " + new Offer15().hammingWeight(-1));
    }
}
