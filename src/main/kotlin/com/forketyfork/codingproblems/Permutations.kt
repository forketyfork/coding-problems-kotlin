package com.forketyfork.codingproblems

import java.util.*

/**
 * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
 *
 * @see "Daily Coding Problem #1128"
 * @see <a href="https://leetcode.com/problems/permutations/description/">LeetCode #46. Permutations</a>
 */
class Permutations {

    fun permute(nums: IntArray): List<List<Int>> = permute(LinkedList(nums.toList()))

    private fun permute(nums: LinkedList<Int>): List<MutableList<Int>> {
        if (nums.isEmpty()) {
            return listOf(mutableListOf())
        }
        return nums.indices.flatMap { idx ->
            nums.removeAt(idx).let { el ->
                permute(nums).also { lists ->
                    lists.forEach { it.add(el) }
                    nums.add(idx, el)
                }
            }
        }
    }

}