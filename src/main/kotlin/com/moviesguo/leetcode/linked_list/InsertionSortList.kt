package linked_list

/**
 * 147. 对链表进行插入排序
 * 插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
 * 每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。
 *
 * 插入排序算法：
 * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。
 *  
 *
 * 示例 1：
 *
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2：
 *
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 */
fun main() {
    val root = ListNode(3)
    val node1 = ListNode(2)
    val node2 = ListNode(4)
    val node3 = ListNode(3)
    val node4 = ListNode(0)
    val node5 = ListNode(6)

    root.next = node1
    node1.next = node2
//    node2.next = node3
//    node3.next = node4
//    node4.next = node5

    val insertionSortList = insertionSortList2(root)
    println(insertionSortList.toString())

}

/**
 * 这个思路比较乱,不像下面那个那么清晰，原理是一样的，只不过没有把cur.next.next和cur连接起来
 * 导致了两个问题，
 * 一个是循环链表,cur和cur.next相邻的时候,如果不修改cur.next,那么cur.next会指向cur,
 * cur还是会指向cur.next就循环上了,这里做了一个判断解决这个问题
 * 另一个就是在最后的时候cur可能是最大的,这个时候的cur由于之前没有连接,所以它是一个单独的节点
 * 还需要最后的时候把它连接起来
 * 这里没有连接的原因是并没有通过比较cur和cur.next而是直接遍历了整个链表,依赖排序后或者遍历到了自己进行移动,
 * 可靠性非常的低,很容易出现死循环,不要参考这个
 */
fun insertionSortList(head: ListNode?): ListNode? {
    if (head?.next == null) return head

    var dummy:ListNode? = ListNode(0)
    dummy?.next = head
    var cur = head.next
    while (cur != null) {
        var temp = dummy
        while (temp?.next != null) {
            //防止重复的数字
            if (temp == cur) {
                cur = cur.next
                break
            } else if (temp.next!!.`val` >= cur!!.`val`) {
                 val next = temp.next
                 val curNext = cur.next
                 temp.next = cur
                 cur.next = next
                 if (cur == next?.next) next.next = null
                 cur = curNext
                 break
             } else {
                temp = temp.next
            }
        }
        //防止最后一个被断开
        if (temp != null && cur != null && temp.next == null) {
            if (temp.`val` < cur.`val`) {
                temp.next = cur
            }
        }
    }
    return dummy?.next
}

/**
 * 这个思路和RemoveElement比较相似
 * 比较cur和cur.next,看一下cur.next是否比cur小
 * 如果小，从head遍历找到合适的位置，然后将cur.next插入到合适的位置
 * 不要忘了改变cur.next.next的时候将cur.next指向cur.next.next,不然后续的节点就会丢失了
 * 然后不许要往前移动cur节点，因为cur.next已经变成了下一个，这一点和removeElement比较相似
 * 如果不需要移动,直接移动cur节点到下一个就好
 */
fun insertionSortList2(head: ListNode?): ListNode? {
    val dummy: ListNode? = ListNode(0)
    dummy?.next = head
    var cur = head
    while (cur != null) {
        val next = cur.next
        //去找下一个比当前小的数，如果比当前值大就没必要排序
        if (null != next && next.`val` < cur.`val`) {
            var temp = dummy
            //从头开始找，找到比一个他的下一个数比next要大的数
            while (temp?.next != null && temp.next!!.`val` < next.`val`) {
                temp = temp.next
            }
            //把找到的数的下一个记录下来
            val node = temp?.next
            //把找到的数的next指向next
            temp?.next = next
            //把cur指向next的下一个，等于将链表再连起来
            cur.next = next.next
            //将next的next指向找到的那个数的下一个，也就是比自己大的数
            next.next = node
        } else {
            cur = next
        }
    }
    return dummy?.next
}