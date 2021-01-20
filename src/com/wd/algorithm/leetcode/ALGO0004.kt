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
     * 时间复杂度 T(n²)
     */
    fun findMedianSortedArrays1(nums1: IntArray, nums2: IntArray): Double {
        val nums = nums1.plus(nums2)
        nums.sort()
        return when {
            nums.isEmpty() -> 0.0
            nums.size % 2 != 0 -> nums[nums.size / 2].toDouble()
            else -> {
                val index = nums.size / 2
                (nums[index - 1] + nums[index]) / 2.0
            }
        }
    }

    /**
     * 方式二：暴力解法
     * 将 2 个数组合并，然后取中位数
     * 时间复杂度 T(n²)
     */
    fun findMedianSortedArrays2(nums1: IntArray, nums2: IntArray): Double {
        return 0.0
    }

}

fun main() {
    val clazz = ALGO0004()
    val num1 = intArrayOf(1,2,3)
    val num2 = intArrayOf(4,5,6)
    println(clazz.findMedianSortedArrays1(num1, num2))
    println(clazz.findMedianSortedArrays2(num1, num2))
}