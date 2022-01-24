package com.cangxiao.leetCode.middle;

import java.util.*;

/**
 * @Author cangxiao
 * @Date 2022/1/16
 * @Desc 752. 打开转盘锁
 */
public class Solution752_2 {

    public int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet<>(Arrays.asList(deadends));
        if (dead.contains("0000")) {
            return -1;
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        //已访问的节点
        Set<String> visited = new HashSet<>();
        visited.add("0000");
        int depth = 0;
        while (!queue.isEmpty()) {

            int size = queue.size();
            //根节点一个,走一步 8个节点,走两步64个节点,...;每走一步,查完当前所有节点
            for (int j = 0; j < size; j++) {
                String node = queue.poll();
                if (dead.contains(node) || node==null) continue;
                //解锁成功
                if (target.equals(node)) return depth;
                //4：可以旋转四个拨轮
                for (int i = 0; i < 4; i++) {
                    //四个拨轮分别向左旋
                    String left = leftHand(node, i);
                    if (!visited.contains(left)) {
                        visited.add(left);
                        queue.offer(left);
                    }
                    //四个拨轮分别向右旋
                    String right = rightHand(node, i);
                    if (!visited.contains(right)) {
                        visited.add(right);
                        queue.offer(right);
                    }
                }
            }
            //初始状态不算步数;
            depth++;
        }
        return -1;
    }

    /**
     * 左旋, 0->9  9->8 8->7 ... 1->0
     *
     * @param node 当前密码锁状态
     * @param i    第 i 个转盘锁
     * @return 左旋一次锁后的状态
     */
    private String leftHand(String node, int i) {
        char[] lock = node.toCharArray();
        if (lock[i] == '0') lock[i] = '9';
        else lock[i]--;
        return new String(lock);
    }

    /**
     * 右旋, 0->1  1->2 2->3 ... 9->0
     *
     * @param node 当前密码锁状态
     * @param i    第 i 个转盘锁
     * @return 右旋一次锁后的状态
     */
    private String rightHand(String node, int i) {
        char[] lock = node.toCharArray();
        if (lock[i] == '9') lock[i] = '0';
        else lock[i]++;
        return new String(lock);
    }

}
