package com.moviesguo.leetcode.linked_list

import com.moviesguo.leetcode.linked_list.ListNode

/**
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 *
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 * 示例 2:
 *
 * 输入: 2->1->3->5->6->4->7->NULL
 * 输出: 2->3->6->7->1->5->4->NULL
 * 说明:
 *
 * 应当保持奇数节点和偶数节点的相对顺序。
 * 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。
 *
 */

fun main() {
    val root = ListNode(1)
    val node1 = ListNode(2)
    val node2 = ListNode(3)
    val node3 = ListNode(4)
    val node4 = ListNode(5)
    val node5 = ListNode(4)
    val node6 = ListNode(7)
    root.next = node1
    node1.next = node2
    node2.next = node3
    node3.next = node4
//    node4.next = node5
//    node5.next = node6
    val oddEvenList = oddEvenList(root)
    println(oddEvenList)

}

fun oddEvenList(head: ListNode?): ListNode? {
    if (head == null) return null
    var oddNode: ListNode = head
    var cur = head
    var isOdd = true
    while (cur?.next != null) {
        if (isOdd){
            isOdd = !isOdd
            cur = cur.next
            continue
        }
        val temp = oddNode.next
        oddNode.next = cur.next
        oddNode = oddNode.next!!
        cur.next = oddNode.next
        oddNode.next = temp
//        val temp2 = cur.next?.next
//        cur.next!!.next = temp
//        cur.next = temp2
        isOdd = !isOdd
    }
    return head
}