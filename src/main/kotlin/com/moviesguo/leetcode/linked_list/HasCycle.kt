package com.moviesguo.algorithm.linked_list

/**
 * 给定一个链表，判断链表中是否有环。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 * 示例 1：
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 * 示例 2：
 *
 * 输入：head = [1,2], pos = 0
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 *
 * 示例 3：
 *
 * 输入：head = [1], pos = -1
 * 输出：false
 * 解释：链表中没有环。
 *
 */

/**
 * 快慢指针
 *
 * fast指针每次移动两步,slow指针每次移动一步,如果链表是一个环形链表,那么fast和slow总会相遇
 *
 */
fun hasCycle(head: ListNode): Boolean {

    var slow:ListNode? = head
    var fast:ListNode? = head

    while (fast?.next != null) {
        fast = fast.next?.next
        slow = slow?.next
        if (fast==slow) return true
    }
    return false
}

class ListNode {
    var `val`:Int? = null
    var next:ListNode? = null
    constructor(x :Int){
        `val` = x
        next = null
    }
}