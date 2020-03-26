package linked_list

/**
 * 给定一个头结点为 root 的链表, 编写一个函数以将链表分隔为 k 个连续的部分。
 *
 * 每部分的长度应该尽可能的相等: 任意两部分的长度差距不能超过 1，也就是说可能有些部分为 null。
 *
 * 这k个部分应该按照在链表中出现的顺序进行输出，并且排在前面的部分的长度应该大于或等于后面的长度。
 *
 * 返回一个符合上述规则的链表的列表。
 *
 * 举例： 1->2->3->4, k = 5 // 5 结果 [ [1], [2], [3], [4], null ]
 *
 * 示例 1：
 *
 * 输入:
 * root = [1, 2, 3], k = 5
 * 输出: [[1],[2],[3],[],[]]
 * 解释:
 * 输入输出各部分都应该是链表，而不是数组。
 * 例如, 输入的结点 root 的 val= 1, root.next.val = 2, \root.next.next.val = 3, 且 root.next.next.next = null。
 * 第一个输出 output[0] 是 output[0].val = 1, output[0].next = null。
 * 最后一个元素 output[4] 为 null, 它代表了最后一个部分为空链表。
 * 示例 2：
 *
 * 输入:
 * root = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], k = 3
 * 输出: [[1, 2, 3, 4], [5, 6, 7], [8, 9, 10]]
 * 解释:
 * 输入被分成了几个连续的部分，并且每部分的长度相差不超过1.前面部分的长度大于等于后面部分的长度。
 *
 *
 * 提示:
 *
 * root 的长度范围： [0, 1000].
 * 输入的每个节点的大小范围：[0, 999].
 * k 的取值范围： [1, 50].
 */

fun main() {

    val root = generateLinkedList(intArrayOf(1, 2, 3, 4, 5, 6, 7,8))
    val splitListToParts = splitListToParts(root, 3)
    println(splitListToParts.contentToString())
}

fun splitListToParts(root: ListNode?, k: Int): Array<ListNode?> {

    if (root == null) return Array(k){ null }

    var fast = root
    var slow = root
    var mid = 0
    //快慢指针求长度
    while (fast?.next!= null) {
        slow = slow?.next
        fast = fast.next?.next
        mid++
    }

    val size = 2 * mid + if (fast == null) { 0 }else { 1 }
    //每一份最少的数量
    val subCount = size / k
    //还有多少个需要+1,如果k>=size那就是一个一个切不需要计算这个
    var lastCount = if (k >= size) 0 else size % k
    val ans = Array<ListNode?>(k) { null }
    var index = 0
    var cur :ListNode? = root
    while (cur != null) {
        val temp = cur
        repeat(subCount - 1) {
            cur = cur?.next
        }
        if (lastCount-- > 0) cur = cur?.next
        ans[index++] = temp
        if (index == k) return ans
        val next = cur?.next
        cur?.next = null
        cur = next
    }
    return ans
}