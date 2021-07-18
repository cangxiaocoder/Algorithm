package com.cangxiao.heap;

import java.util.Arrays;

/**
 * @Author cangxiao
 * @Date 2021/7/17
 * @Desc 堆实现 - 大顶堆
 */
public class Heap {
    private int[] heap;
    private int n; //堆中可以存储最大数据个数
    private int count;//堆中已存储数据的个数

    /**
     * 数组的第一个元素不存储数据，是满足一下规律
     * 数组中下标为 i 的节点的左子节点，就是下标为 i∗2 的节点，右子节点就是下标为 i∗2+1 的节点，父节点就是下标为 i/2 的节点。
     * @param capacity
     */
    public Heap(int capacity) {

        heap = new int[capacity+1];
        n = capacity;
        count = 0;
    }

    /**
     * 插入一个元素
     * @param value
     */
    public void insert(int value){
        if(count>=n)throw new RuntimeException("堆已经满了");
        //第一个位置不存储元素
        heap[++count] = value;
        int i = count;
        while (i/2>0 && heap[i]>heap[i/2]){
            swap(heap,i,i/2);
            i = i/2;
        }
    }

    /**
     * 删除对顶元素
     * 1. 将最后一个元素移动到对顶
     * 2. 比较堆顶元素与左叶子节点大小，若左叶子节点大，记录左叶子节点的索引为maxIndex
     * 3. 比较左叶子节点点与右叶子节点的大小，若右叶子节点大于左叶子节点，更新maxIndex为右叶子节点的索引
     * 4. 交换对顶元素与maxIndex索引位置的值
     * 5. 当不在右交换时，移除完成
     */
    public void removeMax(){
        if(count==0) return;
        //将最后一个元素移动收到对顶
        heap[1] = heap[count];
        //删除最后一个元素
        heap[count] = 0;
        count--;
        int i = 1;
        int maxIndex = i;
        while (true){
            if(2*i<=count && heap[i]<heap[2*i]){
                maxIndex = 2*i;
            }
            if(2*i+1<=count && heap[maxIndex]<heap[2*i+1]){
                maxIndex = 2*i+1;
            }
            if(i==maxIndex)break;
            swap(heap,maxIndex,i);
            //记录交换后的索引
            i = maxIndex;
        }
    }

    private void swap(int[] heap, int i, int j){
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {0,33,27,21,16,13,15,19,5,6,7,8,1,2,12};
        Heap heap = new Heap(16);
        System.arraycopy(arr, 1, heap.heap, 1, arr.length - 1);
        System.out.println(Arrays.toString(heap.heap));
        heap.count = 14;
        heap.insert(24);
        System.out.println(Arrays.toString(heap.heap));
        heap.removeMax();
        System.out.println(Arrays.toString(heap.heap));

    }
}
