package com.cangxiao.interview;

import java.util.concurrent.Callable;

/**
 * @Author 占栋
 * @Date 2023/6/12
 * @Desc 15171357227
 * 1个整数数组nums和两个整数firstLen和secondLen，找出两个非重叠子数组中元素的最大和，2个子数组长度分别为firstIen和secondLen。
 * 注意:
 *  1)长度为firstLen的子数组可以出现在长为secondLen的子数组之前或之后
 *  2)子数组是数组的一个连续部分，2个子数组不重叠;
 *  示例1:
 *  输入: nums=[0,6,5,2,2,5,1,9,4],firstLen=1,secondLen=2
 *  输出:
 *  20
 *  解释:子数组的一种选择中，[9]长度为1，[6,5]长度为2。
 *  示例2:
 *  输入: nums=[3,8,1,3,2,1,8,9,0],firstLen=3,secondLen=2输出:29
 *  解释:子数组的一种选择中，[3,8,1]长度为3，[8,9]长度为2。
 *  示例3:
 *  输入: nums=[2,1,5,6,0,9,5,0,3,8],firstLen=4,secondLen=3
 *  输出:
 *  31
 *  解释:子数组的一种选择中，[5,6,0,9]长度为4，[0,3,8]长度为3。
 *  示例4:
 *  输入: nums=[1,8,8,9,9,9,5,1,37,1],firstLen=1,secondLen=5
 *  输出:80
 *  解释:子数组的一种选择中，[37]长度为1，[8,8,9,9,9]长度为5。
 */
public class HW2 {
    public static void main(String[] args) {
//        int[] nums = new int[]{0,6,5,2,2,5,1,9,4};
//        int[] nums = new int[]{3,8,1,3,2,1,8,9,0};
//        int[] nums = new int[]{2,1,5,6,0,9,5,0,3,8};
        int[] nums = new int[]{1,8,8,9,9,9,5,1,37,1};
        int result = getMax(nums, 1, 5);
        System.out.println("result = " + result);
    }
    private static int getMax(int[] nums,int firstLen, int secondLen){
        if (nums.length==0) return 0;
        int i = 0;
        int j = firstLen - 1;
        int maxi = 0;
        int maxj = j;
        int firstMax = 0;
        int secondMax = 0;
        int temp = 0;
        for (int k=i; k < j; k++){
            temp = nums[k] + temp;
        }
        while (j<nums.length){
            temp = temp + nums[j];
            if (firstMax<temp){
                maxi = i;
                maxj = j;
                firstMax = temp;
            }
            temp = temp - nums[i];
            i++;
            j++;
        }
        int i2 = 0;
        int j2 = secondLen - 1;
        temp = 0;
        for (int k = i2; k < j2; k++){
            temp = nums[k] + temp;
        }
        while (j2<nums.length){
            if (j2>= maxi && j2 <= maxj){
                i2 = j2+maxj - maxi + 1;
                j2 = i2 + secondLen - 1;
            }
            if (j2>= nums.length){
                break;
            }
            temp = temp + nums[j2];
            secondMax = Math.max(secondMax,temp);
            temp = temp - nums[i2];
            i2++;
            j2++;
        }
        return firstMax + secondMax;
    }
}
