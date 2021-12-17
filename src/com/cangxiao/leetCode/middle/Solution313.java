package com.cangxiao.leetCode.middle;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @Author cangxiao
 * @Date 2021/12/4
 * @Desc 313. 超级丑数
 */
public class Solution313 {

    public int nthSuperUglyNumber(int n, int[] primes) {
        PriorityQueue<Long> minQueue = new PriorityQueue<>(Comparator.comparingLong(o -> o));
        //避免重复数据
        Set<Long> uniset = new HashSet<>();
        minQueue.offer(1L);
        uniset.add(1L);
        long data = 1;
        int count = 0;
        while (!minQueue.isEmpty() && count < n){
            data = minQueue.poll();
            count++;
            for (int i = 0; i < primes.length; i++) {
                if (!uniset.contains(data*primes[i])){
                    minQueue.offer(data*primes[i]);
                    uniset.add(data*primes[i]);
                }
            }
        }
        return (int) data;
    }
}
