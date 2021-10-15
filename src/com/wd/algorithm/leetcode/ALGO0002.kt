package com.wd.algorithm.leetcode

import com.wd.algorithm.test

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
    fun addTwoNumbers1(l1: ListNode, l2: ListNode): ListNode {
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
    fun addTwoNumbers2(l1: ListNode?, l2: ListNode?): ListNode {
        var node1 = l1
        var node2 = l2
        val node = ListNode(-1)
        var curr = node
        var offset = 0
        while (node1 != null || node2 != null) {
            val value1 = node1?.`val` ?: 0
            val value2 = node2?.`val` ?: 0
            val result = value1 + value2 + offset
            val value = result.rem(10)
            offset = result.div(10)
            val newNode = ListNode(value)

            node1?.let { node1 = it.next }
            node2?.let { node2 = it.next }

            curr.next = newNode
            curr = curr.next!!
        }
        if (offset > 0) {
            curr.next = ListNode(1)
        }
        return node.next!!
    }

}

fun main() {
    val clazz = ALGO0002()

    val l1 = getListNode(intArrayOf(9, 9, 9, 9, 9, 9, 9))
    val l2 = getListNode(intArrayOf(9, 9, 9, 9))

    (clazz::addTwoNumbers1).test(l1, l2)
    (clazz::addTwoNumbers2).test(l1, l2)
}

private fun getListNode(data: IntArray): ListNode {
    if (data.isEmpty()) return ListNode(0)
    var lastNode: ListNode? = null
    var node: ListNode? = null
    for (i in data) {
        val item = ListNode(i)
        if (node == null) node = item
        else lastNode?.next = item
        lastNode = item
    }
    return node!!
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