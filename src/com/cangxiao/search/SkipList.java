package com.cangxiao.search;

import java.util.Arrays;

/**
 * @Author cangxiao
 * @Date 2021/7/25
 * @Desc 跳表
 */
public class SkipList {

    private static final float SKIPLIST_P = 0.5f;
    private static final int MAX_LEVEL = 16;
    private int levelCount = 1;

    private final Node head = new Node();

    private class Node{

        private int data; //当前结点的数据
        //当前结点的下一个结点所有层的数据，
        // 如forwards[3]表示当前结点在第三层的下一个结点数据，非当前结点的下一个结点在第三层的数据，因为当前结点的下一个结点可能没有三层；
        private Node[] forwards;
        //当前结点的最大层数
        private int maxLevel;

        public Node() {
            this.data = -1;
            this.forwards = new Node[MAX_LEVEL];
            maxLevel = 0;
        }
        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("{ data: ");
            builder.append(data);
            builder.append("; levels: ");
            builder.append(maxLevel);
            builder.append(" }");
            return builder.toString();
        }
    }

    /**
     * 插入操作
     *
     * 1. 为插入结点随机一个层数
     * 2. 找到结点插入的位置，若插入的数据大于链表中的数据，只需更新每层的最后一个结点，将这个个结点指向新插入的结点
     * 3. 若插入的数据在链表中间，则更新插入结点每层前后结点的指针
     * @param value
     */
    public void insert(int value){
        //插入的结点有多少层
        int level = randomLevel();
        Node newNode = new Node();
        newNode.data = value;
        newNode.maxLevel = level;
        Node p = head;
        for (int i = level-1; i>=0; i--) {
            while (p.forwards[i]!=null&& p.forwards[i].data<value){
                p = p.forwards[i];
            }
            if(p.forwards[i]==null){
                p.forwards[i] = newNode;
            }else {
                //如果p.forwards[i]不为null。说明插入的数据在两节点之间
                Node next = p.forwards[i];
                p.forwards[i] = newNode;
                newNode.forwards[i] = next;
            }
        }
        //更新结点的高度
        if(levelCount<level) levelCount = level;
    }

    /**
     * 1. 从最高层向下遍历，当当前结点的下一个结点为null或结点值大于被查找的值value,结束
     * 2. 如果最终当前结点的下一个结点为null，则此值不存在
     * 3. 如果存在，则无论i为多少，小于等于i所指向的接待你为同一个结点
     * @param value
     * @return
     */
    public Node find(int value){
        Node p = head;
        for (int i = levelCount-1; i >= 0; i--) {
            while (p.forwards[i]!=null && p.forwards[i].data<value){
                p = p.forwards[i];
            }
        }
        if(p.forwards[0]!=null && p.forwards[0].data==value){
            return p.forwards[0];
        }else {
            return null;
        }

    }

    /**
     * 删除操作
     *
     * 1. 找到需要删除结点的所有前置结点
     * 2. 将这些前置结点的指针指向被删除结点的后置结点
     * @param value
     * @return
     */
    public boolean delete(int value){
        boolean flag = false;
        Node p = head;
        //记录被删除结点的前置结点
        Node[] updates = new Node[levelCount];
        for (int i = levelCount-1; i >= 0; i--) {
            while (p.forwards[i]!=null && p.forwards[i].data<value){
                p = p.forwards[i];
            }
            updates[i] = p;
        }

        if(p.forwards[0]!=null && p.forwards[0].data==value){
            for (int i = updates.length-1; i >= 0; i--) {
                if(updates[i].forwards[i]!=null && updates[i].forwards[i].data==value){
                    updates[i].forwards[i] = updates[i].forwards[i].forwards[i];
                }
            }
            flag = true;
        }
        //如果删除了最顶部的一个元素，则跳表的高度需要减 1；
        while (levelCount>1 && head.forwards[levelCount-1]==null){
            levelCount--;
        }
        return flag;

    }

    /** 理论来讲，一级索引中元素个数应该占原始数据的 50%，二级索引中元素个数占 25%，三级索引12.5% ，一直到最顶层。
    * 因为这里每一层的晋升概率是 50%。对于每一个新插入的节点，都需要调用 randomLevel 生成一个合理的层数。
    * 该 randomLevel 方法会随机生成 1~MAX_LEVEL 之间的数，且 ：
    *        50%的概率返回 1 : Math.random()<0.5的概率为50%
    *        25%的概率返回 2 ：Math.random()第一次小于0.5第二次大于0.5的概率为50%*50%=25%
    *      12.5%的概率返回 3 ...
     */
    private int randomLevel() {
        int level = 1;

        while (Math.random() < SKIPLIST_P && level < MAX_LEVEL)
            level += 1;
        return level;
    }

    public void printAll() {
        Node p = head;
        while (p.forwards[0] != null) {
            System.out.print(p.forwards[0] + " ");
            p = p.forwards[0];
        }
        System.out.println();
    }
    /**
     * 打印所有数据
     */
    public void printAll_beautiful() {
        Node p = head;
        Node[] c = p.forwards;
        Node[] d = c;
        int maxLevel = c.length;
        for (int i = maxLevel - 1; i >= 0; i--) {
            do {
                System.out.print((d[i] != null ? d[i].data : null) + ":" + i + "-------");
            } while (d[i] != null && (d = d[i].forwards)[i] != null);
            System.out.println();
            d = c;
        }
    }


    public static void main(String[] args) {
        SkipList skipList = new SkipList();
        skipList.insert(3);
        skipList.insert(5);
        skipList.insert(7);
        skipList.insert(9);
//        skipList.printAll();
        skipList.insert(11);
//        skipList.printAll();
        skipList.insert(6);
//        skipList.printAll();
//        skipList.insert(2);
//        skipList.insert(4);
//        skipList.insert(6);
//        skipList.insert(8);
        skipList.insert(10);
        skipList.printAll();
        skipList.printAll_beautiful();
        System.out.println(Arrays.toString(skipList.head.forwards));
        System.out.println("skipList.find(4) = " + skipList.find(4));
        System.out.println("skipList.delete(4) = " + skipList.delete(4));
        System.out.println("skipList.delete(8) = " + skipList.delete(8));
        skipList.printAll();
    }

}
