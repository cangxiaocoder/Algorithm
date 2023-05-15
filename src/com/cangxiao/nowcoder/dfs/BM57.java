package com.cangxiao.nowcoder.dfs;

import java.util.Arrays;
import java.util.TreeMap;
import java.util.concurrent.locks.Condition;

/**
 * @Author cangxiao
 * @Date 2023/5/14
 * @Desc BM57 岛屿数量
 * 给一个01矩阵，1代表是陆地，0代表海洋， 如果两个1相邻，那么这两个1属于同一个岛。我们只考虑上下左右为相邻。
 * 岛屿: 相邻陆地可以组成一个岛屿（相邻:上下左右） 判断岛屿个数。
 * 例如：
 * 输入
 * [
 * [1,1,0,0,0],
 * [0,1,0,1,1],
 * [0,0,0,1,1],
 * [0,0,0,0,0],
 * [0,0,1,1,1]
 * ]
 * 对应的输出为3
 * (注：存储的01数据其实是字符'0','1')
 */
public class BM57 {
    public static void main(String[] args) {
        char[][] gird = {
                {'1', '1', '0', '0', '0'},
                {'0', '1', '0', '1', '1'},
                {'0', '0', '0', '1', '1'},
                {'0', '0', '0', '0', '0'},
                {'0', '0', '1', '1', '1'}
        };
        gird = new char[][]{{
                '0', '0', '1', '0', '1', '1', '1', '1', '1', '0', '1', '0', '1', '1', '0', '0', '0', '1', '1', '1', '0', '1', '0', '0', '0', '1', '0', '1', '0', '0',
                '0', '1', '1', '1', '1', '0', '0', '0', '1', '0', '0', '0', '1', '1', '1', '1', '1', '0', '1', '0', '1', '0', '0', '1', '0', '1', '1', '0', '1', '0',
                '0', '0', '1', '0', '0', '1', '0', '1', '0', '1', '1', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '0', '1', '1', '0', '1', '1', '1', '1', '0',
                '0', '0', '1', '0', '0', '0', '1', '0', '0', '0', '0', '0', '0', '0', '1', '0', '1', '1', '1', '0', '1', '1', '1', '1', '1', '0', '0', '0', '1', '1',
                '1', '0', '1', '1', '0', '1', '1', '0', '0', '1', '0', '0', '1', '0', '0', '0', '1', '1', '1', '0', '0', '0', '0', '0', '1', '0', '0', '1', '1',},
                {
                        '0', '0', '0', '1', '0', '0', '0', '0', '0', '0', '1', '0', '1', '0', '1', '0', '0', '1', '1', '0', '0', '1', '0', '1', '1', '0', '0', '1', '0', '0', '0', '0', '0', '0', '1',
                        '1', '1', '1', '1', '1', '1', '0', '1', '0', '1', '0', '0', '1', '0', '0', '1', '1', '1', '1', '1', '0', '1', '1', '0', '1', '0', '1', '0', '0', '1', '0', '0',
                        '1', '1', '1', '0', '0', '0', '1', '0', '1', '0', '1', '1', '0', '0', '1', '0', '1', '1', '0', '1', '0', '0', '1', '0', '0', '1', '1', '1', '1', '1', '0', '0',
                        '0', '1', '0', '0', '1', '1', '0', '1', '0', '1', '0', '0', '0', '0', '1', '1', '1', '1', '0', '0', '1', '1', '1', '1', '0', '0', '1', '0', '0', '0', '0', '0',
                        '1', '0', '0', '0', '0', '1', '0', '1', '0', '1', '1', '0', '1', '0', '1', '1', '1', '0', '1'}};

        BM57 bm57 = new BM57();

//        int count = bm57.solve(gird);
        int count = solve2(gird);

        System.out.println("count = " + count);
    }


    public static int solve(char[][] grid) {
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j]) {
                    continue;
                }
                if (dfs2(grid, i, j, m, n, visited)) count++;
                System.out.println("count = " + count);
            }
        }
        System.out.println("count = " + count);
        return count;
    }
    public static int solve2(char[][] grid) {
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j]) {
                    continue;
                }
                if (dfs2(grid, i, j, m, n, visited)) count++;
                System.out.println("count = " + count);
            }
        }
        System.out.println("count = " + count);
        return count;
    }

    private static boolean dfs2(char[][] gird, int i, int j, int m, int n, boolean[][] visited) {
        if (i>=0 && j>=0 && i < m && j < n && gird[i][j] == '1') {
            if (visited[i][j]){
                //已经访问过的陆地 直接退出
                return true;
            }
            //记录访问过的陆地
            visited[i][j] = true;
            //上下左右找到相邻的陆地
            dfs2(gird, i + 1, j, m, n, visited);
            dfs2(gird, i - 1, j, m, n, visited);
            dfs2(gird, i, j+1, m, n, visited);
            dfs2(gird, i, j - 1, m, n, visited);
            return true;
        }
        return false;
    }

}
