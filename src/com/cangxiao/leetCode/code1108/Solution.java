package com.cangxiao.leetCode.code1108;

/**
 * 给你一个有效的 IPv4 地址 address，返回这个 IP 地址的无效化版本。
 *
 * 所谓无效化 IP 地址，其实就是用 "[.]" 代替了每个 "."。
 * @Author cangxiao
 * @Date 2021/8/18
 * @Desc IP地址无效化
 */
public class Solution {

    public String defangIPaddr1(String address) {
        char[] chars = address.toCharArray();
        char[] newChars = new char[chars.length+2*3];
        int k = 0;
        for (int i = 0; i < chars.length; i++) {
            if(chars[i]=='.'){
                newChars[k++] = '[';
                newChars[k++] = '.';
                newChars[k++] = ']';
            }else {
                newChars[k++] = chars[i];
            }
        }
        return String.valueOf(newChars);
    }

    public String defangIPaddr2(String address) {
        StringBuilder sb = new StringBuilder();
        String[] strs = address.split("\\.");
        for (int i = 0; i < strs.length; i++) {
            if(i==strs.length-1){
                sb.append(strs[i]);
            }else {
                sb.append(strs[i]).append("[.]");
            }
        }
        return String.valueOf(sb);
    }

    public static void main(String[] args) {
        String address = "123.12.3.232";

        Solution solution = new Solution();
        System.out.println("solution.defangIPaddr1(address) = " + solution.defangIPaddr1(address));
        System.out.println("solution.defangIPaddr2(address) = " + solution.defangIPaddr2(address));
    }
}
