package com.cangxiao.leetCode.middle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author cangxiao
 * @Date 2021/12/21
 * @Desc 17. 电话号码的字母组合
 */
public class Solution17 {

    private Map<Character, String> phoneMap = new HashMap<>();
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.isEmpty())return result;
        phoneMap.put('2', "abc");
        phoneMap.put('3', "def");
        phoneMap.put('4', "ghi");
        phoneMap.put('5', "jkl");
        phoneMap.put('6', "mno");
        phoneMap.put('7', "pqrs");
        phoneMap.put('8', "tuv");
        phoneMap.put('9', "wxyz");
        backtrack(result,digits,0,new StringBuilder());
        return result;

    }

    private void backtrack(List<String> result, String digits, int index, StringBuilder stringBuilder) {
        if (index==digits.length()){
            result.add(String.valueOf(stringBuilder));
        }else {
            //决策第一步
            String letters = phoneMap.get(digits.charAt(index));
            for (int i = 0; i < letters.length(); i++) {
                stringBuilder.append(letters.charAt(i));
                //决策下一步
                backtrack(result,digits,index+1,stringBuilder);
                //回退一步，重新决策这一步
                stringBuilder.deleteCharAt(index);
            }
        }
    }
}
