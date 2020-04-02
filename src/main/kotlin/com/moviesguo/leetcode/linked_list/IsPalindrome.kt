package com.moviesguo.leetcode.linked_list

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
    val root = ListNode(1)
    val node1 = ListNode(2)
    val node2 = ListNode(3)
    val node3 = ListNode(1)
//    root.next = node1
//    node1.next = node2
    node2.next = node3
    println(isPalindrome(root))
}

/**
 * 递归版本
 */
var fontPoint: ListNode? = null //
fun isPalindromeRecursive(head: ListNode?){
    fontPoint = head
}

/**
 * 直接递归到最后，fontPoint从头
 * 然后在递归栈回退的时候就是从后向前比较了 真好玩
 */
fun recursivelyisPalindrome(currentNode: ListNode?):Boolean {
    currentNode?.apply {
        if (!recursivelyisPalindrome(currentNode.next)) return false
        if (this.`val` != fontPoint?.`val`) return false
        fontPoint = fontPoint?.next
    }
    return true
}

/**
 * 快慢指针去找到中间的节点，在找的同时反转前面的链表
 * 找到之后需要区分奇数和偶数的区别，奇数的需要slow多往前走一次
 * 之后将fast指针指向之前反转的头节点，然后一一比较，如果有不相同的就返回false
 */
fun isPalindrome(head: ListNode?): Boolean {
    if (head == null) return true
    var fast = head
    var slow = head
    var pre: ListNode? = null

    var findMid = false

    while (slow != null) {
        if (findMid){
            if (fast?.`val` != slow.`val`) return false
            fast = fast.next
            slow = slow.next
            continue
        }
        fast = fast?.next?.next
        val temp = slow.next
        slow.next = pre
        pre = slow
        slow = temp
        //奇数情况
        if (fast != null && fast.next == null) {
            fast = pre
            slow = slow?.next
            findMid = true
            continue
        }
        //偶数情况
        if (fast == null) {
            fast = pre
            findMid = true
            continue
        }


    }
    return true
}