package com.wd.algorithm.leetcode

/**
 * 7. 整数反转
 *
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 *
 */
class ALGO0007 {

    fun reverse(x: Int): Int {
        if (x > -10 && x < 10) return x
        var num = kotlin.math.abs(x.toLong())
        var result = 0L
        while (num > 0) {
            result = result * 10 + num % 10
            num /= 10
        }
        if (x > 0 && result > Int.MAX_VALUE) return 0
        if (x < 0 && result > (Int.MAX_VALUE + 1L)) return 0
        return (if (x < 0) -result else result).toInt()
    }

}

fun main() {
    val clazz = ALGO0007()
    val num = 964632435
//    (clazz::reverse).test(num)
    println(clazz.reverse(num))
}