package com.cangxiao.interview;

import java.util.Comparator;
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
public class MinPathV2 {


    public static void main(String[] args) {
        int[][] nums = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        MinPathV2 minPath = new MinPathV2();
        System.out.println(minPath.minPathSum(nums));
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
     * @param grid
     * @return
     */
    public int MinPathDijkstra(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        // dist[i][j]：记录到(i,j)目前最小和
        int[][] dist = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) dist[i][j] = Integer.MAX_VALUE;
        }
        // 小根堆：按sum从小到大
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.sum));
        // 到达当前节点的总花费
        dist[0][0] = grid[0][0];
        pq.add(new Node(0, 0, grid[0][0]));
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
                    int newSum = sum + grid[nx][ny];
                    if (newSum < dist[nx][ny]) {
                        dist[nx][ny] = newSum;
                        pq.add(new Node(nx, ny, newSum));
                    }
                }
            }
        }
        return -1;
    }


    /**
     * 动态规划 DP
     * @param grid
     * @return
     */
    private int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        // 第一行：只能从左边来
        for (int j = 1; j < n; j++) dp[0][j] = dp[0][j - 1] + grid[0][j];
        // 第一列：只能从上边来
        for (int i = 1; i < m; i++) dp[i][0] = dp[i - 1][0] + grid[i][0];

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[m - 1][n - 1];
    }


}
