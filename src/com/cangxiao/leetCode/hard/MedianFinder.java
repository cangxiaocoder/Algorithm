package com.cangxiao.leetCode.hard;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author cangxiao
 * @Date 2021/11/22
 * @Desc 295. 数据流的中位数
 * https://leetcode-cn.com/problems/find-median-from-data-stream/
 */
public class MedianFinder {
    //小顶堆存放较大的值
    private PriorityQueue<Integer> minQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o));
    //大顶堆存放较小的值
    private PriorityQueue<Integer> maxQueue = new PriorityQueue<>((o1, o2) -> o2-o1);

    public MedianFinder() {}

    public void addNum(int num) {
        //num比大顶堆的堆顶值还小，属于较小的值，应该放在大顶堆
        if (maxQueue.isEmpty() || num < maxQueue.peek()){
            maxQueue.offer(num);
        }else {
            minQueue.offer(num);
        }
        while (maxQueue.size()<minQueue.size()){
            maxQueue.offer(minQueue.poll());
        }
        //如果数量是奇数，则maxQueue.size比minQueue.size多一个元素
        while (maxQueue.size()>minQueue.size()+1){
            minQueue.offer(maxQueue.poll());
        }
    }

    public double findMedian() {
        if (maxQueue.size()>minQueue.size()){
            return maxQueue.peek();
        }else {
            return (double) (maxQueue.peek() + minQueue.peek()) /2;
        }
    }
}
class MedianFinder2 {

    private PriorityQueue<Integer> minQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o));
    private PriorityQueue<Integer> maxQueue = new PriorityQueue<>((o1, o2) -> o2-o1);

    public MedianFinder2() {}

    public void addNum(int num) {
        //num比小顶堆的堆顶值还大，属于较大的值，应该放在小顶堆
        if (minQueue.isEmpty() || num > minQueue.peek()){
            minQueue.offer(num);
        }else {
            maxQueue.offer(num);
        }
        while (maxQueue.size()<minQueue.size()-1){
            maxQueue.offer(minQueue.poll());
        }
        //如果数量是奇数，则maxQueue.size比minQueue.size多一个元素
        while (maxQueue.size()>minQueue.size()){
            minQueue.offer(maxQueue.poll());
        }
    }

    public double findMedian() {
        if (minQueue.size()>maxQueue.size()){
            return minQueue.peek();
        }else {
            return (double) (maxQueue.peek() + minQueue.peek()) /2;
        }
    }

    public static void main(String[] args) {
        MedianFinder2 medianFinder = new MedianFinder2();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
    }
}