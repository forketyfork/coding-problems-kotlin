package com.forketyfork.codingproblems

/**
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 *
 * Given two integers x and y, return the Hamming distance between them.
 *
 * @see <a href="https://leetcode.com/problems/hamming-distance/description/">LeetCode #461. Hamming Distance</a>
 * @see <a href="https://leetcode.com/problems/minimum-bit-flips-to-convert-number/description/">2220. Minimum Bit Flips to Convert Number</a>
 */
class BitHammingDistance {
    fun solve(start: Int, goal: Int): Int {
        var count = 0
        var start = start
        var goal = goal
        while (start != 0 || goal != 0) {
            if ((start xor goal) and 1 == 1) {
                count++
            }
            start = start shr 1
            goal = goal shr 1
        }
        return count
    }
}