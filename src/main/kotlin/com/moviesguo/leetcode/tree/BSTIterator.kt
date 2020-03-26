package tree

import TreeNode
import java.util.*

/**
 * 实现一个二叉搜索树迭代器。你将使用二叉搜索树的根节点初始化迭代器。
 *
 * 调用 next() 将返回二叉搜索树中的下一个最小的数。
 * BSTIterator iterator = new BSTIterator(root);
 * iterator.next();    // 返回 3
 * iterator.next();    // 返回 7
 * iterator.hasNext(); // 返回 true
 * iterator.next();    // 返回 9
 * iterator.hasNext(); // 返回 true
 * iterator.next();    // 返回 15
 * iterator.hasNext(); // 返回 true
 * iterator.next();    // 返回 20
 * iterator.hasNext(); // 返回 false
 *  
 *
 * 提示：
 *
 * next() 和 hasNext() 操作的时间复杂度是 O(1)，并使用 O(h) 内存，其中 h 是树的高度。
 * 你可以假设 next() 调用总是有效的，也就是说，当调用 next() 时，BST 中至少存在一个下一个最小的数。
 *
  */
class BSTIterator(root: TreeNode) {

    val stack = Stack<TreeNode>()

    init {
        inOrder(root)
    }

    fun next():Int{
        val node = stack.pop()
        if (node.right !=null) inOrder(node.right!!)
        return node.`val`
    }

    fun hasNext(): Boolean {
        return stack.isNotEmpty()
    }

    fun inOrder(root: TreeNode) {
        var cur: TreeNode? = root
        while (cur != null) {
            stack.push(cur)
            cur = cur.left
        }
    }

}