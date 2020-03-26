package com.moviesguo.leetcode.tree;

import java.util.Stack;

/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 * 示例 1:
 *
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 *
 * 示例 2:
 *
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5
 * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 * 说明:
 *
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉树中。
 */
public class LowestCommonAncestor {

    public static void main(String[] args) {

        JavaTreeNode root = new JavaTreeNode(3);
        JavaTreeNode node1 = new JavaTreeNode(5);
        JavaTreeNode node2 = new JavaTreeNode(1);
        JavaTreeNode node3 = new JavaTreeNode(6);
        JavaTreeNode node4 = new JavaTreeNode(2);
        JavaTreeNode node5 = new JavaTreeNode(0);
        JavaTreeNode node6 = new JavaTreeNode(8);
        JavaTreeNode node7 = new JavaTreeNode(7);
        JavaTreeNode node8 = new JavaTreeNode(4);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node4.left = node7;
        node4.right = node8;
        node2.left = node5;
        node2.right = node6;

        LowestCommonAncestor ancestor = new LowestCommonAncestor();
        JavaTreeNode parent = ancestor.lowestCommonAncestor(root, node1, node3);
        System.out.println("最终父节点" + parent.val);
    }

    JavaTreeNode answer;

    /**
     * 分别查找左右子树，如果找到p或者q返回true
     * mid为当前节点是否是p或者q，mid+right+left的值为2时，该节点就是父节点
     */
    public boolean helper(JavaTreeNode root, JavaTreeNode p, JavaTreeNode q) {
        if (root==null) return false;
        int left = helper(root.left, p, q) ? 1 : 0;
        int right = helper(root.right, p, q) ? 1 : 0;
        int mid = (root == p || root == q) ? 1 : 0;
        if (mid + right + left >= 2) {
            answer = root;
        }
        return (mid + left + right > 0);
    }

    /**
     * 左右子树分别查找，找到一个就直接返回，如果左右都不为空，那么当前的节点为父节点
     * 如果有一个为空，那么另一个返回的就是父节点了
     */
    public JavaTreeNode helper2(JavaTreeNode root, JavaTreeNode p, JavaTreeNode q) {
        if(root == null || root == p || root == q) return root;
        JavaTreeNode left = helper2(root.left, p, q);
        JavaTreeNode right = helper2(root.right, p, q);
        if (left!=null&&right!=null) return root;
        return left != null ? left : right;
    }

    /**
     * 暂定思路，使用后序遍历，找到p或者q的时候记录为父节点，返回root节点的时候记录为父节点，如果再找到另外一个的时候直接返记录的值
     * 这个方式是有问题的，还需要多一个栈的泛型应该换成一个包装类，加一个表示该节点的状态的，然后等到某个状态的时候他就是公共父节点了
     * @param root
     * @param p
     * @param q
     * @return
     */
    public JavaTreeNode lowestCommonAncestor(JavaTreeNode root, JavaTreeNode p, JavaTreeNode q) {

        JavaTreeNode parent = root;
        JavaTreeNode cur = root;
        JavaTreeNode last = root;
        boolean pConfirm = false;
        boolean qConfirm = false;

        Stack<JavaTreeNode> stack = new Stack<>();
        while (!stack.empty() || cur != null) {

            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.peek();

            if (p == cur){
                pConfirm = true;
                System.out.println("找到p节点" + p.val);
            }
            if (q == cur){
                qConfirm = true;
                System.out.println("找到q节点" + q.val);
            }

            System.out.println("当前节点" + cur.val);
            System.out.println("父节点" + parent.val);
            //后序遍历需要判断是否左右子树都已经遍历完成
            if (cur.right == null || cur.right == last) {
                if (pConfirm && qConfirm) return parent;
                stack.pop();
                last = cur;
                cur = null;
            }else {
                parent = cur;
                cur = cur.right;
            }
        }

        return parent;
    }
}

