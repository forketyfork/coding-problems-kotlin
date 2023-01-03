package com.forketyfork.codingproblems

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource

class PerfectSquaresTest {
    companion object {
        @JvmStatic
        fun data() = arrayOf(
            of(4, 1),
            of(12, 3),
            of(13, 2),
            of(17, 2),
            of(18, 2),
            of(60, 4),
        )
    }

    @ParameterizedTest(name = "input {0}, expected {1}")
    @MethodSource("data")
    fun test(input: Int, expected: Int) {
        assertThat(PerfectSquares().numSquares(input)).isEqualTo(expected);
    }

}