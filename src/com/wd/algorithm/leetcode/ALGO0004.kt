package com.wd.algorithm.leetcode

import com.wd.algorithm.test

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
        val totalNum = nums1.size + nums2.size
        val isEven = totalNum % 2 == 0
        val halfIndex = totalNum / 2
        var index = 0
        var left = 0
        var right = 0
        var middle = 0.0
        while (left < nums1.size || right < nums2.size) {
            val value = when {
                left >= nums1.size -> nums2[right++]
                right >= nums2.size -> nums1[left++]
                nums1[left] > nums2[right] -> nums2[right++]
                else -> nums1[left++]
            }.toDouble()
            if (index == halfIndex) {
                middle = if (isEven) (middle + value) / 2 else value
                break
            } else middle = value
            index++
        }
        return middle
    }

}

fun main() {
    val clazz = ALGO0004()
    val num1 = intArrayOf(1, 2, 3)
    val num2 = intArrayOf(4, 5, 6)
    (clazz::findMedianSortedArrays1).test(num1, num2)
    (clazz::findMedianSortedArrays2).test(num1, num2)
}