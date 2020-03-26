package linked_list

/**
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 *
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 *
 */
fun main() {
    val root = ListNode(3)
    val node = ListNode(5)
    root.next = node
    val reverseBetween = reverseBetween(root, 1, 2)
}

var successor :ListNode? = null
//再看看这个https://leetcode-cn.com/problems/reverse-linked-list-ii/solution/bu-bu-chai-jie-ru-he-di-gui-di-fan-zhuan-lian-biao/
fun normalReverse(node:ListNode):ListNode?{
//    if (n == 1){
//        successor = node.next
//        return node
//    }
    if (node.next == null) return node
    val root = normalReverse(node.next!!)
    // 1->2 这个时候root返回时就是2, 1的next是2,然后将2的next指向1就反转了
    node.next!!.next = node
    node.next = successor
    return root
}

fun reverseBetween(head: ListNode?, m: Int, n: Int): ListNode? {
    if (head == null || m == n) return head
    var count = n - m
    var dummy :ListNode? = ListNode(0)
    dummy!!.next = head
    val dummyHead = dummy
    var index = 0
    //这个图说的很清楚 https://leetcode-cn.com/problems/reverse-linked-list-ii/solution/ji-bai-liao-100de-javayong-hu-by-reedfan-6/
    //将m-n这一段反转，然后 当前的next = 遍历后的last , 第一个要反转的node的next就是遍历后的dummy
    //还有递归方式，暂时没看懂
    while (dummy?.next != null) {
        if (index == m - 1) {
            val temp = dummy
            dummy = dummy.next
            val tail = dummy
            var last: ListNode? = null
            while (count != -1) {
                val next:ListNode? = dummy!!.next
                dummy.next = last
                last = dummy
                dummy = next
                count--
            }
            temp.next = last
            tail!!.next = dummy
            break
        }
        dummy = dummy.next
        index++
    }
    return dummyHead.next
}

