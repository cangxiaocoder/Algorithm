package com.cangxiao.crushTrain;

/**
 * @Author cangxiao
 * @Date 2021/8/17
 * @Desc 检测IP合法性
 */
public class CheckIP {

    public boolean check(String ipStr){
        if (ipStr == null) return false;
        // 处理起始位和结束位点，“127.0.0.1.”.split("\\.").length()=4;
        String[] segments = ipStr.split("\\.",5);
        if (segments.length != 4)
            return false;
        for (String segment : segments) {
            if (!this.checkSegment(segment)) {
                return false;
            }
        }
        return true;
    }

    //合法 “123“ ” 123“ ”123 “
    // 不合法”12 3“ “1ab" ”256“ "   "
    public boolean checkSegment(String segment) {
        if (segment.isEmpty()) return false;
        int i = 0;
        // 处理前空格
        while (i < segment.length() && segment.charAt(i) == ' ') {
            i++;
        }
        // 全是空格
        if (i >= segment.length()) {
            return false;
        }
        int ip = 0;
        int index = i;
        // 再次遇到空格结束
        while (i < segment.length() && segment.charAt(i) != ' '){
            // 有字母
            if ('0' > segment.charAt(i) || segment.charAt(i) > '9'){
                return false;
            }
            // 数字前面有0
            if (segment.charAt(index)=='0' && index != i){
                return false;
            }
            // ip > 255
            ip = ip * 10 + segment.charAt(i) - '0';
            if (ip > 255) {
                return false;
            }
            i++;
        }
        // 中间存在空格
        while (i < segment.length()){
            if(segment.charAt(i)!=' ') return false;
            i++;
        }
        return true;
    }

    public static void main(String[] args) {
        CheckIP checkIP =  new CheckIP();
        System.out.println("127 . 0 . 0 . 1 = " + checkIP.check("123.12.2.1"));
        System.out.println("123.12.2.1 = " + checkIP.check("123.12.2.1"));
        System.out.println("0.2.0.33 = " + checkIP.check("0.2.0.33"));
        System.out.println("123.123.123.132 = " + checkIP.check("123.123.123.132"));
        System.out.println("123  .123.123.132 = " + checkIP.check("123  .123.123.132"));
        System.out.println("12 3.123.123.132 = " + checkIP.check("12 3.123.123.132"));
        System.out.println("123.a23.123.132 = " + checkIP.check("123.a23.123.132"));
        System.out.println("023.123.123.132 = " + checkIP.check("023.123.123.132"));
        System.out.println("0.2.0.33 = " + checkIP.check("023.123.123.132"));
        System.out.println("'' = " + checkIP.check(""));
        System.out.println("null = " + checkIP.check("null"));
        System.out.println("123. .123 = " + checkIP.check("123.123.123"));
        System.out.println("123..123.132 = " + checkIP.check("123..123.132"));
    }

}
