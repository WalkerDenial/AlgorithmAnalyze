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
     * 时间复杂度 T(n²)
     */
    fun lengthOfLongestSubstring1(s: String): Int {
        if (s.isEmpty()) return 0
        if (s.length == 1 || s.matches(Regex("(${s[0]})+"))) return 1
        var endIndex = 0
        var maxLength = 0
        val set = hashSetOf<String>()
        for (i in s.indices) {
            set.clear()
            set.add("${s[i]}")
            endIndex = i
            for (j in (i + 1) until s.length) {
                endIndex = j
                if (set.contains("${s[j]}")) break
                else set.add("${s[j]}")
            }
            maxLength = Math.max(maxLength, endIndex - i)
        }
        return maxLength
    }

    /**
     * 方式二：滑动窗口及优化
     * 向右递增，如果发现重复，则移动起始点下标，并记录当前长度
     * 时间复杂度 T(n)
     */
    fun lengthOfLongestSubstring2(s: String): Int {
        if (s.isEmpty()) return 0
        if (s.length == 1 || s.matches(Regex("(${s[0]})+"))) return 1
        var startIndex = 0
        var maxLength = 0
        val map = mutableMapOf<String, Int>()
        for (i in s.indices) {
            if (map.containsKey("${s[i]}")) {
                maxLength = Math.max(maxLength, i - startIndex)
                startIndex = map["${s[i]}"]!! + 1
            }
            map["${s[i]}"] = i
        }
        return maxLength
    }

}

fun main() {
    val clazz = ALGO0003()
    val str = "pwwkew"

    println(clazz.lengthOfLongestSubstring1("au"))
    println(clazz.lengthOfLongestSubstring2("au"))

//    (clazz::lengthOfLongestSubstring1).test(str)
//    (clazz::lengthOfLongestSubstring2).test(str)
}