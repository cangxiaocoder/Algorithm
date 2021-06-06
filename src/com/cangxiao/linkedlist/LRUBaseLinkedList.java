package com.cangxiao.linkedlist;

import java.util.*;

/**
 * 缓存淘汰策略来决定。常见的策略有三种：
 * 先进先出策略 FIFO（First In，First Out）、
 * 最少使用策略 LFU（Least Frequently Used）、
 * 最近最少使用策略 LRU（Least Recently Used）。
 * @Author cangxiao
 * @Date 2021/5/29
 * @Desc 缓存淘汰策略 - 基于链表实现
 */
public class LRUBaseLinkedList<T> {

    /**
     * 默认链表容量
     */
    private final static Integer DEFAULT_CAPACITY = 10;

    /**
     * 头结点
     */
    private Node<T> headNode;

    /**
     * 链表长度
     */
    private Integer length;

    /**
     * 链表容量
     */
    private Integer capacity;

    public LRUBaseLinkedList() {
//        this.headNode = new Node<>();
        this.capacity = DEFAULT_CAPACITY;
        this.length = 0;
    }

    public LRUBaseLinkedList(Integer capacity) {
//        this.headNode = new Node<>();
        this.capacity = capacity;
        this.length = 0;
    }


    public boolean add(T value) {
        //1.第一次插入
        if(headNode==null){
            this.insertValueBegin(value);
            length++;
            return true;
        }
        if(headNode.getValue().equals(value)){
            return true;
        }
        //2. 空间未满，遍历链表，如果存在，将这个删除然后插入到头部,如果不存在直接插入到头部
        //查询是否有节点的值与当前值相同,如果有返回它的前一个节点，如果返回当前节点，则删除当前节点后，无法将它的前后节点相连
        Node preNode = this.findPreNode(value);
        //如果前一个节点不为null，说明有节点的值与当前值相等，则删除当前节点，将值插到头节点
        if (preNode!=null){
            deleteNode(preNode);
        }else {
            //3. 空间已满，需要删除尾部节点然后再头部插入
            if(length>=capacity){
                deleteEnd();
            }
        }
        insertValueBegin(value);
        length++;
        return true;


    }

    private void deleteEnd() {
        Node<T> ptr = headNode;
        if(ptr==null){
            return;
        }
        //当ptr的下一个节点的下一个节点为null时。ptr为倒数第二个节点
        while (ptr.getNext().getNext()!=null){
            ptr = ptr.getNext();
        }
        //获取倒数第二个节点的，然后将最后一个节点删除
        Node<T> temp = ptr.getNext();
        //将倒数第二个节点的下一个节点设为空
        ptr.setNext(null);
        temp = null;
        length--;
    }

    private void deleteNode(Node<T> preNode) {
        //拿到需要删除的节点
        Node temp = preNode.getNext();
        //将删除节点的后节点向前移
        preNode.setNext(temp.getNext());
        temp = null;
        length--;
    }

    /**
     * 插入天瀑布节点，原头节点后移
     *
     * @param value
     * @return
     */
    public boolean insertValueBegin(T value) {
        Node<T> next = headNode;
        this.headNode = new Node<>(value);
        headNode.setNext(next);
        return true;
    }

    /**
     * 查询是否有节点的值与当前值相同,如果有返回它的前一个节点，
     * 如果返回当前节点，则删除当前节点后，无法将它的前后节点相连
     * @param value
     * @return
     */
    public Node<T> findPreNode(T value) {
        Node<T> node = headNode;
        while (node.getNext() != null) {
            if (value.equals(node.getNext().getValue())) {
                return node;
            }
            node = node.getNext();
        }
        return null;
    }


    public class Node<T> {

        private T value;

        private Node<T> next;

        public Node() {
            this.next = null;
        }

        public Node(T value) {
            this.value = value;
//            this.next = null;
        }

        public Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
    private void printAll() {
        Node node = headNode;
        while (node != null) {
            System.out.print(node.getValue() + ",");
            node = node.getNext();
        }
        System.out.println();
    }
    public static void main(String[] args) {
        LRUBaseLinkedList<Integer> list = new LRUBaseLinkedList<>();
        Scanner sc = new Scanner(System.in);
        while (true) {
            list.add(sc.nextInt());
            list.printAll();
        }
    }
}
