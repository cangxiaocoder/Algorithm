package com.cangxiao.stack;


import java.util.Arrays;
import java.util.LinkedList;

/**
 * @Author cangxiao
 * @Date 2023/2/25
 * @Desc 图像渲染
 */
public class FloodFill {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        boolean[][] view = new boolean[m][n];

        LinkedList<Node> queue = new LinkedList<>();
        int temp = image[sr][sc];
        queue.push(new Node(sr, sc));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            image[node.x][node.y] = color;
            view[node.x][node.y] = true;

            if (node.x > 0 && image[node.x - 1][node.y] == temp && !view[node.x - 1][node.y]) {
                queue.offer(new Node(node.x - 1, node.y));
            }
            if (node.x < m - 1 && image[node.x + 1][node.y] == temp && !view[node.x + 1][node.y]) {
                queue.offer(new Node(node.x + 1, node.y));
            }
            if (node.y > 0 && image[node.x][node.y - 1] == temp && !view[node.x][node.y - 1]) {
                queue.offer(new Node(node.x, node.y - 1));
            }
            if (node.y < n - 1 && image[node.x][node.y + 1] == temp && !view[node.x][node.y + 1]) {
                queue.offer(new Node(node.x, node.y + 1));
            }

        }

        return image;
    }

    class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    int m;
    int n;

    public int[][] floodFill2(int[][] image, int sr, int sc, int color) {
        m = image.length;
        n = image[0].length;

        int oldColor = image[sr][sc];
        if (oldColor==color) return image;
        dfs(image, sr, sc, color, oldColor);

        return image;

    }

    private void dfs(int[][] image, int sr, int sc, int color, int oldColor) {
        if (sr < 0 || sc < 0 || sr >= m || sc >= n || image[sr][sc] != oldColor) {
            return;
        }
        image[sr][sc] = color;
        dfs(image, sr - 1, sc, color, oldColor);
        dfs(image, sr, sc-1, color, oldColor);
        dfs(image, sr, sc+1, color, oldColor);
        dfs(image, sr + 1, sc, color, oldColor);
    }

    public static void main(String[] args) {
        int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
//        int[][] image = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        FloodFill floodFill = new FloodFill();
        floodFill.floodFill(image, 0, 0, 2);
        System.out.println("image = " + Arrays.deepToString(image));

        floodFill.floodFill2(image, 0, 0, 2);
        System.out.println("image = " + Arrays.deepToString(image));
    }
}
