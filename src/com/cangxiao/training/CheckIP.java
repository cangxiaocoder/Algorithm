package com.cangxiao.training;

/**
 * @Author cangxiao
 * @Date 2021/8/17
 * @Desc 检测IP合法性
 */
public class CheckIP {

    public boolean check(String IP){
        if(IP==null) return false;
        //1分隔IP
        String[] segments = IP.split("\\.");
        //如果IP没有四部分则不和法
        if(segments.length!=4) return false;
        //2检查IP每段数字的合法性
        boolean flag = false;
        for (String segment : segments) {
            flag = checkSegment(segment);
            if(!flag) return false;
        }
        return true;
    }
    //合法 “123“ ” 123“ ”123 “
    // 不合法”12 3“ “1ab" ”256“ "   "
    public boolean checkSegment(String segment){

        char[] chars = segment.toCharArray();
        //1 处理前空格
        int i = 0;
        //第一次出现非空格退出
        while (i<chars.length && chars[i]==' '){
            i++;
        }
        //segment全是空格
        if(i == chars.length) return false;
        //第一位不为0，
        if(chars[0] == '0') return false;
        //2 处理中间空格
        int digit = 0;
        //第二次出空格退出
        while (i < chars.length && chars[i] != ' '){
            //3 处理字母
            if(chars[i] < '0' || chars[i] > '9') return false;
            //4 处理大于255
            digit = digit * 10 + (chars[i] - '0');
            //IP的每一段都不能大于255
            if(digit>255) return false;
            i++;
        }
        //5 处理后置空格. 如果后置空格中还包含有非空格，则不是IP
        while (i < chars.length){
            if(chars[i]!=' ') return false;
            i++;
        }

        return true;
    }

    public static void main(String[] args) {
        CheckIP checkIP =  new CheckIP();
        System.out.println("123.123.123.132 = " + checkIP.check("123.123.123.132"));
        System.out.println("123  .123.123.132 = " + checkIP.check("123  .123.123.132"));
        System.out.println("12 3.123.123.132 = " + checkIP.check("12 3.123.123.132"));
        System.out.println("123.a23.123.132 = " + checkIP.check("123.a23.123.132"));
        System.out.println("023.123.123.132 = " + checkIP.check("023.123.123.132"));
        System.out.println("'' = " + checkIP.check(""));
        System.out.println("null = " + checkIP.check("null"));
        System.out.println("123. .123 = " + checkIP.check("123.123.123"));
        System.out.println("123..123.132 = " + checkIP.check("123..123.132"));
    }

}
