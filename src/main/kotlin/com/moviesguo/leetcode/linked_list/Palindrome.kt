package com.moviesguo.algorithm.linked_list

import com.moviesguo.leetcode.linked_list.ListNode

/**
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 *
 */
fun main() {

}

/**
 * 反转链表再比较
 */
fun isPalindrome(head: ListNode?): Boolean {

    if (head?.next==null) return true

    var fast = head //快指针
    var slow = head //慢指针

    var p :ListNode? = null     //反转的前一段链表
    var pre:ListNode? = null

    while (fast?.next != null) {

        p = slow
        slow = slow!!.next
        fast = fast!!.next!!.next

        p!!.next = pre  //一边遍历一边反转链表
        pre = p
    }

    if (fast!=null) slow = slow!!.next  //如果是奇数就跳过一个

    while (p != null) {
        if (p.`val`!=slow!!.`val`)  //再对比两个链表
            return false
        p = p.next
        slow = slow.next
    }

    return true
}
