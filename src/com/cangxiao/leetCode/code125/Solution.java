package com.cangxiao.leetCode.code125;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author cangxiao
 * @Date 2021/8/19
 * @Desc 验证回文串
 */
public class Solution {

    public boolean isPalindrome(String s) {
        char[] chars = s.toLowerCase().toCharArray();
        List<Character> characterList = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            if('a'>chars[i] || 'z'<chars[i] || '0'>chars[i] || '9'<chars[i]) continue;
            characterList.add(chars[i]);
        }
        int i = 0, j = characterList.size()-1;
        while (i<j){
            if(characterList.get(i++)!=characterList.get(j--))return false;
        }

        return true;
    }

    public static void main(String[] args) {
//        String s = "A man, a plan, a canal: Panama";
        String s = "0P";
        System.out.println(s.toLowerCase().toCharArray());
        System.out.println((int)'z');
        System.out.println((int)'0');
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(s));
    }
}
