package com.cangxiao.leetCode.easy;

/**
 * 给你一个排序后的字符列表 letters ，列表中只包含小写英文字母。另给出一个目标字母target，请你寻找在这一有序列表里比目标字母大的最小字母。
 *
 * 在比较时，字母是依序循环出现的。举个例子：
 *
 * 如果目标字母 target = 'z' 并且字符列表为letters = ['a', 'b']，则答案返回'a'
 *
 * @Author cangxiao
 * @Date 2021/9/21
 * @Desc 744. 寻找比目标字母大的最小字母
 */
public class Solution744 {

    public char nextGreatestLetter(char[] letters, char target) {
        int low  = 0;
        int high = letters.length-1;
        while (low<high){
            int mid = low + (high - low)/2;
            if (letters[mid]<=target){
                low = mid+1;
            }else {
                high = mid;//可能存在正好mid就是第一个大于target的字母
            }
        }
        return letters[low] > target ? letters[low] : letters[0];
    }

    public static void main(String[] args) {
        Solution744 solution = new Solution744();
        System.out.println(solution.nextGreatestLetter(new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g'}, 'z'));
    }
}
