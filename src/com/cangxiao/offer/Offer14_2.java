package com.cangxiao.offer;

/**
 * @Author cangxiao
 * @Date 2022/3/12
 * @Desc 剑指 Offer 14- II. 剪绳子 II
 */
public class Offer14_2 {

    public int cuttingRope(int n) {
        if (n<=3)return n-1;
        long result = 1;
        while (n>4){
            result =(int) ((result * 3) %(1e9+7));
//            result = (int) (result%(1e9+7));
            n = n-3;
        }
        result = result * n;
        return (int) (result%(1e9+7));
    }

    public static void main(String[] args) {
        System.out.println("result = " + new Offer14_2().cuttingRope(120));
    }
}
