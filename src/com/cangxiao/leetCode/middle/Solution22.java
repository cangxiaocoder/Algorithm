package com.cangxiao.leetCode.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author cangxiao
 * @Date 2022/1/8
 * @Desc 22. 括号生成
 */
public class Solution22 {
    List<String> result = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        char[] path = new char[2*n];
        backtrack(n,0,0,0,path);
        return result;
    }

    private void backtrack(int n, int leftUsed, int rightUsed, int k, char[] path) {
        if (k==2*n){
            result.add(String.valueOf(path));
            return;
        }
        //左括号不能大于n
        if (leftUsed < n){
            path[k]='(';
            backtrack(n,leftUsed+1,rightUsed,k+1, path);
        }
        //右括号不能大于左括号的个数
        if (rightUsed < leftUsed){
            path[k]=')';
            backtrack(n,leftUsed,rightUsed+1,k+1, path);
        }
    }

}
