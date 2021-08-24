package com.cangxiao.leetCode.interview;

/**
 * 字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。
 *
 * 示例1:
 *
 * 输入:
 * first = "pale"
 * second = "ple"
 * 输出: True
 * @Author cangxiao
 * @Date 2021/8/22
 * @Desc 面试题 01.05. 一次编辑
 */
public class Solution01_05 {

    public boolean oneEditAway(String first, String second) {
        int firstLen = first.length();
        int secondLen = second.length();
        if(Math.abs(firstLen-secondLen)>1)return false;
        int i = 0; int j = 0;
        int count = 0;
        if(firstLen==secondLen){
            while (i<firstLen){
                if(first.charAt(i++) != second.charAt(j++)){
                    count++;
                    if(count>1) return false;
                }
            }
        }
        while (i<firstLen && j<secondLen){
            if(first.charAt(i) ==second.charAt(j)){
                i++;
                j++;
                continue;
            }
            if(firstLen<secondLen){
                j++;
            }
            if(firstLen>secondLen){
                i++;
            }
            count++;
            if(count>1) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution01_05 solution = new Solution01_05();
        System.out.println(solution.oneEditAway("pale", "p le"));
//        System.out.println(solution.oneEditAway("pale", "ple"));
//        System.out.println(solution.oneEditAway("pale", "le"));
//        System.out.println(solution.oneEditAway("pale", "ccle"));
//        System.out.println(solution.oneEditAway(" ", " "));
//        System.out.println(solution.oneEditAway(" ", "p"));
//        System.out.println(solution.oneEditAway(" ", "pe"));
    }

}
