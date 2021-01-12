package com.wd.algorithm.leetcode

import org.w3c.dom.NodeList

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
     * 冒泡方式
     * 时间复杂度 T(n²)
     */
    fun addTwoNumbers(l1: NodeList, l2: NodeList): NodeList {

    }

}

fun main() {
    val clazz = ALGO0001()
    println(clazz.twoSum1(intArrayOf(42, 34, 1, 6, 7, 87, 45, 7, 4, 9, 2, 423, 126), 127).contentToString())
    println(clazz.twoSum2(intArrayOf(42, 34, 1, 6, 7, 87, 45, 7, 4, 9, 2, 423, 126), 127).contentToString())
}