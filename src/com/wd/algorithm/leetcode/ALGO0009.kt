package com.wd.algorithm.leetcode

/**
 * 9. 回文数
 *
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
 *
 */
class ALGO0009 {

    fun isPalindrome1(x: Int): Boolean {
        if (x < 0 || x > Int.MAX_VALUE) return false
        if (x < 10) return true
        var num = x
        var curr = 0
        while (curr < num) {
            val end = num % 10
            if (curr == 0 && curr == end) break
            num /= 10
            if (curr == num) return true
            curr = curr * 10 + end
            if (curr == num) return true
            else if (num < 10) break
        }
        return false
    }

    fun isPalindrome2(x: Int): Boolean {
        if (x < 0 || x > Int.MAX_VALUE) return false
        val str = "$x"
        val reverseStr = str.reversed()
        return str == reverseStr
    }

    fun isPalindrome3(x: Int): Boolean {
        if (x < 0 || x > Int.MAX_VALUE) return false
        if (x < 10) return true
        if (x % 10 == 0) return false
        val str = "$x"
        val length = str.length
        val lastIndex = length - 1
        for (i in 0 until length / 2) {
            if (str[i] != str[lastIndex - i]) return false
        }
        return true
    }

}

fun main() {
    val clazz = ALGO0009()
    val num = 21120
//    (clazz::isPalindrome).test(num)
    println(clazz.isPalindrome1(num))
}