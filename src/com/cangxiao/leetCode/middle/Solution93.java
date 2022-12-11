package com.cangxiao.leetCode.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author cangxiao
 * @Date 2022/1/4
 * @Desc 93. 复原 IP 地址
 */
public class Solution93 {
    List<String> result = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        backtrack(s,0, 0, new ArrayList<>());
        return result;
    }

    private void backtrack(String s, int k, int step, List<String> path) {
        if (k==s.length() && step==4){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 3; i++) {
                sb.append(path.get(i)).append(".");
            }
            sb.append(path.get(3));
            String ip = sb.toString();
            if (isIP(ip))
                result.add(ip);
            return;
        }
        if (k==s.length())return;
        if (step>=4)return;
        //Ip地址每个分隔最多只有三位
        int len = Math.min(k+3, s.length());
        for (int end = k; end < len; end++) {
            //从k开始 只是截取一位
            path.add(s.substring(k,end+1));
            //下次截取从end+1 位置开始
            backtrack(s,end+1,step+1,path);
            path.remove(path.size()-1);
        }
    }


    private boolean isIP(String IP){
        String[] split = IP.split("\\.");

        for (String str : split) {
            if (str.length() > 3) return false;
            int s = Integer.parseInt(str);
            if (str.length() == 1) {
                if (s < 0 || s > 9) {
                    return false;
                }
            } else if (str.length() == 2) {
                if (s < 10 || s > 99) {
                    return false;
                }
            } else {
                if (s < 100 || s > 255) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution93 solution = new Solution93();
        List<String> result = solution.restoreIpAddresses("25525511135");
        System.out.println("result = " + result);
    }
}
