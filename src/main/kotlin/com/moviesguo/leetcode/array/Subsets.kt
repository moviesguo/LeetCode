package com.moviesguo.algorithm.array

/*
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 *  [1]
 *  [1,2]
 *  [1,3]
 *  [1,4]
 *  [1,2,3]
 *  [1,2,4]
 *  [1,3,4]
 *  [1,2,3,4]
 *  [2,3,4]
 *  [2,3]
 *  [2,4]
 *  [3,4]
 *
 *
 */

fun main() {

//    var nums = intArrayOf(1, 2, 3)
//
//    var result = subsets(nums)


    var result = ArrayList<List<Int>>()
    var nums = intArrayOf(1,2,3)
    foo(nums, result, ArrayList(), 0)

    result.forEach{
        println(it.toString())
    }

}

/**
 * 考虑了每个子集可能的个数进行循环，然后每个子集的开头不同又有一次循环
 * 所以变成了现在这种有两重循环之后里面还有一层循环的结果
 */
fun subsets(nums: IntArray): List<List<Int>> {
    var result = ArrayList<List<Int>>()
    //
    for (i in 0 until nums.size) {
        var list = ArrayList<Int>()
        for (j in 0 until nums.size) {
            foo(nums, result, list, j, i)
            list.clear()
        }
    }
    result.add(ArrayList())
    return result
}

fun foo(nums: IntArray, result: MutableList<List<Int>>, list: MutableList<Int>, index: Int, count: Int) {
    list.add(nums[index])
    if (count == 0) {
        var temp = ArrayList<Int>()
        temp.addAll(list)
        result.add(temp)
        return
    }

    for (i in index until nums.size - 1) {
        var temp = ArrayList<Int>()
        temp.addAll(list)
        foo(nums, result, temp, i + 1, count - 1)
    }
}

/**
 * 其实可以直接就不考虑子集list的不同数量问题,在递归的时候,每递归一层,子集list的size就会+1
 * 就相当于对list的不同数量做了处理,子集会带着本次的结果继续向下递归,
 * 例如 子集为 [1] 的时候 会先向下递归一层,先将[1]加入result,
 * 再向下递归变成 [1,2] 然后被加入到result,[1,2]再向下递归变成[1,2,3] 加入result
 * 这个时候到头了,就会将自己删除,然后返回上一层,这时候sub为[1,2],再往下也没有了,再将自己删除,
 * 然后返回上一层,这时候sub为[1],这时再往下递归一层就是[1,3] 了, 同理继续回到[1]的时候,这个时候[1]的循环走完了,
 * 将自己删除,返回上次一层,这个时候就sub为[],再向下循环就是[2]开头的子集了
 *
 * 总结 : 递归牛逼,我好菜
 */
fun foo(nums: IntArray, result: MutableList<List<Int>>, list: MutableList<Int>, start: Int) {
    result.add(ArrayList(list))
    for (i in start until nums.size) {
        list.add(nums[i])
        foo(nums, result, list, i + 1)
        list.removeAt( list.size - 1)
    }
}