package com.cangxiao.sort;

/**
 * @Author cangxiao
 * @Date 2021/7/10
 * @Desc 用快速排序查找第K大的元素
 */
public class SelectK {
    private static final int k = 1;
    private static int value = 0;
    public static void main(String[] args) {
        int[] array = {13, 15, 24, 99, 14, 11, 1, 2, 3};
//        int[] array = {3,2,5,4,1};
        SelectK selectK= new SelectK();
        value = selectK.sort(array, 0, array.length - 1);

        System.out.println("第K大的元素是："+value);
    }

    public int sort(int[] array, int left, int right) {
        if (left <= right) {
            //获取基准值索引进行分区
            int index = partition(array, left, right);
            if(k==index+1){
                value = array[index];
            }else if(k<=index){
                sort(array, left, index - 1);
            }else {
                sort(array, index + 1, right);
            }
        }
        return value;
    }

    public int partition(int[] array, int left, int right) {

        //选择一个基准值，大于基准值的放右边，小于基准值的放左边
        int temp = array[left];
        while (left < right) {
            //从右往左，右边的值大于基准值，不需要交换位置，比较下一个值
            while (left < right && temp >= array[right]) {
                right--;
            }
            //当右边的值小于基准值时，交换位置，将右边小的值放到左边
            if(left!=right){
                swap(array, left, right);
            }
            //从左往右，基准值大于左边的值，不需要交换位置，比较下一个值
            while (left < right && temp < array[left]) {
                left++;
            }
            //当左边的值大于基准值时，交换位置，将左边大的值放到右边
            if(left!=right){
                swap(array, left, right);
            }
        }
        //排序完，基准值都会排到数组的中间位置；即 left==right时
        int index = left;
        return index;
    }

    private void swap(int[] array, int left, int right) {
        int t = array[left];
        array[left] = array[right];
        array[right] = t;
    }
}
