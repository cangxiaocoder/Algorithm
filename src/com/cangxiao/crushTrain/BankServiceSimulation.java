package com.cangxiao.crushTrain;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author cangxiao
 * @Date 2024/11/18
 * @Desc 某银行将客户分为了若干个优先级，1 级最高， 5 级最低，
 * 当你需要在银行办理业务时，优先级高的人随时可以插队到优先级低的人的前面。
 * 现在给出一个人员到来和银行办理业务的时间序列，请你在每次银行办理业务时输出客户的编号。
 * 如果同时有多位优先级相同且最高的客户，则按照先来后到的顺序办理。
 * 请实现 BankServiceSimulation 类来模拟该业务流程，BankServiceSimulation
 * 支持以下操作：
 *  1）void joinQueue(int customNo, int priority)，一个新客户加入队列，customNo为客户编号，priority为优先级。
 *  2）int handleBusiness()，当前优先级最高的客户出队去办理业务，返回值为该客户编号。
 */
public class BankServiceSimulation {

    Queue<Integer>[] queues;
    int queueLength = 5;
    public BankServiceSimulation() {
        this.queues = new LinkedList[queueLength];
        for (int i = 0; i < queueLength; i++) {
            queues[i] = new LinkedList<>();
        }

    }

    public void joinQueue(int customNo, int priority) {
        queues[priority - 1].offer(customNo);
    }

    public int handleBusiness() {
        for (int i = 0; i < queueLength; i++) {
            if (!queues[i].isEmpty()) {
                return queues[i].poll();
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        BankServiceSimulation service = new BankServiceSimulation();
//        service.joinQueue(1,3);
//        service.joinQueue(2,2);
//        service.joinQueue(3,2);
        System.out.println("service.handleBusiness() = " + service.handleBusiness());
    }
}
