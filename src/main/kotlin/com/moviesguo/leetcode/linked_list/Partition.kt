package com.moviesguo.leetcode.linked_list

import com.moviesguo.leetcode.linked_list.ListNode

/**
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 *
 * 你应当保留两个分区中每个节点的初始相对位置。
 *
 * 示例:
 *
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 *
 */

fun main() {
    val root = ListNode(1)
    val node1 = ListNode(4)
    val node2 = ListNode(3)
    val node3 = ListNode(2)
    val node4 = ListNode(5)
    val node5 = ListNode(2)

    root.next = node1
    node1.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node5
    val message = partition(root, 3)
    println(message)

}
fun partition(head: ListNode?, x: Int): ListNode? {
    if (head == null) return head
    var cur = head
    var low: ListNode? = ListNode(0)
    val lowHead = low
    var high: ListNode? = ListNode(0)
    val highHead = high
    while (cur != null) {
        //分大小加入到两个链表里面
        if (cur.`val` < x) {
            low?.next = cur
            low = low!!.next
        } else {
            high?.next = cur
            high = high!!.next
        }
        cur = cur.next
    }
    //避免和之前的链表连接在一起
    high?.next = null
    //连接到一起
    low?.next = highHead?.next
    return lowHead?.next
}