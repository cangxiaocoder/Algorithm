package com.cangxiao.array;

import java.util.Arrays;

/**
 * @Author: cangxiao
 * @Since: 7/11/2026
 * @description: 27. 移除元素
 */
public class RemoveArray {

    public int removeElement(int[] nums, int val) {
        int length = nums.length;
        int i = length - 1;
        int j = length - 1;
        while (i >= 0){
            if (nums[i] == val){
                if (nums[i] != nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
                j--;
            }
            i--;
        }
        return j + 1;
    }

    public static void main(String[] args) {
//        int[] nums = {0,1,2,2,3,0,4};
//        int[] nums = {0,1,2,2,3,0,4,2};
        int[] nums = {0,1,4,6,3,0,4,2};
//        int[] nums = {0,1,2,2,3,0,4,2,2};

        RemoveArray removeArray = new RemoveArray();
        int i = removeArray.removeElement(nums, 2);
        System.out.println(Arrays.toString(nums));
        System.out.println(i);
    }
}
