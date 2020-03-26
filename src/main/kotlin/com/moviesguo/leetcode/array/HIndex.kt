package array

import java.util.*

/**
 * 给定一位研究者论文被引用次数的数组（被引用次数是非负整数）。编写一个方法，计算出研究者的 h 指数。
 *
 * h 指数的定义: “h 代表“高引用次数”（high citations），一名科研人员的 h 指数是指他（她）的 （N 篇论文中）至多有 h 篇论文分别被引用了至少 h 次。
 * （其余的 N - h 篇论文每篇被引用次数不多于 h 次。）”
 *
 * 示例:
 *
 * 输入: citations = [3,0,6,1,5]
 * 输出: 3
 * 解释: 给定数组表示研究者总共有 5 篇论文，每篇论文相应的被引用了 3, 0, 6, 1, 5 次。
 * 由于研究者有 3 篇论文每篇至少被引用了 3 次，其余两篇论文每篇被引用不多于 3 次，所以她的 h 指数是 3。
 *
 * 说明: 如果 h 有多种可能的值，h 指数是其中最大的那个。
 */

/**
 * 首先我们将引用次数降序排序，在排完序的数组 citations 中，
 * 如果 citations[i]>i，那么说明第 0 到 i 篇论文都有至少 i+1
 * 次引用。因此我们只要找到最大的 i 满足 citations[i]>i，那么 h 指数即为 i+1。例如：
 */
fun hIndex(citations: IntArray): Int {

    Arrays.sort(citations)
    var i = 0
    while (i < citations.size && citations[citations.size - 1 - i] > i) {
        i++;
    }
    return i
}

/**
 * 从直方图中可以更明显地看出结论的正确性，将 y>ny>n 的区域去除，并不会影响到最大的正方形，也就不会影响到 hh 指数。
 *
 *  我们用一个例子来说明如何使用计数排序得到 hh 指数。首先，引用次数如下所示：
 */
fun hIndex2(citations: IntArray):Int{
    val n: Int = citations.size
    val papers = IntArray(n + 1)
    // 计数
    // 计数
    for (c in citations) papers[Math.min(n, c)]++
    // 找出最大的 k
    // 找出最大的 k
    var k = n
    var s = papers[n]
    while (k > s) {
        k--
        s += papers[k]
    }
    return k
}