package com.cangxiao.backtracking;

/**
 * @Author cangxiao
 * @Date 2021/12/12
 * @Desc 例题讲解：例题30-1背包问题 假设有一个背包，背包可承载的最大重量是wkg。
 * 现在有n个物品，每个物品的重量不等， 并旦不可分割。我们期望选择几件物品，
 * 装到背包中。在不超过背包最大重量限制的前提 下，求背包中物品的最大重量
 */
public class Solution2 {

    private int maxW = Integer.MIN_VALUE; //存储背包中物品总重量的最大值
    public int bage(int[] items,int W){
        backtrack(items,0,0,W);
        return maxW;
    }

    /**
     *
     * @param items 物品
     * @param k 存放物品的下标
     * @param cw 存放背包中物品的重量
     * @param W 背包总承受重量
     */
    private void backtrack(int[] items, int k, int cw, int W) {
        //当K==items.length-1时，最后一个还没有被决策，
        //当K==items.length时, 最后一个物品决策完毕，即遍历完所有物品
        if (cw==W || k ==items.length){
            if (cw>maxW) maxW = cw;
            return;
        }

        if (cw + items[k] <=W){
            backtrack(items,k+1, cw+items[k], W);
        }
        backtrack(items,k+1,cw,W);
    }

    public static void main(String[] args) {
        int[] items = new int[]{3,5,7,8,10};
        Solution2 solution2 = new Solution2();
        int bage = solution2.bage(items, 10);
        System.out.println("bage = " + bage);
    }
}
