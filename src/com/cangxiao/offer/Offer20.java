package com.cangxiao.offer;

import com.sun.scenario.effect.impl.prism.PrTexture;

import java.util.Stack;

/**
 * @Author cangxiao
 * @Date 2022/3/19
 * @Desc 剑指 Offer 20. 表示数值的字符串
 */
public class Offer20 {

    public boolean isNumber(String s) {
        String str = s.trim();
        boolean isNum = false, isDot = false, isEe = false;
        int len = str.length();
        for(int i=0; i<len; i++) {
            char ch = str.charAt(i);
            if(Character.isDigit(ch)) {
                isNum = true;
            } else if(ch == '.' && !isDot && !isEe) {
                //点只能出现一次且之前不能为e
                isDot = true;
            } else if((ch == 'e' || ch == 'E') && !isEe && isNum) {
                //e只能出现一次，且在数字之后
                isEe = true;
                isNum = false;
            } else if(ch == '+' || ch == '-') {
                if(i==0 || str.charAt(i-1) == 'e' || str.charAt(i-1) == 'E') {
                    continue;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return isNum;
    }

    public static void main(String[] args) {
        Offer20 offer20 = new Offer20();
//        System.out.println("-1E-16 = " + offer20.isNumber("-1E-16"));
//        System.out.println(". 2 = " + offer20.isNumber(". 2"));
//        System.out.println("2.    = " + offer20.isNumber("2.   "));
        System.out.println("  .2 = " + offer20.isNumber("+"));
        System.out.println("  .2 = " + offer20.isNumber("  .2"));
//        System.out.println("e+2 = " + offer20.isNumber("e+2"));
//        System.out.println("e2 = " + offer20.isNumber("e2"));
//        System.out.println(".e2 = " + offer20.isNumber(".e2"));
        System.out.println(".1e2 = " + offer20.isNumber(".1e2"));
    }
}
