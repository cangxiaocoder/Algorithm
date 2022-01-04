package com.cangxiao.leetCode.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author cangxiao
 * @Date 2022/1/3
 * @Desc 131. 分割回文串
 */
public class Solution131 {

    List<List<String>> result = new ArrayList<>();
    List<String> path = new ArrayList<>();
    public List<List<String>> permuteUnique(String s) {

        backtrack(s,0);
        return result;
    }

    private void backtrack(String s, int k) {
        if (k==s.length()){
            result.add(new ArrayList<>(path));
            return;
        }
        for (int end = k; end < s.length(); end++) {
            //判断是否是回文串，从k到end是回文串才截取出来加进去
            if (isPalindrome(s,k,end)){
                //从k开始 只是截取一位
                path.add(s.substring(k,end+1));
                //下次截取从end+1 位置开始
                backtrack(s,end+1);
                path.remove(path.size()-1);
            }

        }
    }

    private boolean isPalindrome(String s, int p, int r) {
        int i = p;
        int j = r;
        while (i<=j){
            if (s.charAt(i)!=s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }


    public static void main(String[] args) {
        Solution131 solution = new Solution131();
        List<List<String>> result = solution.permuteUnique("AAB");
        System.out.println("result = " + result);
    }

}
