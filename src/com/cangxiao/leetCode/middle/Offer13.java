package com.cangxiao.leetCode.middle;

/**
 * @Author cangxiao
 * @Date 2022/1/15
 * @Desc 剑指 Offer 13. 机器人的运动范围
 */
public class Offer13 {

    private boolean visited[][];
    private int count = 0;
    public int movingCount(int m, int n, int k) {
        visited = new boolean[m][n];
        dfs(0,0,m,n,k);
        return count;
    }

    private void dfs(int i, int j, int m, int n, int k) {
        //将满足条件的加进去
        visited[i][j] = true;
        count++;
        //每次走一步，上下左右四个方向
        int[][] directions = {{0,1},{0,-1},{-1,0},{1,0}};
        for (int index = 0; index < directions.length; index++) {
            //分别向四个方向移动，深度搜索， 形成新的坐标
            int newI = i+directions[index][0];
            int newJ = j+directions[index][1];
            if (newI>=0 && newI < m && newJ>=0 && newJ< n && !visited[newI][newJ] && check(newI,newJ,k)){
                dfs(newI,newJ,m,n,k);
            }
        }
    }

    private boolean check(int i, int j, int k){
        int sum = 0;
        while (i!=0){
            sum = sum+i%10;
            i = i/10;
        }
        while (j!=0){
            sum = sum+j%10;
            j = j/10;
        }
        return sum <= k;
    }
}
