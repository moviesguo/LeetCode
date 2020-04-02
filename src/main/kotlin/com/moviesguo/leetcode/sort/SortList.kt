package com.moviesguo.algorithm.sort

import com.moviesguo.leetcode.linked_list.ListNode


/**
 *
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 *
 * 示例 1:
 *
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2:
 *
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 *
 */

//自顶向下归并排序
fun sortList(head: ListNode?): ListNode? {
    if (head?.next == null) return head
    var fast = head.next
    var slow = head
    //使用快慢指针找到中点
    while (fast?.next != null) {
        fast = fast.next?.next
        slow = slow?.next
    }
    var temp = slow?.next
    slow?.next = null
    //然后继续二分,最后会拆成一个一个的
    var left = sortList(head)
    var right = sortList(temp)

    //合并两个列表
    return merge(left, right)
}

/**
 * bottom-to-up 的归并思路是这样的：先两个两个的 merge，完成一趟后，再 4 个4个的 merge，直到结束。举个简单的例子：[4,3,1,7,8,9,2,11,5,6].
 *
 * step=2: (3->4)->(1->7)->(8->9)->(2->11)->(5->6)
 * step=4: (1->3->4->7)->(2->8->9->11)->(5->6)
 * step=8: (1->2->3->4->7->8->9->11)->5->6
 * step=16: (1->2->3->4->5->6->7->8->9->11)
 * 链表里操作最难掌握的应该就是各种断链啊，然后再挂接啊。在这里，我们主要用到链表操作的两个技术：
 *
 * merge(l1, l2)，双路归并，我相信这个操作大家已经非常熟练的，就不做介绍了。
 * cut(l, n)，可能有些同学没有听说过，它其实就是一种 split 操作，即断链操作。不过我感觉使用 cut 更准确一些，它表示，将链表 l 切掉前 n 个节点，并返回后半部分的链表头。
 * 额外再补充一个 dummyHead 大法，已经讲过无数次了，仔细体会吧。
 * 希望同学们能把双路归并和 cut 断链的代码烂记于心，以后看到类似的题目能够刷到手软。
 *
 * 掌握了这三大神器后，我们的 bottom-to-up 算法伪代码就十分清晰了：
 */
fun sortList2(head: ListNode?): ListNode? {

    val root = ListNode(0)
    root.next = head

    var length = 1
    var step = 1

    var temp = head
    //获取长度
    while (temp != null) {
        length++
        temp = temp.next
    }

    //按步进1,2,4,8进行合并
    while (step < length) {
        var cur = head
        var tail:ListNode? = root
        while (cur != null) {
            var left = cur
            //获取当前step下需要对比的右侧list
            var right = cut(cur,step)
            //再讲右侧与之后需要比较的list断开
            cur = cut(right,step)
            //接到结果上
            tail?.next = merge(left,right)
            //置为尾巴节点
            while (tail != null) {
                tail = tail.next
            }
        }
        //步进为 1,2,4,8 与二进制的左移操作相符
        step shl 1
    }

    return root.next
}

//向前移动n-1个节点,然后切断该节点,返回切断之后的头节点
// 切断前  node : 1->2->3->4  size 2
// 切断后  node : 1->2 next: 3->4
fun cut(node: ListNode?,size: Int):ListNode? {
    if (size<=0) return node
    var p = node
    var i = size
    while (p != null && --i > 0) {
        p = p.next
    }
    if (p==null) return null
    var next = p?.next
    p?.next = null
    return next

}

/**
 * 合并两个有序数组
 */
fun merge(left: ListNode?, right: ListNode?):ListNode? {

    var l:ListNode? = left
    var r:ListNode? = right
    var head = ListNode(0)
    var res = head
    while (l != null && r != null) {
        if (l.`val`!!<=r.`val`!!){
            res.next = l
            l = l.next
        } else{
            res.next = r
            r = r.next
        }
        res = res.next!!
    }
    if (l!=null) res.next = l
    if (r!=null) res.next = r
    return head.next
}