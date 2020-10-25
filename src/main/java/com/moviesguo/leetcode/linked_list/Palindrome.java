package com.moviesguo.leetcode.linked_list;

import com.moviesguo.leetcode.java_bean.ListNode;

/**
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 *
 */
public class Palindrome {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(1);

//        head.next  = node1;
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
        Palindrome palindrome = new Palindrome();
        System.out.println(palindrome.isPalindrome(head));
    }

    /**
     * 使用快慢指针去找到链表的中点，反转慢指针走过的链表
     * 如果fast最后不为空，那么这么链表的数量为奇数，再去对比slow.next 和 pre 两个链表就可以了
     * 如果fast为空，那么对比slow和pre就可以了
     * 这种操作会改变链表的结构，如果不想改变链表的结构还需要在比较完成之后恢复
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        ListNode pre = null;
        ListNode slow = head;
        ListNode fast = head;
        //找到中间节点
        while(fast != null && fast.next != null){
            ListNode temp = slow;
            slow = slow.next;
            fast = fast.next.next;
            if (pre != null)temp.next = pre;
            pre = temp;
        }
        if (fast != null) slow = slow.next;
        while(slow != null){
            if(slow.val != pre.val) return false;
            slow = slow.next;
            pre = pre.next;
        }
        return true;
    }

    ListNode frontHead;

    /**
     * 使用递归的特性来实现首尾的比较
     * frontHead记录头节点，然后不断递归到尾节点
     * 之后比较尾节点和头结点，递归往回走，头结点往前走，完美
     * @param head
     * @return
     */
    public boolean isPalindromeRecursive(ListNode head){
        frontHead = head;
        return recursivelyCheck(head);
    }

    public boolean recursivelyCheck(ListNode currentNode){
        if (currentNode != null) {
            //不断往下递归,如果一个对不上了就直接全部返回了
            if (!recursivelyCheck(currentNode.next)) {
                return false;
            }
            if (currentNode.val != frontHead.val) {
                return false;
            }
            frontHead = frontHead.next;
        }
        return true;
    }

}


