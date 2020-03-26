package com.moviesguo.algorithm.stack

/**
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 * 示例:
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 *
 *
 */

/**
 *
 *
 *
 * @link{url = https://leetcode-cn.com/problems/min-stack/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-38/}
 */
class MinStack {

    class Node(val value: Int, val minValue: Int) {
        var next: Node? = null
    }

    var root: Node? = null

    //入栈
    fun push(x: Int) {
        if (null == root) {
            root = Node(x, x)
        } else {
            var node = Node(x, Math.min(x, root!!.value))
            node.next = root
            root = node
        }
    }

    //删除栈顶元素
    fun pop() {
        root = root?.next
    }

    //获取栈顶元素
    fun top(): Int {
        return root?.value ?: Int.MIN_VALUE
    }

    fun getMin(): Int {
        return root?.minValue ?: Int.MIN_VALUE
    }

}



fun main() {

    var minStack = MinStack()
    minStack.push(-2)
    minStack.push(0)
    minStack.push(-3)
    println(minStack.getMin())
    minStack.pop()
    println(minStack.top())
}