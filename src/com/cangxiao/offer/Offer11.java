package com.cangxiao.offer;

/**
 * @Author cangxiao
 * @Date 2022/2/28
 * @Desc 剑指 Offer 11. 旋转数组的最小数字
 */
public class Offer11 {
    /**
     * 当前一个元素大于后一个元素时，后一个元素就是最小值
     *
     * @param numbers
     * @return
     */
    public int minArray(int[] numbers) {
        if (numbers == null) return 0;
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i - 1] > numbers[i]) {
                return numbers[i];
            }
        }
        return numbers[0];
    }

    /**
     * 二分查找
     * 5 6 0 1 2 3 4
     * @param numbers
     * @return
     */
    public int minArray2(int[] numbers) {
        if (numbers == null) return 0;
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            if (numbers[left] <= numbers[right]){
                return numbers[left];
            }
            int mid = left + (right - left) / 2;
            //若[mid,right]区间时升序，则最小值一定在[left,mid]之间
            if (numbers[mid] < numbers[right]) {
                right = mid;
            //若numbers[mid] > numbers[right]，而且mid不是最小值，则最小值一定在[mid + 1,right]区间，
            }else if (numbers[mid] > numbers[right]){
                left = mid + 1;
            }else {
                //若numbers[mid] == numbers[right]
                right--;
            }
        }
        return numbers[left];
    }

    public static void main(String[] args) {
        Offer11 offer11 = new Offer11();
        int min = offer11.minArray2(new int[]{5, 6, 0, 1, 2, 3, 4});
        System.out.println("min = " + min);
    }

}
