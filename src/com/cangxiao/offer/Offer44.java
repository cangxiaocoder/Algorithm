package com.cangxiao.offer;

/**
 * @Author cangxiao
 * @Date 2022/9/12
 * @Desc 剑指 Offer 44. 数字序列中某一位的数字
 */
public class Offer44 {

    /**
     * 数字范围     位数      数字数量     数位数量
     *   1~9       1         9          9
     *  10~99      2        90          180
     * 100~999     3        900         2700
     * start~end    digit   9*start     9*start*digit
     * @param n
     * @return
     */
    public int findNthDigit(int n) {
        int digit = 1; //1  2   3
        long start = 1; //1  10  100
        long count = 9;
        while (n>count){
            n -= count;
            digit+=1;
            start*=10;
            count = 9*start*digit;
        }
        //得到对应的数字 n-1 :减去start占的一位
        long num = start + (n-1)/digit;
        System.out.println("num = " + num);
        //n-1:第n个数，索引为n-1：
        return Long.toString(num).charAt((n-1) % digit) - '0';
    }

    public static void main(String[] args) {
        Offer44 offer44 = new Offer44();
        int nthDigit = 0;
        try {
            nthDigit = offer44.findNthDigit(1000000000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("nthDigit = " + nthDigit);
    }
}
