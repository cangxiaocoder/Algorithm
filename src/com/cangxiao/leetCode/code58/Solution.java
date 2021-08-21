package com.cangxiao.leetCode.code58;

/**
 * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中最后一个单词的长度。
 *
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 * @Author cangxiao
 * @Date 2021/8/21
 * @Desc 最后一个单词的长度
 */
public class Solution {

    public int lengthOfLastWord(String s) {
        String[] strs = s.split(" ");
        String lastStr = "";
        for (int i = strs.length - 1; i >= 0; i--) {
            if(!"".equals(strs[i])) {
                lastStr = strs[i];
                break;
            }
        }
        return lastStr.length();
    }

    public int lengthOfLastWord2(String s) {
        int i = s.length() - 1;
        int j = i;
        for (; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (i != j) {
                    break;
                }
                j--;
            }
        }
        return j - i;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLastWord("   fly me   to   the moon  "));
        System.out.println(solution.lengthOfLastWord("word"));
        System.out.println(solution.lengthOfLastWord2("   fly me   to   the moon  "));
        System.out.println(solution.lengthOfLastWord2("word"));
    }
}
