package com.moviesguo.leetcode.linked_list

import com.moviesguo.leetcode.linked_list.ListNode

/**
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例 1:
 *
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * 示例 2:
 *
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 *
 */

fun main() {
    val root = ListNode(1)
    val node1 = ListNode(2)
    val node2 = ListNode(3)
    val node3 = ListNode(4)
    val node4 = ListNode(5)
    val node5 = ListNode(6)

    root.next = node1
    node1.next = node2
    node2.next = node3
    node3.next = node4
//    node4.next = node5

    reorderListRecursive(root)

}

fun recorderListHelper(head: ListNode, len: Int): ListNode {
    if (len == 1) return head
    if (len == 2) return head.next!!

    val tail = recorderListHelper(head.next!!, len - 2)
    val temp = tail.next
    tail.next = tail.next?.next
    temp?.next = head.next
    head.next = temp
    return tail
}

fun reorderListRecursive(head: ListNode?){
    if (head?.next == null) return
    var count = 0
    var cur = head

    while (cur != null) {
        cur = cur.next
        count++
    }
    recorderListHelper(head, count)

}


fun reorderList(head: ListNode?): Unit {
    if (head == null) return
    //变成数组便于访问
    val nodes = ArrayList<ListNode>()
    var cur = head
    while (cur != null) {
        nodes.add(cur)
        cur = cur.next
    }

    var left = 0
    var right = nodes.size - 1
    //双指针
    while (left < right) {
        val temp = nodes[left].next
        nodes[left].next = nodes[right]
        nodes[right].next = temp
        left++
        right--
    }
    nodes[left].next = null

}