package com.moviesguo.leetcode.array

/**
 * 42. 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
 *
 * 示例:
 *
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 */

fun main() {
    val height = intArrayOf(4,2,3)
    println(trap(height))
}

fun trap(height: IntArray): Int {
    if (height.isEmpty() ) return 0
    var ans = 0
    for (i in height.indices) {
        var maxLeft = 0
        //找到左边最大的
        for (j in i downTo 0) {
            if (maxLeft<height[j]) maxLeft = height[j]
        }
        //找到右边最大的
        var maxRight = 0
        for (k in i until height.size) {
            if (maxRight < height[k]) maxRight = height[k]
        }
        //然后用他俩较小的那个减自己
        ans += Math.min(maxLeft, maxRight) - height[i]
    }
    return ans
}

fun dpTrap(height: IntArray) {
    val leftMax = IntArray(height.size) { 0 }
    val rightMax = IntArray(height.size){ 0}

    var ans = 0
    //提前保存i位置时，左右最大的
    //我们注意到，解法二中。对于每一列，我们求它左边最高的墙和右边最高的墙，都是重新遍历一遍所有高度，这里我们可以优化一下。
    //
    //首先用两个数组，max_left [i] 代表第 i 列左边最高的墙的高度，max_right[i] 代表第 i 列右边最高的墙的高度。（一定要注意下，第 i 列左（右）边最高的墙，是不包括自身的，和 leetcode 上边的讲的有些不同）
    //
    //对于 max_left我们其实可以这样求。
    //
    //max_left [i] = Max(max_left [i-1],height[i-1])。它前边的墙的左边的最高高度和它前边的墙的高度选一个较大的，就是当前列左边最高的墙了。
    //
    //对于 max_right我们可以这样求。
    //
    //max_right[i] = Max(max_right[i+1],height[i+1]) 。它后边的墙的右边的最高高度和它后边的墙的高度选一个较大的，就是当前列右边最高的墙了。
    //
    //这样，我们再利用解法二的算法，就不用在 for 循环里每次重新遍历一次求 max_left 和 max_right 了。
    for (i in 1 until height.size) {
        leftMax[i] = Math.max(leftMax[i - 1], height[i - 1])
    }
    for (j in height.size - 2 downTo 0) {
        rightMax[j] = Math.max(rightMax[j + 1], height[j + 1])
    }

    for (i in height.indices) {
        ans += Math.min(rightMax[i], leftMax[i]) - height[i]
    }

}

fun doubleIndexTrap(height: IntArray) {
    var leftMax = 0
    var rightMax = 0
    var left = 1
    var right = height.size - 1
    var ans = 0
    for (i in 1 until height.size) {
        //对于位置left而言，它左边最大值一定是left_max，右边最大值“大于等于”right_max，
        // 这时候，如果left_max<right_max成立，那么它就知道自己能存多少水了。
        // 无论右边将来会不会出现更大的right_max，都不影响这个结果。
        // 所以当left_max<right_max时，我们就希望去处理left下标，反之，我们希望去处理right下标。
        if (height[left - 1] < height[right + 1]) {
            leftMax = Math.max(leftMax, height[left])
            if (leftMax > height[left]) ans += leftMax - height[left]
            left++
        } else {
            rightMax = Math.max(rightMax, height[right])
            if (rightMax > height[right]) ans += rightMax - height[right]
            right--
        }
    }

    //双指针法真的妙，那么如何理解双指针法呢？听我来给你捋一捋。（捋的过程和原解中的C++在细节方面的处理是有出入的）
    //
    //我们先明确几个变量的意思：
    //
    //left_max：左边的最大值，它是从左往右遍历找到的
    //right_max：右边的最大值，它是从右往左遍历找到的
    //left：从左往右处理的当前下标
    //right：从右往左处理的当前下标
    //定理一：在某个位置i处，它能存的水，取决于它左右两边的最大值中较小的一个。
    //
    //定理二：当我们从左往右处理到left下标时，左边的最大值left_max对它而言是可信的，但right_max对它而言是不可信的。（见下图，由于中间状况未知，对于left下标而言，right_max未必就是它右边最大的值）
    //
    //定理三：当我们从右往左处理到right下标时，右边的最大值right_max对它而言是可信的，但left_max对它而言是不可信的。
    //
    //                                   right_max
    // left_max                             __
    //   __                                |  |
    //  |  |__   __??????????????????????  |  |
    //__|     |__|                       __|  |__
    //        left                      right
    //对于位置left而言，它左边最大值一定是left_max，右边最大值“大于等于”right_max，这时候，如果left_max<right_max成立，（这是重点，如果左边最大值比较小，那么肯定最多也就那么多了）
    // 那么它就知道自己能存多少水了。无论右边将来会不会出现更大的right_max，都不影响这个结果。
    // 所以当left_max<right_max时，我们就希望去处理left下标，反之，我们希望去处理right下标。
//    class Solution:
//        def trap(self, height: List[int]) -> int:
//    left=0
//    right=len(height)-1
//    left_max=right_max=0
//    ans=0
//    while left<=right:
//    if left_max<right_max:
//    ans+=max(0,left_max-height[left])
//    left_max=max(left_max,height[left])
//    left+=1
//    else:
//    ans+=max(0,right_max-height[right])
//    right_max=max(right_max,height[right])
//    right-=1
//    return ans

    fun doubleIndex(height: IntArray) {
        var leftMax = 0
        var rightMax = 0
        var left = 1
        var right = height.size - 1
        var ans = 0
        while (left <= right) {
            if (leftMax < rightMax) {
                ans += Math.max(0, leftMax - height[left])
                leftMax = Math.max(leftMax, height[left])
                left++
            } else {
                //如果rightMax比当前要小那么没法存水，所以用0来比较
                ans += Math.max(0, rightMax - height[right])
                rightMax = Math.max(rightMax, height[right])
                right--
            }

        }
    }

}