package com.moviesguo.leetcode.linked_list

import com.moviesguo.leetcode.linked_list.ListNode

/**
 *
 * 82. 删除排序链表中的重复元素 II
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 示例 2:
 *
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 *
 */

fun main() {
    val head = ListNode(1)
    val node1 = ListNode(2)
    val node2 = ListNode(2)
    val node3 = ListNode(1)
    val node4 = ListNode(1)
    val node5 = ListNode(2)
    val node6 = ListNode(5)
    head.next = node1
    node1.next = node2
//    node2.next = node3
    node3.next = node4
    node4.next = node5
    node5.next = node6
    val message = deleteDuplicates2(head)
    println(message)
}

fun deleteDuplicates2(head: ListNode?): ListNode? {
    if (head == null) return head
    if (head.next == null) return head
    var cur = head
    var duplicateNum:Int? = null
    var lastNode = head
    //这里可以创建一个dummy = ListNode(0)然后将它的next指向head，可以省略每次判断realHead==null
    //然后遍历的时候从dummy开始
    var realHead : ListNode? = null

    while (cur?.next != null) {
        //如果当前节点和当前节点的下一个节点值相同或者和上一次出现的数字重复，那么将这个节点删除
        if (cur.`val` == cur.next!!.`val` || duplicateNum == cur.`val`) {
            lastNode?.next = lastNode?.next?.next
            duplicateNum = cur.`val`
            cur = lastNode?.next
        } else {
            //如果第一次遇到不重复的当作头节点
            if (realHead == null) realHead = cur
            //记录一下不重复的
            lastNode = cur
            duplicateNum = cur.`val`
            cur = cur.next
        }
    }

    //如果realHead为null，那么当前还没有遇到不重复的，判断一下最后一个
    if (realHead == null && duplicateNum != cur?.`val`) return cur
    //处理一下最后一个节点没有处理的情况
    if (cur?.`val` == duplicateNum){
        lastNode?.next = lastNode?.next?.next
    }
    return realHead
}

/**
 * 说下大概思路：
 * 与链表的其他题目类似，为了防止删除头结点的极端情况发生，先创建空结点dummy，使dummy指向传入的head结点。
 * 然后创建cur的指针，指向链表的头部（即dummy）。
 * 接着对cur指针迭代，因为要对比cur(cur最初始的定义指向空结点)指针的下一个结点与下下一个结点的值是否相等，为了防止产生空指针异常，故退出迭代的条件为：cur.next != null && cur.next.next != null。
 * 在迭代过程中，如果cur.next.val == cur.next.next.val说明此时有重复元素，此时创建一个临时指针temp，指向cur的下一个节点，即temp指向的第一个重复元素所在的位置。通过while循环去重，去重后，temp指向的是重复元素中的最后一个位置。最后cur.next = temp.next就实现了消除重复元素。
 * 当然，如果为发现重复元素，则直接向后迭代即可。
 * 迭代完成后，返回dummy的next。
 *
 */
fun  deleteDuplicates(head: ListNode): ListNode? {
    val dummy = ListNode(0);
    dummy.next = head
    var cur: ListNode? = dummy
    while (cur?.next != null && cur.next!!.next != null) {
        if (cur.next!!.`val` == cur.next!!.next!!.`val`) {
            var temp = cur.next;
            while (temp?.next != null && temp.`val` == temp.next!!.`val`) {
                temp = temp.next;
            }
            cur.next = temp?.next;
        }
        else
        cur = cur.next
    }
    return dummy.next
}