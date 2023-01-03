package com.forketyfork.codingproblems

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource

class PermutationsTest {
    companion object {
        @JvmStatic
        fun data() = arrayOf(
            of(
                intArrayOf(1, 2, 3),
                listOf(
                    listOf(1, 2, 3),
                    listOf(1, 3, 2),
                    listOf(2, 1, 3),
                    listOf(2, 3, 1),
                    listOf(3, 1, 2),
                    listOf(3, 2, 1)
                )
            ),
            of(
                intArrayOf(0, 1),
                listOf(listOf(0, 1), listOf(1, 0))
            ),
            of(
                intArrayOf(1),
                listOf(listOf(1))
            ),
        )
    }

    @ParameterizedTest(name = "input {0}, expected {1}")
    @MethodSource("data")
    fun test(input: IntArray, expected: List<List<Int>>) {
        assertThat(Permutations().permute(input)).containsExactlyInAnyOrderElementsOf(expected)
    }

}