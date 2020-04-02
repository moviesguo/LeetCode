package com.moviesguo.leetcode.linked_list

import com.moviesguo.leetcode.linked_list.ListNode

/**
 * 1290. 二进制链表转整数
 * 给你一个单链表的引用结点 head。链表中每个结点的值不是 0 就是 1。已知此链表是一个整数数字的二进制表示形式。
 *
 * 请你返回该链表所表示数字的 十进制值 。
 * 输入：head = [1,0,1]
 * 输出：5
 * 解释：二进制数 (101) 转化为十进制数 (5)
 * 示例 2：
 *
 * 输入：head = [0]
 * 输出：0
 * 示例 3：
 *
 * 输入：head = [1]
 * 输出：1
 * 示例 4：
 *
 * 输入：head = [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]
 * 输出：18880
 * 示例 5：
 *
 * 输入：head = [0,0]
 * 输出：0
 * 提示：
 *
 * 链表不为空。
 * 链表的结点总数不超过 30。
 * 每个结点的值不是 0 就是 1。
 *
 */

fun main() {
    val root = ListNode(1)
    val node1 = ListNode(0)
    val node2 = ListNode(1)
    root.next = node1
    node1.next = node2
    getDecimalValue(root)

}

fun getDecimalValue(head: ListNode?): Int {
    if (head == null) return 0
    var cur = head
    var length = 0
    while (cur != null) {
        cur = cur.next
        length++
    }
    cur = head
    var ans = 0
    for (i in length - 1 downTo 0) {
        ans += (Math.pow(2.0, i.toDouble()).toInt() * cur!!.`val`)
        cur = cur.next
    }

    return ans
}