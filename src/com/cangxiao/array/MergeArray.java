package com.cangxiao.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Author cangxiao
 * @Date 2022/7/30
 * @Desc
 */
public class MergeArray {

    public int[][] merge(int[][] intervals) {
        int k = 0;
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i][1] >= intervals[i+1][0]){
                intervals[i+1][0] = Math.min(intervals[i+1][0],intervals[i][0]);
                intervals[i+1][1] = Math.max(intervals[i+1][1],intervals[i][1]);
                k++;
                intervals[i][0] = 0;
                intervals[i][1] = 0;
            }
        }
        System.out.println("intervals = " + Arrays.deepToString(intervals));
        int[][] array = new int[intervals.length - k][2];
        int j = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0]==0 && intervals[i][1]==0){
                continue;
            }
            array[j++] = intervals[i];
        }
        return array;
    }

    public int[][] merge2(int[][] intervals) {
        if (intervals.length==0) return new int[0][0];
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> list = new ArrayList<>();
        for (int[] interval : intervals) {
            int l = interval[0];
            int r = interval[1];
            // 1 当list集合为空， 直接放入第一个元素
            // 2 list集合最后一个数组的右边元素值小于 l， 则说明没有重叠 ，则直接放入第一个元素
            if (list.isEmpty() || list.get(list.size() - 1)[1] < l){
                list.add(new int[]{l,r});
            }else {
                //有重叠，当前数组右边的元素则选择较大的那个值
                list.get(list.size() - 1)[1] = Math.max(list.get(list.size() - 1)[1], r);
            }
        }
        return list.toArray(new int[list.size()][2]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
//        int[][] intervals = {{1,4},{0,6}};
        MergeArray mergeArray = new MergeArray();
        int[][] merge = mergeArray.merge(intervals);
        System.out.println("merge = " + Arrays.deepToString(merge));
    }
}
