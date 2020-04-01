package com.moviesguo.leetcode.binary

import java.util.*

/**
 * 1111. 有效括号的嵌套深度
 * 给你一个「有效括号字符串」 seq，请你将其分成两个不相交的有效括号字符串，A 和 B，并使这两个字符串的深度最小。
 *
 * 不相交：每个 seq[i] 只能分给 A 和 B 二者中的一个，不能既属于 A 也属于 B 。
 * A 或 B 中的元素在原字符串中可以不连续。
 * A.length + B.length = seq.length
 * 深度最小：max(depth(A), depth(B)) 的可能取值最小。 
 * 划分方案用一个长度为 seq.length 的答案数组 answer 表示，编码规则如下：
 *
 * answer[i] = 0，seq[i] 分给 A 。
 * answer[i] = 1，seq[i] 分给 B 。
 * 如果存在多个满足要求的答案，只需返回其中任意 一个 即可。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：seq = "(()())"
 * 输出：[0,1,1,1,1,0]
 * 示例 2：
 *
 * 输入：seq = "()(())()"
 * 输出：[0,0,0,1,1,0,1,1]
 * 解释：本示例答案不唯一。
 * 按此输出 A = "()()", B = "()()", max(depth(A), depth(B)) = 1 。
 * 像 [1,1,1,0,0,1,1,1]，也是正确结果，其中 A = "()()()", B = "()", max(depth(A), depth(B)) = 1 。
 *  
 *
 * 提示：
 *
 * 1 <= text.size <= 10000
 *
 * 有效括号字符串：
 *
 * 仅由 "(" 和 ")" 构成的字符串，对于每个左括号，都能找到与之对应的右括号，反之亦然。
 * 下述几种情况同样属于有效括号字符串：
 *
 * 1. 空字符串
 * 2. 连接，可以记作 AB（A 与 B 连接），其中 A 和 B 都是有效括号字符串
 * 3. 嵌套，可以记作 (A)，其中 A 是有效括号字符串
 * 嵌套深度：
 *
 * 类似地，我们可以定义任意有效括号字符串 s 的 嵌套深度 depth(S)：
 *
 * 1. s 为空时，depth("") = 0
 * 2. s 为 A 与 B 连接时，depth(A + B) = max(depth(A), depth(B))，其中 A 和 B 都是有效括号字符串
 * 3. s 为嵌套情况，depth("(" + A + ")") = 1 + depth(A)，其中 A 是有效括号字符串
 *
 * 例如：""，"()()"，和 "()(()())" 都是有效括号字符串，嵌套深度分别为 0，1，2，而 ")(" 和 "(()" 都不是有效括号字符串。
 *
 */
fun main() {
    val seq = "(((()))((())))"
    val maxDepthAfterSplit = maxDepthAfterSplit(seq)
    println(maxDepthAfterSplit.contentToString())
}


fun maxDepthAfterSplit(seq: String): IntArray {
    if (seq.isEmpty()) return intArrayOf()
    var size = seq.length
    val ans = IntArray(size){ 0 }
    var depth = 0
    //类似遇见一对连续的左括号或者右括号就给他拆成两组
    //这样(())的时候就是 () ()
    //这样的 ()() 还是 ()()
    // (((()))) 的时候就是 (()) (())
    // (((())))(()) 的时候就是 (())() (())()
    for (i in 0 until size) {
        if (seq[i] == '(') {
            //遇到左括号入栈
            //然后奇偶,如果是偶数就给0,奇数就给1,这样相当于平分嵌套的那种
            //对于连续出现的左括号来说,这样就是分到了不同的组,也就相当于从嵌套中隔一个抽一个出来
            ans[i] = depth++ % 2
            //ans[i] = i and 1
        } else {
            //右括号同理
            ans[i] = --depth % 2
            // ans[i] = 1 - i and 1
        }
    }
    return ans
}