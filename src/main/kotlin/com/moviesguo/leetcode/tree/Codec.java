package com.moviesguo.leetcode.tree;

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder builder = new StringBuilder();
        serialize(root.left);
        builder.append(root.val + ",");
        serialize(root.right);
        return builder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] values = data.split(",");
        if (values.length == 0) return null;
        TreeNode lastNode = null;
        for (String value : values) {
            int number = Integer.parseInt(value);
            TreeNode node = new TreeNode(number);

            if (lastNode == null) {
                lastNode = node;
                continue;
            }
            if (lastNode.val < number) {
                node.left = lastNode;
                lastNode = node;
            } else if (lastNode.val > number) {
                node.right = lastNode;
                lastNode = node;
            }
        }

        return null;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
