package com.moviesguo.algorithm.array

import java.util.*

/*
 *
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 * 示例 1:
 *
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 *
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 */

fun main() {

    var a = intArrayOf(4,5)
    var b = intArrayOf(2,4)
    var c = intArrayOf(4,6)
    var d = intArrayOf(3,4)
    var e = intArrayOf(0,0)
    var f = intArrayOf(1,1)
    var g = intArrayOf(3,5)
    var h = intArrayOf(2,2)

    var intervals = arrayOf(a, b, c, d,e,f,g,h)
    var merge = merge(intervals)
    println("--------------")
    merge.forEach {
        println(it.contentToString())
    }
}

fun merge(intervals: Array<IntArray>): Array<IntArray> {
    sort(intervals, 0, intervals.size - 1)
    var result = LinkedList<IntArray>()

    intervals.forEach {
        println(it.contentToString())
    }

    intervals.forEach {
        foo(result, it)
    }
    //先排序吧
    return result.toTypedArray()
}

fun foo(result: MutableList<IntArray>, a: IntArray) {
    if (result.isEmpty()) {
        result.add(a)
        return
    }
    if (result[result.lastIndex][1] >= a[0]) {
        var element = intArrayOf(result[result.lastIndex][0], Math.max(a[1], result[result.lastIndex][1]))
        result.removeAt(result.lastIndex)
        result.add(element)
    } else  {
        result.add(a)
    }

}

// 快速排序
fun sort(intervals: Array<IntArray>, start: Int, end: Int) {
    if (start>end) return

    var temp = intervals[start][0]
    var i = start
    var j = end
    while (i != j) {
        while (intervals[j][0] >= temp && i < j) {
            j--
        }
        while (intervals[i][0] <= temp && i < j) {
            i++
        }
        swap(intervals, i, j)
    }
    swap(intervals, start, i)
    sort(intervals, start, i - 1)
    sort(intervals, i + 1, end)
}

/**
 * 交换位置
 */
fun swap(intervals: Array<IntArray>, i: Int, j: Int) {
    println("change ${i} ${j}")
    var temp = intervals[i]
    intervals[i] = intervals[j]
    intervals[j] = temp

}