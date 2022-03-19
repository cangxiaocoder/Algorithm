package com.cangxiao.offer;

import java.util.Arrays;

/**
 * @Author cangxiao
 * @Date 2022/3/15
 * @Desc 剑指 Offer 17. 打印从1到最大的n位数
 */
public class Offer17 {

    public int[] printNumbers(int n) {
        int max = (int) Math.pow(10,n);

        int [] result = new int[max - 1];
        for (int i = 1; i < max; i++) {
            result[i - 1] = i;
        }
        return result;
    }
//==================================================================================================================
    /**
     * 考虑大数
     * @param n
     * @return
     */
    char[] chars = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    char[] num;
    public String printString(int n) {
        //定义长度为你的字符串列表
        num = new char[n];
        //记录最终结果
        StringBuilder result = new StringBuilder();
        dfs(result,0,n);

        return String.valueOf(result);
    }

    private void dfs(StringBuilder result, int i, int n) {
        if (i==n){
            result.append(String.valueOf(num)).append(",");
            return;
        }
        for (char c : chars) {
            num[i] = c;
            dfs(result,i+1,n);
        }
    }
//==================================================================================================================
    /**
     * 考虑大数
     */
    int count = 0;
    public int[] printNum(int n) {
        //定义长度为你的字符串列表
        num = new char[n];
        //记录最终结果
        int[] result = new int[(int) (Math.pow(10, n) - 1)];
        dfsNum(result,0,n);

        return result;
    }

    private void dfsNum(int[] result, int i, int n) {
        if (i==n){
            int curNum = Integer.parseInt(String.valueOf(num));
            if (curNum!=0){
                result[count++] = (curNum);
            }
            return;
        }
        for (char c : chars) {
            num[i] = c;
            dfsNum(result,i+1,n);
        }
    }

    public static void main(String[] args) {
        String result1 = new Offer17().printString(2);
        System.out.println("result1 = " + result1);

        int[] result2 = new Offer17().printNum(2);
        System.out.println("result2 = " + Arrays.toString(result2));
    }
}
