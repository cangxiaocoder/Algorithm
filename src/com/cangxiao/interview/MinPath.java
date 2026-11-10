package com.cangxiao.interview;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @Author: cangxiao
 * @Since: 8/11/2026
 * @description: 最小路径
 * 最小路径和
 * 求二位矩阵中最小路径和, 从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 限定往右或者往下走。
 * 输入:
 * [
 * [1,3,1],
 * [1,5,1],
 * [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。"
 */
public class MinPath {


    public static void main(String[] args) {
        int[][] nums = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        MinPath minPath = new MinPath();
        System.out.println(minPath.searchMinPath(nums));
    }

    private static class Node {
        int x, y, sum;

        Node(int x, int y, int sum) {
            this.x = x;
            this.y = y;
            this.sum = sum;
        }
    }

    /**
     * Dijkstra：优先队列（小根堆）
     * @param nums
     * @return
     */
    public int searchMinPath(int[][] nums) {
        int m = nums.length, n = nums[0].length;
        // dist[i][j]：记录到(i,j)目前最小和
        int[][] dist = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) dist[i][j] = Integer.MAX_VALUE;
        }
        // 小根堆：按sum从小到大
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.sum));
        // 到达当前节点的总花费
        dist[0][0] = nums[0][0];
        pq.add(new Node(0, 0, nums[0][0]));
        // 只允许向下、向右
        int[][] dirs = {{1, 0}, {0, 1}};
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int x = cur.x, y = cur.y, sum = cur.sum;
            if (x == m - 1 && y == n - 1) {
                return sum;
            }
            if (sum > dist[x][y]) {
                continue;
            }
            for (int[] d : dirs) {
                int nx = x + d[0], ny = y + d[1];
                if (nx < m && ny < n) {
                    int newSum = sum + nums[nx][ny];
                    if (newSum < dist[nx][ny]) {
                        dist[nx][ny] = newSum;
                        pq.add(new Node(nx, ny, newSum));
                    }
                }
            }
        }
        return -1;
    }

}
