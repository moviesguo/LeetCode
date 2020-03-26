package com.moviesguo.leetcode.linked_list;

/**
 * Created by guo on 2017/8/29.
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two letters and return it as a linked list.
 You may assume the two letters do not contain any leading zero, except the number 0 itself.
 Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 0 -> 8
 */
public class AddTwoNumbersLink {


    //两个链表相加，要考虑进位问题以及一个两个链表长度不同而且也有进位的问题
    public static void main(String[] args){
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(0);
        ListNode l3 = new ListNode(1);
        ListNode l4 = new ListNode(5);
        ListNode l5 = new ListNode(9);
        ListNode l11 = new ListNode(5);
        ListNode l22 = new ListNode(9);
        ListNode l33 = new ListNode(9);
        ListNode l44 = new ListNode(7);
        ListNode l55 = new ListNode(7);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l11.next = l22;
        l22.next = l33;
        l33.next = l44;
        l44.next = l55;

        ListNode list = addTwoNumbers(l1, l11);
        while(true){
            System.out.print(list.val+" ");
            list = list.next;
            if(list==null) break;
        }
    }

    /*
    这里写的好复杂，我自己都不想看了，leetCode 上面有一个好看的算法
    思路应该是一样的用除和求余来得到进位的数和本位的数，记得都为空的时候不要忘了在进位一个
     */

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode list = new ListNode(0);
        ListNode head = list;
        boolean hasNext = false;
        while(true){
            int val;
            if(!hasNext) val = l1.val+l2.val;
            else val = l1.val+l2.val+1;
            head.val=val%10;
            if(l1.val!=0||l2.val!=0) hasNext=val/10==0?false:true;
            else hasNext = false;
            l1 = l1.next;
            l2 = l2.next;
            if(l1==null||l2==null) break;
            ListNode node = new ListNode(0);
            head.next = node;
            head = head.next;
        }
        if(l1==null&&l2!=null){
            l2 = foo(l2,hasNext);
            head.next = l2;
            head = head.next;
        }else if(l2==null&&l1!=null){
            l1 = foo(l1,hasNext);
            head.next = l1;
            head = head.next;
        } else if (l1 == null && l2 == null && hasNext) {
            ListNode node = new ListNode(1);
            head.next = node;
        }
        return list;
    }

        public static ListNode foo(ListNode list,boolean hasNext){
            ListNode head = list;
            while(true){
                if (hasNext) {
                    head.val = (head.val+1)%10;
                    hasNext = head.val==0?true:false;
                }
                if(head.next==null) break;
                head = head.next;
            }
            if(hasNext){
                ListNode node = new ListNode(1);
                head.next = node;
            }
            return list;
        }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}

