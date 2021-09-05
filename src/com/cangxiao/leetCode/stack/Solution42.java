package com.cangxiao.leetCode.stack;

import java.util.Stack;

/**
 * @Author cangxiao
 * @Date 2021/9/5
 * @Desc 42. 接雨水
 */
public class Solution42 {


    public int trap(int[] height) {
        int result = 0;
        //单调栈维护索引 - 单调减
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
 //            if (stack.isEmpty()){
//                stack.push(i);
//                continue;
//            }
//            if (height[i] < height[stack.peek()]){
//                stack.push(i);
//                continue;
//            }
            while (!stack.isEmpty() && height[i] > height[stack.peek()]){
                //top保存两边柱子之间的柱子高度，
                int top = height[stack.pop()];
                if (stack.isEmpty()){
                    break;
                }
                //接雨水的数量为两边柱子的高度 * 柱子间 的间隔
                result+= (Math.min(height[i] - top, height[stack.peek()] - top)) * (i - stack.peek() -1);
            }
            stack.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution42 solution = new Solution42();
        System.out.println(solution.trap(new int[]{4, 2, 1, 3,2, 5}));
        System.out.println(solution.trap(new int[]{4}));
        System.out.println(solution.trap(new int[]{0,4}));
        System.out.println(solution.trap(new int[]{4,2}));
        System.out.println(solution.trap(new int[]{4,0,0,0,5}));
        System.out.println(solution.trap(new int[]{4,0,1,1,5}));
        System.out.println(solution.trap(new int[]{1,1,1}));
    }
}
