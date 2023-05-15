package com.cangxiao.nowcoder.dfs;

import java.util.*;

/**
 * @Author cangxiao
 * @Date 2023/5/14
 * @Desc HJ43 迷宫问题
 */
public class HJ43dfs {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int a = in.nextInt();
            int b = in.nextInt();
            int[][] maze = new int[a][b];
            for (int i = 0; i < a; i++) {
                for (int j = 0; j < b; j++) {
                    maze[i][j] = in.nextInt();
                }
            }
            System.out.println("maze = " + Arrays.deepToString(maze));

            List<Node> path = new ArrayList<>();
            if (maze[a - 1][b - 1] != 0) {
                System.out.print(path);
            }
            System.out.println("-==========");
            dfs2(maze, 0, 0, a, b, path);
            System.out.println("path = " + path);

        }
    }


    private static boolean dfs2(int[][] maze, int i, int j, int a, int b, List<Node> path) {
        //走的路径
        path.add(new Node(i, j));
        //标记已经走过的路径
        maze[i][j] = 1;
        //到达终点
        if (i == a - 1 && j == b - 1) {
            return true;
        }

        if (i + 1 < a && maze[i + 1][j] == 0) {
            if (dfs2(maze, i + 1, j, a, b, path)){
                return true;
            }

        }
        if (i - 1 >= 0 && maze[i - 1][j] == 0) {
            if (dfs2(maze, i - 1, j, a, b, path)){
                return true;
            }

        }
        if (j + 1 < b && maze[i][j+1] == 0) {
            if (dfs2(maze, i, j+1, a, b, path)){
                return true;
            }

        }
        if (j - 1 >= 0 && maze[i][j - 1] == 0) {
            if (dfs2(maze, i, j-1, a, b, path)){
                return true;
            }

        }

        //当前路径走不通，回退
        path.remove(path.size() - 1);
        maze[i][j] = 0;
        return false;
    }

    private static class Node {
        int i;
        int j;

        public Node(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "i=" + i +
                    ", j=" + j +
                    '}';
        }
    }
}
