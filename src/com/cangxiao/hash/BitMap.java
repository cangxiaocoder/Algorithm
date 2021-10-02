package com.cangxiao.hash;

import sun.net.idn.Punycode;

/**
 * @Author cangxiao
 * @Date 2021/10/1
 * @Desc 位图过滤器
 */
public class BitMap {
    private char[] a;
    private int nbits;

    public BitMap(int nbits) {
        /*
            一个char字符占16位，可以存储0到15共16个数，
         */
        this.a = new char[(nbits-1)/16+1];
        this.nbits = nbits;
    }

    public void set(int k){
        if (k>nbits) return;
        int charIdx = k / 16;
        int bitIdx = k % 16;
        a[charIdx] |= (1<<bitIdx);
    }

    /**
     * 判断是否存在
     * @param k
     * @return
     */
    public boolean get(int k){
        if (k>nbits) return false;
        int charIdx = k / 16;
        int bitIdx = k % 16;
        return (a[charIdx] & (1<<bitIdx))!=0;
    }

    public static void main(String[] args) {
        BitMap bitMap = new BitMap(64);
        bitMap.set(16);
        System.out.println(bitMap.get(37));
    }
}
