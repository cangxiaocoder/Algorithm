package com.cangxiao.leetCode.middle;

import sun.security.util.Resources_es;

import java.util.*;

/**
 * @Author cangxiao
 * @Date 2021/10/2
 * @Desc 49. 字母异位词分组
 */
public class Solution49 {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            if (strs[i]==null) continue;
            List<String> list = new ArrayList<>();
            list.add(strs[i]);
            strs[i] = null;
            for (int j = i+1; j < strs.length; j++) {
                if (strs[j]!=null && CheckPermutation(list.get(0), strs[j])){
                    list.add(strs[j]);
                    strs[j] = null;
                }
            }
            result.add(list);
        }
        return result;
    }



    /**
     * 判断两个字符串是否为异位词
     * @param s1
     * @param s2
     * @return
     */
    private boolean CheckPermutation(String s1, String s2) {
        if (s1.length()!=s2.length()) return false;
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        int[] c1 = new int[26];
        int[] c2 = new int[26];
        for (char c : chars1) {
            c1[c-'a']++;
        }
        for (char c : chars2) {
            c2[c-'a']++;
        }
        return Arrays.equals(c1, c2);
    }

    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<String,List<String>> resultMap = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            List<String> list = resultMap.getOrDefault(key, new ArrayList<>());
            list.add(str);
            resultMap.put(key,list);
        }
        return new ArrayList<>(resultMap.values());
    }
}
