package com.cangxiao.queue;

import java.util.*;

/**
 * @Author cangxiao
 * @Date 2022/10/3
 * @Desc 克隆图 给你无向连通图中一个节点的引用，请你返回该图的深拷贝（克隆）。
 * 图中的每个节点都包含它的值 val（int） 和其邻居的列表（list[Node]）。
 */
class Node {
    public int val;
    public List<Node> neighbors;

    public Node(int val, List<Node> neighbors) {
        this.val = val;
        this.neighbors = neighbors;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                ", neighbors=" + neighbors +
                '}';
    }
}

public class CloneGraph {

    public Node cloneGraph(Node node){
        return doCloneGraph(node, new HashMap<>());
    }

    /**
     * DFS 深度优先搜索
     * @param node
     * @param visited
     * @return
     */
    private Node doCloneGraph(Node node, HashMap<Integer, Node> visited) {
        if (node==null) return null;
        if (visited.containsKey(node.val)){
            return visited.get(node.val);
        }
        //克隆节点
        Node cloneNode = new Node(node.val, new ArrayList<>());
        visited.put(cloneNode.val,cloneNode);
        for (Node neighbor : node.neighbors) {
            Node tempNode = doCloneGraph(neighbor, visited);
            cloneNode.neighbors.add(tempNode);
        }
        return cloneNode;
    }

    /**
     * BFS 广度优先搜索
     * @param node
     * @return
     */
    private Node cloneGraph2(Node node) {
        if (node==null)return null;
        //克隆的节点
        Map<Integer,Node> cloned = new HashMap<>();
        //保存访问过的节点，后续处理
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        //克隆第一个节点
        Node cloneNode = new Node(node.val, new ArrayList<>());
        cloned.put(node.val, cloneNode);
        while (!queue.isEmpty()){
            Node current = queue.poll();
            for (Node neighbor : current.neighbors) {
                //判断此节点释放已克隆
                if (cloned.containsKey(neighbor.val)){
                    //取出克隆的节点
                    Node tempNode = cloned.get(neighbor.val);
                    //将取出的节点放到当前节点的neighbors属性中
                    cloned.get(current.val).neighbors.add(tempNode);
                }else {
                    //第一次访问到这个节点
                    Node tempNode = new Node(neighbor.val, new ArrayList<>());
                    //保存已克隆的节点
                    cloned.put(neighbor.val, tempNode);
                    //将新克隆的节点放到当前节点的neighbors属性中
                    cloned.get(current.val).neighbors.add(tempNode);
                    queue.add(neighbor);
                }
            }
        }
        return cloneNode;
    }



    public static void main(String[] args) {
        Node node1 = new Node(1, new ArrayList<>());
        Node node2 = new Node(2, new ArrayList<>());
        Node node3 = new Node(3, new ArrayList<>());
        Node node4 = new Node(4, new ArrayList<>());
        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

//        CloneGraph cloneGraph = new CloneGraph();
//        Node node = cloneGraph.cloneGraph2(node1);
        System.out.println("node = " + node1);
    }
}