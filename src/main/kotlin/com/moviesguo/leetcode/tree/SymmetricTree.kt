package com.moviesguo.algorithm.tree


/**
 *给定一个二叉树，检查它是否是镜像对称的。
 *
 *例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *    1
 *   / \
 *  2   2
 * / \ / \
 *3 4 4  3
 *但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:

 *    1
 *   / \
 *  2   2
 *  \   \
 *  3   3
 * 说明:

 *如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
 */

fun main(args: Array<String>) {


//    var tree = TreeNode(1)
//    tree.left = TreeNode(2)
//    tree.right = TreeNode(2)
//    tree.left!!.left = TreeNode(3)
//    tree.left!!.right = TreeNode(4)
//    tree.right!!.left = TreeNode(4)
//    tree.right!!.right = TreeNode(3)


    val arg: List<Int> = listOfNotNull(1,2,2,3,4,4,3)

    val root = TreeNode(arg[0])
    buildTree(arg.toIntArray(), root, 0)
    foo(root)
    println(isSymmetric(root))
}

fun foo(node: TreeNode?){
    if (node == null) return
    println(node.`val`)
    foo(node.left)
    foo(node.right)
}


fun isSymmetric(root: TreeNode?): Boolean {
    return compare(root?.left, root?.right)
}

fun compare(left: TreeNode?, right: TreeNode?) :Boolean{
    if (left==null&&right==null) return true
    //如果左右子树有一个为空，则不对称
    if (left==null&&right!=null||(left!=null&&right==null)) return false
    if(left?.`val`!=right?.`val`) return false
    //比较左子树的右边和右子树的左边以及 左子树的左边和右子树的右边
    return compare(left?.left, right?.right) && compare(left?.right, right?.left)

}

fun buildTree(arg: IntArray, node: TreeNode?, index:Int) {


    if (node==null) return

    val leftIndex = 2 * index + 1

    val rightIndex = 2 * index + 2


    if (leftIndex > arg.size - 1) return
    if (rightIndex > arg.size - 1) return

    if (arg[leftIndex]!=0) {
        node.left = TreeNode(arg[leftIndex])
    }

    if (arg[rightIndex]!=0){
        node.right = TreeNode(arg[rightIndex])
    }
    buildTree(arg, node.left, leftIndex)
    buildTree(arg, node.right, rightIndex)

}

