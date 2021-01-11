package com.wd.algorithm.leetcode

/**
 * 1. 两数之和
 *
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那两个整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * 你可以按任意顺序返回答案。
 */
class ALGO0001 {

    /**
     * 方式一
     * 冒泡方式
     * 时间复杂度 T(n²)
     */
    fun twoSum1(num: IntArray, target: Int): IntArray {
        for (i in 0 until (num.size - 1)) {
            // 从剩余的数据中查找能相加等于 target 的数，如果存在，则返回
            for (j in (i + 1) until num.size) {
                if (num[i] + num[j] == target) return intArrayOf(i, j)
            }
        }
        return intArrayOf(0, 0)
    }

    /**
     * 方式二
     * 采用 Map 作为缓存的方式
     * 时间复杂度 T(n)
     */
    fun twoSum2(num: IntArray, target: Int): IntArray {
        val paramMap = mutableMapOf<Int, Int>()
        for (i in num.indices) {
            val diff = target - num[i]
            // 如果数据匹配，则返回结果
            if (paramMap.containsKey(diff)) return intArrayOf(paramMap[diff]!!, i)
            // 如果数据不匹配，则计入缓存中
            paramMap[num[i]] = i
        }
        return intArrayOf(0, 0)
    }

}

fun main() {
    val clazz = ALGO0001()
    println(clazz.twoSum1(intArrayOf(42, 34, 1, 6, 7, 87, 45, 7, 4, 9, 2, 423, 126), 127).contentToString())
    println(clazz.twoSum2(intArrayOf(42, 34, 1, 6, 7, 87, 45, 7, 4, 9, 2, 423, 126), 127).contentToString())
}