package com.moviesguo.leetcode.tree;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>(1000);
        if (root == null) return ans;
        Queue<Node> queue = new LinkedList();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> sub = new ArrayList();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (node.children != null) {
                    queue.addAll(node.children);
                }
                sub.add(node.val);
            }
            ans.add(sub);
        }
        return ans;
    }

    private List<List<Integer>> ans = new ArrayList();

    //递归版本的层序遍历
    public void traverseNode(Node node, int level) {
        if (node==null) return;
        if (ans.size() <= level) {
            ans.add(new ArrayList<>());
        }
        ans.get(level).add(node.val);
        if (node.children == null) return;
        node.children.forEach(sub->{
            traverseNode(sub, level + 1);
        });
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
