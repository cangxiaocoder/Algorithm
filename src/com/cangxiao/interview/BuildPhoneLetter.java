package com.cangxiao.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: cangxiao
 * @Since: 10/11/2026
 * @description: 电话号码字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 */
public class BuildPhoneLetter {

    public static void main(String[] args) {
        BuildPhoneLetter phoneLetter = new BuildPhoneLetter();
        System.out.println(phoneLetter.build("23"));
    }

    Map<Character,List<Character>> numToLetter = Map.of(
            '2',List.of('a','b','c'),
            '3',List.of('d','e','f'),
            '4',List.of('g','h','i'),
            '5',List.of('j','k','l'),
            '6',List.of('m','n','o'),
            '7',List.of('p','q','r','s'),
            '8',List.of('t','u','v'),
            '9',List.of('w','x','y','z'));

    private List<String> build(String str){
        List<String> result = new ArrayList<>();
        if (str == null || str.isEmpty()){
            return result;
        }
        backtrack(str, 0, new StringBuilder(), result);
        return result;
    }

    private void backtrack(String digits, int index, StringBuilder path, List<String> result){
        // 递归结束
        if (index == digits.length()){
            result.add(path.toString());
            return;
        }
        // 遍历当前数字对应的字母
        List<Character> letters = numToLetter.get(digits.charAt(index));
        for (Character letter : letters) {
            path.append(letter);
            backtrack(digits, index + 1, path, result);
            // 撤销选择
            path.deleteCharAt(index);
        }
    }

}
