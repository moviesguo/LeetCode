package com.moviesguo.leetcode.linked_list

import java.util.*
import kotlin.collections.ArrayList

/**
 * 给出一个以头节点 head 作为第一个节点的链表。链表中的节点分别编号为：node_1, node_2, node_3, ... 。
 *
 * 每个节点都可能有下一个更大值（next larger value）：对于 node_i，如果其 next_larger(node_i) 是 node_j.val，
 * 那么就有 j > i 且  node_j.val > node_i.val，而 j 是可能的选项中最小的那个。如果不存在这样的 j，那么下一个更大值为 0 。
 *
 * 返回整数答案数组 answer，其中 answer[i] = next_larger(node_{i+1}) 。
 *
 * 注意：在下面的示例中，诸如 [2,1,5] 这样的输入（不是输出）是链表的序列化表示，其头节点的值为 2，第二个节点值为 1，第三个节点值为 5 。
 * 示例 1：
 *
 * 输入：[2,1,5]
 * 输出：[5,5,0]
 * 示例 2：
 *
 * 输入：[2,7,4,3,5]
 * 输出：[7,0,5,5,0]
 * 示例 3：
 *
 * 输入：[1,7,5,1,9,2,5,1]
 * 输出：[7,9,9,9,0,5,0,0]
 * 提示：
 *
 * 对于链表中的每个节点，1 <= node.val <= 10^9
 * 给定列表的长度在 [0, 10000] 范围内
 */

fun main() {
    val root = generateLinkedList(intArrayOf(9,7,6,7,6,9))
    println(nextLargerNodes(root).contentToString())
}

/**
 *
 * 栈中存储的是元素的 val 和下标，每次出栈依靠下标去修改 ans 中的值，val 则用作比较大小
 *
 * 以示例 22 为例：
 * [2,7,4,3,5]
 *
 * 过程                栈       ans
 * 2进栈              [2]      [0]
 * 7>2,2出栈,7进栈    [7]      [7,0]
 * 4,3进栈            [7,4,3]  [7,0,0,0]
 * 5>3 3出栈         [7,4]     [7,0,5,0]
 * 5>4 4出栈         [7]       [7,0,5,5]
 * 5进栈             [7,5]     [7,0,5,5,0]
 * head为null，结束循环
 */
fun nextLargerNodesWithStack(head:ListNode?):IntArray{
    if (head == null) return intArrayOf()
    var cur = head
    var count = 0
    val ans = ArrayList<Int>()
    val stack = Stack<Pair<Int, Int>>()
    while (cur != null) {
        //占个位置
        ans.add(0)
        //遇到了比自己还要大的就可以开始出栈到对应的位置
        while (stack.isNotEmpty() && cur.`val` > stack.peek().first) {
            val pair = stack.pop()
            ans[pair.second] = cur.`val`
        }
        stack.push(Pair(cur.`val`, count++))
        cur = cur.next
    }
    return ans.toIntArray()
}

fun nextLargerNodes(head: ListNode?): IntArray {
    if (head == null) return intArrayOf()
    val ans = ArrayList<Int>()
    var cur = head
    while (cur != null) {
        if (cur.next == null){
            ans.add(0)
            break
        }
        var temp = cur.next
        while (temp != null) {
            if (temp.`val` > cur.`val`) {
                ans.add(temp.`val`)
                break
            }
            temp = temp.next
        }
        if (temp == null){
            ans.add(0)
        }
        cur = cur.next
    }
    return ans.toIntArray()
}