package com.forketyfork.codingproblems

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource

class SmallestWindowTest {
    companion object {
        @JvmStatic
        fun data() = arrayOf(
            of("a", "a"),
            of("jiujitsu", "ujits"),
            of("aabcbcdbca", "dbca"),
            of("aaab", "ab"),
            of("baaa", "ba"),
            of("abcddabc", "abcd"),
            of("aaabc", "abc"),
            of("caaab", "caaab"),
            of("abcd", "abcd"),
            of("aacbccaacbccaacbccaacbccaacbccaacbccaacbccaacbccaacaacbccaacbccaacbccaacbccaacbccaacbccaacbccaacbccaacaacbccaacbccaacbccaacbccaacbccaacbccaacbccaacbccaacaacbccaacbccaacbccaacbccaacbccaacbccaacbccaacbccaacaacbccaacbccaacbccaacbccaacbccaacbccaacbccaacbccaacbccaacbccaacbdabca", "acbd"),
        )
    }

    @ParameterizedTest(name = "input {0}, expected {1}")
    @MethodSource("data")
    fun test(input: String, expected: String) {
        assertThat(SmallestWindow().solve(input)).isEqualTo(expected);
    }

}