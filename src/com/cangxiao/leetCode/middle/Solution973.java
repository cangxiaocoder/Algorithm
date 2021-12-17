package com.cangxiao.leetCode.middle;

import javax.lang.model.element.VariableElement;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author cangxiao
 * @Date 2021/12/4
 * @Desc 973. 最接近原点的 K 个点
 */
public class Solution973 {

    private static class QElement {
        int i;
        int j;

        public QElement(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        if (k==0) return null;
        PriorityQueue<QElement> maxQueue = new PriorityQueue<>(
                (o1, o2) -> Double.compare(Math.pow(o2.i, 2) + Math.pow(o2.j, 2), Math.pow(o1.i, 2) + Math.pow(o1.j, 2)));
        for (int i = 0; i < points.length; i++) {
            if (maxQueue.size() < k) {
                maxQueue.offer(new QElement(points[i][0],points[i][1]));
                continue;
            }

            double dis = Math.pow(points[i][0], 2) + Math.pow(points[i][1], 2);
            QElement element = maxQueue.peek();
            double maxDis = Math.pow(element.i,2)+Math.pow(element.j,2);
            if (Double.compare(maxDis, dis)>0) {
                maxQueue.poll();
                maxQueue.offer(new QElement(points[i][0],points[i][1]));
            }
        }
        int[][] result = new int[maxQueue.size()][2];
        int size = maxQueue.size();
        for (int i = 0; i < size; i++) {
            QElement element = maxQueue.poll();
            result[i][0] = element.i;
            result[i][1] = element.j;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] points = new int[][]{{3,3},{5,-1},{-2,4}};
        Solution973 solution = new Solution973();
        int[][] ints = solution.kClosest(points, 2);
        System.out.println(Arrays.deepToString(ints));
    }
}
