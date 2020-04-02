package com.moviesguo.leetcode.linked_list

import com.moviesguo.leetcode.linked_list.ListNode

/**
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->4->5, k = 2
 * 输出: 4->5->1->2->3
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4
 * 向右旋转 2 步: 4->5->1->2->3
 * 示例 2:
 *
 * 输入: 0->1->2, k = 4
 * 输出: 2->0->1
 * 解释:
 * 向右旋转 1 步: 2->0->1
 * 向右旋转 2 步: 1->2->0
 * 向右旋转 3 步: 0->1->2
 * 向右旋转 4 步: 2->0->1
 *
 */
fun main() {
    val root = ListNode(1)
    val node1 = ListNode(2)
    val node2 = ListNode(3)
    val node3 = ListNode(4)
    val node4 = ListNode(5)

    root.next = node1
//    node1.next = node2
    node2.next = node3
    node3.next = node4
    println(rotateRight(root, 2))
}

/**
 * 找到最尾节点，直接变成循环链表
 * 然后通过计算 size - 1 - (k&size) 得到需要移动的次数，在把链断开，当前指针的下一个节点就是头节点
 */
fun rotateRight(head: ListNode?, k: Int): ListNode? {
    if (head?.next == null) return head
    var cur = head
    var index = 0
    while (cur != null) {
        index++
        if (cur.next == null) {
            if (index == k) return head
            cur.next = head
            cur = cur.next
            break
        }
        cur = cur.next
    }
    val count = index - k % index
    repeat(count - 1) {
        cur = cur?.next
    }
    val temp = cur!!.next
    cur!!.next = null
    return temp
}