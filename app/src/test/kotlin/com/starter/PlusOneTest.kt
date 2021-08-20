package com.starter

import org.amshove.kluent.`should equal`
import org.junit.jupiter.api.Test

class PlusOneTest {

    /*
        1,2,3 == 1,2,4
        1,2,9 == 1,3,0
        1,9,9 == 2,0,0
        9,9,9 == 1,0,0,0
     */

    fun plusOne(digits: IntArray): IntArray {
        for (i in digits.size - 1 downTo 0) {
            if (digits[i] < 9) {
                digits[i]++
                return digits
            }
            digits[i] = 0
        }

        val result = IntArray(digits.size + 1){0}
        result[0] = 1
        return result
    }

    @Test
    fun `should add plus 1 to array`() {
        val result = plusOne(intArrayOf(1, 2, 3))

        result.size `should equal` 3
        result[0] `should equal` 1
        result[1] `should equal` 2
        result[2] `should equal` 4
    }

    @Test
    fun `should add plus 1 to array when input is 9`() {
        val result = plusOne(intArrayOf(9))

        result.size `should equal` 2
        result[0] `should equal` 1
        result[1] `should equal` 0
    }
}