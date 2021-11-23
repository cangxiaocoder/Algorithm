package com.cangxiao.leetCode.middle;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @Author cangxiao
 * @Date 2021/11/21
 * @Desc 347. 前 K 个高频元素
 */
public class Solution347 {

    private static class QElement{
        int key;
        int count;

        public QElement(int key, int count) {
            this.key = key;
            this.count = count;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        if (nums.length==0 || k==0) return null;
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            counts.put(num,counts.getOrDefault(num,0)+1);
        }
        PriorityQueue<QElement> minQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o.count));
        counts.forEach((key, value) -> {
            if (minQueue.size()<k){
                minQueue.offer(new QElement(key, value));
            } else {
                if (minQueue.peek().count<value){
                    minQueue.poll();
                    minQueue.offer(new QElement(key, value));
                }

            }

        });
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            if (minQueue.peek()==null) break;
            result[i] = minQueue.poll().key;
        }
        return result;
    }
}
