package com.moviesguo.leetcode.tree;

import com.moviesguo.leetcode.java_bean.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                //把根加进去
                res.add(node.val);
                //把根入栈
                stack.push(node);
                //再去找左边的,这时候下一个加进去的的就是左边
                node = node.left;
            }
            //然后出栈拿右边的就形成了 根左右的顺序了
            node = stack.pop();
            node = node.right;
        }
        return res;
    }


    //我的版本
//    public List<Integer> preorderTraversal(TreeNode root) {
//        if(root == null) return new ArrayList();
//        Stack<TreeNode> stack = new Stack();
//        stack.push(root);
//        List<Integer> res = new ArrayList();
//        while(!stack.isEmpty()){
//            while(!stack.isEmpty()){
//                TreeNode node = stack.pop();
//                res.add(node.val);
//                if(node.right!=null) stack.push(node.right);
//                if(node.left!=null) stack.push(node.left);
//            }
//        }
//        return res;
//    }
}
