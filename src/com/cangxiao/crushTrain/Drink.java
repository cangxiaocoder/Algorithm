package com.cangxiao.crushTrain;

/**
 * 有X瓶酒，每3个空瓶子可以换一瓶酒，每7个盖子也可以换一瓶酒，最后可以和多少酒
 * @Author cangxiao
 * @Date 2021/8/22
 * @Desc
 */
public class Drink {

    public int drinking(int x){
        int count = x;
        int k1 = x, k2 = x;
        while (k1>=3 || k2 >=7){
            if(k1 >= 3){
                int change = k1 / 3;
                count = count + change;
                k1 = k1 % 3;
                k1 = k1 + change;
                k2 = k2 + change;
            }
            if(k2 >= 7){
                int change = k2 / 7;
                count = count + change;
                k2 = k2 % 7;
                k1 = k1 + change;
                k2 = k2 + change;
            }
        }
        return count;
    }

    public int drinking2(int x){
        int count = x; //喝了多少酒
        //有多少空瓶和瓶盖
        int k1 = x, k2 = x;
        while (k1>=3){
            while (k1 >= 3){
                int change = k1/3;
               count += change;
               k1 %= 3;
               k1 += change;
               k2 += change;
            }
            while (k2 >= 7){
                int change = k2/7;
                count += change;
                k2 %= 7;
                k1 += change;
                k2 += change;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Drink drink = new Drink();
        System.out.println("0  ==> "+drink.drinking(0));
        System.out.println("1  ==> "+drink.drinking(1));
        System.out.println("2  ==> "+drink.drinking(2));
        System.out.println("3  ==> "+drink.drinking(3));
        System.out.println("4  ==> "+drink.drinking(4));
        System.out.println("5  ==> "+drink.drinking(5));
        System.out.println("6  ==> "+drink.drinking(6));
        System.out.println("7  ==> "+drink.drinking(7));
        System.out.println("8  ==> "+drink.drinking(8));
        System.out.println("9  ==> "+drink.drinking(9));

    }
}
