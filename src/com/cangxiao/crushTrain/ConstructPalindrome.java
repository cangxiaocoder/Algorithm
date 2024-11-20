package com.cangxiao.crushTrain;

/**
 * @Author cangxiao
 * @Date 2024/11/18
 * @Desc 有一个字符串 s ，请你构造一个长度为 k（k<=s的长度） 的字符串 t，使得 s + t 或 t + s 拼成的字符串是回文串。
 * 如果可以构造，则输出 t（优先将 t 放到 s 的后面） ，若无法构造，请输出 null。
 *
 */
public class ConstructPalindrome {

    public String constructPalindrome(String s, int k) {
        int diff = s.length() - k;
        // k与s字符串的长度相同 则直接反转s就可以构建回文串
        if (diff == 0){
            return new StringBuilder(s).reverse().toString();
        }
        //k与s字符串的长度不同，则需要判断s减去k个字符后的字符串是否为回文串，
        // 如果是则反转前k个字符就可以创建，如 s= abcdefe k = 4,efe是回文串，则在将前k个字符abcd反转为dcba就可以构建回文串abcdefedcba。
        // 如果不是，则无法构建 如 s= abcdefe k = 3,defe不是回文串，则在将前k个字符abc反转为cba也不能构建回文串
        if (isPalindrome(s.substring(k))){
            return new StringBuilder(s.substring(0,k)).reverse().toString();
        }
        // 在前面构建回文串 如 s= babcdef k = 4,bab是回文串，则在将后k个字符cdef反转为fedc就可以构建回文串 fedcbabcdef。
        if (isPalindrome(s.substring(0, s.length() - k))){
            return new StringBuilder(s.substring(s.length() - k, s.length())).reverse().toString();
        }

        return null;
    }

    private boolean isPalindrome(String s){
        int length = s.length();
        int i = 0;
        int j = length - 1;
        while (i < j){
            if (s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        ConstructPalindrome cp = new ConstructPalindrome();
        System.out.println(cp.constructPalindrome("abcdefe", 4));
        System.out.println(cp.constructPalindrome("babcdef", 4));
    }
}
