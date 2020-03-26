package array

/**
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: [1,2,2]
 * 输出:
 * [
 * [2],
 * [1],
 * [1,2,2],
 * [2,2],
 * [1,2],
 * []
 * ]
 *
 */

fun main() {
    val nums = intArrayOf(1, 2, 2)
    subsetRecycle(nums,0)
    ans.forEach{
        println(it.toString())
    }
}

fun subsetsWithDup(nums: IntArray): List<List<Int>> {
    nums.sort()
    //这里控制个数
    for (i in 0..nums.size) {
        subsetsWitDup(nums, 0, i, ArrayList())
    }
    return ans
}

/**
 * 这个思路和下面是一样的，只不过多用了一个count变量，这个变量可以省略
 * 直接依赖递归去控制
 */
fun subsetsWitDup(nums: IntArray, index: Int, count: Int, sub: MutableList<Int>){
    if (count == sub.size) {
        ans.add(ArrayList(sub))
        return
    }
    //这里控制起始点
    for (i in index until nums.size) {
        if (i > index && nums[i] == nums[i - 1]) continue
        sub.add(nums[i])
        subsetsWitDup(nums, i + 1, count, sub)
        sub.removeAt(sub.size - 1)
    }
}

val ans = ArrayList<List<Int>>()

/**
 * 递归版本未去重的
 * 不断地将nums分为一个个地子集  例如 [1,2,3]
 * 第一层递归的时候，sub : [1] 然后将sub传递下去,第二次就是在[2,3]内寻找子集
 *
 * sub: [1]     第一层 加入1,然后进入第二层
 * sub : [1,2]  第二层加入ans,然后加入2,然后进入第三层
 * sub : [1,2,3]  第三层加入ans,然后加入3,然后进入第四层,第四层加入ans,循环条件不成立直接返回第三层
 * sub : [1,2]  第三层删除3,然后循环结束,再返回上一层
 * sub : [1,3] 第二层删除2,然后加入3,进入下一层，加入ans，结束
 *
 * 大概是这样样子的，综合了递归和回溯,之前用count来判断是否结束其实是没有必要的,如果不去判断，下面的循环也不会执行，和判断的效果是一样的，也不会出现数组越界
 *
 *
 */
fun subsets(nums: IntArray, index: Int, sub: MutableList<Int>) {
    ans.add(ArrayList(sub))
    for (i in index until nums.size) {
        if (i > index && nums[i] == nums[i - 1]) continue
        sub.add(nums[i])
        subsets(nums, i + 1, sub)
        sub.removeAt(sub.size - 1)
    }
}

/**
 * 参考https://leetcode-cn.com/problems/subsets/solution/er-jin-zhi-wei-zhu-ge-mei-ju-dfssan-chong-si-lu-9c/
 * 思路二:
 * 每增加一个元素，就将之前的子集拷贝出来加上现在这个元素，就是新增的子集
 * 下面分别是迭代和递归的写法
 */
fun subset(nums: IntArray) {
    ans.add(ArrayList())
    for (i in nums.indices) {
        for (j in ans.indices) {
            val sub = ArrayList(ans[j])
            sub.add(nums[i])
            ans.add(sub)
        }
    }
}

fun subsetRecycle(nums: IntArray, i: Int) {
    //这个单独在外面加
//    ans.add(ArrayList())
    if (i >= nums.size) return
    for (j in 0 until ans.size) {
        val sub = ArrayList(ans[j])
        sub.add(nums[i])
        ans.add(sub)
    }
    subsetRecycle(nums, i + 1)
}