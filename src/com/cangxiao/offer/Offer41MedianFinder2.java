package com.cangxiao.offer;

import java.util.*;

/**
 * @Author cangxiao
 * @Date 2022/6/25
 * @Desc 剑指 Offer 41. 数据流中的中位数
 */
public class Offer41MedianFinder2 {

    //小顶堆存储较大一半的值
    Queue<Integer> minQueue;
    //大顶堆存储较小一半的值
    Queue<Integer> maxQueue;
    //保证堆顶元素为最中间的两个元素

    /**
     * initialize your data structure here.
     */
    public Offer41MedianFinder2() {
        //大顶堆堆顶为最大值， 需要倒序排列
        maxQueue = new PriorityQueue<>((q1, q2) -> q2 - q1);
        minQueue = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (minQueue.isEmpty()) {
            minQueue.add(num);
            return;
        }
        //数据流的数据为奇数
        if (maxQueue.size() != minQueue.size()) {
            //将num放入小顶堆，
            minQueue.add(num);
            //重新排序后小顶堆堆顶的值为最小值，将这个最小值值放入大顶堆，保证大顶堆的数据是较小的一半
            maxQueue.add(minQueue.poll());
        } else {
            //数据流的数据为偶数。先将num放入大顶堆，重新排序后
            maxQueue.add(num);
            //重新排序后大顶堆 堆顶的值为最大值，将这个最大值放入小顶堆，保证小顶堆的数据是较大的一半
            minQueue.add(maxQueue.poll());
        }
    }

    public double findMedian() {
        if (minQueue.isEmpty()){
            return 0;
        }
        if (minQueue.size()!=maxQueue.size()){
            return minQueue.peek();
        }else {
            return (minQueue.peek()+maxQueue.peek())/2.0;
        }
    }

    public static void main(String[] args) {
        Offer41MedianFinder2 finder = new Offer41MedianFinder2();
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
