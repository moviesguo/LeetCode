package com.moviesguo.leetcode.linked_list

/**
 * 给你一个链表的头节点 head，请你编写代码，反复删去链表中由 总和 值为 0 的连续节点组成的序列，直到不存在这样的序列为止。
 *
 * 删除完毕后，请你返回最终结果链表的头节点。
 * 你可以返回任何满足题目要求的答案。
 *
 * （注意，下面示例中的所有序列，都是对 ListNode 对象序列化的表示。）
 *
 * 示例 1：
 *
 * 输入：head = [1,2,-3,3,1]
 * 输出：[3,1]
 * 提示：答案 [1,2,1] 也是正确的。
 * 示例 2：
 *
 * 输入：head = [1,2,3,-3,4]
 * 输出：[1,2,4]
 * 示例 3：
 *
 * 输入：head = [1,2,3,-3,-2]
 * 输出：[1]
 *
 * 提示：
 *
 * 给你的链表中可能有 1 到 1000 个节点。
 * 对于链表中的每个节点，节点的值：-1000 <= node.val <= 1000.
 *
 */

fun main() {
    val list = generateLinkedList(intArrayOf(1,2,3,-3,-2))
    val sub = removeZeroSumSublists(list)
    println(sub.toString())
}

/**
 * 两次计算，第一次计算sum并且把所对应的listNode记下，如果遇见重复的覆盖，说明第一次遇见和为sum到第二次遇见和为sum的这一段是为0的
 * 所以再第二次计算的时候，直接将cur.next指向map[sum].next的值。如果只有一个sum的话，那么在map中的值应该就是自己，如果有多个sum相同的值
 * 那么cur.next会指向最后一个sum记录的node的next
 */
fun removeZeroSumSublists(head: ListNode?): ListNode? {
    val preHead = ListNode(0)
    val map = HashMap<Int, ListNode>()
    preHead.next = head
    var cur: ListNode? = preHead
    var sum = 0
    //map的key是当前节点的和
    //如果有多个相同的key,就会被覆盖
    while (cur != null) {
        sum += cur.`val`
        map[sum] = cur
        cur = cur.next
    }
    cur = preHead
    sum = 0
    //同样计算到当前节点为止的sum,将cur.next指向在map中记录的对应着sum的节点
    //如果存在了相同sum值的节点,那么cur.next会指向最后一次出现sum的节点的next
    //也就是删除了中间的那些为0的节点
    while (cur != null) {
        sum += cur.`val`
        cur.next = map[sum]?.next
        cur = cur.next
    }
    return preHead.next

}