package com.moviesguo.leetcode.tree;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
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
 *           1
 *         /  \
 *        2    3
 *       / \  / \
 *      4  5 6  7
 */
public class Connect {

    public static void main(String[] args) {
        Node root = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        Node node4 = new Node(5);
        Node node5 = new Node(6);
        Node node6 = new Node(7);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        Connect connect = new Connect();
        System.out.println(connect.connect(root));
    }

    /**
     * 拉链法， 分别去练左右的，然后再去练 左的右和右的左
     * 之后再去分别递归左右节点
     *
     * 总结下来就是把树分成两半，然后不断地递归去连中间的 牛逼
     * @param root
     * @return
     */
    public Node foo(Node root){
        if(root == null) return root;
        Node left = root.left;
        Node right = root.right;
        while (left != null) {
            left.next = right;
            left = left.right;
            right = right.left;
        }
        foo(root.left);
        foo(root.right);
        return root;
    }

    public Node connect(Node root) {
        if (root == null) return null;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty() ) {
            ArrayList<Node> list = new ArrayList();
            while (!queue.isEmpty()) {
                list.add(queue.poll());
            }
            for (int i = 0; i < list.size(); i++) {
                Node node = list.get(i);
                if (i == list.size() - 1) {
                    node.next = null;
                } else {
                    node.next = list.get(i + 1);
                }
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
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
