package com.cangxiao.leetCode.Offer61;

import java.util.*;

/**
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，
 * A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 * 示例1:
 * 输入: [1,2,3,4,5]
 * 输出: True
 * 输入: [0,0,1,2,5]
 * 输出: True
 * @Author cangxiao
 * @Date 2021/8/22
 * @Desc 剑指 Offer 61. 扑克牌中的顺子
 */
public class Solution {
    /**
     * 1。除去数组中的0后， 最大值 - 最小值 >= 5肯定不是顺子，
     * 2. 数字出现重复 肯定不是顺子
     * 3. 除去数组中的0后,数字不重复，最大值 - 最小值 < 5,
     *      3.1 数组中没有0 最大值 - 最小值 = 4 ，
     *      3.2 数组中有一个0 最大值 - 最小值 = 3 ，
     *      3.3 数组中有两个0 最大值 - 最小值 = 2 ，
     * @param nums
     * @return
     */
    public boolean isStraight(int[] nums) {
        int max = -1, min = 14;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if(num == 0){
                continue;
            }
            if(set.contains(num)){
                //出现重复
                return false;
            }
            set.add(num);
            if(max < num) max = num;
            if(min > num) min = num;
        }
        return max - min < 5;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isStraight(new int[]{1, 2, 3, 4, 5}));
        System.out.println(solution.isStraight(new int[]{0,0,1,2,5}));
        System.out.println(solution.isStraight(new int[]{0,0,8,2,5}));
        System.out.println(solution.isStraight(new int[]{0,0,0,0,5}));
        System.out.println(solution.isStraight(new int[]{0,0,0,0,0}));
    }
}
