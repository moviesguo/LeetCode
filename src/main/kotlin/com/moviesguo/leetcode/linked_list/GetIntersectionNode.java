package com.moviesguo.algorithm.linked_list;

/**
 * 编写一个程序，找到两个单链表相交的起始节点。
 * @link{ https://leetcode-cn.com/problems/intersection-of-two-linked-lists/ }
 */
public class GetIntersectionNode {

    public static ListNode rootA;
    public static ListNode rootB;

    public static void main(String[] args) {
        ListNode root1 = new ListNode(1);
        ListNode root2 = new ListNode(2);


        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(4);

        root1.setNext(node1);
        root2.setNext(node2);
        ListNode node3 = new ListNode(6);

        node1.setNext(node3);
        node2.setNext(node3);

        ListNode node4 = new ListNode(7);
        ListNode node5 = new ListNode(8);
        node3.setNext(node4);
        node3.setNext(node5);

        ListNode intersectionNode = getIntersectionNode(root1, root2);
        System.out.println(intersectionNode.getVal().toString());
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode ha = headA, hb = headB;
        while (ha != hb) {
            ha = ha != null ? ha.getNext() : headB;
            hb = hb != null ? hb.getNext() : headA;
        }
        return ha;
    }

    /**
     *
     * a+b = b+a
     * A和B两个链表长度可能不同，但是A+B和B+A的长度是相同的，所以遍历A+B和遍历B+A一定是同时结束。
     * 如果A,B相交的话A和B有一段尾巴是相同的，所以两个遍历的指针一定会同时到达交点
     * 如果A,B不相交的话两个指针就会同时到达A+B（B+A）的尾节点
     *
     * @param node1
     * @param node2
     * @return
     */
    public static ListNode foo(ListNode node1,ListNode node2){

        if (node1==node2) return node1;

        if (node1==null) node1 = rootB;
        else node1 = node1.getNext();

        if (node2==null) node2 = rootA;
        else node2 = node2.getNext();
        System.out.println("node1 : " + node1.getVal().toString() + " node2 : " + node2.getVal().toString());
        return foo(node1, node2);
    }

}
