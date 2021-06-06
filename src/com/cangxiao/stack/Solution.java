package com.cangxiao.stack;

import java.util.Arrays;

/**
 * 请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 *
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 * @Author cangxiao
 * @Date 2021/4/18
 * @Desc 每日温度
 */
public class Solution {
    public int[] dailyTemperatures(int[] T) {
        int[] days = new int[T.length];
        if(T.length<2){
            days = new int[]{0};
        }

        for (int i = 0; i < T.length; i++) {
            days[i] = 0;
            for (int j = i+1; j < T.length; j++) {
                if(T[j]>T[i]){
                    days[i] = j-i;
                    break;
                }
            }
        }
        return days;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(solution.dailyTemperatures(temperatures)));
    }
}
