package com.cangxiao.maritx;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: cangxiao
 * @Since: 11/11/2026
 * @description: 289. 生命游戏
 */
public class LifeGame {

    public static void main(String[] args) {
        int[][] board = new int[][]{{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        LifeGame lifeGame = new LifeGame();
        lifeGame.gameOfLife2(board);
        for (int[] ints : board) {
            System.out.println(Arrays.toString(ints));
        }
    }

    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] result = new int[m][n];
        int[][] dire = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {-1, -1}, {1, -1}, {-1, 1}, {1, 1}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = 0;
                for (int k = 0; k < dire.length; k++) {
                    if (i+dire[k][0] >= 0 && i+dire[k][0] < m && j+dire[k][1] >= 0 && j+dire[k][1] < n){
                        count += board[i+dire[k][0]][j+dire[k][1]] == 1 ? 1 : 0;
                    }
                }
                if (count == 2){
                    result[i][j] = board[i][j];
                }else if (count == 3){
                    result[i][j] = 1;
                }else {
                    result[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = result[i][j];
            }
        }

        for (int[] ints : result) {
            System.out.println(Arrays.toString(ints));
        }
    }

    public void gameOfLife2(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] dire = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {-1, -1}, {1, -1}, {-1, 1}, {1, 1}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = 0;
                for (int[] ints : dire) {
                    if (i + ints[0] >= 0 && i + ints[0] < m && j + ints[1] >= 0 && j + ints[1] < n) {
                        // 1 为活着的细胞，-1 为之前活着的细胞
                        count += Math.abs(board[i + ints[0]][j + ints[1]]) == 1 ? 1 : 0;
                    }
                }
                if (count == 2){
                    board[i][j] = board[i][j];
                }else if (count == 3){
                    board[i][j] = board[i][j] == 1 ?  1 : 2;
                }else {
                    board[i][j] = board[i][j] == 0 ? 0 : -1;;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 2){
                    board[i][j] = 1;
                }
                if (board[i][j] == -1){
                    board[i][j] = 0;
                }
            }
        }

    }
}
