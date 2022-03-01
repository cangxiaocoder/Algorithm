package com.cangxiao.offer;

/**
 * @Author cangxiao
 * @Date 2022/2/28
 * @Desc 剑指 Offer 12. 矩阵中的路径
 */
public class Offer12 {

    public boolean exist(char[][] board, String word) {
        if (board == null) return false;
        char[] chars = word.toCharArray();
        //已访问元素
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, i, j, chars, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, char[] chars, int index, boolean[][] visited) {
        //word单词全部搜索比对完成
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || chars[index] != board[i][j] || visited[i][j]) {
            return false;
        }
        if (index == chars.length - 1) {
            return true;
        }
        //标记已访问的元素
        visited[i][j] = true;
        //从当前元素出发向上下左右搜索
        boolean result= dfs(board, i + 1, j, chars, index + 1, visited) ||
                dfs(board, i - 1, j, chars, index + 1, visited) ||
                dfs(board, i, j + 1, chars, index + 1, visited) ||
                dfs(board, i, j - 1, chars, index + 1, visited);
        //若某条路径不通，则将此位置重新设为false，如某个节点从当前节点出发是访问过的，但是从另外一个姐弟啊出发是为访问过的。所以需要重设为false,
        visited[i][j] = false;
        return result;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{{'C','A','A'}, {'A','A','A'},{'B','C','D'}};
        boolean exist = new Offer12().exist(board, "AAB");
        System.out.println("exist = " + exist);
    }
}
