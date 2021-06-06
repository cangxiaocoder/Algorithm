package com.cangxiao.search;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @Author cangxiao
 * @Date 2021/4/13
 * @Desc 广度优先搜索 Breadth first search
 */
public class BFS {
    //[90,69,null,49,89,null,52]
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(52);
        TreeNode node2 = new TreeNode(89,null,node1);
        TreeNode node3 = new TreeNode(49);
        TreeNode node4 = new TreeNode(69,node3,node2);
        TreeNode node5 = new TreeNode(90,node4,null);
        BFS bfs = new BFS();
//        bfs.print(node5);
        int min = bfs.search(node5);
        System.out.println(min);
    }

    private Queue<TreeNode> search = new ArrayDeque<>();
    private List<TreeNode> searched = new ArrayList<>();

    public void print1(TreeNode treeNode){
        if(treeNode==null){
            return ;
        }

    }

    public int search(TreeNode treeNode){
        int min = 0;
        if(treeNode==null){
            return min;
        }
        min = Math.abs(treeNode.val);
        search.add(treeNode);
        while (!search.isEmpty()){
            TreeNode node = search.poll();

            if(node.left!=null){
                search.add(node.left);
                min = Math.min(min,Math.abs(node.val - node.left.val));
            }
            if(node.right!=null){
                search.add(node.right);
                min = Math.min(min,Math.abs(node.val - node.right.val));
            }

        }
        return min;
    }



    public void print2(TreeNode treeNode){
        if(treeNode==null){
            return ;
        }
        search.add(treeNode);
        while (!search.isEmpty()){
            TreeNode node = search.poll();
            if(node.left!=null){

                search.add(node.left);
            }
            if(node.right!=null){

                search.add(node.right);
            }

            if(!searched.contains(node)){
                searched.add(node);
                System.out.println(node.val);
            }
        }
    }
}
