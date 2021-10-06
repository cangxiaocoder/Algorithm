package com.cangxiao.leetCode.middle;

import javax.swing.text.html.HTMLWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author cangxiao
 * @Date 2021/10/2
 * @Desc 面试题 16.21. 交换和
 */
public class SolutionInterView16_21 {

    public int[] findSwapValues(int[] array1, int[] array2) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum1 = 0;
        int sum2 = 0;
        for (int i : array1) {
            sum1+=i;
        }
        for (int i = 0; i < array2.length; i++) {
            sum2 += array2[i];
            map.put(array2[i], i);
        }
        int sum = sum1+sum2;
        if ((sum & 1)==1) return new int[0];
        sum = sum / 2;
        int diff = Math.abs(sum - sum1);
        for (int i = 0; i < array1.length; i++) {
                  
        }
        return new int[0];
    }

    public static void main(String[] args) {
        SolutionInterView16_21 solution = new SolutionInterView16_21();
        int[] values = solution.findSwapValues(new int[]{519, 886, 282, 382, 662, 4718, 258, 719, 494, 795}, new int[]{52, 20, 78, 50, 38, 96, 81, 20});
        System.out.println("values = " + Arrays.toString(values));
    }
}
