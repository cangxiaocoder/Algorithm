package com.cangxiao.crushTrain;

/**
 * @Author cangxiao
 * @Date 2024/11/18
 * @Desc 奇偶抽取
 * 小红拿到了一个正整数，她希望把数位中的奇数和偶数分别抽取出来然后做差，请你求出这个差的绝对值。
 * 例如，302938的奇数抽取出来是393，偶数抽取出来是28，最终的差的绝对值是365。
 */
public class OddAndEven {

    public int getDifference(int n) {
        int odd = 0;
        int even = 0;
        int i = 0;
        int j = 0;
        while (n > 0){
           int temp = n % 10;
           if ((temp & 1) == 0){
               odd = (int) (odd + temp * (Math.pow(10,i++)));
           }else {
               even = (int) (even + temp * (Math.pow(10,j++)));
           }
           n = n / 10;
        }
        System.out.println("odd = " + odd + " even = " + even);
        return Math.abs(odd - even);
    }


    public static void main(String[] args) {
        OddAndEven oddAndEven = new OddAndEven();
        System.out.println(oddAndEven.getDifference(302938));
        System.out.println(oddAndEven.getDifference(1));
        System.out.println(oddAndEven.getDifference(2));
        System.out.println(oddAndEven.getDifference(3));
        System.out.println(oddAndEven.getDifference(1000));
    }
}
