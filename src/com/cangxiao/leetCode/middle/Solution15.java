package com.cangxiao.leetCode.middle;

import java.util.*;

/**
 * 给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * @Author cangxiao
 * @Date 2021/10/1
 * @Desc 15. 三数之和
 */
public class Solution15 {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (i!=0 && nums[i]==nums[i-1]) continue;
            for (int j = i+1; j < nums.length; j++) {
                if (j!=i+1 && nums[j]==nums[j-1]) continue;
                int c = -nums[i] - nums[j];
                if (map.containsKey(c) && map.get(c)>j){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(-nums[i] - nums[j]);
                    result.add(list);
                }
            }
        }
        return result;
    }

    /**
     * 排序 + 双指针
     * 双指针固定k指针，移动 i, j 指针；
     * 固定k指针从头向后遍历，若出现nums[k]=nums[k-1] 则跳过，避免重复数据；
     * i, j指针分别从两端开始 i = k+1. j = nums.length - 1;
     * 记录固定K时所有满足nums[k] + nums[i] + nums[j] == 0 的 i,j 组合
     * 1. 当 nums[k]>0时 退出，因为nums[j]>nums[i]>nums[k] 若nums[k]>0, 则三数相加不可能为 0;
     * 2. 当nums[k]==nums[k-1]时，跳过此元素，若nums[k]满足条件，则nums[k-1]也一定满足，而nums[k-1]已经添加到组合中；
     * 3. 当i<j时，循环计算 S = nums[k] + nums[i] + nums[j]；
     *  - 若S>0, 则j = j - 1,并跳过重复的nums[j], 因为S>0 时，需要向左移动 j, 让三数之和变小
     *  - 若S<0, 则i = i + 1,并跳过重复的nums[i], 因为S<0 时，需向右移动 i 让三数之和变大
     *  - 若S==0, 记录{nums[i],nums[j],nums[k]} 同时i = i + 1, j = j + 1
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum2(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int k = 0; k < nums.length - 2; k++) {
            if (nums[k] > 0) break;
            if (k!=0 && nums[k]==nums[k-1]) continue;//避免nums[k]重复
            int i = k+1; int j = nums.length - 1;
            while (i<j){
                int s = nums[k] + nums[i] + nums[j];
                if (s>0){
                    while (i<j && nums[j]==nums[--j]);//跳过重复的nums[j]
                }else if (s<0){
                    while (i<j && nums[i]==nums[++i]);//跳过重复的nums[i]
                }else {
                    result.add(new ArrayList<>(Arrays.asList(nums[k],nums[i],nums[j])));
                    while (i<j && nums[j]==nums[--j]);//跳过重复的nums[j]
                    while (i<j && nums[i]==nums[++i]);//跳过重复的nums[i]
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution15 solution = new Solution15();
//        System.out.println(solution.threeSum2(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(solution.threeSum2(new int[]{-2,0,1,1,2}));
    }
}
