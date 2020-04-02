package com.moviesguo.leetcode.linked_list

import com.moviesguo.leetcode.linked_list.ListNode
import java.util.*

/**
 * 给定两个非空链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储单个数字。将这两数相加会返回一个新的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 *
 * 进阶:
 *
 * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 *
 * 示例:
 *
 * 输入: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出: 7 -> 8 -> 0 -> 7
 */
fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    if (l1 == null) return l2
    if (l2 == null) return l1

    val stack1 = Stack<ListNode>()
    val stack2 = Stack<ListNode>()

    var cur1 = l1
    var cur2 = l2
    //入栈反序加
    while (cur1 != null || cur2 != null) {
        if (cur1!=null){
            stack1.push(cur1)
            cur1 = cur1.next
        }

        if (cur2 != null) {
            stack2.push(cur2)
            cur2 = cur2.next
        }
    }
    var needIn = false
    var ans: ListNode? = null

    while (stack1.isNotEmpty() || stack2.isNotEmpty()) {
        //有一个完事的情况
        if (stack1.isEmpty()) {
            val node = stack2.pop()
            if (needIn) {
                val newNode = ListNode((node.`val` + 1) % 10)
                newNode.next = ans
                ans = newNode
                needIn = node.`val` + 1 == 10
            } else {
                val newNode = ListNode(node.`val`)
                newNode.next = ans
                ans = newNode
            }
            continue
        }
        if (stack2.isEmpty()) {
            val node = stack1.pop()
            if (needIn) {
                val newNode = ListNode((node.`val` + 1) % 10)
                newNode.next = ans
                ans = newNode
                needIn = node.`val` + 1 == 10
            } else {
                val newNode = ListNode(node.`val`)
                newNode.next = ans
                ans = newNode
            }
            continue
        }
        //都有的时候
        val node1 = stack1.pop()
        val node2 = stack2.pop()
        //不要忘了需要进位的时候+1
        val value = node1.`val` + node2.`val` + if(needIn) 1 else 0
        val newNode = ListNode(value % 10)
        newNode.next = ans
        ans = newNode
        needIn = value >= 10
    }
    //如果长度相同还需要进位再前面加一个1
    if (needIn) {
        val node = ListNode(1)
        node.next = ans
        ans = node
    }

    return ans
}