package com.cangxiao.leetCode.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Author cangxiao
 * @Date 2021/9/12
 * @Desc 56. 合并区间
 */
public class Solution56 {

    public int[][] merge(int[][] intervals) {
        if (intervals.length==0) return new int[0][0];
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int l = intervals[i][0];
            int r = intervals[i][1];
            //当list为空，或者list中最后一个数组的右区间小于当前数组的左区间时，则没有重叠
            if (list.isEmpty() || l > list.get(list.size()-1)[1]){
                list.add(new int[]{l,r});
            }else {
                //当list中最后一个数组的右区间大于等于当前数组的左区间时，则没有重叠
                list.get(list.size()-1)[1] = Math.max(list.get(list.size()-1)[1],r);
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}
