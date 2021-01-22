package com.wd.algorithm.leetcode

import com.wd.algorithm.test

/**
 * 5. 最长回文子串
 *
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 */
class ALGO0005 {

    /**
     * 方式一：暴力解法
     * 分别遍历每一个字符，向后找回文字符串，经过所有遍历后，得到最长回文子串
     * 时间复杂度 T(n²)
     */
    fun longestPalindrome1(s: String): String {
        return ""
    }

    /**
     * 方式二：双指针查找
     * 通过 2 个指针，标注起始点和结束点，移动指针，判断是否为回文
     * 时间复杂度 T(n)
     */
    fun longestPalindrome2(s: String): String {
        return ""
    }

}

fun main() {
    val clazz = ALGO0005()
}