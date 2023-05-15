package com.cangxiao.nowcoder.recur;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author cangxiao
 * @Date 2023/5/13
 * @Desc HJ61 放苹果
 * 把m个同样的苹果放在n个同样的盘子里，允许有的盘子空着不放，问共有多少种不同的分法？
 * 注意：如果有7个苹果和3个盘子，（5，1，1）和（1，5，1）被视为是同一种分法。
 */
public class HJ61 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            int count = backtrack(m, n);
            System.out.println("result = " + count);

        }
    }

    private static int backtrack(int m, int n) {
        if (m < 0 || n < 0) {
            return 0;
        }
        //如果没有苹果则只有一种放法 如果苹果或者盘子只有一个也只有一种放法
        if (m == 0 || m == 1 || n == 1) {
            return 1;
        }

        /*
            1、至少有一个盘子为空，则有（backtrack(m,n-1))中放法，每次递归n都会减 1，
                第1次递归  会出现空1个盘子
                第2次递归  会出现空2个盘子
                第3次递归  会出现空3个盘子
                ...
              直到n为1 则只有一种放法，退出
            2、假设没有盘子为空，则每个盘子至少有一个苹果  相当于每个盘子都去掉一个苹果，不影响方案数量，
                如7个苹果3个盘子
                3，2，2是一个方案
                2，1，1是一个方案
                将下面的方案替换上面的方案，方案的数量还是1，同时方案数量的时候都是累加 1；
                则剩余m-n个苹果，每次递归都会减少n个苹果
                第1次递归  少m-n个苹果
                第2次递归  少m-n-n个苹果
                第3次递归  少m-n-n-n个苹果
                ...
                直到n>m则
         */
        return backtrack(m, n - 1) + backtrack(m - n, n);
    }

    private static int backtrack2(int m, int n) {

        //如果没有苹果则只有一种放法 如果苹果或者盘子只有一个也只有一种放法
        if (m == 0 || m == 1 || n == 1) {
            return 1;
        }
        //如果盘子比苹果多，则最多可以放m个盘子
        if (n > m) {
            return backtrack2(m, m);
        }
        /*
            1、至少有一个盘子为空，则有（backtrack(m,n-1))中放法，每次递归n都会减 1，
                第1次递归  会出现空1个盘子
                第2次递归  会出现空2个盘子
                第3次递归  会出现空3个盘子
                ...
              直到n为1 则只有一种放法，退出
            2、假设没有盘子为空，则每个盘子至少有一个苹果  相当于每个盘子都去掉一个苹果，不影响方案数量，
                如7个苹果3个盘子
                3，2，2是一个方案
                2，1，1是一个方案
                将下面的方案替换上面的方案，方案的数量还是1，同时方案数量的时候都是累加 1；
                则剩余m-n个苹果，每次递归都会减少n个苹果
                第1次递归  少m-n个苹果
                第2次递归  少m-n-n个苹果
                第3次递归  少m-n-n-n个苹果
                ...
                直到n>m则
         */
        return backtrack2(m, n - 1) + backtrack2(m - n, n);
    }

}
