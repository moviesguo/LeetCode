package com.moviesguo.algorithm.tree

/**
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 *
 * 示例:
 *
 * Trie trie = new Trie();
 *
 * trie.insert("apple");
 * trie.search("apple");   // 返回 true
 * trie.search("app");     // 返回 false
 * trie.startsWith("app"); // 返回 true
 * trie.insert("app");
 * trie.search("app");     // 返回 true
 * 说明:
 *
 * 你可以假设所有的输入都是由小写字母 a-z 构成的。
 * 保证所有输入均为非空字符串。
 *
 */

fun main() {

    var root = Trie()
    root.insert("apple")
    root.insert("abcd")
    println(root)
}

/**
 *
 * 这里的思路其实和刚开始写的差不多，不过承载数据的方式换成了数组，一开始也想用数组来着
 * 感觉每个node都要声明一个26长度的数组可能有些浪费就使用了链表，但是用链表的时间复杂度会多出N的M次方倍
 *
 * 思路就是childs是存储某个字母是否存在,然后一级一级往下找,使用数组可以以O(1)的时间复杂度找到对应的字符是否存在
 *
 * 链表方法在最新面
 *
 */
class TrieNode{

    val links = arrayOfNulls<TrieNode>(26)

    //标记当前是否有在此结束的字符
    var isEnd = false
    //是否包含某个字符
    fun containsKey(c: Char) = links[c - 'a']!=null
    //获取某个字符的TreeNode
    fun get(c: Char) = links[c - 'a']
    //添加某个字符
    fun put(c:Char,node:TrieNode) {
        links[c - 'a'] = node
    }

    fun setEnd() {
        isEnd = true
    }

}

class Trie {


    val root = TrieNode()

    /** Inserts a word into the trie. */
    fun insert(word: String) {
        if (word.isEmpty()) return
        var node = root
        word.forEach {
            if (!node.containsKey(it)){
                node.put(it, TrieNode())
            }
            node = node.get(it)!!
        }
        node.setEnd()
    }

    /** Returns if the word is in the trie. */
    fun search(word: String): Boolean {
        val node = searchPrefix(word)
        return node != null && node.isEnd
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    fun startsWith(prefix: String): Boolean {
        return searchPrefix(prefix) != null
    }

    fun searchPrefix(prefix: String): TrieNode? {
        var node = root
        prefix.forEach {
            if (!node.containsKey(it)) {
                return null
            }
            node = node.get(it)!!
        }
        return node
    }

}

//class Trie {
//
//    var links = ArrayList<Trie>()
//
//    var c: Char? = null
//
//
//    /** Inserts a word into the trie. */
//    fun insert(word: String) {
//
//        if (word.isEmpty()) return
//
//        var index = 0
//        var wordIndex = 0
//        var contentChilds = links
//        if (links.isEmpty()) {
//            var pre = Trie()
//            pre.c = word[0]
//            links.add(pre)
//            for (i in 1 until word.length) {
//                var node = Trie()
//                node.c = word[i]
//                pre.links.add(node)
//                pre = node
//            }
//        }
//        var child :Trie? = null
//        while (index < contentChilds.size) {
//
//            child = contentChilds[index]
//
//            if (child.c == word[wordIndex]) {
//                contentChilds = child.links
//                index = 0
//                wordIndex += 1
//                if (wordIndex==word.length) return
//                if (contentChilds.isEmpty()) return
//            } else {
//                index++
//            }
//        }
//
//        if (wordIndex == word.length) return
//        for (i in wordIndex until word.length) {
//            var node = Trie()
//            node.c = word[i]
//            contentChilds.add(node)
//            contentChilds = node.links
//        }
//    }
//
//    /** Returns if the word is in the trie. */
//    fun search(word: String): Boolean {
//        return false
//    }
//
//    /** Returns if there is any word in the trie that starts with the given prefix. */
//    fun startsWith(prefix: String): Boolean {
//        return false
//    }
//
//    override fun toString(): String {
//        val builder = StringBuilder()
//        links.forEach {
//            builder.append(it.c)
//            builder.append(it.toString())
//        }
//        return builder.toString()
//    }
//
//
//}