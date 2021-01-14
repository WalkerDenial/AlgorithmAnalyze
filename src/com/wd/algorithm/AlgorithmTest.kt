package com.wd.algorithm

import java.text.DecimalFormat
import kotlin.reflect.KFunction

private var startTime = 0L // 开始测试时间
private var endTime = 0L // 结束测试时间

private var startMemory = 0.0 // 开始测试时已用内存
private var endMemory = 0.0 // 结束测试时已用内存

private val runtime by lazy { Runtime.getRuntime() }

private val dfFormat by lazy { DecimalFormat("###0.##") }

private val TOTAL_TEST_RANGE by lazy { IntRange(0, 100000) } // 总共测试次数

private fun beforeTest() {
    System.gc() // 先 GC 一次，这样得到的内存更准确
    startMemory = getUsedMemory()
    startTime = System.currentTimeMillis()
}

private fun afterTest(tag: String = "") {
    endTime = System.currentTimeMillis()
    endMemory = getUsedMemory()
    println("$tag 总计：测试次数 ${TOTAL_TEST_RANGE.last - TOTAL_TEST_RANGE.first} 次，耗时 ${endTime - startTime} ms, 内存开销：${dfFormat.format(endMemory - startMemory)} Mb")
}

// 获取内存信息
private fun getUsedMemory(): Double {
    return (runtime.totalMemory() - runtime.freeMemory()) / 1024.0 / 1024.0
}

fun KFunction<Any>.test(vararg obj: Any) {
    if (obj.size > 9) throw RuntimeException("obj size must less than 9")
    beforeTest()
    // 如果放在循环内部进行选择的话，会影响到最终的测试结果，因此哪怕代码重复，也要区分开
    when (obj.size) {
        1 -> for (i in TOTAL_TEST_RANGE) this.call(obj[0])
        2 -> for (i in TOTAL_TEST_RANGE) this.call(obj[0], obj[1])
        3 -> for (i in TOTAL_TEST_RANGE) this.call(obj[0], obj[1], obj[2])
        4 -> for (i in TOTAL_TEST_RANGE) this.call(obj[0], obj[1], obj[2], obj[3])
        5 -> for (i in TOTAL_TEST_RANGE) this.call(obj[0], obj[1], obj[2], obj[3], obj[4])
        6 -> for (i in TOTAL_TEST_RANGE) this.call(obj[0], obj[1], obj[2], obj[3], obj[4], obj[5])
        7 -> for (i in TOTAL_TEST_RANGE) this.call(obj[0], obj[1], obj[2], obj[3], obj[4], obj[5], obj[6])
        8 -> for (i in TOTAL_TEST_RANGE) this.call(obj[0], obj[1], obj[2], obj[3], obj[4], obj[5], obj[6], obj[7])
        else -> for (i in TOTAL_TEST_RANGE) this.call()
    }
    afterTest(this.name)
}