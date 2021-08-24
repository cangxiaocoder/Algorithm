package com.cangxiao.leetCode.interview;

/**
 * 设计一个算法，判断玩家是否赢了井字游戏。输入是一个 N x N 的数组棋盘，由字符" "，"X"和"O"组成，其中字符" "代表一个空位。
 *
 * 以下是井字游戏的规则：
 *
 * 玩家轮流将字符放入空位（" "）中。
 * 第一个玩家总是放字符"O"，且第二个玩家总是放字符"X"。
 * "X"和"O"只允许放置在空位中，不允许对已放有字符的位置进行填充。
 * 当有N个相同（且非空）的字符填充任何行、列或对角线时，游戏结束，对应该字符的玩家获胜。
 * 当所有位置非空时，也算为游戏结束。
 * 如果游戏结束，玩家不允许再放置字符。
 * 如果游戏存在获胜者，就返回该游戏的获胜者使用的字符（"X"或"O"）；
 * 如果游戏以平局结束，则返回 "Draw"；如果仍会有行动（游戏未结束），则返回 "Pending"。
 *
 * 示例 1：
 *
 * 输入： board = ["O X"," XO","X O"]
 * 输出： "X"
 * @Author cangxiao
 * @Date 2021/8/22
 * @Desc 面试题 16.04. 井字游戏
 */
public class Solution16_04 {

    public String tictactoe(String[] board) {
        boolean empty = false;
        int len = board.length;
        int heng;
        int row;
        int left = 0;
        int right = 0;
        for (int i = 0; i < len; i++) {
            heng = 0; row = 0;
            for (int j = 0; j < len; j++) {
                if(board[i].charAt(j) == ' ') {
                    empty = true;
                    break;
                }
                //横向
                heng = heng + board[i].charAt(j);
                //纵向
                row = row + board[j].charAt(i);
            }
            if(heng=='X' * len || row == 'X' * len ) return "X";
            if(heng=='O' * len || row == 'O' * len ) return "O";
            //左对角线
            left = left + board[i].charAt(i);
            //右对角线
            right = right + board[i].charAt(len - i -1);
            if(left=='X' * len || right == 'X' * len ) return "X";
            if(left=='O' * len || right == 'O' * len ) return "O";
        }


        if(empty){
            return "Pending";
        }else {
            return  "Draw";
        }

    }
}
