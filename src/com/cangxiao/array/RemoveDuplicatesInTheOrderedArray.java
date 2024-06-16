package com.cangxiao.array;


import java.util.Arrays;

/**
 * @Author cangxiao
 * @Date 2024/5/26
 * @Desc 删除有序数组中的重复项
 */
public class RemoveDuplicatesInTheOrderedArray {
    public static void main(String[] args) {
        int[] nums = {2,2,2,3,6,6,6,7};
        System.out.println(new RemoveDuplicatesInTheOrderedArray().removeDuplicates(nums));
    }

    /**
     * [2,2,3,6,6,6,7]
     * [2,*,3,6,*,*,7]
     * [2,3,*,6,*,*,7]
     * [2,3,6,7,*,*,*]
     * [2,2,2,3,6,6,6,7]
     * [2,3,2,2,6,6,6,7]
     * [2,3,6,2,2,6,6,7]
     * [2,3,6,7,2,6,6,2]
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int i = 1;
        int j = 1;
        while (i < nums.length && j < nums.length){
            boolean flag = true;
            for (int k = 0; k < i; k++) {
                if (nums[k] == nums[j]){
                    flag = false;
                    break;
                }
            }
            if (flag){
                swap(nums, i , j);
                i++;
            }
            j++;
        }
        System.out.println("nums = " + Arrays.toString(nums));
        return i;
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
