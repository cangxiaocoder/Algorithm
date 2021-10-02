package com.cangxiao.leetCode.interview;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author cangxiao
 * @Date 2021/10/1
 * @Desc 面试题 16.02. 单词频率
 */
public class WordsFrequency {

    private Map<String, Integer> map = new HashMap<>();
    public WordsFrequency(String[] book) {
        for (String s : book) {
            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            } else {
                map.put(s, 1);
            }
        }
    }

    public int get(String word) {
        if (!map.containsKey(word)) return 0;
        return map.get(word);
    }
}
