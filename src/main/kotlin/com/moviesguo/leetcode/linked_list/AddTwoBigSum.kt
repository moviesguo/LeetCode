package linked_list

/**
 * 大数相加
 * 十进制的两位数每一位都作为一个节点存在链表里，求两个链表相加
 */

fun main() {

    val root1 = Node(9)
    val root2 = Node(1)
    val node1 = Node(2)
    val node2 = Node(2)
    val node3 = Node(2)
    val node4 = Node(2)
    val node5 = Node(2)
    val node6 = Node(2)

    val node7 = Node(2)
    val node8 = Node(2)
    val node9 = Node(2)
    node1.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node5
    node5.next = node6

    node7.next = node8
    node8.next = node9

    root1.next = node1
    root2.next = node7

    println("${addTwoBigSum(root1, root2)}")

}


fun addTwoBigSum(list1:Node,list2:Node):Node? {
    var root1 = reversList(list1)
    var root2 = reversList(list2)
    //合并后的头指针
    val combine = Node(-1)
    //当前指针
    var cur:Node? = combine
    //是否需要进位
    var carry = 0
    while (root1 != null || root2 != null) {
        val value1 = root1?.value ?: 0
        val value2 = root2?.value ?: 0
        var value = value1 + value2 + carry
        carry = value / 10
        value %= 10
        cur!!.next = Node(value)
        cur = cur.next
        root1 = root1?.next
        root2 = root2?.next
    }
    if (carry == 1) cur!!.next = Node(1)
    return reversList(combine.next)
}

fun reversList(root: Node?):Node? {
    var pre:Node? = null
    var cur = root
    while (cur != null) {
        val temp = cur.next
        cur.next = pre
        if (temp == null) break
        pre = cur
        cur = temp
    }
    return cur
}

class Node(val value: Int){
    var next: Node? = null
    override fun toString(): String {
        if (next==null) return "$value"
        return "$value$next"
    }
}