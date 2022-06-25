package com.cangxiao.offer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @Author cangxiao
 * @Date 2022/6/25
 * @Desc 剑指 Offer 41. 数据流中的中位数
 */
public class Offer41MedianFinder {


    int size;
    List<Integer> nums;
    /** initialize your data structure here. */
    public Offer41MedianFinder() {
        size = 0;
        nums = new ArrayList<>();
    }

    public void addNum(int num) {
        nums.add(num);
        size++;
    }

    public double findMedian() {
        nums.sort(Comparator.comparingInt(o -> o));
        if ((size&1)==1){
            return nums.get(size>>1);
        }
        return (double) (nums.get(size >> 1) + nums.get((size >> 1) - 1)) /2 ;
    }

    public static void main(String[] args) {
        Offer41MedianFinder finder = new Offer41MedianFinder();
        finder.addNum(6);
        System.out.println("finder.findMedian() = " + finder.findMedian());
        finder.addNum(10);
        System.out.println("finder.findMedian() = " + finder.findMedian());
        finder.addNum(2);
        System.out.println("finder.findMedian() = " + finder.findMedian());
        finder.addNum(6);
        System.out.println("finder.findMedian() = " + finder.findMedian());
        finder.addNum(5);
        System.out.println("finder.findMedian() = " + finder.findMedian());
    }
}
