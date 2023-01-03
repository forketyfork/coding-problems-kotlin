package com.forketyfork.codingproblems

/**
 * Given a string, find the length of the smallest window that contains every distinct character.
 * Characters may appear more than once in the window.
 *
 * As a variant of this problem, return the smallest window itself.
 *
 * @see "Daily Coding Problem #1127"
 */
class SmallestWindow {

    fun solve(string: String): String {
        var start = 0
        var end = 0
        var resultStart = 0
        var resultEnd = string.length
        val distinctCharCount = string.toSet().size
        val charCounts = mutableMapOf<Char, Int>()
        while (end < string.length) {
            // progress the end pointer until all distinct characters are in the window
            while (end < string.length && charCounts.size < distinctCharCount) {
                charCounts.compute(string[end++]) { _, value -> (value ?: 0) + 1 }
            }
            // if we've found a window of distinct characters terminated by the end pointer
            if (charCounts.size == distinctCharCount) {
                // progress the start pointer while all distinct characters are still in the window
                while (charCounts[string[start]]!! > 1) {
                    charCounts.compute(string[start++]) { _, value -> value!! - 1 }
                }
                // at this point we have the smallest window of distinct characters that terminates with the end pointer
                if (end - start < resultEnd - resultStart) {
                    resultStart = start
                    resultEnd = end
                }
                // progress the start pointer one step more
                charCounts.remove(string[start++])
            }
        }
        return string.substring(resultStart, resultEnd)
    }

}
