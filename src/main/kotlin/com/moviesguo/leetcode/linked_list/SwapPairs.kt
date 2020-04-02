package com.moviesguo.leetcode.linked_list

import com.moviesguo.leetcode.linked_list.ListNode

/**
 *
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例:
 *
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 */

fun main() {
    val root = ListNode(1)
    var cur = root
    for (i in 2..4) {
        cur.next = ListNode(i)
        cur = cur.next!!
    }
    println(swapPairs(root))
}

/**
 * 思路是交换两个节点 1->2->3->4 交换第一次之后是 2->1->3->4
 * 这个时候cur指针指向的是1，所以下一次遍历直接cur = cur.next就可以
 * 但是下一次交换的时候 2->1 4->3 3和4虽然交换了，但是1节点依旧指向3 所以需要last指针来保存上一个节点用于连接 1->4
 */
fun swapPairs(head: ListNode?): ListNode? {
    if (head?.next == null) return head
    val ans = head.next
    var cur: ListNode? = head
    //保留上一个节点，用于连接反转之后的节点
    var last: ListNode? = null
    while (cur?.next != null) {
        swipe(last, cur, cur.next!!)
        last = cur
        cur = cur.next
    }
    return ans
}


fun swipe(last: ListNode?, node1: ListNode, node2: ListNode) {
    val temp = node2.next
    node2.next = node1
    node1.next = temp
    last?.next = node2
}

//递归版本
fun swapPairsHelper(root: ListNode?): ListNode?{
    if (root?.next == null) return root

    var first = root;
    var second = root.next!!;
    //第一个节点会被交换到第二个位置，他的下一个节点是下面节点交换完成之后的
    first.next = swapPairsHelper(second.next)
    //第二个节点被换到了第一个节点
    second.next = first
    //返回的应该是交换完成后的头节点
    return second
}

