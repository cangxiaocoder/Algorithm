package com.cangxiao.leetCode.queue;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author cangxiao
 * @Date 2021/9/8
 * @Desc 剑指 Offer 59 - I. 滑动窗口的最大值
 */
public class SolutionOffer59_1 {


    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length<1 || k<1){
            return new int[0];
        }
        Deque<Integer> queue = new LinkedList<>();
        int[] result = new int[nums.length-k+1];
        int i = 0;
        int j = 0;
        int index = 0;
        while (j < nums.length){
            if (j<k){
                while (!queue.isEmpty() && nums[j]>nums[queue.peekLast()]){
                    queue.pollLast();
                }
                queue.offer(j);
                j++;
                continue;
            }

            result[index++] = nums[queue.peek()];
            if (i>=queue.peek()){
                queue.poll();
            }
            i++;
            while (!queue.isEmpty() && nums[j]>nums[queue.peekLast()]){
                queue.pollLast();
            }
            queue.offer(j);
            j++;
        }
        if (queue.isEmpty()){
            return result;
        }
        result[index] = nums[queue.poll()];
        return result;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1,3,-1,-3,5,3,6,7};
        SolutionOffer59_1 solution = new SolutionOffer59_1();
        System.out.println(Arrays.toString(solution.maxSlidingWindow(array, 3)));
    }

}
