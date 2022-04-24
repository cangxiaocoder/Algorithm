package com.cangxiao.offer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author cangxiao
 * @Date 2022/4/23
 * @Desc 剑指 Offer 38. 字符串的排列
 */
public class Offer38 {
    Set<String> setList = new HashSet<>();
    public String[] permutation(String s) {
        int len = s.length();
        backtrack(s,0,new StringBuilder(),new boolean[len], len);
        return setList.toArray(new String[0]);
    }

    private void backtrack(String s, int k, StringBuilder sb, boolean[]  visited, int len) {
        if (sb.length()==len || k == len){
            setList.add(String.valueOf(sb));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (visited[i]){
                continue;
            }
            sb.append(s.charAt(i));
            visited[i] = true;
            backtrack(s,k+1,sb, visited, len);
            sb.deleteCharAt(sb.length() - 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        String str = "aab";
        Offer38 offer38 = new Offer38();
        System.out.println("permutation = " + Arrays.toString(offer38.permutation(str)));
    }
}
