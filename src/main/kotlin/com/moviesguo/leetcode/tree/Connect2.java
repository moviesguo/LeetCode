package com.moviesguo.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *
 * 初始状态下，所有 next 指针都被设置为 NULL。
 *
 *  
 *
 * 进阶：
 *
 * 你只能使用常量级额外空间。
 * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 *
 */
public class Connect2 {

    public Node connect(Node root) {
        if (root == null) return root;
        Queue<Node> queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()) {
            //记录一下当前的节点个数，只遍历这么多，因为子节点会不断的加入到队列中
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                //不处理最后一个节点，再往后就都是子节点了
                if (i<size - 1) {
                    node.next = queue.peek();
                }
                //将子节点加入到队列中
                if (node.left!=null) queue.add(node.left);
                if (node.right!=null) queue.add(node.right);
            }
        }
        return root;
    }

    Node pre,left;

    public void processNode(Node node) {
        if (node == null) return;
        //第一次进入下一层递归的时候，把第一个进入的节点设置为left
        if (pre == null) {
            left = node;
        } else {
            //把其他的节点连起来
            pre.next = node;
        }
        //自身置为最新添加的节点
        pre = node;
    }

    /**
     * 不使用队列，在N层的时候，将N+1层的节点都连接起来，保存一下下一层的进入点，就可以了
     * @param root
     * @return
     */
    public Node foo(Node root) {
        left = root;
        Node cur;
        //left实际上相当于一个队列
        while (left != null) {
            //每次进入下一层的时候把pre置为null
            pre = null;
            //cur置为当前层的最左节点
            cur = left;
            //把left置为null用于下一层更新
            left = null;
            //遍历这一层的节点，然后去将下一层连接起来
            while (cur != null) {
                //将每个节点的左右孩子连起来,processNode处理了两个父节点的孩子相连的问题，pre一直是最新的上一个被连接的节点
                processNode(cur.left);
                processNode(cur.right);
                cur = cur.next;
            }
        }
        return root;
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    ", next=" + next +
                    '}';
        }
    }

}
