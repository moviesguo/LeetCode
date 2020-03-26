package tree

import TreeNode

/**
 * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 *
 * 例如：
 *
 * 输入: 二叉搜索树:
 *      5
 *    /   \
 *  2     13
 *
 *  输出: 转换为累加树:
 *      18
 *    /   \
 *  20     13
 *
 */

fun main() {
    val root = TreeNode(1)
    val node1 = TreeNode(0)
    val node2 = TreeNode(4)
    val node4 = TreeNode(-2)
    val node5 = TreeNode(3)
    root.left = node1
    root.right = node2
    node1.left = node4
    node1.right = node5


    convertBST1(root)
    println(root)
}

/**
 * 官方解法
 * 其实和我的思路类，找到右边的值，如果是左子树还需要加上parent的值 （我这个思路还是太傻了一些，没有get到点）
 * 官方使用了反序中序遍历（右根左）的方式，把大的值加到了一个sum里面
 * 由于这是在二叉搜索树中，所以是按大->小排序的
 */
fun convert(root:TreeNode?){
    if (root != null) {
        convert(root.right)
        sum += root.`val`
        root.`val` = sum
        convert(root.left)
    }
}

fun convertBST(root: TreeNode?): TreeNode? {
    convertBSTHelper(root)
    return root
}

var sum = 0


fun convertBSTHelper(root: TreeNode?): Int {
    if (root == null) return 0
    root.`val` += convertBSTHelperLeft(root.right, 0)
    convertBSTHelperLeft(root.left, root.`val`)
    return root.`val`
}

fun convertBSTHelperLeft(root: TreeNode?, parentVal: Int): Int {
    if (root == null) return 0
    root.`val` += convertBSTHelperLeft(root.right, parentVal)
    var value = root.`val`
    root.`val` += parentVal
    value += convertBSTHelperLeft(root.left, root.`val`)
    return value
}

/* Get the node with the smallest value greater than this one. */
private fun getSuccessor(node: TreeNode): TreeNode {
    var succ = node.right;
    while (succ?.left != null && succ.left != node) {
        succ = succ.left;
    }
    return succ!!
}

 fun convertBST1(root: TreeNode?): TreeNode? {
    var sum = 0;
    var node = root;

    while (node != null) {
        /*
         * If there is no right subtree, then we can visit this node and
         * continue traversing left.
         */
        if (node.right == null) {
            sum += node.`val`
            node.`val` = sum
            node = node?.left
        }
        /*
         * If there is a right subtree, then there is at least one node that
         * has a greater value than the current one. therefore, we must
         * traverse that subtree first.
         */
        else {
            val succ = getSuccessor (node);
            /*
             * If the left subtree is null, then we have never been here before.
             */
            if (succ.left == null) {
                succ.left = node;
                node = node.right;
            }
            /*
             * If there is a left subtree, it is a link that we created on a
             * previous pass, so we should unlink it and visit this node.
             */
            else {
                succ.left = null
                sum += node.`val`
                node.`val` = sum
                node = node.left
            }
        }
    }
    return root
}

