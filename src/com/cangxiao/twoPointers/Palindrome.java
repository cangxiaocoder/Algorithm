package com.cangxiao.twoPointers;

/**
 * @Author: cangxiao
 * @Since: 31/10/2026
 * @description: 125. 验证回文串
 */
public class Palindrome {

    public boolean isPalindrome(String s) {
        int length = s.length();
        int i = 0, j = length - 1;
        while (i < j && i< length && j >=0){
            while (i < length && !Character.isLetterOrDigit(s.charAt(i))){
                i++;
            }
            while (j>=0 && !Character.isLetterOrDigit(s.charAt(j))){
                j--;
            }
            if (i >= length || j < 0){
                return true;
            }
            if (s.charAt(i)==s.charAt(j) || Character.toLowerCase(s.charAt(i))==Character.toLowerCase(s.charAt(j))){
                i++;
                j--;
            }else {
                System.out.println(i +"==="+ j);
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        String s = "A man, a plan, a canal: Panama";
//        String s = "race a car";
//        String s = ".,";
//        String s = "a.";
        String s = "0P";
        System.out.println(new Palindrome().isPalindrome(s));
    }

}
