package com.cangxiao.leetCode.easy;

import java.util.*;

/**
 * @Author cangxiao
 * @Date 2021/10/2
 * @Desc 349. 两个数组的交集
 */
public class Solution349 {

    public int[] intersection(int[] nums1, int[] nums2) {
        int[] result = new int[Math.min(nums1.length, nums2.length)];
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        int index = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
                continue;
            }
            if (nums1[i] > nums2[j]) {
                j++;
                continue;
            }
            if (nums1[i] == nums2[j] && (index == 0 || result[index - 1] != nums1[i])) {
                result[index++] = nums1[i];
            }
            i++;
            j++;
        }
        return Arrays.copyOfRange(result, 0, index);
    }

    public int[] intersection2(int[] nums1, int[] nums2,int[] nums3) {
        int[] intersection = intersection(nums1, nums2);
        return intersection(intersection, nums3);

    }

    public static void main(String[] args) {
        Solution349 solution = new Solution349();
        int[] intersection = solution.intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2});
        int[] intersection2 = solution.intersection(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4});
        System.out.println(Arrays.toString(intersection));
        System.out.println(Arrays.toString(intersection2));

        int[] intersection3 = solution.intersection2(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4}, new int[]{1, 9, 5});
        System.out.println(Arrays.toString(intersection3));
    }
}
