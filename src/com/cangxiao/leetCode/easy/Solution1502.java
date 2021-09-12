package com.cangxiao.leetCode.easy;

/**
 * @Author cangxiao
 * @Date 2021/9/12
 * @Desc 1502. 判断能否形成等差数列
 */
public class Solution1502 {

    public boolean canMakeArithmeticProgression(int[] arr) {
        sort(arr, 0, arr.length - 1);
        int tem = arr[1] - arr[0];
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] != arr[i - 1] - arr[i - 2]) {
                return false;
            }
        }
        return true;
    }


    public void sort(int[] arr, int p, int q) {
        if (p < q) {
            int index = partition(arr, p, q);
            sort(arr, p, index);
            sort(arr, index+1, q);
        }
    }

    private int partition(int[] arr, int p, int q) {

        int value = arr[p];
        while (p < q) {
            while (p < q && arr[q] >= value) {
                q--;
            }
            arr[p] = arr[q];
            while (p < q && arr[p] < value) {
                p++;
            }
            arr[q] = arr[p];
        }
        arr[p] = value;
        return p;
    }
}
