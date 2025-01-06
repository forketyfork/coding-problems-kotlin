package com.forketyfork.codingproblems

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource

class BitHammingDistanceTest {
    companion object {
        @JvmStatic
        fun data() = arrayOf(
            of(7, 10, 3),
            of(15, 15, 0),
            of(0, 0, 0),
            of(1, 0, 1),
            of(Int.MAX_VALUE, Int.MAX_VALUE, 0),
            of(Int.MAX_VALUE, Int.MAX_VALUE - 1, 1),
        )
    }

    @ParameterizedTest(name = "start {0}, goal {1}, expected {2}")
    @MethodSource("data")
    fun test(start: Int, goal: Int, expected: Int) {
        assertThat(BitHammingDistance().solve(start, goal)).isEqualTo(expected)
    }

}