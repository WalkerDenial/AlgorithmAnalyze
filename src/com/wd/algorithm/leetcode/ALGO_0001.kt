package com.wd.algorithm.leetcode

/**
 * 1. 两数之和
 *
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那两个整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * 你可以按任意顺序返回答案。
 */
class ALGO_0001 {

    fun twoSum(nums: IntArray, target: Int): IntArray {
        val paramMap = mutableMapOf<Int, Int>()
        for (i in nums.indices) {
            val diff = target - nums[i]
            if (paramMap.containsKey(diff)) return intArrayOf(paramMap[diff]!!, i)
            paramMap[nums[i]] = i
        }
        return intArrayOf(0, 0)
    }

}

fun main() {
    val clazz = ALGO_0001()
    println(clazz.twoSum(intArrayOf(42, 34, 1, 6, 7, 87, 45, 7, 4, 9, 2, 423, 126), 127).contentToString())
}