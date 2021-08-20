package com.starter

import org.amshove.kluent.`should equal`
import org.junit.jupiter.api.Test

class RotateImageTest {
    fun rotate(matrix: Array<IntArray>): Unit {
        transpose(matrix)
        reflect(matrix)
    }

    fun transpose(matrix: Array<IntArray>): Unit {
        for (i in matrix.indices) {
            for (j in i until matrix.size) {
                val temp = matrix[i][j]
                matrix[i][j] = matrix[j][i]
                matrix[j][i] = temp
            }
        }
    }

    fun reflect(matrix: Array<IntArray>): Unit {
        for (i in matrix.indices) {
            println(0..(matrix.size / 2))
            for (j in 0 until (matrix.size / 2)) {
                val temp = matrix[i][j]
                matrix[i][j] = matrix[i][matrix.size - 1 - j]
                matrix[i][matrix.size - 1 - j] = temp
            }

        }
    }

    @Test
    fun shouldTransposeMatrix() {
        val matrix = arrayOf(
            intArrayOf(1,2,3),
            intArrayOf(4,5,6),
            intArrayOf(7,8,9)
        )

        transpose(matrix)

        matrix[0][0] `should equal` 1
        matrix[0][1] `should equal` 4
        matrix[0][2] `should equal` 7

        matrix[1][0] `should equal` 2
        matrix[1][1] `should equal` 5
        matrix[1][2] `should equal` 8

        matrix[2][0] `should equal` 3
        matrix[2][1] `should equal` 6
        matrix[2][2] `should equal` 9
    }

    @Test
    fun shouldRotateMatrix() {
        val matrix = arrayOf(
            intArrayOf(1,2,3),
            intArrayOf(4,5,6),
            intArrayOf(7,8,9)
        )

        rotate(matrix)

        matrix[0][0] `should equal` 7
        matrix[0][1] `should equal` 4
        matrix[0][2] `should equal` 1

        matrix[1][0] `should equal` 8
        matrix[1][1] `should equal` 5
        matrix[1][2] `should equal` 2

        matrix[2][0] `should equal` 9
        matrix[2][1] `should equal` 6
        matrix[2][2] `should equal` 3
    }
}