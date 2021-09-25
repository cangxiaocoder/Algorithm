package com.cangxiao.leetCode.easy;

/**
 * 猜数字游戏的规则如下：
 *
 * 每轮游戏，我都会从1到n 随机选择一个数字。 请你猜选出的是哪个数字。
 * 如果你猜错了，我会告诉你，你猜测的数字比我选出的数字是大了还是小了。
 * 你可以通过调用一个预先定义好的接口 int guess(int num) 来获取猜测结果，返回值一共有 3 种可能的情况（-1，1或 0）：
 *
 * -1：我选出的数字比你猜的数字小 pick < num
 * 1：我选出的数字比你猜的数字大 pick > num
 * 0：我选出的数字和你猜的数字一样。恭喜！你猜对了！pick == num
 * 返回我选出的数字。
 * @Author cangxiao
 * @Date 2021/9/21
 * @Desc 374. 猜数字大小
 */


public class Solution374  extends GuessGame{
    public int guessNumber(int n) {
        int left =1 ;
        int right = n;
        while (left<=right){
            int mid = left + (right - left)/2;
            if (guess(mid)==0)return mid;
            if (guess(mid)<0){
                right = mid-1;
            }else {
                left = mid+1;
            }
        }
        return -1;
    }

}

class GuessGame{
    int guess(int num){
        return -1;
    }
}