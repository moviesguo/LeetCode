package com.moviesguo.leetcode.linked_list;

/**
 * 您将获得一个双向链表，除了下一个和前一个指针之外，它还有一个子指针，可能指向单独的双向链表。这些子列表可能有一个或多个自己的子项，依此类推，生成多级数据结构，如下面的示例所示。
 *
 * 扁平化列表，使所有结点出现在单级双链表中。您将获得列表第一级的头部。
 *
 *  
 *
 * 示例:
 *
 * 输入:
 *  1---2---3---4---5---6--NULL
 *          |
 *          7---8---9---10--NULL
 *              |
 *              11--12--NULL
 *
 * 输出:
 * 1-2-3-7-8-11-12-9-10-4-5-6-NULL
 *
 */
public class Flatten {

    public static void main(String[] args) {
        Node node1 = new Node();
        Node node2 = new Node();
        Node node3 = new Node();
        Node node4 = new Node();
        Node node5 = new Node();
        Node node6 = new Node();
        Node node7 = new Node();
        Node node8 = new Node();
        Node node9 = new Node();
        Node node10 = new Node();
        Node node11 = new Node();
        Node node12 = new Node();
//        node1.next = node2;
//        node2.next = node3;
//        node2.prev = node1;
//        node3.next = node4;
//        node3.prev = node2;
//        node3.child = node7;
//        node4.next = node5;
//        node4.prev = node3;
//        node5.next = node6;
//        node5.prev = node4;
//        node7.next = node8;
//        node8.prev = node7;
//        node8.next = node9;
//        node8.child = node11;
//        node9.prev = node8;
//        node9.next = node10;
//        node10.prev = node9;
//        node11.next = node12;
//        node12.prev = node11;
        node1.child = node2;
        node2.child = node3;
        node3.child = node4;
        node1.val = 1;
        node2.val = 2;
        node3.val = 3;
        node4.val = 4;
        node5.val = 5;
        node6.val = 6;
        node7.val = 7;
        node8.val = 8;
        node9.val = 9;
        node10.val = 10;
        node11.val = 11;
        node12.val = 12;


        Node flatten = helper(node1);
        System.out.println(flatten);
    }

    public static Node helper(Node head){
        flatten(head);
        return head;
    }

    /**
     * 其实可以当成二叉树去中序遍历然后再操作的
     * 我这里是遇见child就往下递归，然后返回最后一个节点，再做各种连接和断开操作
     * 其实递归这一点和二叉树是一样的，但是思路就没往二叉树去想
     * @param head
     * @return
     */
    public static Node flatten(Node head) {
        while (head != null && (head.next != null || head.child != null)) {
            if (head.child != null) {
                Node child = flatten(head.child);
                child.next = head.next;
                head.next = head.child;
                head.child.prev = head;
                head.child = null;

                if (child.next != null) {
                    child.next.prev = child;
                    head = child.next;
                } else {
                    return child;
                }
                continue;
            }
            head = head.next;
        }
        return head;
    }


    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }

}
