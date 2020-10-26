package com.moviesguo.leetcode.linked_list;

import com.moviesguo.leetcode.java_bean.ListNode;

public class AddTwoNumbers {

    //优化版本
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode tail = head;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int num1 = l1 != null ? l1.val : 0;
            int num2 = l2 != null ? l2.val : 0;
            int count = num1 + num2 + carry;
            tail.next = new ListNode(count%10);
            carry = count/10;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
            tail = tail.next;
        }
        if (carry!=0) tail.next = new ListNode(carry);
        return head.next;
    }
//    //两次l1,l2有些多余，放在一个while循环里面就行
//    public ListNode addTwoNumbers(ListNode l1,ListNode l2){
//        ListNode res = new ListNode();
//        ListNode head = res;
//        int addition = 0;
//        while(l1 != null){
//            if(l2 != null){
//                int count = l1.val + l2.val + addition;
//                if(count >= 10){
//                    count -= 10;
//                    addition = 1;
//                }else{
//                    addition = 0;
//                }
//                ListNode node = new ListNode(count);
//                head.next = node;
//                head = head.next;
//                l1 = l1.next;
//                l2 = l2.next;
//            }else{
//                int count = l1.val + addition;
//                if(count >= 10){
//                    count -= 10;
//                    addition = 1;
//                }else{
//                    addition = 0;
//                }
//                ListNode node = new ListNode(count);
//                head.next = node;
//                head = head.next;
//                l1 = l1.next;
//            }
//        }
//        while(l2 != null){
//            int count = l2.val + addition;
//            if(count >= 10){
//                count -= 10;
//                addition = 1;
//            }else{
//                addition = 0;
//            }
//            ListNode node = new ListNode(count);
//            head.next = node;
//            head = head.next;
//            l2 = l2.next;
//        }
//        if(addition == 1) head.next = new ListNode(1);
//        return res.next;
//    }

}
