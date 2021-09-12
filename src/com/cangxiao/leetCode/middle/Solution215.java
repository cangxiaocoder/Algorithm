package com.cangxiao.leetCode.middle;

import com.cangxiao.leetCode.linkedList.LinkedList;
import com.cangxiao.leetCode.linkedList.ListNode;

/**
 * @Author cangxiao
 * @Date 2021/9/12
 * @Desc 215. 数组中的第K个最大元素
 */
public class Solution215 {

    public int findKthLargest(int[] nums, int k) {
        return sort(nums,0,nums.length-1,k);
    }

    private int sort(int[] nums, int p , int q, int k){
        int index = partition(nums,p,q);
        if (index+1==k){
            return nums[index];
        }
        if (index+1 > k){
            return sort(nums,p,index,k);
        }
        return sort(nums,index+1,q, k);

    }

    private int partition(int[] nums, int p, int q) {
        int value = nums[p];
        while (p<q){
            while (p<q && value >= nums[q]){
                q--;
            }
            nums[p] = nums[q];
            while (p<q && value < nums[p]){
                p++;
            }
            nums[q] = nums[p];
        }
        nums[p] = value;
        return p;
    }
    public static void main(String[] args) {

        Solution215 solution = new Solution215();
        int k = solution.findKthLargest(new int[]{3,2,1,5,6,4},2);
        System.out.println("k = " + k);
    }

}
