package com.wd.algorithm.leetcode

/**
 * 10. 正则表达式匹配
 *
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 *
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 *
 */
class ALGO0010 {

    fun isMatch(s: String, p: String): Boolean {
        return true
    }

}

fun main() {
    val clazz = ALGO0010()
    val s = "mississippi"
    val p = "mis*is*p*."
//    (clazz::isPalindrome).test(num)
    println(clazz.isMatch(s, p))
}