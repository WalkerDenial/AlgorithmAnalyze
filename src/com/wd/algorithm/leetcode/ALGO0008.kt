package com.wd.algorithm.leetcode

import com.wd.algorithm.test

/**
 * 8. 字符串转换整数 (atoi)
 *
 * 请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
 * 函数 myAtoi(string s) 的算法如下：
 * 读入字符串并丢弃无用的前导空格
 * 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
 * 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
 * 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
 * 如果整数数超过 32 位有符号整数范围 [−231,  231 − 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231 的整数应该被固定为 −231 ，大于 231 − 1 的整数应该被固定为 231 − 1 。
 * 返回整数作为最终结果。
 * 注意：
 * 本题中的空白字符只包括空格字符 ' ' 。
 * 除前导空格或数字后的其余字符串外，请勿忽略 任何其他字符。
 *
 */
class ALGO0008 {

    fun myAtoi1(s: String): Int {
        var num: Long? = null
        var negative: Boolean? = null
        for (c in s) {
            if (c == ' ') {
                if (num == null && negative == null) continue
                else break
            }
            if (c == '-') {
                if (negative == null && num == null) {// 没数没符号
                    negative = true
                    continue
                } else break
            } else if (c == '+') {
                if (negative == null && num == null) { // 没数没符号
                    negative = false
                    continue
                } else break
            }
            if (c < '0' || c > '9') break
            if (num == null) num = 0
            num = num * 10 + (c - '0');// 组合数字
            if (num >= Integer.MAX_VALUE) break
        }
        if (num == null) num = 0
        val n = if (negative == null) num else {
            if (negative) -num else num
        }
        val ans = if (n >= Integer.MAX_VALUE) Integer.MAX_VALUE else {
            if (n <= Integer.MIN_VALUE) Integer.MIN_VALUE else n.toInt()
        }
        return ans
    }

    fun myAtoi2(s: String): Int {
        val str = s.trim()
        if (str.isEmpty()) return 0
        val len = str.length
        var sign = 1
        var index = 0
        val firstChar = str[index]
        if (firstChar == '+') {
            index++
        } else if (firstChar == '-') {
            index++
            sign = -1
        }
        var res = 0
        val maxData = Int.MAX_VALUE / 10
        val minData = Int.MIN_VALUE / 10
        val maxSuffix = Int.MAX_VALUE % 10
        val minSuffix = Int.MIN_VALUE % 10
        while (index < len) {
            val currChar = str[index]
            if (currChar !in '0'..'9') break
            val currValue = currChar - '0'
            if (res > maxData || res == maxData && currValue > maxSuffix) {
                return Int.MAX_VALUE
            }
            if (res < minData || res == minData && currValue > -minSuffix) {
                return Int.MIN_VALUE
            }
            res = res * 10 + sign * currValue
            index++
        }
        return res
    }

}

fun main() {
    val clazz = ALGO0008()
    val str = "  -42"
    (clazz::myAtoi2).test(str)
}