package com.cangxiao.leetCode.queue;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/*
 * @author: cangxiao zhandchn@qq.com
 * @date: Do not edit
 * @desc: 
 * 2809226095
 * Copyright (c) 2023 by zhandchn@163.com, All Rights Reserved. 
 */
public class Solution752 {
    public int openLock(String[] deadends, String target) {

        if ("0000".equals(target)) return 0;
        Set<String> visited = new HashSet<>();
        Set<String> deads = new HashSet<>();
        for (int i = 0; i < deadends.length; i++){
            if (deadends[i]==target) return -1;
            deads.add(deadends[i]);
        }
        
        LinkedList<String> queue = new LinkedList<>();
        queue.offer("0000");
        visited.add("0000");
        int step = 0;

        while(!queue.isEmpty()){
           int size = queue.size();
           for (int i = 0; i< size; i++){
                String status = queue.poll();
                if(deads.contains(status)){
                   continue;
                }
                if (status.equals(target)){
                   return step;
                }   
                
                for (int j = 0; j< 4; j++){
                    String nextUp = up(status, j);
                    if (!visited.contains(nextUp)){
                        queue.offer(nextUp);
                        visited.add(status);
                    }
                    String nextDown = down(status, j);
                    if (!visited.contains(nextDown)){
                        queue.offer(nextDown);
                        visited.add(status);
                    }
                }
            
           }
           step++;
        }
        return -1;
    }

    private String up(String status, int i){
        char[] chars = status.toCharArray();
        if (chars[i]=='9'){
            chars[i]='0';
            return String.valueOf(chars);
        }
        chars[i]++;
        return String.valueOf(chars);
    }
    private String down(String status, int i){
        char[] chars = status.toCharArray();
        if (chars[i]=='0'){
            chars[i]='9';
            return String.valueOf(chars);
        }
        chars[i]--;
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        String[] deadends = new String[]{ "0201", "0101", "0102", "1212", "2002"};
        String target = "0202";
        Solution752 solution752 = new Solution752();
        int step = solution752.openLock(deadends, target);
        System.out.println(step);
    }
}