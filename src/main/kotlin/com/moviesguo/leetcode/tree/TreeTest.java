package com.moviesguo.leetcode.tree;

public class TreeTest {

    public static void main(String[] args) {
        JavaTreeNode node = new JavaTreeNode(10);
        TreeTest test = new TreeTest();
        test.foo(node);
        System.out.println(node.val);
        System.out.println("node" + node.toString());
    }

    public void foo(JavaTreeNode treeNode) {
        treeNode.val = 1000;
        System.out.println("treeNode" + treeNode.toString());
        treeNode = null;
        System.out.println("treeNode" + treeNode);
    }

}
