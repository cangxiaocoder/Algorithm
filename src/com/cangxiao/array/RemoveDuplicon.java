package com.cangxiao.array;

import java.security.interfaces.ECKey;
import java.util.Arrays;

/**
 * @Author: cangxiao
 * @Since: 31/10/2026
 * @description: 删除有序数组中的重复项 II
 */
public class RemoveDuplicon {

    public int removeDuplicates(int[] nums) {
        if (nums.length  < 2){
            return nums.length;
        }
        int i = 2,j =  2;
        while (j < nums.length){
            if (nums[i - 2] != nums[j]){
                nums[i++] = nums[j];
            }
            j++;

        }
        for (int i1 = 0; i1 < i; i1++) {
            System.out.println(nums[i1]);
        }
        return i;
    }

    public static void main(String[] args) {
//        int[] nums = {0,0,1,1,1,1,2,2};
        int[] nums = {0,0,1,1,1,1,2,2,2,3,3,3};
        System.out.println();
        System.out.println(new RemoveDuplicon().removeDuplicates(nums));
    }
}
