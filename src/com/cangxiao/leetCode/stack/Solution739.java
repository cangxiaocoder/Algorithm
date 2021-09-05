package com.cangxiao.leetCode.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * 请根据每日 气温 列表 temperatures，请计算在每一天需要等几天才会有更高的温度。如果气温在这之后都不会升高，请在该位置用0 来代替。
 *
 * 示例 1:
 *
 * 输入: temperatures = [73,74,75,71,69,72,76,73]
 * 输出:[1,1,4,2,1,1,0,0]
 *
 * @Author cangxiao
 * @Date 2021/9/4
 * @Desc 739. 每日温度 - 单调栈
 */
public class Solution739 {

    Stack<Integer> stack = new Stack<>();

    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            if (stack.isEmpty()){
                stack.push(i);
                continue;
            }
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                result[stack.peek()] = i - stack.pop();
            }
            stack.push(i);
        }
//        如果栈中还有元素， 说明没有比其温度更大的温度了，直接默认为0；
//        while (!stack.isEmpty()){
//            result[stack.pop()] = 0;
//        }
        return result;
    }

    public static void main(String[] args) {
        Solution739 solution = new Solution739();
        System.out.println(Arrays.toString(solution.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
    }
}
