package com.cangxiao.maritx;

/**
 * @Author: cangxiao
 * @Since: 3/11/2026
 * @description: 有效的数独
 */
public class Sudoku {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rowHas = new boolean[9][9];
        boolean[][] colHas = new boolean[9][9];
        boolean[][][] subHas = new boolean[3][3][9];
        int length = board.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                char c = board[i][j];
                if (c == '.'){
                    continue;
                }
                int num = c - '1';
                if (rowHas[j][num] || colHas[i][num] || subHas[i/3][j/3][num]){
                    return false;
                }else {
                    rowHas[j][num] = true;
                    colHas[i][num] = true;
                    subHas[i/3][j/3][num] = true;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        System.out.println(new Sudoku().isValidSudoku(board));
    }
}
