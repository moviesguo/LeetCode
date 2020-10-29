package com.moviesguo.leetcode.tree;

import com.moviesguo.leetcode.java_bean.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 129. 求根到叶子节点数字之和
 * 给定一个二叉树，它的每个结点都存放一个0-9的数字，每条从根到叶子节点的路径都代表一个数字。
 *
 * 例如，从根到叶子节点路径 1->2->3 代表数字 123。
 *
 * 计算从根到叶子节点生成的所有数字之和。
 *
 * 说明:叶子节点是指没有子节点的节点。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 *     1
 *    / \
 *   2   3
 * 输出: 25
 * 解释:
 * 从根到叶子节点路径 1->2 代表数字 12.
 * 从根到叶子节点路径 1->3 代表数字 13.
 * 因此，数字总和 = 12 + 13 = 25.
 * 示例 2:
 *
 * 输入: [4,9,0,5,1]
 *     4
 *    / \
 *   9   0
 *  / \
 * 5   1
 * 输出: 1026
 * 解释:
 * 从根到叶子节点路径 4->9->5 代表数字 495.
 * 从根到叶子节点路径 4->9->1 代表数字 491.
 * 从根到叶子节点路径 4->0 代表数字 40.
 * 因此，数字总和 = 495 + 491 + 40 = 1026.
 *
 */
public class SumNumbers {

    public static void main(String[] args) {
        SumNumbers sumNumbers = new SumNumbers();
        System.out.println(sumNumbers.sumNumbers(null));
    }

    /**
     * dfs 优雅写法
     */
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    /**
     * 这里是一路到最终节点才会返回的，不用考虑加上了中间的值的情况
     * @param root
     * @param prevSum
     * @return
     */
    public int dfs(TreeNode root,int prevSum) {
        if (root == null) return 0;
        int sum = prevSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        } else {
            //这里只会是最后加完了之后的返回，就是每一条路径的最终节点的值相加
            return dfs(root.left, sum) + dfs(root.right, sum);
        }
    }

    /**
     * 深度优先搜索
     * 到了最终的节点在ans上加上sum的值
     * 最终节点的判断是左右节点都为空
     */
//    int ans = 0;
//
//    public int sumNumbers(TreeNode root) {
//        if(root == null) return 0;
//        sumNumbersRecursive(root,0);
//        return ans;
//    }
//
//    public void sumNumbersRecursive(TreeNode root,int sum){
//        if(root == null) return;
//        int currentSum = sum * 10 + root.val;
//        if(root.left == null && root.right == null){
//            ans += currentSum;
//            return;
//        }
//        sumNumbersRecursive(root.left,currentSum);
//        sumNumbersRecursive(root.right,currentSum);
//    }

    /**
     *  首先想到的：
     *  把所有的数字都记录下来，然后统一加一下
     */
//    public int sumNumbers(TreeNode root) {
//        List<String> nums = sumNumbersRecusive(root);
//        int ans = 0;
//        for(String num : nums){
//            ans += Integer.parseInt(num);
//        }
//        return ans;
//    }
//
//    public List<String> sumNumbersRecursive(TreeNode root){
//        List<String> res = new ArrayList<String>();
//        if(root == null){
//            return res;
//        }
//        List<String> leftNum = sumNumbersRecusive(root.left);
//        List<String> rightNum = sumNumbersRecusive(root.right);
//        if(leftNum.size() == 0 && rightNum.size() == 0){
//            res.add(String.valueOf(root.val));
//            return res;
//        }
//        String currentNum = String.valueOf(root.val);
//        for(String num : leftNum){
//            res.add(currentNum + num);
//        }
//        for(String num : rightNum){
//            res.add(currentNum + num);
//        }
//        return res;
//    }

}
