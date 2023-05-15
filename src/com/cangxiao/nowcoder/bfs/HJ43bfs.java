package com.cangxiao.nowcoder.bfs;

import com.cangxiao.leetCode.queue.CircularQueue;

import java.util.*;

/**
 * @Author cangxiao
 * @Date 2023/5/14
 * @Desc HJ43 迷宫问题
 */
public class HJ43bfs {
    public static void main(String[] args) {
        main2();
        if (true)return;
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

            if (maze[a - 1][b - 1] != 0) {
                System.out.println();
            }

            LinkedList<Node> queue = new LinkedList<>();
            Node node = new Node(0, 0, null);
            queue.offer(node);
            maze[0][0] = 1;
            Node path = null;
            while (!queue.isEmpty()) {

                int size = queue.size();
                path = queue.poll();
                if (path == null) return;
                int x = path.x;
                int y = path.y;

                //size的大小代表Node链表的条数，每一条都代表一个不同路径
                for (int i = 0; i < size; i++) {
                    if (x == a - 1 && y == b - 1) {
                        print(path);
                        return;
                    }
                    /*
                        当前节点为父节点，可以向前后左右四个方向行走，即一个父节点可以有四个子节点，
                     */
                    if (x + 1 < a && maze[x + 1][y] == 0) {
                        queue.offer(new Node(x + 1, y, path));
                        maze[x + 1][y] = 1;
                    }
                    if (x - 1 >= 0 && maze[x - 1][y] == 0) {
                        queue.offer(new Node(x - 1, y, path));
                        maze[x - 1][y] = 1;
                    }
                    if (y + 1 < b && maze[x][y + 1] == 0) {
                        queue.offer(new Node(x, y + 1, path));
                        maze[x][y + 1] = 1;
                    }
                    if (y - 1 >= 0 && maze[x][y - 1] == 0) {
                        queue.offer(new Node(x, y - 1, path));
                        maze[x][y - 1] = 1;
                    }
                }
            }
        }
    }


    private static void main2() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int[][] maze = new int[a][b];
            for (int i = 0; i < a; i++) {
                for (int j = 0; j < b; j++) {
                    maze[i][j] = scanner.nextInt();
                }
            }

            Queue<Node> queue = new LinkedList<>();
            queue.offer(new Node(0, 0, null));
            maze[0][0] = 1;
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    Node cur = queue.poll();
                    int x = cur.x;
                    int y = cur.y;
                    if (x+1==a && y+1==b){
                        //走到终点结束
                        print(cur);
                        return;
                    }
                    if (x + 1 < a && maze[x + 1][y] == 0) {
                        Node node = new Node(x + 1, y, cur);
                        queue.offer(node);
                        //记录已经走过的节点，不允许再走
                        maze[x + 1][y] = 1;
                    }
                    if (x - 1 >= 0 && maze[x - 1][y] == 0) {
                        Node node = new Node(x - 1, y, cur);
                        queue.offer(node);
                        //记录已经走过的节点，不允许再走
                        maze[x - 1][y] = 1;
                        System.out.println(x+"========="+y);
                    }
                    if (y + 1 < b && maze[x][y + 1] == 0) {
                        Node node = new Node(x, y + 1, cur);
                        queue.offer(node);
                        //记录已经走过的节点，不允许再走
                        maze[x][y + 1] = 1;
                    }
                    if (y - 1 >= 0 && maze[x][y - 1] == 0) {
                        Node node = new Node(x, y - 1, cur);
                        queue.offer(node);
                        //记录已经走过的节点，不允许再走
                        maze[x][y - 1] = 1;
                        System.out.println("-----------");
                    }
                }
            }
        }
    }

    private static void print(Node path) {
        if (path != null) {
            print(path.father);
            System.out.println("(" + path.x + "," + path.y + ")");
        }
    }

    private static class Node {
        int x;
        int y;
        //子节点有四个方向，但是父节点必定都是同一个
        Node father;

        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", y=" + y +
                    ", father=" + father +
                    '}';
        }


        public Node(int x, int y, Node father) {
            this.x = x;
            this.y = y;
            this.father = father;
        }
    }
}
