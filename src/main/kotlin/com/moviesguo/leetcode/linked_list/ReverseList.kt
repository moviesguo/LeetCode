package com.moviesguo.algorithm.linked_list

import com.moviesguo.leetcode.linked_list.ListNode

/**
 *
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 *
 */

fun main() {

    var node1 = ListNode(1)
    var node2 = ListNode(2)
    var node3 = ListNode(3)
    var node4 = ListNode(4)
    var node5 = ListNode(5)
    node1.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node5
    var result:ListNode? = null

    foo(node1)
    var reverseList = ans
    while (reverseList != null) {
        println(reverseList.`val`)
        reverseList = reverseList.next
    }
}

fun reverseList(head: ListNode?): ListNode? {
    var pre:ListNode? = null
    var current = head
    while (current != null) {
        var temp = current.next
        current.next = pre
        pre = current
        current = temp
    }
    return pre
}

fun reverseList2(head: ListNode?,result:ListNode?): ListNode? {
    if (head==null) return result
    var temp = head.next
    var node = head
    head.next = result
    return reverseList2(temp, node)
}

var ans :ListNode? = null
fun foo(head: ListNode): ListNode {
    if(head.next == null){
        ans = head
        return head
    }
    val node = foo(head.next!!)
    node.next = head
    head.next = null
    return head
}