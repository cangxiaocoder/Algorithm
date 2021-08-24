package com.cangxiao.leetCode.interview;

import java.util.Arrays;

/**
 * 你正在使用一堆木板建造跳水板。有两种类型的木板，其中长度较短的木板长度为shorter，长度较长的木板长度为longer。
 * 你必须正好使用k块木板。编写一个方法，生成跳水板所有可能的长度。
 * <p>
 * 返回的长度需要从小到大排列。
 * <p>
 * 示例 1
 * <p>
 * 输入：
 * shorter = 1
 * longer = 2
 * k = 3
 * 输出： [3,4,5,6]
 * 解释：
 * 可以使用 3 次 shorter，得到结果 3；使用 2 次 shorter 和 1 次 longer，得到结果 4 。以此类推，得到最终结果。
 *
 * @Author cangxiao
 * @Date 2021/8/22
 * @Desc 面试题 16.11. 跳水板
 */
public class Solution16_11 {

    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) return new int[]{};
        if (shorter == longer) {
            return new int[]{shorter * k};
        }
        int[] boards = new int[k + 1];
        for (int i = 0; i <= k; i++) {
            boards[i] = shorter * (k - i) + longer * i;
        }
        return boards;
    }

    public static void main(String[] args) {
        Solution16_11 solution = new Solution16_11();
        System.out.println(Arrays.toString(solution.divingBoard(1, 2, 3)));
        System.out.println(Arrays.toString(solution.divingBoard(2, 2, 3)));
        System.out.println(Arrays.toString(solution.divingBoard(1, 2, 3)));
        System.out.println(Arrays.toString(solution.divingBoard(1, 2, 3)));
    }

}
