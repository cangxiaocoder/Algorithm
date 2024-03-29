package com.cangxiao.leetCode.code55;

/**
 * 给定一个非负整数数组nums ，你最初位于数组的 第一个下标 。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 判断你是否能够到达最后一个下标。
 * <p>
 * 示例1：
 * <p>
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 *
 * @Author cangxiao
 * @Date 2021/8/22
 * @Desc 55. 跳跃游戏
 */
public class Solution {

    public boolean canJump(int[] nums) {
        if (nums.length < 2) return true;
        int max = 0; //最远可达
        for (int i = 0; i < nums.length; i++) {
            //i 不能超过最远可达位置
            if(i <= max){
                if(max >= nums.length -1 ) return true;
                max = Integer.max(max, i + nums[i]);
            }

        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.canJump(new int[]{2,3,1,1,4}));
//        System.out.println(solution.canJump(new int[]{3,0,8,2,0,0,1}));
        System.out.println(solution.canJump(new int[]{0,1}));
        System.out.println(solution.canJump(new int[]{0,2,3}));
//        System.out.println(solution.canJump(new int[]{5, 2,0,0}));
//        System.out.println(solution.canJump(new int[]{2, 3, 1, 1, 4}));
//        System.out.println(solution.canJump(new int[]{3,1,0,0,4}));
//        System.out.println(solution.canJump(new int[]{3,2,1,0,4}));
//        System.out.println(solution.canJump(new int[]{3, 2, 1, 1, 0}));
    }
}
