package com.moviesguo.leetcode.linked_list;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
 *
 * 要求返回这个链表的 深拷贝。 
 *
 * 我们用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：
 *
 * val：一个表示 Node.val 的整数。
 * random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为  null 。
 * 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 输入：head = [[1,1],[2,1]]
 * 输出：[[1,1],[2,1]]
 * 输入：head = [[3,null],[3,0],[3,null]]
 * 输出：[[3,null],[3,0],[3,null]]
 * 示例 4：
 *
 * 输入：head = []
 * 输出：[]
 * 解释：给定的链表为空（空指针），因此返回 null。
 *  
 *
 * 提示：
 *
 * -10000 <= Node.val <= 10000
 * Node.random 为空（null）或指向链表中的节点。
 * 节点数目不超过 1000 。
 *
 */
public class CopyRandomList {

    HashMap<Node, Node> map = new HashMap();

    public Node copyRecursive(Node node) {
        if (node == null) return null;
        //如果map中存在新的值直接返回
        if (map.containsKey(node)) return map.get(node);
        //没有就创建一个新的值，然后加入到map中
        Node newNode = new Node(node.val);
        //next和random后面查找next的时候会找到他然后赋值
        map.put(node, newNode);
        //查找next,这里就类似于递归把所有的next节点都添加到了map中,然后才会查找random,这个时候所有节点的拷贝都能在random中找到了
        //还不清楚就去看下面的迭代
        newNode.next = copyRecursive(node.next);
        //查找random
        newNode.random = copyRecursive(node.random);
        return newNode;
    }

    public Node copyRandomList(Node head) {
        if (head == null) return null;

        Node newNode = new Node(head.val);
        Node oldNode = head;
        while (oldNode != null) {
            //拷贝当前节点的next到map中，如果有直接返回，没有就创建一个
            //这么走下去，当前创建的next一开始是没有next和random的，但是会遍历到他，然后就可以给他赋值了
            newNode.next = copyRandomList(oldNode.next);
            newNode.random = copyRandomList(oldNode.random);
            newNode = newNode.next;
            oldNode = oldNode.next;
        }
        return head;
    }

    public Node getCloneNode(Node node) {
        if (!map.containsKey(node)) {
            map.put(node, new Node(node.val));
        }
        return map.get(node);
    }



    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

}
