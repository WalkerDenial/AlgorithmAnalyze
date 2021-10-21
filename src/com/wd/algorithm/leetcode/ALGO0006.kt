package com.wd.algorithm.leetcode

/**
 * 6. Z 字形变换
 *
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 *
 */
class ALGO0006 {

    /**
     * 方式一：按行数进行处理
     * 时间复杂度 T(n²)
     */
    fun convert(s: String, numRows: Int): String {
        val length = s.length
        if (numRows == 1 || length <= numRows) return s
        val lastLine = numRows - 1
        val space = numRows + numRows - 2
        var groups = length / space
        if (length % space > 0) groups++
        val sb = StringBuffer()
        var curr: Int
        for (i in 0 until numRows) {
            for (j in 0 until groups) {
                curr = space * j + i
                if (curr >= length) break
                sb.append(s[curr])
                if (i !in 1 until lastLine) continue
                curr = space * j + space - i
                if (curr >= length) break
                sb.append(s[curr])
            }
        }
        return sb.toString()
    }

}

fun main() {
    val clazz = ALGO0006()
    println("PINALSIGYAHRPI")
    println(clazz.convert("PAYPALISHIRING", 4))
}