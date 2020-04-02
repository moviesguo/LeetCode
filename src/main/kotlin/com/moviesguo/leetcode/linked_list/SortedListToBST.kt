package com.moviesguo.leetcode.linked_list

import com.moviesguo.algorithm.tree.TreeNode
import com.moviesguo.leetcode.linked_list.ListNode


/**
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *
 * 给定的有序链表： [-10, -3, 0, 5, 9],
 *
 * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *   -3   9
 *   /   /
 * -10  5
 *
 */
fun sortedListToBST(head: ListNode?): TreeNode? {
    if (head == null) return null
    //利用快慢指针找到中点
    val midNode = finMidNode(head)
    //初始化当前节点
    val treeNode = TreeNode(midNode.`val`)
    //如果只有head了就返回
    if (head.`val` == midNode.`val`) return treeNode
    //左边就是head
    treeNode.left = sortedListToBST(head)
    //右边就是midNode.next,因为链表会在head->midNode之间断开
    treeNode.right = sortedListToBST(midNode.next)
    return treeNode
}
//利用快慢指针寻找中点
fun finMidNode(head: ListNode): ListNode {
    //用于记录中间节点，然后将链表断开，防止下面的递归再去递归什么的
    var prePtr: ListNode? = null
    var slowPtr = head
    var fastPtr: ListNode? = head

    while (fastPtr?.next != null) {
        prePtr = slowPtr
        slowPtr = slowPtr.next!!
        fastPtr = fastPtr.next?.next
    }

    if (prePtr != null){
        prePtr.next = null
    }
    return slowPtr
}