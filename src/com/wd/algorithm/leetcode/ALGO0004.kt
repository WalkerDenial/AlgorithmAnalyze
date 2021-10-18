package com.wd.algorithm.leetcode

/**
 * 4. 寻找两个正序数组的中位数
 *
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数。
 *
 */
class ALGO0004 {

    /**
     * 方式一：暴力解法
     * 将 2 个数组合并，然后取中位数
     * 时间复杂度 T(m + n)
     */
    fun findMedianSortedArrays1(nums1: IntArray, nums2: IntArray): Double {
        val nums = nums1.plus(nums2)
        nums.sort()
        val index = nums.size / 2
        return when {
            nums.size % 2 != 0 -> nums[index].toDouble()
            else -> (nums[index - 1] + nums[index]) / 2.0
        }
    }

    /**
     * 方式二：二分查找
     * 通过二分查找找出分割位置，然后比较左上、右下 和 左下、右上数据信息，符合条件即为对接点
     * 时间复杂度 T(min(m, n))
     */
    fun findMedianSortedArrays2(nums1: IntArray, nums2: IntArray): Double {
        val num1Size = nums1.size
        val num2Size = nums2.size
        val totalNum = num1Size + num2Size
        val isEven = totalNum % 2 == 0
        val halfIndex = totalNum / 2
        var left = 0
        var right = 0
        var prev = 0
        var curr = 0
        for (i in 0..halfIndex) {
            prev = curr
            curr = when {
                left >= num1Size -> nums2[right++]
                right >= num2Size -> nums1[left++]
                nums1[left] > nums2[right] -> nums2[right++]
                else -> nums1[left++]
            }
        }
        return if (isEven) (prev + curr) / 2.0 else curr.toDouble()
    }

}

fun main() {
    val clazz = ALGO0004()
    val num1 = intArrayOf(1, 2, 3)
    val num2 = intArrayOf(4, 5, 6)
//    (clazz::findMedianSortedArrays1).test(num1, num2)
//    (clazz::findMedianSortedArrays2).test(num1, num2)
    println(clazz.findMedianSortedArrays2(intArrayOf(1, 2), intArrayOf(3, 4)))
}