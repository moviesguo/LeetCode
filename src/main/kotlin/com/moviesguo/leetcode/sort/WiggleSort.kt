package sort

/**
 * 给定一个无序的数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。
 *
 * 示例 1:
 *
 * 输入: nums = [1, 5, 1, 1, 6, 4]
 * 输出: 一个可能的答案是 [1, 4, 1, 5, 1, 6]
 * 示例 2:
 *
 * 输入: nums = [1, 3, 2, 2, 3, 1]
 * 输出: 一个可能的答案是 [2, 3, 1, 3, 1, 2]
 * 说明:
 * 你可以假设所有输入都会得到有效的结果。
 *
 * 进阶:
 * 你能用 O(n) 时间复杂度和 / 或原地 O(1) 额外空间来实现吗？
 */

fun main() {
    val nums = intArrayOf(4,5,5,6)
    wiggleSort(nums)
    println(nums.contentToString())
}

fun wiggleSort(nums: IntArray): Unit {
    val size = nums.size
    quickSelect(nums,0,size,size/2)
    var mid = nums[size / 2]
    var i = 0
    var j = 0
    var k  = size -1
    //把中位数挪到中间
    while (j < k) {
        //这其实也是快排，就是把n当作了基准点
        if (nums[j] > mid){
            swap(nums, j, k)
            k--
        }else if (nums[j] < mid) {
            swap(nums, i, j)
            i++
            j++
        } else {
            j++
        }
    }
    val split = size / 2 + if (size % 2 == 0) 0 else 1
    val temp1 = nums.copyOfRange(0, split)
    val temp2 = nums.copyOfRange(split , size)
    for (m in temp1.indices) {
        nums[2 * m] = temp1[temp1.size - 1 - m]
    }
    for (n in temp2.indices) {
        nums[2 * n + 1] = temp2[temp2.size - 1 - n]
    }

}

/**
 * 快速选择算法，使得idnex为0 until n 的数都小于nums[n],之后的数都大于n
 * @param nums 需要修改的数组
 * @param begin 开始的位置
 * @param end 结束的位置
 * @param n 需要选择的位置
 */
fun quickSelect(nums: IntArray, begin: Int, end: Int, n: Int) {
    val t = nums[end - 1]
    var i = begin
    var j = begin
    while (j < end) {
        //选最后一个点为基准点，如果比他小，就交换i,j的位置
        //这样的话，如果比他大的话，i指针不会动，再遇见比他小的就会交换回去了
        if (nums[j] <= t) {
            swap(nums, i, j)
            i++
            j++
        } else {
            j++
        }
    }
    //i在当前数组中，前面的都比自己小，后面的都比自己大，其实这就是一趟快排
    if (i - 1 > n) {
        //继续去找n所在的位置，然后把n放好
        quickSelect(nums, begin, i - 1, n)
    } else if (i <= n) {
        quickSelect(nums, i, end, n)
    }
}
fun swap(nums: IntArray, i: Int, j: Int) {
    val temp = nums[j]
    nums[j] = nums[i]
    nums[i] = temp
}
