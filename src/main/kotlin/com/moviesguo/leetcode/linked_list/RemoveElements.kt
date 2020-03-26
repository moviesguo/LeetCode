package linked_list

/**
 * 删除链表中等于给定值 val 的所有节点。
 *
 * 示例:
 *
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 */
fun main() {
    val root = ListNode(1)
    val node1 = ListNode(2)
    val node2 = ListNode(6)
    val node3 = ListNode(3)
    val node4 = ListNode(4)
    val node5 = ListNode(5)
    val node6 = ListNode(6)

    root.next = node1
    node1.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node5
    node5.next = node6
    val removeElements = removeElements(node6,6)
    println(removeElements.toString())
}
fun removeElements(head: ListNode?, `val`: Int): ListNode? {
    if (head == null) return null
    val dummy = ListNode(0)
    dummy.next = head
    var cur: ListNode? = dummy

    while (cur?.next != null) {
        //如果cur下一个是target值，将cur.next指向下一个，不改变cur
        if (cur.next!!.`val` == `val`){
            cur.next = cur.next?.next
            continue
        }
        cur = cur.next
    }
    return dummy.next
}