package com.cangxiao.leetCode.code121;

import com.sun.org.apache.xpath.internal.operations.Or;

/**
 * @Author cangxiao
 * @Date 2021/8/7
 * @Desc 买卖股票的最佳时机
 */
public class Solution {
    /**
     * 股票只有两种，要么买， 要么卖
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE, maxPrice = 0;
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price; //要么买
            }
            if ((price - minPrice) > maxPrice) {
                maxPrice = price - minPrice; //要么卖
            }
        }
        return maxPrice;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{7,1,5,3,6,4} ;
//        int[] prices = new int[]{1,2} ;
        Solution solution = new Solution();
        int maxProfit = solution.maxProfit(prices);
        System.out.println(maxProfit);
    }
}
