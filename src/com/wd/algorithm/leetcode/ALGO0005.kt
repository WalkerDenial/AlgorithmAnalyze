package com.wd.algorithm.leetcode

import com.wd.algorithm.test
import kotlin.math.max
import kotlin.math.min

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
     * 时间复杂度 T(n³)
     */
    fun longestPalindrome1(s: String): String {
        val length = s.length
        if (length < 2) return s
        val lastIndex = length - 1
        var start = 0
        var maxLength = 1
        var currStart: Char
        var endIndex: Int
        var tempLen: Int
        var isPaired: Boolean
        for (i in 0 until lastIndex) {
            currStart = s[i]
            endIndex = i + 1
            for (j in lastIndex downTo endIndex) {
                if (s[j] != currStart) continue
                tempLen = j - i + 1
                isPaired = true
                for (k in 0..(tempLen / 2)) {
                    if (s[i + k] != s[j - k]) {
                        isPaired = false
                        break
                    }
                }
                if (isPaired && tempLen > maxLength) {
                    start = i
                    maxLength = tempLen
                }
            }
        }
        return s.substring(start, start + maxLength)
    }

    /**
     * 方式二：中心扩散法
     * 以当前字符串为中心，向两边扩散
     * 时间复杂度 T(n²)
     */
    fun longestPalindrome2(s: String): String {
        val length = s.length
        if (length < 2) return s
        val lastIndex = length - 1
        var start = 0
        var maxLength = 1
        for (i in 0 until lastIndex) {
            val len1 = expandAroundCenter(s, i, i)
            val len2 = expandAroundCenter(s, i, i + 1)
            val tempMax = max(len1, len2)
            if (tempMax > maxLength) {
                maxLength = tempMax
                start = i - tempMax / 2
                if (tempMax % 2 == 0) start++
            }
        }
        return s.substring(start, start + maxLength)
    }

    private fun expandAroundCenter(s: String, left: Int, right: Int): Int {
        val len = s.length
        var l = left
        var r = right
        while (l >= 0 && r < len && s[l] == s[r]) {
            l--
            r++
        }
        return r - l - 1
    }

    /**
     * 方式三：Manacher 算法
     * 时间复杂度 T(n)
     */
    fun longestPalindrome3(s: String): String {
        val length = s.length
        if (length < 2) return s

        val str = manacherString(s)
        val p = IntArray(str.length)
        var r = -1
        var c = 0
        var index = -1
        var maxLength = 0
        for (i in str.indices) {
            p[i] = if (r > i) min(p[2 * index - i], r - i) else 1
            while (i + p[i] < str.length && i - p[i] >= 0) {
                if (str[i + p[i]] == str[i - p[i]]) p[i]++
                else break
            }
            if (i + p[i] > r) {
                r = i + p[i]
                index = i
            }
        }
        for (i in str.indices) {
            if (p[i] > maxLength) {
                maxLength = p[i]
                c = i
            }
        }
        maxLength--
        c = (c - 1) / 2
        val begin: Int = c - (maxLength - 1) / 2
        return s.substring(begin, begin + maxLength)
    }

    private fun manacherString(s: String): String {
        val sb = StringBuffer("#")
        for (item in s) sb.append("$item#")
        return sb.toString()
    }

}

fun main() {
    val clazz = ALGO0005()
    val str = "ababaababa"
    (clazz::longestPalindrome1).test(str)
    (clazz::longestPalindrome2).test(str)
    (clazz::longestPalindrome3).test(str)
}