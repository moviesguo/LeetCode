package com.moviesguo.algorithm.linked_list;

import java.util.HashSet;

public class DetectCycle {

    /**
     *
     * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
     *
     * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
     * 如果 pos 是 -1，则在该链表中没有环。
     *
     * 说明：不允许修改给定的链表。
     *
     */

    public static void main(String[] args) {

        ListNode root = new ListNode(1);
        ListNode a = new ListNode(2);
        ListNode b = new ListNode(0);        ListNode c = new ListNode(-4);
        ListNode d = new ListNode(3);
//        root.setNext(a);
        a.setNext(root);
        b.setNext(c);
        c.setNext(a);
        ListNode listNode = detectCycle(root);
        System.out.println(listNode.getVal());
    }

    /**
     *
     * 该思路是将所有走过的节点加入到set中,如果第一次碰见相同的node，那就是入口
     *
     * 还有一个思路是使用快慢指针先找到相遇的位置,
     * 之后再使用一个指针指向头部,一个指针指向相遇点,同时开始一步一步向前,相遇点就是入口
     * @link{https://leetcode-cn.com/problems/linked-list-cycle-ii/solution/huan-xing-lian-biao-ii-by-leetcode/}
     *
     * @param head
     * @return
     */
    public static ListNode detectCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet();
        ListNode node = head;
        while (node != null) {
            if (set.contains(node)) return node;
            set.add(node);
            node = node.getNext();
        }
        return node;
    }


}
