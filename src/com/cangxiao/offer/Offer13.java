package com.cangxiao.offer;

/**
 * @Author cangxiao
 * @Date 2022/2/28
 * @Desc 剑指 Offer 13. 机器人的运动范围
 */
public class Offer13 {

    private int count = 0;
    //记录被访问过的坐标
    private boolean[][] visited;
    public int movingCount(int m, int n, int k) {
        visited = new boolean[m][n];
        //从坐标[0,0]开始
        dfs(0,0,m,n,k);
        return count;
    }

    private void dfs(int i,int j, int m, int n, int k){
        visited[i][j] = true;
        count++;
        //每个坐标想上下左右移动
        int[][] directions = {{0,1},{0,-1},{-1,0},{1,0}};
        for (int[] direction : directions) {
            int newI = i + direction[0];
            int newJ = j + direction[1];
            if (newI>=0 && newI < m && newJ>=0 && newJ < n && !visited[newI][newJ] && check(newI,newJ,k)){
                dfs(newI, newJ,  m,n, k);
            }
        }
    }

    private boolean check(int i, int j,int k) {
        int sum = 0;
        while (i!=0){
            sum += i%10;
            i = i / 10;
        }
        while (j!=0){
            sum += j%10;
            j = j / 10;
        }
        return sum <= k;
    }

    public static void main(String[] args) {
        System.out.println(132/10);
        int count = new Offer13().movingCount(10,10,18);
        System.out.println("count = " + count);
    }
}
