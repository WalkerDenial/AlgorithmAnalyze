package com.wd.algorithm.leetcode

import com.wd.algorithm.test

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
     * 时间复杂度 T(n²)
     */
    fun lengthOfLongestSubstring1(s: String): Int {
        var endIndex = 0
        var maxLength = 0
        val data = s.toCharArray()
        val set = HashSet<Int>(data.size)
        for (i in data.indices) {
            endIndex = i
            set.clear()
            set.add(data[i].toInt())
            if (i == data.size - 1) endIndex++
            else for (j in (i + 1) until data.size) {
                endIndex = j
                val index = data[j].toInt()
                if (set.contains(index)) break
                set.add(index)
                if (j == s.length - 1) endIndex++
            }
            maxLength = maxLength.coerceAtLeast(endIndex - i)
        }
        return maxLength
    }

    /**
     * 方式二：滑动窗口及优化
     * 向右递增，如果发现重复，则移动起始点下标，并记录当前长度
     * 时间复杂度 T(n)
     */
    fun lengthOfLongestSubstring2(s: String): Int {
        var startIndex = 0
        var maxLength = 0
        val data = s.toCharArray()
        val map = HashMap<Int, Int>(data.size)
        for (i in data.indices) {
            val index = data[i].toInt()
            if (map.containsKey(index) && map[index]!! >= startIndex) {
                maxLength = maxLength.coerceAtLeast(i - startIndex)
                startIndex = map[index]!! + 1
            }
            map[index] = i
            if (i == s.length - 1) maxLength = maxLength.coerceAtLeast(i + 1 - startIndex)
        }
        return maxLength
    }

}

fun main() {
    val clazz = ALGO0003()
    val str = "pwwkew"

    (clazz::lengthOfLongestSubstring1).test(str)
    (clazz::lengthOfLongestSubstring2).test(str)
}