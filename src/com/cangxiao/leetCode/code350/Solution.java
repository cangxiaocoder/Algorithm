package com.cangxiao.leetCode.code350;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 * 示例 1：
 *
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 * @Author cangxiao
 * @Date 2021/8/7
 * @Desc 两个数组的交集 II
 */
public class Solution {

    public int[] intersect2(int[] nums1, int[] nums2) {
        int[] temp = new int[nums1.length]; int k = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            if(map.containsKey(num)){
                map.put(num,map.get(num)+1);
            }else {
                map.put(num,1);
            }
        }
        for (int num : nums2) {
            if (map.containsKey(num) && map.get(num) > 0) {
                temp[k++] = num;
                map.put(num, map.get(num) - 1);
            }
            if (map.isEmpty()) return temp;
        }
        return Arrays.copyOfRange(temp, 0, k);
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{4,9,5};
        int[] nums2 = new int[]{9,4,9,8,4};
        Solution solution = new Solution();
        int[] intersect2 = solution.intersect2(nums1, nums2);
        System.out.println(Arrays.toString(intersect2));

    }
}
