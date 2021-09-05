package com.cangxiao.leetCode.queue;

import java.util.LinkedList;

/**
 * 动物收容所。有家动物收容所只收容狗与猫，且严格遵守“先进先出”的原则。在收养该收容所的动物时，收养人只能收养所有动物中“最老”（由其进入收容所的时间长短而定）的动物，或者可以挑选猫或狗（同时必须收养此类动物中“最老”的）。换言之，收养人不能自由挑选想收养的对象。请创建适用于这个系统的数据结构，实现各种操作方法，比如enqueue、dequeueAny、dequeueDog和dequeueCat。允许使用Java内置的LinkedList数据结构。
 *
 * enqueue方法有一个animal参数，animal[0]代表动物编号，animal[1]代表动物种类，其中 0 代表猫，1 代表狗。
 *
 * dequeue*方法返回一个列表[动物编号, 动物种类]，若没有可以收养的动物，则返回[-1,-1]。
 *
 * @Author cangxiao
 * @Date 2021/9/5
 * @Desc 面试题 03.06. 动物收容所
 */
public class SolutionInterView03_06 {

    LinkedList<Integer> dogs;
    LinkedList<Integer> cats;

    public SolutionInterView03_06() {
        dogs = new LinkedList<>();
        cats = new LinkedList<>();
    }

    public void enqueue(int[] animal) {
        if (animal[1] == 0){
            cats.offer(animal[0]);
        }
        if (animal[1] == 1){
            dogs.offer(animal[0]);
        }
    }

    public int[] dequeueAny() {
        if (!cats.isEmpty() || !dogs.isEmpty()){
            if (dogs.isEmpty()){
                return new int[]{cats.poll(),0};
            }
            if (cats.isEmpty()){
                return new int[]{dogs.poll(),1};
            }
            if (dogs.peek() > cats.peek()){
                return new int[]{cats.poll(),0};
            }
            return new int[]{dogs.poll(),1};
        }

        return new int[]{-1,-1};

    }

    public int[] dequeueDog() {
        if (dogs.isEmpty())return new int[]{-1,-1};
        return new int[]{dogs.poll(),1};
    }

    public int[] dequeueCat() {
        if (cats.isEmpty())return new int[]{-1,-1};
        return new int[]{cats.poll(),0};
    }

    public static void main(String[] args) {
        SolutionInterView03_06 solution = new SolutionInterView03_06();

    }
}
