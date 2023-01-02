package com.forketyfork.codingproblems

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class PerfectSquaresTest {
    companion object {
        @JvmStatic
        fun data() = arrayOf(
            Arguments.of(4, 1),
            Arguments.of(12, 3),
            Arguments.of(13, 2),
            Arguments.of(17, 2),
            Arguments.of(18, 2),
            Arguments.of(60, 4),
        )
    }

    @ParameterizedTest(name = "File {0}, part 1 answer = {1}, part 2 answer = {2}")
    @MethodSource("data")
    fun test(input: Int, expected: Int) {
        assertThat(PerfectSquares().numSquares(input)).isEqualTo(expected);
    }

}