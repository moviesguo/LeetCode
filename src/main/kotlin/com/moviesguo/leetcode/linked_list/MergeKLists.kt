package com.moviesguo.leetcode.linked_list

import java.util.*
import kotlin.Comparator

/**
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * 示例:
 *
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 *
 */

fun main() {

}

fun mergeKLists(lists: Array<ListNode?>): ListNode? {

    //优先级队列
    val queue = PriorityQueue<ListNode>(Comparator<ListNode> { o1, o2 ->
        when {
            o1.`val` == o2.`val` -> return@Comparator 1
            o1.`val` > o2.`val` -> return@Comparator 1
            else -> return@Comparator -1
        }
    })
    val dummy = ListNode(0)
    var cur = dummy

    //把所有的头节点加进去
    for (list in lists) {
        if (list == null) continue
        queue.offer(list)
    }

    while (queue.isNotEmpty()) {
        //每次都去拿第一个
        var node = queue.poll()
        cur.next = node
        cur = cur.next!!
        node = node.next ?: continue
        //然后再把第一个节点的下一个再加进去,这里还是有一次排序
        queue.offer(node)
    }
    return dummy.next
}