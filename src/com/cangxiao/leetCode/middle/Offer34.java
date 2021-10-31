package com.cangxiao.leetCode.middle;

import com.cangxiao.sort.BubbleSort;

import javax.swing.table.TableModel;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.DataFormatException;

/**
 * @Author cangxiao
 * @Date 2021/10/24
 * @Desc 剑指 Offer 34. 二叉树中和为某一值的路径
 */
public class Offer34 {

    List<List<Integer>> result ;
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        result = new ArrayList<>();
        if (root==null) return result;
        dfs(root, target, new ArrayList<>(), 0);
        return result;
    }

    /**
     *
     * @param node 当前节点
     * @param target 目标值
     * @param path 存储符合条件的node节点数组
     * @param sum 当前路径当前节点之前节点的和
     */
    private void dfs(TreeNode node, int target, List<Integer> path, int sum) {
        path.add(node.val);
        if (node.left== null && node.right==null){
            //当前节点值 + 当前路径节点值的和 == target,满足条件
            if (sum + node.val == target){
                List<Integer> tempPath = new ArrayList<>(path);
                result.add(tempPath);
            }
            //返回当前节点的父节点，再向左或向右遍历
            path.remove(path.size() - 1);
            return;
        }
        if (node.left!=null){
            dfs(node.left,target,path,sum+node.val);
        }
        if (node.right!=null){
            dfs(node.right,target,path,sum+ node.val);
        }
        if (path.size()>0){
            path.remove(path.size() - 1);
        }
    }
}
