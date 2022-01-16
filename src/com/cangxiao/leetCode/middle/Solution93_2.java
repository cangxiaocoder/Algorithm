package com.cangxiao.leetCode.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author cangxiao
 * @Date 2022/1/4
 * @Desc 93. 复原 IP 地址
 */
public class Solution93_2 {
    List<String> result = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        backtrack(s, 0, 0, new ArrayList<>());
        return result;
    }

    private void backtrack(String s, int k, int step, List<Integer> path) {
        if (k == s.length() && step == 4) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 3; i++) {
                sb.append(path.get(i)).append(".");
            }
            sb.append(path.get(3));
            result.add(sb.toString());
            return;
        }
        if (step >= 4) return;
        if (k == s.length()) return;
        int val = 0;

        //1位数
        if (k < s.length()) {
            val = val * 10 + (s.charAt(k) - '0');
            path.add(val);
            backtrack(s, k + 1, step + 1, path);
            path.remove(path.size() - 1);
        }
        //放在前面这个if的下面避免s.charAt(k)为空的情况
        if (s.charAt(k) == '0') {
            return;
        }
        //2位数
        if (k + 1 < s.length()) {
            val = val * 10 + (s.charAt(k + 1) - '0');
            path.add(val);
            backtrack(s, k + 2, step + 1, path);
            path.remove(path.size() - 1);
        }
        //3位数
        if (k + 2 < s.length()) {
            val = val * 10 + (s.charAt(k + 2) - '0');
            if (val <= 255) {
                path.add(val);
                backtrack(s, k + 3, step + 1, path);
                path.remove(path.size() - 1);
            }

        }
    }


    public static void main(String[] args) {
        Solution93_2 solution = new Solution93_2();
        List<String> result = solution.restoreIpAddresses("25525511135");
        System.out.println("result = " + result);
    }
}
