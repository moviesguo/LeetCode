package array

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
 *
 * 编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。
 *
 * 示例 1:
 *
 * 输入: nums = [2,5,6,0,0,1,2], target = 0
 * 输出: true
 * 示例 2:
 *
 * 输入: nums = [2,5,6,0,0,1,2], target = 3
 * 输出: false
 * 进阶:
 *
 * 这是 搜索旋转排序数组 的延伸题目，本题中的 nums  可能包含重复元素。
 * 这会影响到程序的时间复杂度吗？会有怎样的影响，为什么？
 *
 */
fun main() {
    val nums = intArrayOf(4,5,6,7,0,1,2)
    println(search(nums,0))
}


fun search(nums: IntArray, target: Int): Boolean {

    var left = 0
    var right = nums.size - 1
    while (left <= right) {
        val mid = left + (right - left) / 2
        if (nums[mid] == target) return true
        if (nums[left] == nums[mid]){
            left++
            continue
        }
        if (nums[left] < nums[mid]) {
            if (target < nums[mid] && target >= nums[left]) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        } else {
            if (target > nums[mid] && target <= nums[right]) {
                left = mid + 1
            } else {
                right = mid - 1
            }
        }
    }
    return false
}


/**
 *
 * 33. 搜索旋转排序数组
 *
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 *
 * 你可以假设数组中不存在重复的元素。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 示例 1:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 *
 */

fun searchFoo(nums: IntArray, target: Int): Int {

    var left = 0
    var right = nums.size - 1

    while (left <= right) {
        val mid = (left + right) / 2
        if (nums[mid] == target) return mid
        //自拍Noam
        if (nums[left] <= nums[mid]) {
            if (nums[left] <= target && nums[mid] > target) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        } else {
            if (nums[mid] < target && nums[right] >= target) {
                left = mid + 1
            } else {
                right = mid - 1
            }
        }
    }
    return -1
}

fun search1(nums: IntArray, target: Int): Int {
    if (nums.isEmpty()) return -1
    if (nums.size == 1) return if(nums[0] == target) 0 else -1
    //先找到旋转点
    val rotateIndex = findRotateIndex(nums)
    //如果没旋转就直接二分搜索
    if (rotateIndex == 0) return searchHelper(nums, 0, nums.size - 1, target)
    //判断一下旋转点是不是目标值
    if (nums[rotateIndex] == target) return rotateIndex
    //如果目标值比nums[0]还小，那么应该是在旋转的数组里
    if (target < nums[0]) {
        return searchHelper(nums, rotateIndex + 1, nums.size - 1, target)
    }
    //如果比nums[0]大，那么肯定在0-rotateIndex
    return searchHelper(nums, 0, rotateIndex - 1, target)
}

fun searchHelper(nums: IntArray,start:Int,end:Int,target: Int):Int{
    var left = start
    var right = end
    while (left <= right) {
        val center = (left + right) / 2
        if (nums[center] == target) return center
        if (nums[center] < target) {
            left = center + 1
        } else {
            right = center - 1
        }
    }
    return -1
}

fun findRotateIndex(nums: IntArray): Int {
    var left = 0
    var right = nums.size - 1
    //如果没有旋转直接返回0
    if (nums[left]<nums[right]) return 0
    while (left <= right) {
        val center = (left + right) / 2
        //如果当前的比右边的要大,那么当前就是旋转位置
        if (nums[center] > nums[center + 1]) return center + 1
        //如果中间比最左边要小,去左边找,因为从左到右是升序的,只要比左边的大一定是正常的顺序，如果比左边小的话当前应该在被旋转的里面，所以需要缩小右侧的值
        if (nums[center] < nums[left]) right = center - 1
        //如果中间的比最左边的大，去右边找，
        else left = center + 1
    }
    return 0
}
