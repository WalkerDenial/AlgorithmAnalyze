package com.wd.algorithm.leetcode

/**
 * 3. 无重复字符的最长子串
 *
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 */
class ALGO0003 {

    /**
     * 方式一：暴力解法
     * 逐个生产子字符串，看看是否含有重复的字符
     * 时间复杂度 T(n³)
     */
    fun lengthOfLongestSubstring1(s: String): Int {
        if(s.isBlank()) return 0
        var max = 0
        for (i in s.indices) {

        }
        return 0
    }

    /**
     * 方式二：滑动窗口及优化
     * 向右递增，如果发现重复，则移动起始点下标，并记录当前长度
     * 时间复杂度 T(n)
     */
    fun lengthOfLongestSubstring2(s: String): Int {
        if(s.isBlank()) return 0
        return 0
    }

}

fun main() {
    val clazz = ALGO0003()
    val str = "pwwkew"
}