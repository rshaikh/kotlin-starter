package com.starter

import org.amshove.kluent.`should equal`
import org.junit.jupiter.api.Test

class SetZerosTest {
    fun setZeroes(matrix: Array<IntArray>): Unit {
        //brute force solution
        val alreadyChanged = mutableSetOf<String>()
        for (m in matrix.indices) {
            for(n in matrix[m].indices) {
                if(matrix[m][n] == 0 && (alreadyChanged.isEmpty() || !alreadyChanged.contains("${m},${n}"))) {
                    for(ni in matrix[m].indices) {
                        if(!alreadyChanged.contains("${m},${ni}") && matrix[m][ni] != 0 ) {
                            matrix[m][ni] = 0
                            alreadyChanged.add("${m},${ni}")
                        }
                    }
                    for(mi in matrix.indices) {
                        if(!alreadyChanged.contains("${mi},${n}") && matrix[mi][n] != 0){
                            matrix[mi][n] = 0
                            alreadyChanged.add("${mi},${n}")
                        }
                    }
                }
            }
        }
    }

    @Test
    fun name() {
        /*
        Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
        Output: [[1,0,1],[0,0,0],[1,0,1]]
         */

        val input = arrayOf(
            intArrayOf(1,1,1),
            intArrayOf(1,0,1),
            intArrayOf(1,1,1)
        )

        setZeroes(input)

        input[0][0] `should equal` 1
        input[0][1] `should equal` 0
        input[0][2] `should equal` 1

        input[1][0] `should equal` 0
        input[1][1] `should equal` 0
        input[1][2] `should equal` 0

        input[2][0] `should equal` 1
        input[2][1] `should equal` 0
        input[2][2] `should equal` 1
    }
}