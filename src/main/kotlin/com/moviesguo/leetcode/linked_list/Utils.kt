package linked_list

fun generateLinkedList(intArray: IntArray): ListNode {
    val head = ListNode(0)
    var cur = head
    for (i in intArray) {
        val node = ListNode(i)
        cur.next = node
        cur = node
    }
    return head.next!!
}