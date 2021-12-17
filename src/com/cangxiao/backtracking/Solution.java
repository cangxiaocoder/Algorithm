package com.cangxiao.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author cangxiao
 * @Date 2021/12/12
 * @Desc 回溯
 * 有一个8乘8的棋盘，我们往里放8个棋子（皇后)，要求每个棋子所在的行、列、对角线都不能
 * 有另外一个棋子。八皇后问题就是期望找到所有满足这种要求的放棋子方式。
 * 我们把求解这个问题的过程划分成8个阶段：在第一行放置棋子、在第二行放置棋子、在第三
 * 行放置棋子…在第八行放置棋子，符合多阶段决策模型。每一个阶段都有8中选择（放在第o
 * 列、第2列…第7列），对应到决策树就是8个分支，第二个阶段的选择变少……
 */
public class Solution {

    List<char[][]> result = new ArrayList<>();
    public List<char[][]> eightQueue(){
        char[][] board = new char[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = '*';
            }
        }
        backtrack(0,board);
        return result;
    }

    private void backtrack(int row, char[][] board) {
        if (row==8){
            char[][] snapshot = new char[8][8];
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    //拷贝可行的棋子位置到快照放入结果集合
                    snapshot[i][j] = board[i][j];
                }
            }
            result.add(snapshot);
        }
        for (int col = 0; col < 8; col++) {
            if (isOK(row,col,board)){
                //如果满足则在此处放棋子Q
                board[row][col] = 'Q';
                //决策下一行
                backtrack(row+1,board);
                //回退一行，重新决策这一行
                board[row][col] = '*';
            }
        }
    }

    private boolean isOK(int row, int col, char[][] board) {
        //此棋子所放的行不需要判断，
        //判断这一列是否可行
        for (int i = 0; i < row; i++) {
            try {
                if (board[i][col]=='Q') return false;
            } catch (Exception e) {
                System.out.println("row = " + row);
                System.out.println("col = " + col);
            }
        }
        //判断右上角是否满足
        int i = row - 1;
        int j = col + 1;
        while (i>=0 && j <8){
            if (board[i][j]=='Q') return false;
            i--;
            j++;
        }
        //判断左上角是否满足
        i = row - 1;
        j = col - 1;
        while (i>=0 && j >= 0){
            if (board[i][j]=='Q') return false;
            i--;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<char[][]> list = solution.eightQueue();
        for (char[][] chars : list) {
            for (int i = 0; i < chars.length; i++) {
                System.out.println("["+i+"] = " + Arrays.toString(chars[i]));
            }
            System.out.println("==========================================================");
        }
    }

}
