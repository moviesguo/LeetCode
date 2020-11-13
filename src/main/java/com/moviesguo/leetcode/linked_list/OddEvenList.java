package com.moviesguo.leetcode.linked_list;

import com.moviesguo.leetcode.java_bean.ListNode;

public class OddEvenList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        OddEvenList oddEvenList = new OddEvenList();
        ListNode listNode = oddEvenList.oddEvenList(head);

    }

    /**
     * 感觉像是交替着在前进
     * https://leetcode-cn.com/problems/odd-even-linked-list/solution/qi-ou-lian-biao-by-leetcode-solution/
     * 上面url中的图解很形象
     * @param head
     * @return
     */
    public ListNode oddEvenList(ListNode head){
        if (head == null) return null;
        ListNode odd = head;
        ListNode evenHead = odd.next;
        ListNode even = evenHead;
        while(even != null && even.next != null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

//    public ListNode oddEvenList(ListNode head) {
//        ListNode node = head;
//        ListNode evenHead = new ListNode();
//        ListNode evenTail = evenHead;
//        while(node.next != null){
//            evenTail.next = node.next;
//            evenTail = evenTail.next;
//            node.next = node.next.next;
//            evenTail.next = null;
//            if(node.next == null) {
//                node.next = evenHead.next;
//                return head;
//            }
//            node = node.next;
//        }
//
//        node.next = evenHead.next;
//        return head;
//    }

}
