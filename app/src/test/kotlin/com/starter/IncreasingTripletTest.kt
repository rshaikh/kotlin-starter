package com.starter

import org.amshove.kluent.shouldEqual
import org.junit.jupiter.api.Test

class IncreasingTripletTest {

    fun increasingTriplet(nums: IntArray): Boolean {
        var firstNumber = Int.MAX_VALUE
        var secondNumber = Int.MAX_VALUE
        for (n in nums) {
            when {
                n <= firstNumber -> firstNumber = n
                n <= secondNumber -> secondNumber = n
                else -> return true
            }
        }
        return false
    }

    @Test
    fun name() {
        /*
        Input: nums = [1,2,3,4,5]
        Output: true
        Explanation: Any triplet where i < j < k is valid.
         */
        increasingTriplet(intArrayOf(1, 2, 3, 4, 5)) shouldEqual true
    }
}