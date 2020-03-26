package string

import java.util.*
import kotlin.collections.HashMap

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 *
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 *
 */

fun main() {
    val s = "rat"
    val t = "car"
    println(isAnagram(s, t))
}

/**
 * 排序，如果存在的字符相同，那么排序之后的字符串也相同
 */
fun isAnagramSBySort(s: String, t: String) {
    val array1 = s.toCharArray()
    Arrays.sort(array1)
    val array2 = t.toCharArray()
    Arrays.sort(array2)
    array1.toString() == array2.toString()
}

/**
 * hashMap记录char出现的次数，如果第一次加，第二次减，如果最后hashMap为空就返回true
 * 此方法可用于unicode
 * 在不是unicode的情况下hashMap可以换成int[26]
 */
fun isAnagram(s: String, t: String): Boolean {
    val map = HashMap<Char,Int>()
    s.forEach {
        if (map.containsKey(it)) {
            map[it] = map[it]!! + 1
        } else {
            map[it] = 1
        }
    }

    t.forEach {
        if (map.containsKey(it)) {
            if (map[it] == 1) {
                map.remove(it)
            } else {
                map[it] = map[it]!! - 1
            }
        } else {
            return false
        }
    }
    return map.isEmpty()
}