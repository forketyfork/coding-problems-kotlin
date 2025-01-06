package com.forketyfork.codingproblems

/**
 * Given an integer n, return the least number of perfect square numbers that sum to n.
 *
 * A perfect square is an integer that is the square of an integer; in other words, it is the product of some integer
 * with itself. For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.
 *
 * @see "Daily Coding Problem #1126"
 * @see <a href="https://leetcode.com/problems/perfect-squares/">LeetCode #279. Perfect Squares</a>
 * @see <a href="https://leetcode.com/problems/perfect-squares/solutions/2985092/kotlin-dp-companion-object-faster-than-70/">Solution explanation</a>
 */
class PerfectSquares {

    companion object {

        private const val MAX_N = 10000
        private const val SQRT_MAX_N = 100

        private val squares = (1..SQRT_MAX_N).map { it * it }

        val dp = IntArray(MAX_N + 1)

        init {
            squares.forEach { dp[it] = 1 }
            (2..<MAX_N).forEach { idx ->
                if (dp[idx] == 0) {
                    dp[idx] = 1 + squares.filter { it <= idx }.minOf { dp[idx - it] }
                }
            }
        }

    }

    fun numSquares(n: Int) = dp[n]

}