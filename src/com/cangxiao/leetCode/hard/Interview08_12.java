package com.cangxiao.leetCode.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author cangxiao
 * @Date 2021/12/16
 * @Desc 面试题 08.12. 八皇后 (https://leetcode-cn.com/problems/eight-queens-lcci/)
 */
public class Interview08_12 {
    List<List<String>> result = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] chars = new char[n];
            for (int j = 0; j < n; j++) {
                chars[j] = '.';
            }
            board.add(String.valueOf(chars));
        }
        backtrack(0,board,n);
        return result;
    }

    private void backtrack(int row, List<String> board,int n) {
        if (row==n){
            List<String> temp = new ArrayList<>(board);
            result.add(temp);
        }
        for (int col = 0; col < n; col++) {
            if (isOK(row,col,board,n)){
                //如果满足则在此处放棋子Q
                char[] chars = board.get(row).toCharArray();
                chars[col] = 'Q';
                board.set(row,String.valueOf(chars));
                //决策下一行
                backtrack(row+1,board,n);
                //回退一行
                chars = board.get(row).toCharArray();
                chars[col] = '.';
                board.set(row,String.valueOf(chars));
            }
        }
    }

    private boolean isOK(int row, int col, List<String> board, int n) {
        //此棋子所放的行不需要判断，
        //判断这一列是否可行
        for (int i = 0; i < row; i++) {
            if (board.get(i).charAt(col)=='Q') return false;
        }
        //判断右上角是否满足
        int i = row - 1;
        int j = col + 1;
        while (i>=0 && j <n){
            if (board.get(i).charAt(j)=='Q') return false;
            i--;
            j++;
        }
        //判断左上角是否满足
        i = row - 1;
        j = col - 1;
        while (i>=0 && j >= 0){
            if (board.get(i).charAt(j)=='Q') return false;
            i--;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        Interview08_12 solution = new Interview08_12();
        List<List<String>> list = solution.solveNQueens(8);

        for (int i = 0; i < list.size(); i++) {
            for (String str : list.get(i)) {
                System.out.println("["+i+"] = "+ str);
            }
            System.out.println("===========================");
        }
        System.out.println(list.size());
    }
//    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
//        list.add("AA");
//        list.add("BB");
//        list.set(1,"CC");
//        System.out.println(list);
//
//    }
}
