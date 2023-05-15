package com.cangxiao.tree;

import java.util.Stack;

/**
 * 二叉查找树要求，在树中的任意一个节点，其左子树中的每个节点的值，都要小于这个节点的值，而右子树节点的值都大于这个节点的值
 *
 * @Author cangxiao
 * @Date 2021/8/1
 * @Desc 二叉查找树
 */
public class BinarySearchTree {

    private Node root;


    public BinarySearchTree() {
    }

    /**
     * 从根节点开始与被查账的数据比较
     * 如果要查找的值小于当前节点，则查找当前节点的左子树
     * 如果要查找的数据大于当前节点，则查找当前节点的右子树
     * 如果要查找大数据等于当前节点，则返回当前节点
     * 直到节点为null ，说明要查找的值不存在
     *
     * @param value
     * @return
     */
    public Node find(int value) {
        Node p = root;
        while (p != null) {
            if (value < p.data) {
                p = p.left;
            } else if (value > p.data) {
                p = p.right;
            } else {
                return p;
            }
        }
        return null;
    }

    /**
     * 1. 如果根节点为空，新数据直接插入到根节点
     * 2. 根节点不为空并且根节点的值大于要插入的数据吗，则递归左子树找到插入的位置
     * 3. 根节点不为空切根节点的值小于要插入的数据，则递归右子树找到要插入的位置
     *
     * @param value
     * @return
     */
    public boolean insert(int value) {
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
            return true;
        }
        Node p = root;
        while (true) {
            if (value < p.data) {
                if (p.left == null) {
                    p.left = newNode;
                    return true;
                }
                p = p.left;
            } else {
                if (p.right == null) {
                    p.right = newNode;
                    return true;
                }
                p = p.right;
            }
        }
    }

    /**
     * 1. 删除的节点如果没有子节点，则直接将要删除的节点设为null
     * 2. 删除的节点如果只有一个子节点，则只需要更新其父节点指向被删除节点的子节点即可；
     * 3。 删除的节点如果有两个子节点，则需要找到其右子树中最小的节点，将 这个节点替换到要删除的节点的位置，然后删除这个最小的节点；
     * 替换的节点是右子树中最小的节点，因为这个节点在右子树，所以这个节点一定大于删除节点的左子树所以的节点，也一定小于右子树所有的节点
     * 所以替换后的二叉树依然会满足二叉搜索树的条件；
     *
     * @param value
     * @return
     */
    public int delete(int value) {

        Node p = root; //p指向要删除的节点
        Node pParent = null; //指向被删除节点的父节点
        while (p != null && p.data != value) {
            pParent = p;
            if (value < p.data) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        if (p == null) return -1;
        //1. 当删除的节点有两个子节点时
        if (p.left != null && p.right != null) {
            //直到删除节点右子树中最小的节点， 即找到右子树或左子树中最接近删除的节点的值
            Node minP = p.right;
            Node minPParent = p;//记录删除节点minP的父节点
            while (minP.left != null) {
                minPParent = minP;
                minP = minP.left;
            }
            //将minP节点数据替换到要删除的p节点，则删除p节点变成了删除minP节点
            p.data = minP.data;
            p = minP;
            pParent = minPParent;
        }
        /*删除的节点有两个子节点 经过替换操作，删除的节点变成了minP,而minP没有子节点或只有一个右子树，
            将删除节点包含两个子节点的情况变成了只有一个子节点或没有子节点的状态
         */
        //2. 当删除的节点只有一个子节点或没有子节点时,如果有子节点，则这个子节点可能是右子树也可能是左子树
        Node child = p;
        if (p.left != null) child = p.left;
        else if (p.right != null) child = p.right;
        else child = null; //p节点的左右没有子节点
        /*
         * 如果删除节点的父节点为null，则删除节点为根节点
         * 如果删除节点为其父节点的左子树，则将删除节点的子子树设为其父节点的左子树
         * 如果删除节点为其父节点的右子树，则将删除节点的子节点设为其父节点的右子树；
         */
        if (pParent == null) {
            root = child;
        } else if (pParent.left == p) {
            pParent.left = child;
        } else {
            pParent.right = child;
        }
        return 1;
    }

    /**
     * 如果树中有多个值需要删除
     *
     * @param value
     * @return
     */
    public int delete2(int value) {
        int n = 0;
        while (true) {
            int i = delete(value);
            if (i == -1) {
                return n;
            }
            n += i;
        }
    }


    private static class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }
    }


    /**
     * 前序遍历
     */
    public void print1(Node node){
        if (node!=null){
            System.out.println(node.data);
            print1(node.left);
            print1(node.right);
        }
    }

    /**
     * 中序遍历
     * @param node
     */
    public void print2(Node node){
        if (node!=null){
            print2(node.left);
            System.out.println(node.data);
            print2(node.right);
        }
    }

    /**
     * 后序遍历
     * @param node
     */
    public void print3(Node node){
        if (node!=null){
            print3(node.left);
            print3(node.right);
            System.out.println(node.data);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        /*inarySearchTree.insert(10);
        binarySearchTree.insert(5);
        binarySearchTree.insert(15);
        binarySearchTree.insert(2);
        binarySearchTree.insert(8);
        binarySearchTree.insert(12);
        binarySearchTree.insert(20);
        binarySearchTree.print1(binarySearchTree.root);
        System.out.println("=========================");
        binarySearchTree.print2(binarySearchTree.root);
        System.out.println("=========================");
        binarySearchTree.print3(binarySearchTree.root);*/
//        int[] array = new int[]{1, 6, 3, 2, 5};
        int[] array = new int[]{3,6,5,9,8,11,16,15,13,12,10};
//        int[] array = new int[]{10,8,12,5,9,11,13,3,6,15,16};

        System.out.println("verifyPostorder = " + binarySearchTree.verifyPostorder1(array));
    }

    public boolean verifyPostorder(int[] postorder) {
        return verifyPostorder(postorder, 0, postorder.length-1);
    }

    private boolean verifyPostorder(int[] array, int left, int right){
        //当没有节点或只有一个节点是，递归结束
        if(left>=right){
            return true;
        }
        //后序遍历最后一个节点一定为根节点
        int root = array[right];
        //在数组中找到第一个比根节点大的值， 则这个值之后的节点(除了根节点)都是它的右子树，之前的节点都为它的左子树
        int mid = array[left];
        while (array[mid]<root){
            mid++;
        }
        int temp = mid;
        while (temp<right){
            //右子树都应该比根节点大，如果出现小于根节点的择不是后序遍历
            if(array[temp++]<root){
                return false;
            }
        }
        /*
            递归所有的子树
         */
        return verifyPostorder(array,left, mid-1) && verifyPostorder(array, mid, right-1);
    }
    /**
     * [10,12,13,11,8,9,5,6,3]
     * 参考：[递归和栈两种方式解决，最好的击败了100%的用户 - 二叉搜索树的后序遍历序列 - 力扣（LeetCode） (leetcode-cn.com)]
     * (<a href="https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/solution/di-gui-he-zhan-liang-chong-fang-shi-jie-jue-zui-ha/">...</a>)
     *5\2\3\6\1
     */
    private boolean verifyPostorder1(int[] postorder){
        Stack<Integer> stack = new Stack<>();
        int parent = Integer.MAX_VALUE;
        for (int i = postorder.length - 1; i >= 0; i--) {
            int current = postorder[i];
            while (!stack.isEmpty() && current<stack.peek()){
                //如果当前值小于栈顶的值，出现了降序，说明当前值的节点是栈中某个元素的左子节点；
                //最高一个出栈并且大于当前元素，则出栈的这个元素一定是所有大于当前值中最小的值；
                parent = stack.pop();
            }
            /*  如果current是左子节点，则parent一定是current的父节点，如果current是右子节点，则parent 是这个节点的祖先节点
                但是current仍然是parent左子树上的节点，所有current依然应该小于parent节点；
                处理第一个节点为根节点外，剩下的是右子树，左子树，第一次出现降序这个节点为之前节点的左子节点，
                第一次出现降序的时候，说明右子树的最大值已经压入栈中，出栈是从右子节点开始出栈，所以parent一定是剩下节点中的最大值；

             */
            System.out.println(parent);
            if(current>parent){
                return false;
            }
            //如果当前值大于栈中的元素，说明是升序，则将其压入栈中
            stack.push(current);
        }
        return true;
    }

}
