package com.cangxiao.leetCode.middle;

import java.util.*;

/**
 * @Author cangxiao
 * @Date 2022/1/16
 * @Desc 752. 打开转盘锁
 */
public class Solution752 {

    private Set<String> visited;
    private Set<String> deadSet;
    private int depth = 0;
    public int openLock(String[] deadends, String target) {
        deadSet = new HashSet<>();
        deadSet.addAll(Arrays.asList(deadends));
        if (deadSet.contains("0000")) return -1;
        visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add("0000");
        visited.add("0000");
        while (!queue.isEmpty()){
            int size = queue.size();
            int k = 0;
            while (k < size){
                String node = queue.poll();
                if (target.equals(node)){
                    return depth;
                }
                List<String> newNodes = genNewNodes(node);
                for (String newNode : newNodes) {
                    if (visited.contains(newNode)||deadSet.contains(newNode)){
                        continue;
                    }
                    queue.add(newNode);
                    visited.add(newNode);
                }
                k++;
            }
            depth++;
        }
        return -1;
    }

    private List<String> genNewNodes(String node) {
        List<String> newNodes = new ArrayList<>();
        int[] change = {-1,1};
        for (int i = 0; i < 4; i++) {
            for (int k = 0; k < change.length; k++) {
                char[] newNode = new char[4];
                for (int j = 0; j < i; j++) {
                    newNode[j] = node.charAt(j);
                }
                for (int j = i+1; j < 4; j++) {
                    newNode[j] = node.charAt(j);
                }
                String newC = (((node.charAt(i)-'0')+change[k] + 10) % 10)+"";
                newNode[i] = newC.charAt(0);
                newNodes.add(String.valueOf(newNode));
            }
        }
        return newNodes;
    }

    public static void main(String[] args) {
        Solution752 solution = new Solution752();
        List<String> list = solution.genNewNodes("0000");
        System.out.println("list = " + list);
    }

}
