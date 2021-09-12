package com.cangxiao.leetCode.recursion;

/**
 * @Author cangxiao
 * @Date 2021/9/11
 * @Desc 面试题 08.05. 递归乘法
 */
public class SolutionInterview08_05 {
    /**
     * 3*10 = 3*（2^3+2^1) = 3<<3 + 3<<1
     * 10 转换而进制 1010;
     * 1  ----------- 权重3
     * 0  ----------- 权重2
     * 1  ----------- 权重1
     * 0  ----------- 权重0
     * 即二进制中数字为1的时候需要位移对应的权重
     */
    public int multiply(int A, int B) {
        int result = 0;
        int i = 0;
        while (B!=0){
            if ((B&1)==1){
                result+=(A<<i);
            }
            //如果B是负数， 则位移不能带符号
            B = B>>>1;
            i++;
        }
        return result;
    }




    public static void main(String[] args) {
        SolutionInterview08_05 solution = new SolutionInterview08_05();
        System.out.println(solution.multiply(-3, 10));
//        System.out.println(solution.multiply(3, 5,0));
//        System.out.println(solution.multiply(3, 1,0));
//        System.out.println(solution.multiply2(3, 0));?
        System.out.print(1>>2);
    }
}
