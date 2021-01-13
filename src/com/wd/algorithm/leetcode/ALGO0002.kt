package com.wd.algorithm.leetcode

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

/**
 * 2. 两数相加
 *
 * 给你两个非空的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 */
class ALGO0002 {

    /**
     * 方式一
     * 转换成对应的整数再进行计算，然后逆序输出
     * 时间复杂度 T(n)
     */
    fun addTwoNumbers1(l1: ListNode?, l2: ListNode?): ListNode? {
        val str1 = l1.contentToString() // l1 逆序
        val str2 = l2.contentToString() // l2 逆序
        val num1 = if (str1.isBlank()) 0 else str1.reversed().toInt() // l1 真实数值
        val num2 = if (str2.isBlank()) 0 else str2.reversed().toInt() // l2 真是数值
        val result = (num1 + num2).toString().reversed() // 求出结果并逆序
        val data = IntArray(result.length)  // 转换成数组
        for (i in result.indices) data[i] = result[i].toString().toInt()
        return getListNode(data) // 获取返回结果
    }

    /**
     * 方式二
     * 按节点进位处理
     * 时间复杂度 T(n)
     */
    fun addTwoNumbers2(l1: ListNode?, l2: ListNode?): ListNode? {
        var node = ListNode(0) // 待返回数据
        var curr:ListNode? = node // 待返回数据当前节点
        var currNode1 = l1 // l1 当前节点
        var currNode2 = l2 // l2 当前节点
        var offset = 0 // 进位值
        while (currNode1 != null || currNode2 != null) {
            val result = (currNode1?.`val` ?: 0) + (currNode2?.`val` ?: 0) + offset
            offset = result / 10
            curr?.next = ListNode(result % 10)
            curr = curr?.next
            currNode1 = currNode1?.next
            currNode2 = currNode2?.next
        }
        if(offset > 0) curr?.next = ListNode(offset) // 虽然测试结束，如果有进位，需要增加一个节点
        return node.next
    }

}

fun main() {
    val clazz = ALGO0002()

    val l1 = getListNode(intArrayOf(9, 9, 9, 9, 9, 9, 9))
    val l2 = getListNode(intArrayOf(9, 9, 9, 9))

    println("l1: " + l1.contentToString())
    println("l2: " + l2.contentToString())

    println("result: " + clazz.addTwoNumbers1(l1, l2).contentToString())
    println("result: " + clazz.addTwoNumbers2(l1, l2).contentToString())
}

private fun getListNode(data: IntArray): ListNode? {
    if (data.isEmpty()) return null
    var lastNode: ListNode? = null
    var node: ListNode? = null
    for (i in data) {
        val item = ListNode(i)
        if (node == null) node = item
        else lastNode?.next = item
        lastNode = item
    }
    return node
}

private fun ListNode?.contentToString(): String {
    if (this == null) return ""
    val sb = StringBuilder()
    var item: ListNode? = this
    while (item != null) {
        sb.append("${item.`val`}")
        item = item.next
    }
    return sb.toString()
}