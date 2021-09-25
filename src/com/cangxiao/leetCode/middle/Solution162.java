package com.cangxiao.leetCode.middle;

/**
 * @Author cangxiao
 * @Date 2021/9/25
 * @Desc 162. 寻找峰值
 */
public class Solution162 {
    /**
     * 峰值的左侧和右侧元素一定小于峰值
     * 只要存在峰值一定存在一个元素比相邻的元素大，沿着这个元素向左或向右一定可以找到一个峰值
     * 如 arr[index] < arr[index+1] 则index之后一定存在一个峰值
     * 两个指针都向峰值靠近，当两个指针处在相同的位置就是峰值
     * @param arr
     * @return
     */
    public int findPeakElement(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        //当left和right相等时处在最高点
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid]<arr[mid+1]){
                //arr[mid]<arr[mid+1] 所以arr[mid]一定不是顶点，left可以直接跳过mid
                left = mid + 1;
            }else {
                //mid可能正好处在定点， 如果right = mid - 1 则会跳过定点
                right = mid;
            }
        }
        return left;
    }

}
